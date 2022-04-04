package org.labbooksys.web.servlet.swiper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.Swiper;
import org.labbooksys.service.swiper.SwiperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "SwiperServlet")
public class SwiperServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo resultInfo = new ResultInfo();
        HashSet<Swiper> swipers = SwiperService.getSwipers();

        resultInfo.setData(swipers);
        if(swipers != null){
            resultInfo.setFlag(true);
            resultInfo.setReturnInfo("获取轮播图成功");
        }else{
            resultInfo.setFlag(false);
            resultInfo.setReturnInfo("获取轮播图失败");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        response.getWriter().print(json);
    }
}
