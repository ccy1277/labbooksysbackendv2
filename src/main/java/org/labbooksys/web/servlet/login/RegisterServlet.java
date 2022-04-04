package org.labbooksys.web.servlet.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.User;
import org.labbooksys.service.login.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取注册用户数据,并将数据封装User对象
        User user = new User();
        user.setUsers_id(request.getParameter("id"));
        user.setUsers_pwd(request.getParameter("pwd"));
        user.setUsers_role(request.getParameter("role"));
        user.setUsers_token("test no token");

        // 调用service方法
        boolean flag = RegisterService.registerUser(user);
        ResultInfo resultInfo = new ResultInfo();
        // 封装响应结果
        resultInfo.setData(flag);
        if(flag){
            resultInfo.setFlag(true);
            resultInfo.setReturnInfo("注册成功");
        }else {
            resultInfo.setFlag(false);
            resultInfo.setReturnInfo("注册失败");
        }
        // 将对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        // 将json数据返回至前端
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
