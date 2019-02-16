import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/6.
 */
public class testFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String site=filterConfig.getInitParameter("site");
        System.out.println(site+"网站名称");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("调用本过滤器");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
