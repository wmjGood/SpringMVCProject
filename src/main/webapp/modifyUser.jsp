<%--
  Created by IntelliJ IDEA.
  User: wumengjie
  Date: 2018/08/29
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<fm:form method="post" modelAttribute="users">
    用户名：
    <fm:input path="userName"/>
    密码：
    <fm:password path="userPassword"/>
    <input type="submit" value="提交">
</fm:form>
</body>
</html>
