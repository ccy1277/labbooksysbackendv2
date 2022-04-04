package org.labbooksys.web.servlet.cat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.TitleList;
import org.labbooksys.service.cat.TitleListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TitleListServlet")
public class TitleListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TitleList> cat = new ArrayList<TitleList>();
        ResultInfo resultInfo = new ResultInfo();

        cat = TitleListService.getCat();
        resultInfo.setData(cat);
        if(cat != null){
            resultInfo.setFlag(true);
            resultInfo.setReturnInfo("请求列表标题成功");
        }else{
            resultInfo.setFlag(false);
            resultInfo.setReturnInfo("请求列表标题失败");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        response.getWriter().print(json);
    }
}
