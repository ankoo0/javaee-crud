
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="icon"
          href="https://i0.wp.com/antoniogoncalves.org/wp-content/uploads/2014/05/java_ee_logo_vert_v2.png?ssl=1">
    <link rel="stylesheet" href="<c:url value='/static/styles/users.css'/>">
    <title>Error</title>
</head>
<body>

<header>
    <h1>JAVA EE CRUD</h1>
    <nav>
        <ul>
        </ul>
    </nav>
</header>

    <h1>Invalid Login or Password</h1>
<a href="${pageContext.request.contextPath}/users">Try Again</a>

<footer></footer>
</body>
</html>
