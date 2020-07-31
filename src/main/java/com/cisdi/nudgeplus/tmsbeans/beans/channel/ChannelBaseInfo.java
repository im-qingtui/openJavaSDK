package com.cisdi.nudgeplus.tmsbeans.beans.channel;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;

/**
 * 群基础信息
 * Date:2020/7/31
 *
 * @author GuanZhong
 */
public class ChannelBaseInfo extends BaseResult {
    private String id;
    private String name;

    //组织机构id，非部门群时可为空
    private String orgId;
    // 群头像
    private String avatar;

    // 群的类型
    private String type;

    private String domainId;
    private String comment;

    // 群是否归档
    private String archive;
    private String pinyin;
    private String pinyinSearch;

    private String createDatetime;
    private String modifyDatetime;
    // 群的创建者账号id
    private String creatorAccountId;
    //群主aid
    private String hostAccountId;

    // 群的类别 （0:企业私有群，1：企业公开群 2:普通群， 3:全员群，4部门群）
    private int category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinSearch() {
        return pinyinSearch;
    }

    public void setPinyinSearch(String pinyinSearch) {
        this.pinyinSearch = pinyinSearch;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(String modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public String getCreatorAccountId() {
        return creatorAccountId;
    }

    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }

    public String getHostAccountId() {
        return hostAccountId;
    }

    public void setHostAccountId(String hostAccountId) {
        this.hostAccountId = hostAccountId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
