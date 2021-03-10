<%--
  Created by IntelliJ IDEA.
  User: XingKe
  Date: 2021/3/5
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--<script type="text/javascript" src="view/jquery-3.6.0.min.js"/>--%>
<body>
 <h1> hello world</h1>
    <form action = "testPost" method = "post">
       <input  name = "userName"/>
        <input  name = "password"/>
        <input type="submit" value="提交">
    </form>

   <form action="upload" method = "post" enctype = "multipart/form-data">
       用户名:<input type = "text" name = "userName"/>
       密码:<input type = "text" name = "password"/>
       文件:<input type = "file" name = "pic">
       <input type = "submit" value = "提交">
   </form>

</body>
</html>
