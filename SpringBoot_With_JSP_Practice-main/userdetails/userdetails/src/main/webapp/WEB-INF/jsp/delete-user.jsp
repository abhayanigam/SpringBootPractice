<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add User</title>
    </head>
    <body>
        <c:if test="${addUserSuccess}">
            <div>Successfully added User with Id: ${savedUser.id}</div>
        </c:if>

        <c:url var="add_user_url" value="/user/addUser"/>
        <form:form action="${add_user_url}" method="post" modelAttribute="user">
            <form:label path="id">ID: </form:label> <form:input type="text" path="id"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>