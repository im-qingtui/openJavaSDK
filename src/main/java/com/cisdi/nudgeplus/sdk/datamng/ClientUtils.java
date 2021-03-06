package com.cisdi.nudgeplus.sdk.datamng;

import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ErrorResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.beans.StatusCode;
import com.google.gson.JsonSyntaxException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * 网络请求工具类
 */
public final class ClientUtils {

    private static final String BASE_URL = NudgePlusConfig.getValue("baseURL");

    private static final String TEAM_URL = NudgePlusConfig.getValue("teamURL");

    private static final String POST_METHOD = "post";

    private static final String GET_METHOD = "get";

    private static final int READ_TIMEOUT = 30000;

    private static final int CONNECT_TIMEOUT = 5000;

    private ClientUtils() {

    }

    /**
     * 向指定地址发送http get请求
     *
     * @param path 请求地址 子路径
     * @param params 参数map
     * @param clazz 返回的对象类型
     * @param <T> 返回的泛型
     * @return 返回对象
     * @throws IllegalRequestException 非法返回
     */
    public static <T extends BaseResult> ResultWapper<T> get(String path, Map<String, String> params, Class<T> clazz)
        throws IllegalRequestException {
        if (params == null || params.isEmpty()) {
            throw new IllegalRequestException(" request params is null !");
        }
        String result;
        InputStream responseInputStream = null;
        HttpURLConnection connection = null;
        try {
            URL realUrl = getUrl(path, params);
            connection = getHttpURLConnection(realUrl, GET_METHOD);
            responseInputStream = connection.getInputStream();
            result = dealResponseToString(responseInputStream);
            return parseResponse(result, clazz);
        } catch (IOException e) {
            throw new IllegalRequestException("send get request error,Probably the path is wrong", e);
        } finally {
            try {
                if (responseInputStream != null) {
                    responseInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

    /**
     * 发送post请求
     *
     * @param path 请求路径
     * @param token 认证token
     * @param json 请求参数
     * @param clazz 返回类型
     */
    public static <T extends BaseResult> ResultWapper<T> post(String path, String token, String json, Class<T> clazz)
        throws IllegalRequestException {
        HttpURLConnection connection = null;
        InputStream responseInputStream = null;
        try {
            URL url = getPostUrl(path, token, null);
            connection = getHttpURLConnection(url, POST_METHOD);
            sendPostRequestParam(connection, json);
            responseInputStream = connection.getInputStream();
            String result = dealResponseToString(responseInputStream);
            return parseResponse(result, clazz);
        } catch (Exception e) {
            throw new IllegalRequestException(" send post request error:", e);
        } finally {
            try {
                if (responseInputStream != null) {
                    responseInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

    /**
     * 上传文件
     *
     * @param path 请求路径
     * @param token 认证token
     * @param type 发送的文件类型 ("image","file")
     */
    public static <T extends BaseResult> ResultWapper<T> uploadMedia(String path, String token, String type, File media, Class<T> clazz)
        throws IllegalRequestException {
        HttpURLConnection connection = null;
        InputStream responseInputStream = null;
        try {
            URL url = getPostUrl(path, token, type);
            connection = getHttpURLConnection(url, POST_METHOD);
            sendRequestForUploadMedia(type, media, connection);
            responseInputStream = connection.getInputStream();
            String result = dealResponseToString(responseInputStream);
            return parseResponse(result, clazz);
        } catch (Exception e) {
            throw new IllegalRequestException("send post request error", e);
        } finally {
            try {
                if (responseInputStream != null) {
                    responseInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

    /**
     * 发送上传文件的请求
     */
    private static void sendRequestForUploadMedia(String type, File media, HttpURLConnection httpURLConnection) throws IOException {
        String boundary = "----------" + System.currentTimeMillis();
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        OutputStream requestOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        byte[] head = getHeaderOfUploadedFileRequest(boundary, media, type);
        requestOutputStream.write(head);
        writeFileToRequestOutputStream(media, requestOutputStream);
        byte[] foot = getFootOfUploadedFileRequest(boundary);// 定义最后数据分隔线
        requestOutputStream.write(foot);
        requestOutputStream.flush();
        requestOutputStream.close();
    }


    /**
     * 根据请求路径和请求参数，拼装后取得 请求的 URL 连接 对象
     *
     * @param urlStr 请求路径
     * @param params 请求参数
     */
    private static URL getUrl(String urlStr, Map<String, String> params) throws MalformedURLException {
        if (params != null && !params.isEmpty()) {
            String param = dealParamsMapToString(params);
            urlStr += "?" + param;
        }
        return new URL(urlStr);
    }


    /**
     * 根据响应输入流得到响应流的字符串
     *
     * @param responseInputStream 响应输入流
     * @return 响应字符串
     */
    private static String dealResponseToString(InputStream responseInputStream) {
        InputStreamReader responseInputReader = new InputStreamReader(responseInputStream);
        BufferedReader responseBufferedReader = new BufferedReader(responseInputReader);
        StringBuilder result = new StringBuilder();
        try {
            String line;
            while ((line = responseBufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                responseInputReader.close();
                responseBufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }

    /**
     * 关闭响应输入流
     *
     * @param responseBufferedReader 响应输入流
     */
    private static void closeBufferedReader(BufferedReader responseBufferedReader) {
        if (responseBufferedReader != null) {
            try {
                responseBufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理参数map 使其变成  key1=value1&key2=value2&key3=value3... 样式的字符串
     *
     * @param params 参数map
     * @return 参数字符串
     */
    private static String dealParamsMapToString(Map<String, String> params) {
        StringBuilder paramStr = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramStr.append(entry.getKey());
            paramStr.append("=");
            paramStr.append(entry.getValue());
            paramStr.append("&");
        }
        paramStr.substring(0, paramStr.length() - 1);
        return paramStr.toString();
    }


    /**
     * 向建立好的http连接发送 请求参数
     */
    private static void sendPostRequestParam(HttpURLConnection httpURLConnection, String json) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(httpURLConnection.getOutputStream());
            writer.print(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    /**
     * 根据请求路径和 token ,type获取请求的 url对象
     */
    private static URL getPostUrl(String urlStr, String token, String type) throws MalformedURLException, IllegalRequestException {
        if (token == null || ("").equals(token)) {
            throw new IllegalRequestException("token is valid");
        }
        urlStr += "?access_token=" + token;
        if (type != null && !("").equals(type)) {
            urlStr += "&type=" + type;
        }
        return new URL(urlStr);
    }


    /**
     * 根据 url 打开HttpURL连接
     *
     * @param url URL对象
     */
    private static HttpURLConnection getHttpURLConnection(URL url, String requestMethod) throws IOException {

        // 打开和URL之间的连接
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setConnectTimeout(CONNECT_TIMEOUT);
        httpURLConnection.setReadTimeout(READ_TIMEOUT);
        if (GET_METHOD.equals(requestMethod)) {
            return httpURLConnection;
        }
        // 设置通用的请求属性
        // 发送POST请求必须设置如下两行
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setRequestProperty("content-type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }


    /**
     * 将待上传的文件，写入请求输出流
     */
    private static void writeFileToRequestOutputStream(File media, OutputStream requestOutputStream) throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(media));
        int bytes;
        byte[] bufferOut = new byte[1024];
        while ((bytes = inputStream.read(bufferOut)) != -1) {
            requestOutputStream.write(bufferOut, 0, bytes);
        }
        inputStream.close();
    }

    /**
     * 获取上传文件时的http请求头部
     */
    private static byte[] getHeaderOfUploadedFileRequest(String boundary, File media, String type)
        throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("--")
            .append(boundary)
            .append("\r\n")
            .append("Content-Disposition: form-data;name=\"media\";filename=\"")
            .append(media.getName())
            .append("\"\r\n");
        if (("image").equals(type) && isPicture(media)) {
            sb.append("Content-Type:image/jpeg\r\n\r\n");
        } else {
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
        }
        return sb.toString().getBytes("utf-8");
    }

    /**
     * 获取上传文件时的http请求头部
     */
    private static byte[] getFootOfUploadedFileRequest(String boundary)
        throws UnsupportedEncodingException {
        return ("\r\n--" + boundary + "--\r\n").getBytes("utf-8");
    }

    /**
     * 根据返回的json字符串，将其转化为对象
     */
    private static <T extends BaseResult> ResultWapper<T> parseResponse(String jsonStr, Class<T> clazz)
        throws IllegalRequestException {
        ResultWapper<T> result = new ResultWapper<T>();
        T bean = null;
        try {
            bean = JsonUtils.jsonToBean(jsonStr, clazz);
        } catch (JsonSyntaxException e) {
            bean = (T) new BaseResult();
            bean.setErrcode(40038);
            bean.setErrmsg(StatusCode.is(40038));
        }
        if (bean.getErrcode() != 0) {
            result.setError(true);
            result.setErrorResult(new ErrorResult(bean.getErrcode(), bean.getErrmsg()));
        } else {
            result.setResult(bean);
        }
        return result;
    }

    /**
     * 判断文件是否是图片
     */
    private static boolean isPicture(File media) {
        boolean isPicture = false;
        try {
            BufferedImage image = ImageIO.read(media);
            if (image != null) {
                isPicture = true;
            }
        } catch (IOException ex) {
            isPicture = false;
        }
        return isPicture;
    }

}
