package com.jingjing.manage.dto;

import com.jingjing.manage.entity.Picture;

/**
 * Created by yuanqingjing on 2018/5/4
 */
public class PictureDto extends Picture {
    /**
     * 发布人
     */
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PictureDto)) return false;
        if (!super.equals(o)) return false;

        PictureDto that = (PictureDto) o;

        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PictureDto{" +
                "user='" + user + '\'' +
                '}';
    }
}

