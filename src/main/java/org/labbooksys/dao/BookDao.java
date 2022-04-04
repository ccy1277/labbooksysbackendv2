package org.labbooksys.dao;

import org.labbooksys.entity.Book;

import java.util.ArrayList;

public interface BookDao {
    /**
     * 管理员发布预约 （预约状态）
     * @param labId 预约的实验室id
     * @param bookTime 预约上实验的时间
     * @param bookStatus 预约状态
     * @return true：成功 false：失败
     */
    public boolean insert(String labId, String[] bookTime, String bookStatus);

    /**
     * 教师选择管理员发布的预约（完善预约信息 即预约对应时间的实验室 （预约状态））
     * @param bookId 预约列表序号
     * @param name  教师姓名
     * @param myClass 任教班级
     * @param project 任教实验
     * @return true：成功 false：失败
     */
    public boolean update(int bookId, String name, String myClass, String project);

    /**
     * 管理员撤销预约
     * @param bookId 撤销的预约id
     * @return true：成功 false：失败
     */
    public boolean delete(String bookId);

    /**
     * 查询所有的预约
     * @return 预约对象集合
     */
    public ArrayList<Book> findAll();

    public Book findById(int id);
}
