package org.labbooksys.dao.impl;

import org.labbooksys.dao.TitleListDao;
import org.labbooksys.entity.TitleList;
import org.labbooksys.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TitleListDaoImpl implements TitleListDao {
    public ArrayList<TitleList> findAll() {
        Connection c = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        ArrayList<TitleList> ls = new ArrayList<TitleList>();
        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from cat";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){
                TitleList titleList = new TitleList();
                titleList.setCat_id(rs.getInt("cat_id"));
                titleList.setRole(rs.getString("role"));
                titleList.setFirst_title(rs.getString("first_title"));
                titleList.setSecond_title(rs.getString("second_title"));
                ls.add(titleList);
            }
            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }
}
