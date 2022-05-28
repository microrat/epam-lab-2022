<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="orders" scope="request" type="java.util.List"/>


<p:html title="order list"></p:html>
<body>

<p:header></p:header>

<table class="table">
    <thead>
    <tr>
        <th>Order Id</th>
        <th>User Id</th>
        <th>Car Id</th>
        <th>Passport</th>
        <th>Date start</th>
        <th>Term</th>
        <th>Status</th>
        <th>Reject reason</th>
        <th>Cost</th>
    </tr>
    </thead>
    <tbody></tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                <p>
                        ${order.id}
                    <c:if test="${session_user.role=='admin'}">
                    <A href="orderEdit?id=${order.getId()}">edit</A>
                </p>
                <form action="orderDelete" method="post">
                    <input type="hidden" name="id" value="${order.id}">
                    <button type="submit" class="button">delete</button>
                </form>
                </c:if>
            </td>
            <td>${order.user_id}</td>
            <td>${order.car_id}</td>
            <td>${order.passport}</td>
            <td>${order.dateStart}</td>
            <td>${order.term}</td>
            <td>${order.status}</td>
            <td>${order.rejectReason}</td>
            <td>${order.cost}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <c:if test="${session_user.role=='admin'}">
        <a href="orderEdit?id=${null}" class="common-button">add new order</a>
    </c:if>
</p>
</body>

