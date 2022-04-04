package org.labbooksys.dao.impl;

import org.labbooksys.dao.PersonalMsgDao;
import org.labbooksys.entity.Class;
import org.labbooksys.entity.Manager;
import org.labbooksys.entity.Teacher;
import org.labbooksys.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalMsgDaoImpl implements PersonalMsgDao {
    Connection c = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public Object findById(String id, String role) {
        // 当查询不存在的工号/班级号时
        // 会出现Manager{id=0, mtId='null', mtName='null', mtPhone='null', mtEmail='null', mOffice='null', mLabs='null'}的特殊情况
        if("管理员".equals(role)) {
            Manager manager = new Manager();
            try {
                c = JdbcUtils.getConnection();
                String sql = "select * from manager_msg where mtId = ?";
                psmt = c.prepareStatement(sql);
                psmt.setString(1, id);
                rs = psmt.executeQuery();
                while(rs.next()){
                    manager.setId(rs.getInt("id"));
                    manager.setMtId(rs.getString("mtId"));
                    manager.setMtName(rs.getString("mtName"));
                    manager.setMtPhone(rs.getString("mtPhone"));
                    manager.setMtEmail(rs.getString("mtEmail"));
                    manager.setmOffice(rs.getString("mOffice"));
                    manager.setmLabs(rs.getString("mLabs"));
                }
                return manager;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtils.release(c, psmt, rs);
            }
        }else if("教师".equals(role)){
            Teacher teacher = new Teacher();
            try {
                c = JdbcUtils.getConnection();
                String sql = "select * from teacher_msg where mtId = ?";
                psmt = c.prepareStatement(sql);
                psmt.setString(1, id);
                rs = psmt.executeQuery();
                while(rs.next()){
                    teacher.setId(rs.getInt("id"));
                    teacher.setMtId(rs.getString("mtId"));
                    teacher.setMtName(rs.getString("mtName"));
                    teacher.settProject(rs.getString("tProject"));
                    teacher.settClasses(rs.getString("tClasses"));
                    teacher.setTcDept(rs.getString("tcDept"));
                    teacher.setMtPhone(rs.getString("mtPhone"));
                    teacher.setMtEmail(rs.getString("mtEmail"));
                }
                return teacher;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtils.release(c, psmt, rs);
            }
        }else{
            Class myClass = new Class();
            try {
                c = JdbcUtils.getConnection();
                String sql = "select * from class_msg where cId = ?";
                psmt = c.prepareStatement(sql);
                psmt.setString(1, id);
                rs = psmt.executeQuery();
                while(rs.next()){
                    myClass.setId(rs.getInt("id"));
                    myClass.setcId(rs.getString("cId"));
                    myClass.setcName(rs.getString("cName"));
                    myClass.setcNum(rs.getInt("cNum"));
                    myClass.setcMonitor(rs.getString("cMonitor"));
                    myClass.setcProfession(rs.getString("cProfession"));
                    myClass.setTcDept(rs.getString("tcDept"));
                }
                return myClass;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtils.release(c, psmt, rs);
            }
        }

        return null;
    }

    public Class findByName(String cName) {
        Class myClass = new Class();
        try{
            c = JdbcUtils.getConnection();
            String sql = "select * from class_msg where cName = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, cName);

            rs = psmt.executeQuery();
            while(rs.next()){
                myClass.setId(rs.getInt("id"));
                myClass.setcId(rs.getString("cId"));
                myClass.setcName(rs.getString("cName"));
                myClass.setcNum(rs.getInt("cNum"));
                myClass.setcMonitor(rs.getString("cMonitor"));
                myClass.setcProfession(rs.getString("cProfession"));
                myClass.setTcDept(rs.getString("tcDept"));
            }
            return myClass;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public ArrayList<Manager> findAllManagers() {
        try{
            c = JdbcUtils.getConnection();
            String sql = "select * from manager_msg";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();

            ArrayList<Manager> managers = new ArrayList<Manager>();
            while(rs.next()){
                Manager manager = new Manager();

                manager.setId(rs.getInt("id"));
                manager.setMtId(rs.getString("mtId"));
                manager.setMtName(rs.getString("mtName"));
                manager.setMtPhone(rs.getString("mtPhone"));
                manager.setMtEmail(rs.getString("mtEmail"));
                manager.setmOffice(rs.getString("mOffice"));
                manager.setmLabs(rs.getString("mLabs"));

                managers.add(manager);
            }

            return managers;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public ArrayList<Teacher> findAllTeachers() {
        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from teacher_msg";
            psmt = c.prepareStatement(sql);
            rs = psmt.executeQuery();

            ArrayList<Teacher> teachers = new ArrayList<Teacher>();

            while (rs.next()) {
                Teacher teacher = new Teacher();

                teacher.setId(rs.getInt("id"));
                teacher.setMtId(rs.getString("mtId"));
                teacher.setMtName(rs.getString("mtName"));
                teacher.settProject(rs.getString("tProject"));
                teacher.settClasses(rs.getString("tClasses"));
                teacher.setTcDept(rs.getString("tcDept"));
                teacher.setMtPhone(rs.getString("mtPhone"));
                teacher.setMtEmail(rs.getString("mtEmail"));

                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }
        return null;
    }

    public ArrayList<Class> findAllClasses() {
        try {
            c = JdbcUtils.getConnection();
            String sql = "select * from class_msg";
            psmt = c.prepareStatement(sql);

            rs = psmt.executeQuery();

            ArrayList<Class> classes = new ArrayList<Class>();
            while(rs.next()){
                Class myClass = new Class();
                myClass.setId(rs.getInt("id"));
                myClass.setcId(rs.getString("cId"));
                myClass.setcName(rs.getString("cName"));
                myClass.setcNum(rs.getInt("cNum"));
                myClass.setcMonitor(rs.getString("cMonitor"));
                myClass.setcProfession(rs.getString("cProfession"));
                myClass.setTcDept(rs.getString("tcDept"));

                classes.add(myClass);
            }
            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return null;
    }

    public boolean insert(Manager manager) {
        try {
            c = JdbcUtils.getConnection();
            String sql = "insert into manager_msg(mtId, mtName, mtPhone, mtEmail, mOffice, mLabs)values(" +
                    "?, ?, ?, ?, ?, ?)";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, manager.getMtId());
            psmt.setString(2, manager.getMtName());
            psmt.setString(3, manager.getMtPhone());
            psmt.setString(4, manager.getMtEmail());
            psmt.setString(5, manager.getmOffice());
            psmt.setString(6, manager.getmLabs());

            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }
    public boolean insert(Teacher teacher){
        try {
            c = JdbcUtils.getConnection();
            String sql = "insert into teacher_msg(mtId, mtName, tProject, tClasses, tcDept, mtPhone, mtEmail)values(" +
                    "?, ?, ?, ?, ?, ?, ?)";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, teacher.getMtId());
            psmt.setString(2, teacher.getMtName());
            psmt.setString(3, teacher.gettProject());
            psmt.setString(4, teacher.gettClasses());
            psmt.setString(5, teacher.getTcDept());
            psmt.setString(6, teacher.getMtPhone());
            psmt.setString(7, teacher.getMtEmail());

            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean insert(Class myClass){
        try {
            c = JdbcUtils.getConnection();
            String sql = "insert into class_msg(cId, cName, cNum, cMonitor, cProfession, tcDept)values(" +
                    "?, ?, ?, ?, ?, ?)";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, myClass.getcId());
            psmt.setString(2, myClass.getcName());
            psmt.setInt(3, myClass.getcNum());
            psmt.setString(4, myClass.getcMonitor());
            psmt.setString(5, myClass.getcProfession());
            psmt.setString(6, myClass.getTcDept());

            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean updateManagerById(Manager manager) {
        try {
            c = JdbcUtils.getConnection();
            String sql = "update manager_msg set mtName = ?, mtPhone = ?, mtEmail = ?, mOffice = ?, mLabs = ? where mtId = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, manager.getMtName());
            psmt.setString(2, manager.getMtPhone());
            psmt.setString(3, manager.getMtEmail());
            psmt.setString(4, manager.getmOffice());
            psmt.setString(5, manager.getmLabs());
            psmt.setString(6, manager.getMtId());

            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }
        return false;
    }

    public boolean updateTeacherById(Teacher teacher) {
        try {
            c = JdbcUtils.getConnection();
            String sql = "update teacher_msg set mtName = ?, mtPhone = ?, mtEmail = ?, tProject = ?, tClasses = ?, tcDept = ? where mtId = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, teacher.getMtName());
            psmt.setString(2, teacher.getMtPhone());
            psmt.setString(3, teacher.getMtEmail());
            psmt.setString(4, teacher.gettProject());
            psmt.setString(5, teacher.gettClasses());
            psmt.setString(6, teacher.getTcDept());
            psmt.setString(7, teacher.getMtId());

            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }
        return false;
    }

    public boolean updateClassById(Class myClass) {
        try {
            c = JdbcUtils.getConnection();
            String sql = "update class_msg set cName = ?, cNum = ?, cMonitor = ?, cProfession = ?, tcDept = ? where cId = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, myClass.getcName());
            psmt.setInt(2, myClass.getcNum());
            psmt.setString(3, myClass.getcMonitor());
            psmt.setString(4, myClass.getcProfession());
            psmt.setString(5, myClass.getTcDept());
            psmt.setString(6, myClass.getcId());

            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean deleteManagerById(String id) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "delete from manager_msg where mtId = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, id);

            int returnNum = psmt.executeUpdate();

            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean deleteTeacherById(String id) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "delete from teacher_msg where mtId = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, id);

            int returnNum = psmt.executeUpdate();

            return returnNum > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(c, psmt, rs);
        }

        return false;
    }

    public boolean deleteClassById(String id) {
        try{
            c = JdbcUtils.getConnection();
            String sql = "delete from class_msg where cId = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, id);

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
