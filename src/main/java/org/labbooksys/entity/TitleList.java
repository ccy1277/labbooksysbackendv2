package org.labbooksys.entity;

public class TitleList {
    private int cat_id;
    private String role;
    private String first_title;
    private String second_title;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirst_title() {
        return first_title;
    }

    public void setFirst_title(String first_title) {
        this.first_title = first_title;
    }

    public String getSecond_title() {
        return second_title;
    }

    public void setSecond_title(String second_title) {
        this.second_title = second_title;
    }

    @Override
    public String toString() {
        return "TitleList{" +
                "cat_id=" + cat_id +
                ", role='" + role + '\'' +
                ", first_title='" + first_title + '\'' +
                ", second_title='" + second_title + '\'' +
                '}';
    }
}
