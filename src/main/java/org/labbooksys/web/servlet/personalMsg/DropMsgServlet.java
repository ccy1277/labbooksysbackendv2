package org.labbooksys.web.servlet.personalMsg;

import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.msg.MsgService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DropMsgServlet")
public class DropMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String role = request.getParameter("role");

        ResultInfo resultInfo = new ResultInfo();
        boolean flag = MsgService.dropMsg(id, role);

        resultInfo.setFlag(flag);
        resultInfo.setData(flag);
        if(flag)
            resultInfo.setReturnInfo("删除个人/班级信息成功");
        else
            resultInfo.setReturnInfo("删除个人/班级信息失败");

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }
}
