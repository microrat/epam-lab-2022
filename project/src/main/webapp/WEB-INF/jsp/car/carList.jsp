<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="cars" scope="request" type="java.util.List" />

<p:html title="list of cars"/>

<body>

<p:header></p:header>
<table class="table">
    <thead>
    <tr>
        <th>Car Id</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Price for Day</th>
    </tr>
</thead>
    <tbody>
<c:forEach var="car" items="${cars}">
   <c:if test="${car.available=='true'}">
    <tr>
    <td>
        <p>
           ${car.getId()}
               <c:if test="${session_user.role=='admin'}">
        <A href="carEdit?id=${car.id}">edit</A>
        </p>
        <form action="carDelete" method="post">
            <input type="hidden" name="id" value="${car.getId()}">
            <button type="submit" class="button">delete</button>
        </form>
</c:if>
    </td>
    <td>${car.brand}</td>
    <td>${car.model}</td>
    <td>${car.dayPrice}</td>
    </tr>
   </c:if>
</c:forEach>
    </tbody>
</table>
<p>
    <c:if test="${session_user.role=='admin'}">
    <a href="carEdit?id=${null}" class="common-button">add new car</a>
    </c:if>
    <a href="orderEdit?id=${null}"  class="common-button">rent</a>
</p>
<c:if test="${session_user.role=='admin'}">
<h2>Unavailable cars:</h2>
    <table class="table">
    <c:forEach var="car" items="${cars}">
        <c:if test="${car.available=='false'}">
            <tr>
                <td>
                    <p>
                            ${car.id}
                        <A href="carEdit?id=${car.id}">edit</A>
                    </p>
                    <form action="carDelete" method="post">
                        <input type="hidden" name="id" value="${car.id}">
                        <button type="submit" class="button">delete</button>
                    </form>
                </td>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.dayPrice}</td>
            </tr>
        </c:if>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
