package com.jingjing.manage.entity;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable {
	private Integer id;

	private String path;

	private Integer classifyId;

	private Date createTime;

	private String url;

	private Integer userId;

	private Integer type;

	private Integer deleted;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
		Picture other = (Picture) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
				&& (this.getClassifyId() == null ? other.getClassifyId() == null : this.getClassifyId().equals(other.getClassifyId()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
		result = prime * result + ((getClassifyId() == null) ? 0 : getClassifyId().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", path=").append(path);
		sb.append(", classifyId=").append(classifyId);
		sb.append(", createTime=").append(createTime);
		sb.append(", url=").append(url);
		sb.append(", userId=").append(userId);
		sb.append(", type=").append(type);
		sb.append(", deleted=").append(deleted);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}