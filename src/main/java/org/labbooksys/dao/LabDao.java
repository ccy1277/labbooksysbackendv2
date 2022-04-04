package org.labbooksys.dao;

import org.labbooksys.entity.Lab;

import java.util.ArrayList;

public interface LabDao {
    /**
     * 查询所有的实验室信息
     * @return 返回所有的实验室对象集合
     */
    public ArrayList<Lab> findAll();

    /**
     * 根据实验室id 查询某一实验室的信息
     * @param id 想要查找的实验室id
     * @return 返回查找的实验室对象
     */
    public Lab findById(String id);

    /**
     * 根据管理员id 查询该管理员所管理的实验室
     * @param mtId 管理员id
     * @return 返回该管理员所管理的实验室集合
     */
    public ArrayList<Lab> findByMtId(String mtId);

    /**
     * 根据实验室id 删除该实验室的信息
     * @param id 想要删除的实验室id
     * @return true：成功 false：失败
     */
    public boolean deleteById(String id);

    /**
     * 创建新的实验室数据
     * @param lab 想要创建的实验室对象
     * @return true：成功 false：失败
     */
    public boolean insert(Lab lab);

    /**
     * 根据新的实验室对象修改该对象
     * @param lab 更改的实验对象
     * @return true：成功 false：失败
     */
    public boolean updateById(Lab lab);
}
