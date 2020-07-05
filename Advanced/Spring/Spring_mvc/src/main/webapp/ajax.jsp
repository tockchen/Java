<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <script src="js/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            var userList = new Array();
            userList.push({username: "zhangsan",age:12});
            userList.push({username: "ls",age:67});
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/user/quick15",
                data:JSON.stringify(userList),
                contentType:"application/json;charset=utf8"

            });
        })


    </script>
    <body>
        <h1>sd</h1>
    </body>
</html>
