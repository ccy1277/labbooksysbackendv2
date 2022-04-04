package org.labbooksys.entity;

public class Manager {
    private int id;
    private String mtId;
    private String mtName;
    private String mtPhone;
    private String mtEmail;
    private String mOffice;
    private String mLabs;

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

    public String getmOffice() {
        return mOffice;
    }

    public void setmOffice(String mOffice) {
        this.mOffice = mOffice;
    }

    public String getmLabs() {
        return mLabs;
    }

    public void setmLabs(String mLabs) {
        this.mLabs = mLabs;
    }

    public boolean isExist(){
        return this.mtId == null;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", mtId='" + mtId + '\'' +
                ", mtName='" + mtName + '\'' +
                ", mtPhone='" + mtPhone + '\'' +
                ", mtEmail='" + mtEmail + '\'' +
                ", mOffice='" + mOffice + '\'' +
                ", mLabs='" + mLabs + '\'' +
                '}';
    }
}
