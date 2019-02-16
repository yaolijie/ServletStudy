import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Administrator on 2019/2/10.
 */
public class DatabaseAccess extends HttpServlet {

    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysqk://localhost:3306/RUNOOB";
    static final String USER="root";
    static final String PASS="123456";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        Connection conn=null;
        Statement stmt=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String title="mysql测试";
        String docType="<!DOCTYPE html>";
        out.println(docType+"<html><head><title>"+title+"</title></head>" +
                "<body><h1>"+title+"</h1>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            stmt=conn.createStatement();
            String sql="select id,name,url from webstites";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String url=rs.getString("url");
                out.println("ID  :"+id);
                out.println("name   :"+name);
                out.println("url    :"+url);
            }
            out.println("</body><html>");
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ee){
            ee.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null)
                    stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest requset,HttpServletResponse response) throws IOException,ServletException{
        doGet(requset,response);
    }
}
