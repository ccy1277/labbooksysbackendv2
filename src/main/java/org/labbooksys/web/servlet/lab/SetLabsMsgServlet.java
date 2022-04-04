package org.labbooksys.web.servlet.lab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.Lab;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.lab.LabsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetLabsMsgServlet")
public class SetLabsMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labs_id = request.getParameter("labs_id");
        int labs_num = Integer.parseInt(request.getParameter("labs_num"));
        String labs_equipment = request.getParameter("labs_equipment");
        String labs_status = request.getParameter("labs_status");
        String mtId = request.getParameter("mtId");

        Lab lab = new Lab();
        ResultInfo resultInfo = new ResultInfo();

        lab.setLabs_id(labs_id);
        lab.setLabs_num(labs_num);
        lab.setLabs_equipment(labs_equipment);
        lab.setLabs_status(labs_status);
        lab.setManager_id(mtId);

        //  新增/修改实验室
        boolean flag = LabsService.setLab(lab);

        resultInfo.setFlag(flag);
        resultInfo.setData(flag);
        if(flag)
            resultInfo.setReturnInfo("编辑实验室成功");
        else{
            resultInfo.setReturnInfo("编辑实验室失败");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
