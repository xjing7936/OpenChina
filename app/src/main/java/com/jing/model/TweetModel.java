package com.jing.model;

import java.util.ArrayList;

/**
 * Created by jing on 2016/1/8.
 */
public class TweetModel {
  private String id;
    private String portrait;
    private String author;
    private String authorid;
    private String body;
    private String attach;
    private String appclient;
    private String commentCount;
    private String pubDate;
    private String imgSmall;
    private String imgBig;
    private String likeCount;
    private String isLike;
    private ArrayList<LikeListModel> likeList;

    public ArrayList<LikeListModel> getLikeList() {
        return likeList;
    }

    public void setLikeList(ArrayList<LikeListModel> likeList) {
        this.likeList = likeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getAppclient() {
        return appclient;
    }

    public void setAppclient(String appclient) {
        this.appclient = appclient;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall;
    }

    public String getImgBig() {
        return imgBig;
    }

    public void setImgBig(String imgBig) {
        this.imgBig = imgBig;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getIsLike() {
        return isLike;
    }

    public void setIsLike(String isLike) {
        this.isLike = isLike;
    }


}
