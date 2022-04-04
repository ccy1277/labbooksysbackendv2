package org.labbooksys.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
    public static Connection getConnection() throws SQLException {
        DataSource ds = null;
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        ds = cpds;

        return ds.getConnection();
    }

    public static void release(Connection c, PreparedStatement psmt, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(psmt != null){
                psmt.close();
            }
            if(c != null){
                c.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs = null;
        psmt = null;
        c = null;
    }
}
