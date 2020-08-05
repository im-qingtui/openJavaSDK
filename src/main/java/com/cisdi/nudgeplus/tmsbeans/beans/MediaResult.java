package com.cisdi.nudgeplus.tmsbeans.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MediaResult extends BaseResult {

    private String type;

    private String mediaId;

    private long createdAt;

}
