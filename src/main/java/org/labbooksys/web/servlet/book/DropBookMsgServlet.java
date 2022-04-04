package org.labbooksys.web.servlet.book;

import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.book.BookService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DropBookMsgServlet")
public class DropBookMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        ResultInfo resultInfo = new ResultInfo();

        boolean flag = BookService.deleteBookMsg(bookId);
        resultInfo.setFlag(flag);
        resultInfo.setData(flag);

        if(flag)
            resultInfo.setReturnInfo("删除预约成功");
        else{
            resultInfo.setReturnInfo("删除预约失败");
        }

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }
}
