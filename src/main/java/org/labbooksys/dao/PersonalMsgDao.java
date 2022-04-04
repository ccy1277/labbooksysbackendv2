package org.labbooksys.dao;

import org.labbooksys.entity.Class;
import org.labbooksys.entity.Manager;
import org.labbooksys.entity.Teacher;

import java.util.ArrayList;

public interface PersonalMsgDao {
    /**
     * @return 返回所有的Manager
     */
    public ArrayList<Manager> findAllManagers();

    /**
     * @return 返回所有的Teacher
     */
    public ArrayList<Teacher> findAllTeachers();

    /**
     * @return 返回所有的Class
     */
    public ArrayList<Class> findAllClasses();

    /**
     * 根据工号/班级号 +身份 查询管理员/教师/班级的信息
     * @param id 工号/班级号
     * @param role 身份
     * @return  管理员/教师/班级对象
     */
    public Object findById(String id, String role);

    /**
     * 根据班级名查找对应班级信息
     * @param cName 想要查询的班级名
     * @return 班级对象
     */
    public Class findByName(String cName);

    /**
     * 创建管理员的信息
     * @param manager 管理员
     * @return true:创建成功,false:创建失败;
     */
    public boolean insert(Manager manager);

    /**
     * 创建教师的信息
     * @param teacher 教师对象
     * @return true:创建成功,false:创建失败;
     */
    public boolean insert(Teacher teacher);

    /**
     * 创建班级的信息
     * @param myClass 班级对象
     * @return true:创建成功,false:创建失败;
     */
    public boolean insert(Class myClass);

    /**
     * 修改管理员的信息
     * @param manager 管理员对象
     * @return true:成功,false:失败;
     */
    public boolean updateManagerById(Manager manager);

    /**
     * 修改管理员的信息
     * @param teacher 教师
     * @return true:成功,false:失败;
     */
    public boolean updateTeacherById(Teacher teacher);

    /**
     * 修改管理员的信息
     * @param myClass 班级对象
     * @return true:成功,false:失败;
     */
    public boolean updateClassById(Class myClass);

    /**
     * 删除管理员
     * @param id 管理员id
     * @return true:成功,false:失败;
     */
    public boolean deleteManagerById(String id);

    /**
     * 删除教师
     * @param id 教师id
     * @return true:成功,false:失败;
     */
    public boolean deleteTeacherById(String id);

    /**
     * 删除班级
     * @param id 班级id
     * @return true:成功,false:失败;
     */
    public boolean deleteClassById(String id);
}
