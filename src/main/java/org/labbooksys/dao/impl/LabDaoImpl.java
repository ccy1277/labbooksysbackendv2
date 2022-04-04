package org.labbooksys.dao.impl;

import org.labbooksys.dao.LabDao;
import org.labbooksys.entity.Lab;
import org.labbooksys.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabDaoImpl implements LabDao {
    Connection c = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public ArrayList<Lab> findAll() {
        try{
            c = JdbcUtils.getConnection();
            String sql = "select * from lab";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();

            ArrayList<Lab> labs = new ArrayList<Lab>();
            while(rs.next()){
                Lab lab = new Lab();
                lab.setId(rs.getInt("id"));
                lab.setLabs_id(rs.getString("labs_id"));
                lab.setLabs_equipment(rs.getString("labs_equipment"));
                lab.setLabs_num(rs.getInt("labs_num"));
                lab.setLabs_status(rs.getString("labs_status"));
                lab.setManager_id(rs.getString("manager_id"));
                labs.add(lab);
            }
            return labs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public Lab findById(String id) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "select * from lab where labs_id = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, id);
            rs = psmt.executeQuery();

            Lab lab = new Lab();
            while(rs.next()){
                lab.setId(rs.getInt("id"));
                lab.setLabs_id(rs.getString("labs_id"));
                lab.setLabs_equipment(rs.getString("labs_equipment"));
                lab.setLabs_num(rs.getInt("labs_num"));
                lab.setLabs_status(rs.getString("labs_status"));
                lab.setManager_id(rs.getString("manager_id"));
            }
            return lab;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public ArrayList<Lab> findByMtId(String mtId) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "select * from lab where manager_id = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, mtId);
            rs = psmt.executeQuery();

            ArrayList<Lab> labs = new ArrayList<Lab>();
            while(rs.next()){
                Lab lab = new Lab();

                lab.setId(rs.getInt("id"));
                lab.setLabs_id(rs.getString("labs_id"));
                lab.setLabs_equipment(rs.getString("labs_equipment"));
                lab.setLabs_num(rs.getInt("labs_num"));
                lab.setLabs_status(rs.getString("labs_status"));
                lab.setManager_id(rs.getString("manager_id"));

                labs.add(lab);
            }
            return labs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public boolean deleteById(String id) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "delete from lab where labs_id = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.executeUpdate();
            int returnNum = psmt.executeUpdate();

            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insert(Lab lab) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "insert into lab(labs_id, labs_equipment, labs_num, labs_status, manager_id)values(?, ?, ?, ?, ?)";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, lab.getLabs_id());
            psmt.setString(2, lab.getLabs_equipment());
            psmt.setInt(3, lab.getLabs_num());
            psmt.setString(4, lab.getLabs_status());
            psmt.setString(5, lab.getManager_id());

            int returnNum = psmt.executeUpdate();
            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean updateById(Lab lab) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "update lab set labs_equipment = ?, labs_num = ?, labs_status = ?, manager_id = ? where labs_id = ?";
            psmt = c.prepareStatement(sql);

            psmt.setString(1, lab.getLabs_equipment());
            psmt.setInt(2, lab.getLabs_num());
            psmt.setString(3, lab.getLabs_status());
            psmt.setString(4, lab.getManager_id());
            psmt.setString(5, lab.getLabs_id());

            int returnNum = psmt.executeUpdate();
            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }
}
