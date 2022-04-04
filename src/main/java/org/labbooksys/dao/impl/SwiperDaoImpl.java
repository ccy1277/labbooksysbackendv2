package org.labbooksys.dao.impl;

import org.labbooksys.dao.SwiperDao;
import org.labbooksys.entity.Swiper;
import org.labbooksys.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class SwiperDaoImpl implements SwiperDao {
    Connection c = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public HashSet<Swiper> findAll() {
        HashSet<Swiper> hs = new HashSet<Swiper>();
        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from swiper";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){
                Swiper swiper = new Swiper();
                swiper.setId(rs.getInt("id"));
                swiper.setImgUrl(rs.getString("imgUrl"));
                swiper.setDetail(rs.getString("detail"));
                hs.add(swiper);
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
