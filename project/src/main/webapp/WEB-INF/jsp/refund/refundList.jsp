<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="refunds" scope="request" type="java.util.List"/>


<p:html title="refund list"></p:html>
<body>

<p:header></p:header>

<table class="table">
    <thead>
    <tr>
        <th>Refund Id</th>
        <th>Order Id</th>
        <th>Damage</th>
        <th>Repair</th>
    </tr>
    </thead>
    <tbody></tbody>
    <c:forEach var="refund" items="${refunds}">
        <tr>
            <td>
                <p>
                        ${refund.id}
                    <c:if test="${session_user.role=='admin'}">
                    <A href="refundEdit?id=${refund.id}">edit</A>
                </p>
                <form action="refundDelete" method="post">
                    <input type="hidden" name="id" value="${refund.id}">
                    <button type="submit" class="button">delete</button>
                </form>
                </c:if>
            </td>
            <td>${refund.order_id}</td>
            <td>${refund.damage}</td>
            <td>${refund.repair}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <c:if test="${session_user.role=='admin'}">
        <a href="refundEdit?id=${null}" class="common-button">add new refund</a>
    </c:if>
</p>
</body>