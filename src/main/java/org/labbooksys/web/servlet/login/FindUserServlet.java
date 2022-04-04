package org.labbooksys.web.servlet.login;

import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.User;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo resultInfo = new ResultInfo();
        // 创建或者获取保存用户信息的session对象
        HttpSession session = request.getSession();
        // session.getAttribute()的返回值;
        String userString = (String) session.getAttribute("user");
        User user = null;
        if(userString != null){
            user = JsonUtils.toUserObject(userString);
        }

        if(null == user){
            resultInfo.setFlag(false);
            resultInfo.setData(false);
            resultInfo.setReturnInfo("您还没有登录，请登录");
            // 重定向到登录页面
//            response.sendRedirect("http://" + request.getLocalAddr() + ":8080" );
        }else{
            resultInfo.setFlag(true);
            resultInfo.setData(user);
            resultInfo.setReturnInfo("欢迎您的访问");
        }

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }
}
