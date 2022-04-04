package org.labbooksys.web.servlet.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.book.BookService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetBookMsgServlet")
public class SetBookMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labId = request.getParameter("labId");
        String booksDate = request.getParameter("booksDate");
        // 注意测试一下这个数据 是否是数组 如何转换成数组
        String time = request.getParameter("booksTime");
        String[] times = new ObjectMapper().readValue(time, String[].class);

        boolean flag = BookService.setBookMsg(labId, booksDate, times);

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setFlag(flag);
        resultInfo.setData(flag);
        if(flag)
            resultInfo.setReturnInfo("创建预约成功");
        else
            resultInfo.setReturnInfo("创建预约异常(请注意是否重复预约)");

        String json = JsonUtils.toJsonString(resultInfo);

        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
