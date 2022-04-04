package org.labbooksys.web.servlet.login;

import org.labbooksys.entity.ResultInfo;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExitServlet")
public class ExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo resultInfo = new ResultInfo();
        request.getSession().invalidate();

        resultInfo.setFlag(true);
        resultInfo.setData(true);
        resultInfo.setReturnInfo("用户已退出登录，session已销毁");

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }
}
