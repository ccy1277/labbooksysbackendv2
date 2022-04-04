package org.labbooksys.service.msg;

import org.labbooksys.dao.impl.PersonalMsgDaoImpl;
import org.labbooksys.entity.Class;
import org.labbooksys.entity.Manager;
import org.labbooksys.entity.Teacher;

import java.util.ArrayList;

public class MsgService {
    /**
     * 创建管理员/教师/班级的信息
     * @param obj  管理员/教师/班级对象
     * @return true:创建成功,false:创建失败;
     */
    public static boolean setPersonalMsg(Object obj){
        PersonalMsgDaoImpl pmdi = new PersonalMsgDaoImpl();

        if(obj instanceof Manager){
            Manager manager = (Manager)obj;

            if(((Manager)pmdi.findById(manager.getMtId(), "管理员")).isExist()){
                // 该用户不存在时插入
                return pmdi.insert(manager);
            }else{
                // 该用户存在时修改
                return pmdi.updateManagerById(manager);
            }
        }else if(obj instanceof Teacher){
            Teacher teacher = (Teacher) obj;

            if(((Teacher)pmdi.findById(teacher.getMtId(), "教师")).isExist()){
                // 该用户不存在时插入
                return pmdi.insert(teacher);
            }else{
                // 该用户存在时修改
                return pmdi.updateTeacherById(teacher);
            }
        }else if(obj instanceof Class){
            Class myClass = (Class)obj;
            if(((Class)pmdi.findById(myClass.getcId(), "班级")).isExist()){
                // 该用户不存在时插入
                return pmdi.insert(myClass);
            }else{
                // 该用户存在时修改
                return pmdi.updateClassById(myClass);
            }
        }

        return false;
    }

    public static ArrayList<Manager> getAllManagerMsg(){
        return new PersonalMsgDaoImpl().findAllManagers();
    }

    public static ArrayList<Teacher> getAllTeacherMsg(){
        return new PersonalMsgDaoImpl().findAllTeachers();
    }

    public static ArrayList<Class> getAllClassMsg(){
        return new PersonalMsgDaoImpl().findAllClasses();
    }

    /**
     * 根据工号查询管理员的信息
     * @param id 工号
     * @return  管理员对象
     */
    public static Manager getManagerMsg(String id){
        return (Manager)new PersonalMsgDaoImpl().findById(id, "管理员");
    }

    /**
     * 根据工号查询教师的信息
     * @param id 工号
     * @return  教师对象
     */
    public static Teacher getTeacherMsg(String id){
        return (Teacher)new PersonalMsgDaoImpl().findById(id, "教师");
    }

    /**
     * 根据班级号查询班级的信息
     * @param id 班级号
     * @return  班级对象
     */
    public static Class getClassMsgById(String id){
        return (Class)new PersonalMsgDaoImpl().findById(id, "班级");
    }

    public static Class getClassMsgByName(String cName){
        return new PersonalMsgDaoImpl().findByName(cName);
    }

    public static boolean dropMsg(String id, String role){
        if(role.equals("管理员")){
            return new PersonalMsgDaoImpl().deleteManagerById(id);
        }else if(role.equals("教师")){
            return new PersonalMsgDaoImpl().deleteTeacherById(id);
        }else{
            return new PersonalMsgDaoImpl().deleteClassById(id);
        }
    }
}
