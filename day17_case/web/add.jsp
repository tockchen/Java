<%--
  User: tockc
  Date: 2020/6/24
  Time: 18:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        .error {
            color: red;
        }
        .container{
            width: 700px;
        }
    </style>
    <script>
        window.onload = function () {
            document.getElementById("form").onsubmit = function () {

                return checkName() && checkAag() && checkQq() && checkEmail();


            }
            document.getElementById("name").onblur = checkName;
            document.getElementById("age").onblur = checkAag;
            document.getElementById("qq").onblur = checkQq;
            document.getElementById("email").onblur = checkEmail;
        }

        function checkName() {
            let name = document.getElementById("name").value;
            let reg_name = /^\w{3,12}$/;
            let flag = reg_name.test(name);
            let s_name = document.getElementById("s_name");
            if (flag) {
                //提示绿色对勾
                s_name.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
            } else {
                s_name.innerHTML = "用户名格式不正确--3-12位"
            }
            return flag;

        }

        function checkAag() {
            let age = document.getElementById("age").value;
            let s_age = document.getElementById("s_age");
            if (age >= 0 && age != null) {
                s_age.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
            } else {
                s_age.innerHTML = "年龄要不小于o岁,也不能为空"
            }
        }

        function checkQq() {
            let qq = document.getElementById("qq").value;
            let reg_qq = /^[1-9][0-9]{4,11}$/;
            //  /^\d{5,11}/
            let s_qq = document.getElementById("s_qq");
            let flag = reg_qq.test(qq);
            if (flag) {
                s_qq.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
            } else {
                s_qq.innerHTML = "qq号不要小于4位大于11位,也不能是非数字";
            }
        }

        function checkEmail() {
            let email = document.getElementById("email").value;
            let reg_email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            let s_emali = document.getElementById("s_email");
            let flag = reg_email.test(email);
            if (flag){
                s_emali.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
            }else {
                s_emali.innerHTML = "邮箱地址不正确";
            }

        }

    </script>
</head>
<body>
    <div class="container">
        <center><h3>添加联系人页面</h3></center>
        <form action="${pageContext.request.contextPath}/addUserServlet" method="post" id="form">
            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                <span id="s_name" class="error"></span>
            </div>

            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女"/>女
            </div>

            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                <span id="s_age" class="error"></span>
            </div>

            <div class="form-group">
                <label for="address">籍贯：</label>
                <select name="address" class="form-control" id="address">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                </select>
            </div>

            <div class="form-group">
                <label for="qq">QQ：</label>
                <input type="text" class="form-control" name="qq" id="qq" placeholder="请输入QQ号码"/>
                <span id="s_qq" class="error"></span>
            </div>

            <div class="form-group">
                <label for="email">Email：</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="请输入邮箱地址"/>
                <span id="s_email" class="error"></span>
            </div>

            <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交"/>
                <input class="btn btn-default" type="reset" value="重置"/>
                <input class="btn btn-default" type="button" value="返回"/>
            </div>
        </form>
    </div>
</body>
</html>
