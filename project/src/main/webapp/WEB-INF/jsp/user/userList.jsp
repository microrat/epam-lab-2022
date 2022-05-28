<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="users" scope="request" type="java.util.List"/>


<p:html title="user list"></p:html>
<body>

<p:header></p:header>
<table class="table">
    <thead>
    <tr>
        <th>User Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody></tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <p>
                        ${user.id}
                    <c:if test="${session_user.role=='admin'}">
                    <A href="userEdit?id=${user.id}">edit</A>
                </p>
                <form action="userDelete" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" class="button">delete</button>
                </form>
                </c:if>
            </td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <c:if test="${session_user.role=='admin'}">
        <a href="userEdit?id=${null}" class="common-button">add new user</a>
    </c:if>
</p>
</body>
</html>
