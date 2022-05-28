
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>

<p:html title="login"/>

<div class="login-container">
    <form class="login" action="login" method="post">
        <h1>Welcome!</h1>
        <h3>Sign in to continue</h3>
        <div >
            <input type="text" name="login" placeholder="Login"/>
        </div>
        <div >
            <input type="text" name="password" placeholder="Password"/>
        </div>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
