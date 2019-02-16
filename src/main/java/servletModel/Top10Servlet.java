package servletModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/31.
 */
public class Top10Servlet extends HttpServlet {

    private List<String> londonAttractions;

    private List<String> parisAttractions;

   // @Override
    public void init(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        londonAttractions=new ArrayList<String>(10);
        londonAttractions.add("Buckingham Palace");
        londonAttractions.add("London Eye");
        londonAttractions.add("British Museum");
        londonAttractions.add("National Gallery");
        londonAttractions.add("Big Ben");
        londonAttractions.add("Tower of london");
        londonAttractions.add("Naturnal History Museum");
        londonAttractions.add("Canary Whart");
        londonAttractions.add("2012 Olympic Park");
        londonAttractions.add("St Puauls Cathedral");

        parisAttractions=new ArrayList<String>(10);
        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Notre Dame");
        parisAttractions.add("Champs Elysees");
        parisAttractions.add("The Louevre");
        parisAttractions.add("Arc de Triomphe");
        parisAttractions.add("saince");
        parisAttractions.add("Les");
        parisAttractions.add("Musee");
        parisAttractions.add("Montmarte");
        parisAttractions.add("Sarce");

    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String city=request.getParameter("city");
        if(city!=null&&(city.equals("london")||city.equals("paris"))){
            showAttractions(request,response);
        }else{
            showMainPage(request,response);
        }
    }


    public void showAttractions(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        writer.println("<html><head><title>top10</title></head><body>");
        writer.println("Please select a city:"+"<br/><a href='?city=london'>London</a>" +
                "   zgst" +
                "");
    }

    public void showMainPage(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        response.setContentType("text/html");
    }
}
