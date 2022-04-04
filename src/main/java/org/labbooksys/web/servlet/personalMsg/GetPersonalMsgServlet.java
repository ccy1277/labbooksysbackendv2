package org.labbooksys.web.servlet.personalMsg;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.Class;
import org.labbooksys.entity.Manager;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.Teacher;
import org.labbooksys.service.msg.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonalMsgServlet")
public class GetPersonalMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String role = request.getParameter("role");
        ResultInfo resultInfo = new ResultInfo();

        if("管理员".equals(role)) {
            Manager manager = MsgService.getManagerMsg(id);
            if(manager != null){
                resultInfo.setFlag(true);
                resultInfo.setReturnInfo("查询管理员信息成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setReturnInfo("查询管理员信息失败");
            }
            resultInfo.setData(manager);
        }else if("教师".equals(role)){
            Teacher teacher = MsgService.getTeacherMsg(id);
            if(teacher != null){
                resultInfo.setFlag(true);
                resultInfo.setReturnInfo("查询教师信息成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setReturnInfo("查询教师信息失败");
            }
            resultInfo.setData(teacher);
        }else{
            Class myClass = MsgService.getClassMsgById(id);
            if(myClass != null){
                resultInfo.setFlag(true);
                resultInfo.setReturnInfo("查询班级信息成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setReturnInfo("查询班级信息失败");
            }
            resultInfo.setData(myClass);
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
