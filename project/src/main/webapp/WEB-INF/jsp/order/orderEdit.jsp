<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<c:choose>
    <c:when test="${not empty editOrder}">
        <c:set var="id" value="${editOrder.getId()}"/>
        <c:set var="user_id" value="${editOrder.getUser_id()}"/>
        <c:set var="car_id" value="${editOrder.getCar_id()}"/>
        <c:set var="passport" value="${editOrder.getPassport()}"/>
        <c:set var="date_start" value="${editOrder.getDateStart()}"/>
        <c:set var="term" value="${editOrder.getTerm()}"/>
        <c:set var="status" value="${editOrder.getStatus()}"/>
        <c:set var="reject_reason" value="${editOrder.getRejectReason()}"/>
    </c:when>
    <c:otherwise>
        <c:set var="id" value=""/>
        <c:set var="user_id" value="${session_user.id}"/>
        <c:set var="car_id" value=""/>
        <c:set var="passport" value=""/>
        <c:set var="date_start" value=""/>
        <c:set var="term" value=""/>
        <c:set var="status" value=""/>
        <c:set var="reject_reason" value=""/>
    </c:otherwise>
</c:choose>
<p:html title="order edit"/>

<body>
<p:header></p:header>
<div class="login-container">
    <form class="edit" action="orderSave" method="post">

        <h1>edit order</h1>
        <div>
            <label>Id:</label>
            <input type="text" name="id" value="${id}"/>
        </div>
        <div>
            <label>user_id:</label>
            <input type="text" name="user_id" value="${user_id}"/>
        </div>
        <div>
            <label>car_id:</label>
            <input type="text" name="car_id" value="${car_id}"/>
        </div>
        <div>
            <label>passport:</label>
            <input type="text" name="passport" value="${passport}"/>
        </div>
        <div>
            <label>date_start:</label>
            <input type="text" name="date_start" value="${date_start}" placeholder="2012-09-20"/>
        </div>
        <div>
            <label>term:</label>
            <input type="text" name="term" value="${term}"/>
        </div>
            <c:if test="${session_user.role=='admin'}">
        <div>
            <label>status:</label>
            <input type="text" name="status" value="${status}"/>
        </div>
        <div>
            <label>reject_reason:</label>
            <input type="text" name="reject_reason" value="${reject_reason}"/>
        </div>
            </c:if>
        <c:if test="${session_user.role=='user'}">
            <div>
                <label>status:</label>
                <input type="hidden" name="status" value="${status}"/>
            </div>
            <div>
                <label>reject_reason:</label>
                <input type="hidden" name="reject_reason" value="${reject_reason}"/>
            </div>
        </c:if>

        <button type="submit">Save</button>
            <a href="orderList" class="common-button">Back</a>
    </form>
</div>
</body>
</html>
