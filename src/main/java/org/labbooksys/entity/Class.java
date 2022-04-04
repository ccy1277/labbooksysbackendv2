package org.labbooksys.entity;

public class Class {
    private int id;
    private String cId;
    private String cName;
    private int cNum;
    private String cMonitor;
    private String cProfession;
    private String tcDept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public String getcMonitor() {
        return cMonitor;
    }

    public void setcMonitor(String cMonitor) {
        this.cMonitor = cMonitor;
    }

    public String getcProfession() {
        return cProfession;
    }

    public void setcProfession(String cProfession) {
        this.cProfession = cProfession;
    }

    public String getTcDept() {
        return tcDept;
    }

    public void setTcDept(String tcDept) {
        this.tcDept = tcDept;
    }

    public boolean isExist(){
        return this.cId == null;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cNum='" + cNum + '\'' +
                ", cMonitor='" + cMonitor + '\'' +
                ", cProfession='" + cProfession + '\'' +
                ", tcDept='" + tcDept + '\'' +
                '}';
    }
}
