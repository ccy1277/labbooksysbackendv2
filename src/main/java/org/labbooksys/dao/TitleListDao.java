package org.labbooksys.dao;

import org.labbooksys.entity.TitleList;

import java.util.ArrayList;

public interface TitleListDao {
    /**
     * 查询系统列表标题
     * @return 返回存储着TitleList的HashSet集合
     */
    public ArrayList<TitleList> findAll();
}
