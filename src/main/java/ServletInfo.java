import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019/2/2.
 */
public class ServletInfo extends HttpServlet {

    private static String message;

    public void init(ServletConfig config) throws ServletException{

        System.out.println("servlet初次加载。。。");
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        System.out.println("<h2>"+"get方法开始执行...."+"</h2>");
        String title="";
        String name=new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String docType="<!DOCTYPE html>\n";
        pw.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + request.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException{
        Enumeration enumeration=request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String hq=(String)enumeration.nextElement();
        }
    }

    public void destroy(){

    }


}
