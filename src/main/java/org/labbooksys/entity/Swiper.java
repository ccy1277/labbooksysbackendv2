package org.labbooksys.entity;

public class Swiper {
    private int id;
    private String imgUrl;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Swiper{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
