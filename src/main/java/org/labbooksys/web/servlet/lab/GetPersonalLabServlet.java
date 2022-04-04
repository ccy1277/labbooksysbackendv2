package org.labbooksys.web.servlet.lab;

import org.labbooksys.entity.Lab;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.lab.LabsService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetPersonalLabServlet")
public class GetPersonalLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mtId = request.getParameter("id");

        ArrayList<Lab> labs = LabsService.getMtLabs(mtId);

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(labs);
        if(labs != null){
            resultInfo.setFlag(true);
            resultInfo.setReturnInfo("获取对应的实验室数据成功");
        }else{
            resultInfo.setFlag(false);
            resultInfo.setReturnInfo("获取对应的实验室数据失败");
        }

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }
}
