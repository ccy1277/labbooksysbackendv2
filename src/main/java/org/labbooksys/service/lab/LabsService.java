package org.labbooksys.service.lab;

import org.labbooksys.dao.impl.LabDaoImpl;
import org.labbooksys.entity.Lab;

import java.util.ArrayList;

public class LabsService {
    public static ArrayList<Lab> getAllLabsMsg(){
        return new LabDaoImpl().findAll();
    }

    public static ArrayList<Lab> getMtLabs(String mtId){
        return new LabDaoImpl().findByMtId(mtId);
    }

    public static Lab getLabs(String labsId){
        return new LabDaoImpl().findById(labsId);
    };

    public static boolean deleteLab(String id){
        return new LabDaoImpl().deleteById(id);
    }

    public static boolean setLab(Lab lab){
        LabDaoImpl labDaoImpl = new LabDaoImpl();

        // 判断该实验室是否已经存在
        if(labDaoImpl.findById(lab.getLabs_id()).getLabs_id() != null){
            // 存在 即更新实验室信息
            return labDaoImpl.updateById(lab);
        }else{
            // 不存在 创建实验室信息

            return labDaoImpl.insert(lab);
        }
    }
}
