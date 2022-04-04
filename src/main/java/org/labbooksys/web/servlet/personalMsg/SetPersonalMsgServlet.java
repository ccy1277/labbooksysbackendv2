package org.labbooksys.web.servlet.personalMsg;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.*;
import org.labbooksys.entity.Class;
import org.labbooksys.service.msg.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetPersonalMsg")
public class SetPersonalMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String msg = request.getParameter("msg");

        ResultInfo resultInfo = new ResultInfo();
        boolean flag;
        // 将json字符串转成对象
        ObjectMapper mapper = new ObjectMapper();
        // 判断role
        if("管理员".equals(role)) {
            Manager manager = mapper.readValue(msg, Manager.class);
            flag = MsgService.setPersonalMsg(manager);
        }else if("教师".equals(role)){
            Teacher teacher = mapper.readValue(msg, Teacher.class);
            flag = MsgService.setPersonalMsg(teacher);
        }else{
            Class myClass = mapper.readValue(msg, Class.class);
            flag = MsgService.setPersonalMsg(myClass);
        }

        resultInfo.setFlag(flag);
        resultInfo.setData(flag);
        if(flag)
            resultInfo.setReturnInfo("信息保存成功");
        else
            resultInfo.setReturnInfo("信息保存失败");

        String json = mapper.writeValueAsString(resultInfo);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
