package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /** 1,doFilter方法的第一个参数为ServletRequest对象。此对象给过滤器提供了对进入的信息（包括* 表单数据、cookie和HTTP请求头）的完全访问。第二个参数为ServletResponse，通常在简单的过* 滤器中忽略此参数。最后一个参数为FilterChain，此参数用来调用servlet或JSP页。*/
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        /** 如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中* 无法得到的方法，就要把此request对象构造成HttpServletRequest*/
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String currentURL = request.getRequestURI();
        System.out.println(currentURL);
        //取得根目录所对应的绝对路径:
        String targetURL = currentURL.substring(currentURL.indexOf("/", 1), currentURL.length());
        System.out.println(targetURL);
        //截取到当前文件名用于比较
        HttpSession session = request.getSession(false);
        if (!"/login.html".equals(targetURL)) {//判断当前页是否是重定向以后的登录页面页面，如果是就不做session的判断，防止出现死循环
            if (session == null || session.getAttribute("root") == null) {
                //*用户登录以后需手动添加session
                System.out.println("request.getContextPath()=" + request.getContextPath());
                response.sendRedirect(request.getContextPath() + "/login.html");
                //如果session为空表示用户没有登录就重定向到login.html页面
                return;
            }
        }
        //加入filter链继续向下执行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
