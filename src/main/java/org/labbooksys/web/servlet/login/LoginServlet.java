package org.labbooksys.web.servlet.login;

import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.User;
import org.labbooksys.service.login.LoginService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet2")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取登录用户数据
        User user = new User();
        user.setUsers_id(request.getParameter("id"));
        user.setUsers_pwd(request.getParameter("pwd"));
        // 判断账号密码是否正确
        User myUser = LoginService.login(user);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(myUser);

        // 封装ResultInfo对象
        if(myUser == null){
            resultInfo.setFlag(false);
//            resultInfo.setData(false);
            resultInfo.setReturnInfo("登录失败");
        }else{
            resultInfo.setFlag(true);
//            resultInfo.setData(true);
            resultInfo.setReturnInfo("登录成功");
            // 登录成功 创建session
            HttpSession session = request.getSession();
            session.setAttribute("user", JsonUtils.toJsonString(myUser));
        }

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
