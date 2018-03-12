package com.werson.springtest.servlet.filter;

import javax.servlet.*;
import java.io.PrintWriter;

/**
 * Created by wersom on 2018/2/28.
 */
public class AuthenFilter implements Filter {

    public void  init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        String name = request.getParameter("name");

        // 过滤器核心代码逻辑
        System.out.println("过滤器获取请求参数:"+name);

        if("123".equals(name)){
            // 把请求传回过滤链
            chain.doFilter(request,response);
        }else{
            //设置返回内容类型
            response.setContentType("text/html;charset=GBK");

            //在页面输出响应信息
            PrintWriter out = response.getWriter();
            out.print("<b>name不正确，请求被拦截，不能访问web资源</b>");
            System.out.println("name不正确，请求被拦截，不能访问web资源");
        }

    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
        System.out.println("过滤器被移除");
    }
}
