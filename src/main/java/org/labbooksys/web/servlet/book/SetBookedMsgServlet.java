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
import java.text.ParseException;

@WebServlet(name = "SetBookedMsgServlet")
public class SetBookedMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String teacherName = request.getParameter("name");
        String myClass = request.getParameter("class");
        String project = request.getParameter("project");
        // 教师预约实验
        ResultInfo resultInfo = null;
        try {
            resultInfo = BookService.setBookedMsg(bookId, teacherName, myClass, project);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String json = JsonUtils.toJsonString(resultInfo);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
