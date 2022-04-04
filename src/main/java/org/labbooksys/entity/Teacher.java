package org.labbooksys.entity;

public class Teacher {
    private int id;
    private String mtId;
    private String mtName;
    private String tProject;
    private String tClasses;
    private String tcDept;
    private String mtPhone;
    private String mtEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMtId() {
        return mtId;
    }

    public void setMtId(String mtId) {
        this.mtId = mtId;
    }

    public String getMtName() {
        return mtName;
    }

    public void setMtName(String mtName) {
        this.mtName = mtName;
    }

    public String gettProject() {
        return tProject;
    }

    public void settProject(String tProject) {
        this.tProject = tProject;
    }

    public String gettClasses() {
        return tClasses;
    }

    public void settClasses(String tClasses) {
        this.tClasses = tClasses;
    }

    public String getTcDept() {
        return tcDept;
    }

    public void setTcDept(String tcDept) {
        this.tcDept = tcDept;
    }

    public String getMtPhone() {
        return mtPhone;
    }

    public void setMtPhone(String mtPhone) {
        this.mtPhone = mtPhone;
    }

    public String getMtEmail() {
        return mtEmail;
    }

    public void setMtEmail(String mtEmail) {
        this.mtEmail = mtEmail;
    }

    public boolean isExist(){
        return this.mtId == null;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", mtId='" + mtId + '\'' +
                ", mtName='" + mtName + '\'' +
                ", tProject='" + tProject + '\'' +
                ", tClasses='" + tClasses + '\'' +
                ", tcDept='" + tcDept + '\'' +
                ", mtPhone='" + mtPhone + '\'' +
                ", mtEmail='" + mtEmail + '\'' +
                '}';
    }
}
