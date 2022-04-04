package org.labbooksys.service.cat;

import org.labbooksys.dao.impl.TitleListDaoImpl;
import org.labbooksys.entity.TitleList;

import java.util.ArrayList;

public class TitleListService {
    public static ArrayList<TitleList> getCat(){
        TitleListDaoImpl titleListDaoImpl = new TitleListDaoImpl();

        return titleListDaoImpl.findAll();

    }
}
