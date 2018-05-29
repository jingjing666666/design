package com.jingjing.manage.dto;

import com.jingjing.manage.entity.Article;

import java.io.Serializable;

/**
 * Created by yuanqingjing on 2018/5/4
 */
public class ArticleDto extends Article implements Serializable{
    /**
     * 发布人
     */
    private String user;
    /**
     * 分类名称
     */
    private String classifyName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ArticleDto that = (ArticleDto) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return classifyName != null ? classifyName.equals(that.classifyName) : that.classifyName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (classifyName != null ? classifyName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "user='" + user + '\'' +
                ", classifyName='" + classifyName + '\'' +
                '}';
    }
}
