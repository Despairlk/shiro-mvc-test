<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>list</title>
</head>
<body>
<shiro:hasRole name="role1"><a>role1</a></shiro:hasRole>
<shiro:hasRole name="role2"><a>role2</a></shiro:hasRole>
<shiro:hasRole name="role3"><a>role3</a></shiro:hasRole>

<shiro:hasPermission name="user:update"><a>user->update</a></shiro:hasPermission>
<shiro:hasPermission name="user:create"><a>user->create</a></shiro:hasPermission>
<shiro:hasPermission name="user:delete"><a>user->delete</a></shiro:hasPermission>
</body>
</html>