package org.labbooksys.dao;

import org.labbooksys.entity.User;

import java.util.HashSet;

public interface UserDao {
    /**
     * 根据用户ID查询用户信息；
     * @param id
     * @return 若用户存在一个User对象;返回值若为空: 该用户不存在;
     */
    public User findById(String id);

    /**
     * 注册新用户，将用户信息存至user表中；
     * @param user
     * @return 返回值>0，注册成功，否则注册失败
     */
    public boolean insert(User user);


    /**
     * 查询所有用户信息
     * @return 返回所有的用户信息
     */
    public HashSet<User> findAll();
}
