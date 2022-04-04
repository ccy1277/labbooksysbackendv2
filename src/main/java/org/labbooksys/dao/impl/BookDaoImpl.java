package org.labbooksys.dao.impl;

import org.labbooksys.dao.BookDao;
import org.labbooksys.entity.Book;
import org.labbooksys.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookDaoImpl implements BookDao {
    Connection c = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public boolean insert(String labId, String[] bookTimes, String bookStatus) {
        try{
            c = JdbcUtils.getConnection();
            int len = bookTimes.length, i = 0;
            int returnNum = 0;
            boolean flag = true;
            while(i < len){
                String sql = "insert into book(labs_id, books_time, books_status)values(?, ?, ?)";
                psmt = c.prepareStatement(sql);
                psmt.setString(1, labId);
                psmt.setString(2, bookTimes[i]);
                psmt.setString(3, bookStatus);

                returnNum = psmt.executeUpdate();
                // 有一个插入失败
                if(returnNum <= 0){
                    flag = false;
                }

                i++;
            }
            return returnNum > 0 && flag;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean update(int bookId, String name, String myClass, String project) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date successTime = new Date();
        String timeString = ft.format(successTime);
        try{
            c = JdbcUtils.getConnection();
            String sql = "update book set teachers_name = ?, classes_name = ?, project = ?, success_time = ?," +
                    " books_status = '已预约' where books_id = ? and books_status = '可预约'";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, name);
            psmt.setString(2, myClass);
            psmt.setString(3, project);
            psmt.setDate(4, new java.sql.Date(ft.parse(timeString).getTime()));
            psmt.setInt(5, bookId);

            int returnNum = psmt.executeUpdate();
            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean delete(String bookId) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "delete from book where books_id = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, bookId);

            int returnNum = psmt.executeUpdate();
            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public ArrayList<Book> findAll() {
        try{
            c = JdbcUtils.getConnection();
            String sql = "select * from book";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();

            ArrayList<Book> books = new ArrayList<Book>();
            while(rs.next()){
                Book book = new Book();
                book.setBooks_id(rs.getInt("books_id"));
                book.setLabs_id(rs.getString("labs_id"));
                book.setBooks_time(rs.getString("books_time"));
                book.setTeachers_name(rs.getString("teachers_name"));
                book.setClasses_name(rs.getString("Classes_name"));
                book.setProject(rs.getString("Project"));
                book.setBooks_status(rs.getString("books_status"));
                book.setCreate_time(rs.getDate("create_time"));
                book.setSuccess_time(rs.getDate("success_time"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }
        return null;
    }

    public Book findById(int id) {
        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from book where books_id = ?";
            psmt = c.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            Book book = new Book();
            while (rs.next()) {
                book.setBooks_id(rs.getInt("books_id"));
                book.setLabs_id(rs.getString("labs_id"));
                book.setBooks_time(rs.getString("books_time"));
                book.setTeachers_name(rs.getString("teachers_name"));
                book.setClasses_name(rs.getString("Classes_name"));
                book.setProject(rs.getString("Project"));
                book.setBooks_status(rs.getString("books_status"));
                book.setCreate_time(rs.getDate("create_time"));
                book.setSuccess_time(rs.getDate("success_time"));

            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }
        return null;
    }
}
