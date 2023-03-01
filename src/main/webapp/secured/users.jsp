

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users</title>
    <link rel="icon" href="https://i0.wp.com/antoniogoncalves.org/wp-content/uploads/2014/05/java_ee_logo_vert_v2.png?ssl=1">
    <link rel="stylesheet" href="<c:url value='/static/styles/users.css'/>">

</head>
<body>

<dialog id="modal">
    <div class="modal-container">
        <div class="modal-text">
            <p>Delete user from the system?</p>
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
            <li>
                <a href="${pageContext.request.contextPath}/users/add">Add</a>
            </li>
        </ul>
        <a href="${pageContext.request.contextPath}/logout"><button class="sign-in-btn">Log Out</button></a>
    </nav>

</header>

<%--<%String val = session.getAttribute("users").toString();--%>
<%--out.print(val);--%>
<%--%>--%>



<div class="user-table-container">
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Position</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${sessionScope.users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td>${user.position}</td>
<%--                why need localhost 8080--%>
<%--                <c:out value="${pageContext.request.contextPath}/users/edit?id=${user.id}"/>--%>
                <td><a href="${pageContext.request.contextPath}/users/edit?id=${user.id}"><button class="edit-btn">Edit</button></a></td>
                <td><button class="delete-btn" id="${user.id}">Delete</button></td>
            </tr>
        </c:forEach>


    </table>

</div>

<footer>
</footer>




</body>


<script src="<c:url value='/static/script/users.js'/>" defer></script>
</html>