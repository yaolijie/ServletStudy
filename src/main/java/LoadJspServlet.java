import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2019/2/3.
 */
public class LoadJspServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        if(req.getParameter("method")!=null&&req.getParameter("method").equals("loadmodel")){
//            loadmodel(req,resp);
//        }else{
//            doGet(req,resp);
//        }
//    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        if(request.getParameter("method")!=null&&request.getParameter("method").equals("loadmodel")){
            loadmodel(request,response);
        }else if(request.getParameter("method")!=null&&"loadCheck".equals(request.getParameter("method"))){
            request.getRequestDispatcher("view/jsp/FormJsp.jsp").forward(request,response);
        }else if(request.getParameter("method")!=null&&"upload".equals(request.getParameter("method"))) {
            upload(request,response);
        }else{
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        System.out.println("<h2>"+"get方法开始执行...."+"</h2>");
        String title="";
        String name=new String(request.getParameter("name"));
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
    }

   public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
       System.out.print("post方法");
       doGet(request,response);
   }

    public void loadmodel(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("view/jsp/FormJsp.jsp").forward(request,response);
    }
    public void upload(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("view/jsp/upload.jsp").forward(request,response);
    }
}

