package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RichMsg extends BaseBean implements Serializable, Message {

    private String title;

    private long xtime;

    private String body;

    private List<RichMedia> imgList;

    private List<RichUrl> urlList;

    private RichMedia attachment;

}
