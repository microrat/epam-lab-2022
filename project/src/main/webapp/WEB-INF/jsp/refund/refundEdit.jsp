<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<c:choose>
    <c:when test="${not empty editRefund}">
        <c:set var="id" value="${editRefund.id}"/>
        <c:set var="order_id" value="${editRefund.order_id}"/>
        <c:set var="damage" value="${editRefund.damage}"/>
        <c:set var="repair" value="${editRefund.repair}"/>
    </c:when>
    <c:otherwise>
        <c:set var="id" value=""/>
        <c:set var="order_id" value=""/>
        <c:set var="damage" value="none"/>
        <c:set var="repair" value=""/>
    </c:otherwise>
</c:choose>
<p:html title="refund edit"/>

<body>
<p:header></p:header>
<div class="login-container">
    <form class="edit" action="refundSave" method="post">
        <h1>edit refund</h1>
        <div>
            <label>Id:</label>
            <input type="text" name="id" value="${id}"/>
        </div>
        <div>
            <label>order_id:</label>
            <input type="text" name="order_id" value="${order_id}"/>
        </div>
        <div>
            <label>damage:</label>
            <input type="text" name="damage" value="${damage}"/>
        </div>
        <div>
            <label>repair:</label>
            <input type="text" name="repair" value="${repair}"/>
        </div>
        <button type="submit">Save</button>
        <a href="refundList" class="common-button">Back</a>
    </form>
</div>
</body>
</html>
