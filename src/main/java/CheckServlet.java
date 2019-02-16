import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019/2/3.
 */
public class CheckServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        if (request.getParameter("method") != null && "httpHead".equals(request.getParameter("method"))) {
            httpHead(request, response);
        }else if(request.getParameter("method")!=null&&request.getParameter("method").equals("httpResponse")){
            httpResponse(request,response);
        }else if(request.getParameter("method")!=null&&"sendError".equals(request.getParameter("method"))) {
            sendError(request,response);
        }
            else{
            response.setContentType("text/html;charset=UTF-8");

            request.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            String title = "读取复选框内容";
            String taobao = request.getParameter("taobao");
            String rounn = request.getParameter("runoob");
            String goole = request.getParameter("goole");
            String doType = "<!DOCT Y P E  html> \n";
            writer.println(doType + "<html><head><title>" + title + "</title></head><body>\n");
            writer.println(
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                            "<table wiidth=\"100%\" border=\"1\" align=\"center\">" +
                            "<tr bgcolor=\"949494\"><th>参数名称</th><th>参数值 </th></tr>"

                            + "<ul>\n" + "<li><b>菜鸟教程标识：</b>" +
                            rounn + "</li>\n"
                            + "<li><b>Goole 标识:</b>" +
                            goole + "</li>\n" +
                            "<li>淘宝标识：</li>" + taobao + "\n" +
                            "</ul>"
            );
//        Enumeration enumeration=request.getParameterNames();
//        while (enumeration.hasMoreElements()){
//            String paramName=(String)enumeration.nextElement();
//            writer.println("<tr><td>"+paramName+"</td>");
//            String[] paramValue=request.getParameterValues(paramName);
//            if(paramName.length()==1){
//                String value=paramValue[0];
//                if(value.length()==0){
//                    writer.println("<td><i>没有值</i></td>");
//                }else{
//                    writer.println("<td>"+value+"</td>");
//                }
//            }else{
//                writer.println("<td><ul>");
//                for (int i=0;i<paramValue.length;i++){
//                    writer.println("<li>"+paramValue[i]+"</li>");
//                }
//                writer.println("</ul><td>");
//            }
//            writer.println("</tr>");
//        }
            writer.println("</body></html>");
            //writer.println( "</table></body></html>");
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        doGet(request,response);
    }

    public void httpHead(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter writer=response.getWriter();
        writer.println("<html><head><title>请求菜鸟教程");
        writer.println("</title></head><body>");
        writer.println("<table><tr><th>名称</th><th>值</th></tr>");
        Enumeration enumeration=request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String paramName=(String)enumeration.nextElement();
            String paramValue=request.getHeader(paramName);
            writer.print("<tr border=\"1\"><td>"+paramName+"</td><td>"+paramValue+"</td></tr>\n");
        }
        writer.println("</table></body></html>");
    }

    public void httpResponse(HttpServletRequest request,HttpServletResponse response) throws  IOException,ServletException{
        response.setIntHeader("Refresh",5);
        response.setContentType("text/html;charset=utf-8");
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate=simpleDateFormat.format(calendar.getTime());
        PrintWriter writer=response.getWriter();
        String title="自动刷新header设置";
        String docType="<!DocType html>\n";
        writer.println("<html><head><title>"+title+"</title><head>");
        writer.println("<h1 align=\"center\">"+title+"</h1>");
        writer.println("<p>当前时间是："+newDate+"</p>");
    }

    public void sendError(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        response.sendError(500,"未找到请求");
    }
}
