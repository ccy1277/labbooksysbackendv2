package org.labbooksys.service.login;

import org.labbooksys.dao.impl.UserDaoImpl;
import org.labbooksys.entity.User;

public class RegisterService {
    public static boolean registerUser(User user){
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        // 判断该用户是否存在
        User myUser = userDaoImpl.findById(user.getUsers_id());
        if(myUser != null){
            // 该用户存在
            return false;
        }else{
            // 该用户不存在
            return userDaoImpl.insert(user);
        }
    }
}
