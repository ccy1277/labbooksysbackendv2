package org.labbooksys.service.login;

import org.labbooksys.dao.impl.UserDaoImpl;
import org.labbooksys.entity.User;

public class LoginService {
    public static User login(User user){
        /*
            判断账号密码是否正确
         */
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User myUser = userDaoImpl.findById(user.getUsers_id());

        if(myUser == null)
            return null;
        else if(myUser.getUsers_pwd().equals(user.getUsers_pwd()))
            return myUser;
        else
            return null;
    }
}
