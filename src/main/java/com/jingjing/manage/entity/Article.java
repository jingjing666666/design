package com.jingjing.manage.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer id;

    private String title;

    private Date createTime;

    private Integer isTop;

    private Integer userId;

    private String url;

    private Integer classifyId;

    private Date updateTime;

    private String content;

    private Integer deleted;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
                && (this.getClassifyId() == null ? other.getClassifyId() == null : this.getClassifyId().equals(other.getClassifyId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getClassifyId() == null) ? 0 : getClassifyId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append(", isTop=").append(isTop);
        sb.append(", userId=").append(userId);
        sb.append(", url=").append(url);
        sb.append(", classifyId=").append(classifyId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}