<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users</title>
    <link rel="icon"
          href="https://i0.wp.com/antoniogoncalves.org/wp-content/uploads/2014/05/java_ee_logo_vert_v2.png?ssl=1">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
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

            <li>
                <a href="${pageContext.request.contextPath}/users">All Users</a>
            </li>
        </ul>
        <a><button class="sign-in-btn">Sign In</button></a>
    </nav>
</header>




<div class="add-user-form-container">


    <form class="add-user-form" action="${pageContext.request.contextPath}/users/add" method="post">
        <div class="input-container">
            <h2>Add User to Database</h2>
            <hr/>
        </div>
        <div class="input-container">
            <input required="required" class="add-user-input" type="text" name="fName">
            <span>First Name</span>
        </div>
        <div class="input-container">
            <input required="required"  class="add-user-input" type="text" name="lName">
            <span>Last Name</span>
        </div>
        <div class="input-container">
            <input required="required" class="add-user-input" type="text" name="age">
            <span>Age</span>
        </div>
        <div class="input-container">
            <input required="required"  class="add-user-input" type="email" name="email">
            <span>Email</span>
        </div>

        <div>

            <select class="select-position" name="position">
                <option selected="selected" value="position">Java Developer</option>
                <option value="JavaScript Developer">JavaScript Developer</option>
                <option value="Python Developer">Python Developer</option>
                <option value="HR Manager">HR Manager</option>
                <option value="Data Scientist">Data Scientist</option>
                <option value="Project Manager">Project Manager</option>
                <option value="Team Lead">Team Lead</option>
            </select>
        </div>
        <button class="edit-btn" type="submit">Add User</button>
    </form>
</div>




<footer>
</footer>
</body>

<script src="users.js" defer></script>


</html>