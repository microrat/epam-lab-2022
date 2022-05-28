<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<c:choose>
    <c:when test="${not empty editUser}">
        <c:set var="id" value="${editUser.id}"/>
        <c:set var="name" value="${editUser.name}"/>
        <c:set var="surname" value="${editUser.surname}"/>
        <c:set var="role" value="${editUser.role}"/>
        <c:set var="login" value="${editUser.login}"/>
        <c:set var="password" value="${editUser.password}"/>
    </c:when>
    <c:otherwise>
        <c:set var="id" value=""/>
        <c:set var="name" value=""/>
        <c:set var="surname" value=""/>
        <c:set var="role" value=""/>
        <c:set var="login" value=""/>
        <c:set var="password" value=""/>
    </c:otherwise>
</c:choose>
<p:html title="edit user"/>

<body>
<p:header></p:header>
<div class="login-container">
    <form class="edit" action="userSave" method="post">
        <h1>User profile</h1>
        <div>
            <label>Id:</label>
            <input type="text" name="id" value="${id}"/>
        </div>
        <div>
            <label>Name:</label>
            <input type="text" name="name" value="${name}"/>
        </div>
        <div>
            <label>Surname:</label>
            <input type="text" name="surname" value="${surname}"/>
        </div>
        <div>
            <c:if test="${session_user.role=='admin'}">
            <label>Role:</label>
            <select name="role">
                <option value="admin">admin</option>
                <option value="user">user</option>
            </select>
            </c:if>
        </div>
        <div>
            <label>Login:</label>
            <input type="text" name="login" value="${login}"/>
        </div>
        <div>
            <label>Password:</label>
            <input type="text" name="password" value="${password}"/>
        </div>
        <button type="submit">Save</button>
        <a href="carList" class="common-button">Back</a>
    </form>
</div>
</body>
</html>
