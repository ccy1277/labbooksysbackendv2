package org.labbooksys.web.servlet.lab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.lab.LabsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DropLabServlet")
public class DropLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("labsId");

        // 删除实验室
        ResultInfo resultInfo = new ResultInfo();
        boolean flag = LabsService.deleteLab(id);
        resultInfo.setFlag(flag);
        resultInfo.setData(flag);
        if(flag)
            resultInfo.setReturnInfo("删除成功");
        else
            resultInfo.setReturnInfo("删除失败");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
