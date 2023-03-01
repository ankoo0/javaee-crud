<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    <link rel="icon"
          href="https://i0.wp.com/antoniogoncalves.org/wp-content/uploads/2014/05/java_ee_logo_vert_v2.png?ssl=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value='/static/styles/users.css'/>">

</head>

<body>

<dialog id="modal">
    <div class="modal-container">
        <div class="modal-text">
            <p>Delete a user from the system?</p>
        </div>
        <div class="modal-btns-container">
            <a class="confirm-anchor" href="">
                <button class="modal-btn" id="yes-modal-btn">Yes</button>
            </a>
            <button class="modal-btn" id="cancel-modal-btn">Cancel</button>
        </div>
    </div>
</dialog>


<header>
    <%--    <c:set var="editPath" value="${pageContext.request.contextPath}"/>--%>
    <c:set var="path" value="${pageContext.request.contextPath}/users/edit"/>
    <h1>JAVA EE CRUD</h1>
    <nav>
        <%--        <c:out value="${path}"/>--%>
        <%--        <c:out value="${pageContext.request.contextPath}/add"/>--%>
        <ul>


            <c:choose>
                <c:when test="${fn:contains(path, '/javaee-crud/users/edit')}">
                    <li>
                        <a href="${pageContext.request.contextPath}/users/add">Add</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/users">All Users</a>
                    </li>
                </c:when>
            </c:choose>
            <%--            <li>--%>
            <%--                <a href="https://localhost:8080/javaee-crud/users/add">Add</a>--%>
            <%--            </li>--%>
            <%--            <li>--%>
            <%--                <a href="https://localhost:8080/javaee-crud/users/add">All Users</a>--%>
            <%--            </li>--%>
        </ul>
        <a>
            <button class="sign-in-btn">Sign In</button>
        </a>
    </nav>
</header>

<%--<img src="data:image/png;base64,${sessionScope.image}" alt="Red dot" />--%>


<div class="add-user-form-container">


    <form class="add-user-form" action="${path}?id=${sessionScope.id}" method="post">
        <div class="input-container">
            <h2>Edit User</h2>
            <hr/>
        </div>
        <div class="input-container">

            <%--            how to insert data to input laceholder--%>
            <%--            <input required="required" class="add-user-input" type="text" name="fName" placeholder="${sessionScope.user.firstName}">--%>
            <input required="required" class="add-user-input" type="text" name="fName"
                   value="${sessionScope.user.firstName}">
            <span>First Name</span>

        </div>
        <div class="input-container">
            <input required="required" class="add-user-input" type="text" name="lName"
                   value="${sessionScope.user.lastName}">
            <span>Last Name</span>
        </div>
        <div class="input-container">
            <input required="required" class="add-user-input" type="text" name="age" value="${sessionScope.user.age}">
            <span>Age</span>
        </div>
        <div class="input-container">
            <input required="required" class="add-user-input" type="email" name="email"
                   value="${sessionScope.user.email}">
            <span>Email</span>
        </div>

        <div>

            <select class="select-position" name="position">
                <option selected="selected" value="Java Developer">Java Developer</option>
                <option value="JavaScript Developer">JavaScript Developer</option>
                <option value="Python Developer">Python Developer</option>
                <option value="HR Manager">HR Manager</option>
                <option value="Data Scientist">Data Scientist</option>
                <option value="Project Manager">Project Manager</option>
                <option value="Team Lead">Team Lead</option>
            </select>
        </div>
        <button class="edit-btn" type="submit">Save Changes</button>
    </form>
</div>


<%--<c:import url="/secured/add.jsp"/>--%>
<footer>

    <div>
        <p>
            <a style="text-decoration: none; color: inherit" href="https://github.com"> <i class="fa fa-github fa-lg"
                                                                                           aria-hidden="true"></i>
                GitHub</a>
        </p>

    </div>

</footer>
</body>

<script src="../static/script/users.js" defer></script>


</html>