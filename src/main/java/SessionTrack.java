import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/2/10.
 */
public class SessionTrack extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        HttpSession session=request.getSession();
        Date createDate=new Date(session.getCreationTime());
        Date lastDate=new Date(session.getLastAccessedTime());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String title="httpsession实例";
        Integer visitCount=new Integer(0);
        String visitCountKey=new String("visitCount");
        String userIDKey=new String("userID");
        String userID=new String("Runoob");
        if(session.getAttribute(visitCountKey)==null){
            session.setAttribute(visitCountKey,new Integer(0));
        }

        //检查网页上是否有新的访客
        if (session.isNew()){
            title="session菜鸟教程";
            session.setAttribute(userIDKey,userID);
        }else{
            visitCount=(Integer)session.getAttribute(visitCountKey);
            visitCount=visitCount+1;
            userID=(String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,visitCount);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        String docType="<!DOCTYPE html>";
        out.println(docType+"<html><head><title>"+title+"</title></head>" +
                "<body><h1>"+title+"</h1>" +
                "<h2>session信息</h2>"+"<table><tr><th>session信息</th><th>值</th></tr>" +
                "<tr><td>创建时间</td><td>"+simpleDateFormat.format(createDate)+"</td></tr><tr><td>" +
                "用户ID</td><td>"+userID+"</td></tr><tr><td>" +
                "访问统计:</td><td>"+visitCount+"</td></tr>" );
        session.removeAttribute(userID);
        out.println("<tr><td>remove后的userID:</td><td>"+session.getAttribute(userID)+"</td></tr>");
        out.println("<tr><td>读取web.xml中的过期时间</td><td>"+session.getMaxInactiveInterval()+"</td><tr>");
        out.println("</table></body></html>");
    }
}
