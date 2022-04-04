package org.labbooksys.dao;

import org.labbooksys.entity.Swiper;

import java.util.HashSet;

public interface SwiperDao {
    /**
     * 查询所有广告图片的数据
     * @return 返回存储着Swiper的HashSet集合
     */
    public HashSet<Swiper> findAll();
}
