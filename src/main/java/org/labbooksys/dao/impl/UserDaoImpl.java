package org.labbooksys.dao.impl;

import org.labbooksys.dao.UserDao;
import org.labbooksys.entity.User;
import org.labbooksys.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class UserDaoImpl implements UserDao {
    Connection c = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public User findById(String id) {
        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from users where users_id = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, id);
            rs = psmt.executeQuery();

            User user = new User();
            while(rs.next()){
                user.setUsers_id(rs.getString("users_id"));
                user.setUsers_pwd(rs.getString("users_pwd"));
                user.setUsers_role(rs.getString("users_role"));
                user.setUsers_token(rs.getString("users_token"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public boolean insert(User user) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "insert into users(users_id, users_pwd, users_role, users_token) values(?, ?, ?, ?)";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, user.getUsers_id());
            psmt.setString(2, user.getUsers_pwd());
            psmt.setString(3, user.getUsers_role());
            psmt.setString(4, user.getUsers_token());

            int returnNum = psmt.executeUpdate();
            return returnNum > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }
        return false;
    }

    public HashSet<User> findAll() {
        HashSet<User> hs = new HashSet<User>();

        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from users";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();


            while(rs.next()){
                User user = new User();
                user.setUsers_id(rs.getString("users_id"));
                user.setUsers_pwd(rs.getString("users_pwd"));
                user.setUsers_role(rs.getString("users_role"));
                user.setUsers_token(rs.getString("users_token"));

                hs.add(user);
            }
            return hs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }
}
