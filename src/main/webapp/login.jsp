
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn"
           uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    this is for request timeout 408 when login--%>
    <meta http-equiv="Cache-Control" content="no-store,no-cache,must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <title>Login</title>
    <link rel="icon"
          href="https://i0.wp.com/antoniogoncalves.org/wp-content/uploads/2014/05/java_ee_logo_vert_v2.png?ssl=1">
    <link rel="stylesheet" href="<c:url value='/static/styles/users.css'/>">

</head>

<body>



<dialog id="modal">
    <div class="modal-container">
        <div class="modal-text">
            <p>Delete a user from the system?</p>
        </div>
        <div class="modal-btns-container">
            <a class="confirm-anchor" href=""><button class="modal-btn" id="yes-modal-btn">Yes</button></a>
            <button class="modal-btn" id="cancel-modal-btn">Cancel</button>
        </div>
    </div>
</dialog>



<header>
    <h1>JAVA EE CRUD</h1>
    <nav>
        <ul>
        </ul>
    </nav>
</header>



<div class="add-user-form-container">


    <form class="add-user-form" action="j_security_check" method="post">
        <div class="input-container">
            <h2>Sign In </h2>
            <hr/>
        </div>
        <div class="input-container">
            <input required="required" class="add-user-input" type="text" name="j_username">
            <span>Username</span>
        </div>

        <div class="input-container">
            <input required="required"  class="add-user-input" type="password" name="j_password">
            <span>Password</span>
        </div>

        <input class="edit-btn" type="submit" value="Submit"/>
    </form>
</div>

<%--<%--%>
<%--    String j_username = "admin";--%>
<%--    String j_password = "12345";--%>
<%--    Cookie[] cookies = request.getCookies();--%>
<%--    for (int i = 0; i < cookies.length; i++) {--%>
<%--        String cookieName = cookies[i].getName();--%>
<%--        if (cookieName.equalsIgnoreCase("j_user")) {--%>
<%--            j_username = cookies[i].getValue();--%>
<%--        } else if (cookieName.equalsIgnoreCase("j_pass")) {--%>
<%--            j_password = cookies[i].getValue();--%>
<%--        }--%>
<%--    }--%>
<%--    String redirectURL = response.encodeURL("j_security_check?j_username="--%>
<%--            + j_username + "&j_password=" + j_password);--%>
<%--    response.sendRedirect(redirectURL);--%>
<%--%>--%>


<footer>
</footer>
</body>



</html>