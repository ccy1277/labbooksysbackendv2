package org.labbooksys.service.swiper;

import org.labbooksys.dao.impl.SwiperDaoImpl;
import org.labbooksys.entity.Swiper;

import java.util.HashSet;

public class SwiperService {
    public static HashSet<Swiper> getSwipers(){
        SwiperDaoImpl swiperDaoImpl = new SwiperDaoImpl();
        HashSet<Swiper> swipers = swiperDaoImpl.findAll();
        return swipers;
    }
}
