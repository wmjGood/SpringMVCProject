<%--
  Created by IntelliJ IDEA.
  User: wumengjie
  Date: 2018/08/28
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加用户</title>
</head>
<%--modelAttribute="user"  自动映射实体类 --%>
<body>
<fm:form  method="post" modelAttribute="user" enctype="multipart/form-data">
    <fm:errors path="userCode"/>
    <br/>
    用户编码：
    <fm:input path="userCode"/>
    <br/>
   <fm:errors path="userName"/>
    <br/>
    用户名：
    <fm:input path="userName"/>
    <br/>
    <fm:errors path="userPassword"/>
    <br/>
    密码：
    <fm:password path="userPassword"/>

    <input type="file" name="idpath" id="idpath"/>
     <input type="submit" value="提交">
</fm:form>

</body>
</html>
