package work.ccpw.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Entry
 * @description: ${description}
 * @author: cone
 * @create: 2020-06-26 21:30
 **/
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    /**
     * 敏感词汇集合
     */
    private List<String> list = new ArrayList<String>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
            // 1. 获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感目录.txt");
            System.out.println(realPath);
            // 2.读取文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            // 3.将文件的每一行数据添加到list中
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1.创建代理对象,增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 判断是否为getParameter()方法
                if ("getParameter".equals(method.getName())) {
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                // 判断方法名是否是getParameterMap
                if ("getParameterMap".equals(method.getName())){

                }
                // 判断方法名是否是getParameterValue
                if ("getParameterValue".equals(method.getName())){

                }

                return method.invoke(req,args);
            }
        });
        // 2.放行
        chain.doFilter(proxy_req,resp);

    }

    @Override
    public void destroy() {

    }

}
