<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<c:choose>
    <c:when test="${not empty editCar}">
        <c:set var="id" value="${editCar.id}"/>
        <c:set var="brand" value="${editCar.brand}"/>
        <c:set var="model" value="${editCar.model}"/>
        <c:set var="available" value="${editCar.available}"/>
        <c:set var="day_price" value="${editCar.dayPrice}"/>
    </c:when>
    <c:otherwise>
        <c:set var="id" value=""/>
        <c:set var="brand" value=""/>
        <c:set var="model" value=""/>
        <c:set var="available" value=""/>
        <c:set var="day_price" value=""/>
    </c:otherwise>
</c:choose>
<p:html title="edit car"/>
<body>
<p:header/>
<div class="login-container">
    <form class="edit" action="carSave" method="post">
        <h1>Car</h1>
        <div>
            <label>Id:</label>
            <input type="text" name="id" value="${id}"/>
        </div>
        <div>
            <label>Brand:</label>
            <input type="text" name="brand" value="${brand}"/>
        </div>
        <div>
            <label>Model:</label>
            <input type="text" name="model" value="${model}"/>
        </div>
        <div>
            <label >Is available:</label>
            <lable>true</lable>
            <input type="radio" name="available" value="true"/>
            <lable>false</lable>
            <input type="radio" name="available" value="false"/>
        </div>
        <div>
            <label>Price for day:</label>
            <input type="text" name="day_price" value="${day_price}"/>
        </div>
        <button type="submit">Save</button>
            <a href="carList" class="common-button">Back</a>
    </form>
</div>
</body>
</html>
