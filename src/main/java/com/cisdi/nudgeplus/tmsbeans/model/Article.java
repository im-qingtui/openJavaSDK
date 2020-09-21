package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseBean implements Serializable {

    private String title;

    private long xtime;

    private String author;

    private String url;

    private String content;

    private String thumbMediaId;

    private int showCoverPic = 1;

}
