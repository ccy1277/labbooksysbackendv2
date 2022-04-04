package org.labbooksys.web.servlet.personalMsg;

import org.labbooksys.entity.Manager;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.Teacher;
import org.labbooksys.entity.Class;
import org.labbooksys.service.msg.MsgService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetAllMsgServlet")
public class GetAllMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");

        ResultInfo resultInfo = new ResultInfo();

        if(role.equals("管理员")){
            ArrayList<Manager> managers = MsgService.getAllManagerMsg();
            resultInfo.setData(managers);
            if(null != managers){
                resultInfo.setFlag(true);
                resultInfo.setReturnInfo("查询全体管理员信息成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setReturnInfo("查询全体管理员信息成功");
            }
        }else if(role.equals("教师")){
            ArrayList<Teacher> teachers = MsgService.getAllTeacherMsg();
            resultInfo.setData(teachers);
            if(null != teachers){
                resultInfo.setFlag(true);
                resultInfo.setReturnInfo("查询全体教师信息成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setReturnInfo("查询全体教师信息成功");
            }
        }else{
            ArrayList<Class> classes = MsgService.getAllClassMsg();
            resultInfo.setData(classes);
            if(null != classes){
                resultInfo.setFlag(true);
                resultInfo.setReturnInfo("查询全体班级信息成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setReturnInfo("查询全体班级信息成功");
            }
        }

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }
}
