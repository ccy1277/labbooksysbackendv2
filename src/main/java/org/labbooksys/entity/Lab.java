package org.labbooksys.entity;

public class Lab {
    private int id;
    private String labs_id;
    private int labs_num;
    private String labs_equipment;
    private String labs_status;
    private String manager_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabs_id() {
        return labs_id;
    }

    public void setLabs_id(String labs_id) {
        this.labs_id = labs_id;
    }

    public int getLabs_num() {
        return labs_num;
    }

    public void setLabs_num(int labs_num) {
        this.labs_num = labs_num;
    }

    public String getLabs_equipment() {
        return labs_equipment;
    }

    public void setLabs_equipment(String labs_equipment) {
        this.labs_equipment = labs_equipment;
    }

    public String getLabs_status() {
        return labs_status;
    }

    public void setLabs_status(String labs_status) {
        this.labs_status = labs_status;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", labs_id='" + labs_id + '\'' +
                ", labs_num=" + labs_num +
                ", labs_equipment='" + labs_equipment + '\'' +
                ", labs_status='" + labs_status + '\'' +
                ", manager_id='" + manager_id + '\'' +
                '}';
    }
}
