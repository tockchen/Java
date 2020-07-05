<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  User: tockc
  Date: 2020/6/23
  Time: 13:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

        // 设置响应的消息提的数据格式以及编码
        response.setContentType("text/html;charset=utf8");
        // 1. 获取所有 Cookie
        Cookie[] cookies = request.getCookies();
        // 没有cookie为lastTime
        boolean flag = false;

        // 2. 遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 3.获取cookie的名称
                String name = cookie.getName();
                // 4.判断名称是否是:lastTime
                if ("lastTime".equals(name)) {
                    // 有该Cookie,不是第一次访问
                    // 有lastTime的cookie
                    flag = true;
                    // 响应数据
                    // 获取Cookie的value,时间
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    //URL解码：
                    value = URLDecoder.decode(value, StandardCharsets.UTF_8);
                    System.out.println("解码后：" + value);
    %>
    <h1>欢迎回来,您上次访问时间为:<%=value%></h1>
    <h2>12</h2>
    <%
                    // 设置Cookie的value
                    // 获取当前时间的字符串,重新设置Cookie的值,重新发送cookie
                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String strDate = sdf.format(data);
                    System.out.println("编码前：" + strDate);
                    //URL编码
                    strDate = URLEncoder.encode(strDate, StandardCharsets.UTF_8);
                    System.out.println("编码后：" + strDate);
                    cookie.setValue(strDate);
                    // 设置cookie的存活时间 一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || !flag) {

            // 设置Cookie的value
            // 获取当前时间的字符串,重新设置Cookie的值,重新发送cookie
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(data);
            System.out.println("编码前：" + strDate);
            //URL编码
            strDate = URLEncoder.encode(strDate, "utf8");
            System.out.println("编码后：" + strDate);

            Cookie cookie = new Cookie("lastTime", strDate);

            // 设置cookie的存活时间 一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);

    %>
    <h1>您好,欢迎您首次访问</h1>
    <h2>12</h2>
    <%
        }

    %>
</body>
</html>
