package org.labbooksys.service.book;

import org.labbooksys.dao.impl.BookDaoImpl;
import org.labbooksys.entity.Book;
import org.labbooksys.entity.Lab;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.service.lab.LabsService;
import org.labbooksys.service.msg.MsgService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class BookService {
    public static ArrayList<Book> getAllBooksMsg(){
        return new BookDaoImpl().findAll();
    }

    /**
     * （管理员）发布预约
     * @param labId 实验室id
     * @param booksDate 实验室开放日期
     * @param times 实验室开放时间
     * @return true: 发布成功 false: 发布失败
     */
    public static boolean setBookMsg(String labId, String booksDate, String[] times){
        // 数据处理 bookTime = date + times[i]
        int len = times.length;
        String[] booksTime = new String[len];

        for(int i = 0; i < len; i++)
            booksTime[i] = booksDate + "  " + times[i];

        return new BookDaoImpl().insert(labId, booksTime, "可预约");
    }

    /**
     * （教师）为（班级）预约实验室
     * @param bookId 预约序号
     * @param name 教师姓名
     * @param myClass 上该实验的班级
     * @param project 实验名称
     * @return ResultInfo
     */
    public static ResultInfo setBookedMsg(int bookId, String name, String myClass, String project) throws ParseException {
        // 创建返回信息封装对象
        ResultInfo resultInfo = new ResultInfo();
        // 对预约班级数据进行处理
        String[] classNames = myClass.split(";|；| |,|，|、|\\|");
        // 获取预约班级总人数
        int num = MsgService.getClassMsgByName(classNames[0]).getcNum() + MsgService.getClassMsgByName(classNames[0]).getcNum();
        // 根据预约记录找到实验室id
        Book book = new BookDaoImpl().findById(bookId);
        String labsId = book.getLabs_id();
        // 根据实验室id查询实验室容纳人数与状态
        Lab lab = LabsService.getLabs(labsId);
        int maxNum = lab.getLabs_num();
        String labStatus = lab.getLabs_status();
        // 获取当前预约时间
        // 获取预约记录允许的日期
        String bookDate = book.getBooks_time().split(" ")[0];
        String[] dates = bookDate.split("/");
        System.out.println(bookDate);
        // 创建Calendar对象
        Calendar ca = Calendar.getInstance();
        // 获取当前时间
        int nowYear = ca.get(Calendar.YEAR);
        int nowMonth = ca.get(Calendar.MONTH) + 1;
        int nowDay = ca.get(Calendar.DATE);
        // 处理预约记录允许的日期
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        // 进行预约
        System.out.println(year + " " + month + " " + day);
        System.out.println(nowYear + " " + nowMonth + " " + nowDay);

        if(labStatus.equals("可预约") && (nowYear <= year && nowMonth <= month && nowDay <= day)){ //&& date.before(bookDate)
            // 实验室状态允许 时间允许 人数不符合也可以强制预约
            boolean flag = new BookDaoImpl().update(bookId, name, myClass, project);
            resultInfo.setFlag(flag);
            if(flag){
                // 人数符合要求
                if(maxNum >= num){
                    resultInfo.setData(true);
                    resultInfo.setReturnInfo("预约成功");
                }else{
                    // 提示人数过多
                    resultInfo.setData("warning");
                    resultInfo.setReturnInfo("警告：实验室预约人数大于实验室容纳人数");
                }
            }else{
                resultInfo.setData("error");
                resultInfo.setReturnInfo("预约失败");
            }
        }else {
            resultInfo.setFlag(false);
            resultInfo.setData(false);
            resultInfo.setReturnInfo("预约失败,该实验室当前不可预约");
        }

        return resultInfo;
    }

    public static boolean deleteBookMsg(String bookId){
        return new BookDaoImpl().delete(bookId);
    }
}
