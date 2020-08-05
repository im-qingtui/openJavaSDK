package com.cisdi.nudgeplus.tmsbeans.beans.channel;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 群基础信息 Date:2020/7/31
 *
 * @author GuanZhong
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ChannelBaseInfo extends BaseResult {

    private String id;

    private String name;

    private String orgId;

    private String avatar;

    private String type;

    private String domainId;

    private String comment;

    private String archive;

    private String pinyin;

    private String pinyinSearch;

    private String createDatetime;

    private String modifyDatetime;

    private String creatorAccountId;

    private String hostAccountId;

    /**
     * 群的类别 （0:企业私有群，1：企业公开群 2:普通群， 3:全员群，4部门群）
     */
    private int category;

}
