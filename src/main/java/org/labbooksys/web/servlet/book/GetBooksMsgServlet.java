package org.labbooksys.web.servlet.book;

import org.labbooksys.entity.Book;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.book.BookService;
import org.labbooksys.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetBooksMsgServlet")
public class GetBooksMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books;
        ResultInfo resultInfo = new ResultInfo();

        books = BookService.getAllBooksMsg();
        resultInfo.setData(books);
        if(books != null){
            resultInfo.setFlag(true);
            resultInfo.setReturnInfo("查询预约列表成功");
        }else{
            resultInfo.setFlag(false);
            resultInfo.setReturnInfo("查询预约列表失败");
        }

        String json = JsonUtils.toJsonString(resultInfo);

        response.getWriter().print(json);
    }
}
