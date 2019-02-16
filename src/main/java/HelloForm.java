import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2019/2/10.
 */
public class HelloForm extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        Cookie name=new Cookie("name", URLEncoder.encode(request.getParameter("name"),"UTF-8"));
        Cookie url=new Cookie("url",request.getParameter("url"));
        name.setMaxAge(360000);
        url.setMaxAge(360000);
        response.addCookie(name);
        response.addCookie(url);
        Integer n=name.getMaxAge();
        Integer u=url.getMaxAge();
        Cookie[] cookies=request.getCookies();
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "设置 Cookie 实例";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名：</b>："
                + request.getParameter("name") + "\n</li>" +
                "  <li><b>站点 URL：</b>："
                + request.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
