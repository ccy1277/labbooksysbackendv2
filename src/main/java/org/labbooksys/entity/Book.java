package org.labbooksys.entity;

import java.util.Date;

public class Book {
    private int books_id;
    private String labs_id;
    private String books_time;
    private String teachers_name;
    private String classes_name;
    private String project;
    private String books_status;
    private Date create_time;
    private Date success_time;

    public int getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int books_id) {
        this.books_id = books_id;
    }

    public String getLabs_id() {
        return labs_id;
    }

    public void setLabs_id(String labs_id) {
        this.labs_id = labs_id;
    }

    public String getBooks_time() {
        return books_time;
    }

    public void setBooks_time(String books_time) {
        this.books_time = books_time;
    }

    public String getTeachers_name() {
        return teachers_name;
    }

    public void setTeachers_name(String teachers_name) {
        this.teachers_name = teachers_name;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBooks_status() {
        return books_status;
    }

    public void setBooks_status(String books_status) {
        this.books_status = books_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(Date success_time) {
        this.success_time = success_time;
    }

    @Override
    public String toString() {
        return "Book{" +
                "books_id=" + books_id +
                ", labs_id='" + labs_id + '\'' +
                ", books_time='" + books_time + '\'' +
                ", teachers_name='" + teachers_name + '\'' +
                ", classes_name='" + classes_name + '\'' +
                ", project='" + project + '\'' +
                ", books_status='" + books_status + '\'' +
                ", create_time=" + create_time +
                ", success_time=" + success_time +
                '}';
    }
}
