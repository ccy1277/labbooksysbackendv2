package org.labbooksys.entity;

public class User {
    private String users_id;
    private String users_pwd;
    private String users_role;
    private String users_token;

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getUsers_pwd() {
        return users_pwd;
    }

    public void setUsers_pwd(String users_pwd) {
        this.users_pwd = users_pwd;
    }

    public String getUsers_role() {
        return users_role;
    }

    public void setUsers_role(String users_role) {
        this.users_role = users_role;
    }

    public String getUsers_token() {
        return users_token;
    }

    public void setUsers_token(String users_token) {
        this.users_token = users_token;
    }

    @Override
    public String toString() {
        return "User{" +
                "users_id='" + users_id + '\'' +
                ", users_pwd='" + users_pwd + '\'' +
                ", users_role='" + users_role + '\'' +
                ", users_token='" + users_token + '\'' +
                '}';
    }
}
