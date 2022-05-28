<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<header>
    <a href="" class="logo">Car Rent</a>
    <nav>
        <ul class="topmenu">
            <li><a href="carList">Home</a></li>
            <li><a href="userEdit?id=${session_user.id}">Profile</a></li>
            <li><a href="userOrder">Orders</a></li>
            <c:if test="${session_user.role=='admin'}">
            <li><a href="#" class="submenu-link">ADMIN PANNEL</a>
                <ul class="submenu">
                    <li><a href="userList">users list</a></li>
                    <li><a href="orderList">orders list</a></li>
                    <li><a href="refundList">refunds list</a></li>
                </ul>
            </li>
            </c:if>
        </ul>
        <a href="logout" class="exit">EXIT</a>
    </nav>
</header>
