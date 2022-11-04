<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Course Insert</title>
</head>
<body>
	<p>	Course: ${insertedCourse.title} <br>
	 	${insertedCourse.description} <br>
	 	${insertedCourse.teacherId} <br>
	 	
	   	successfully inserted!
	   	</p>
	
	<a href="/teachers-app1/index.jsp">Επιστροφή</a>

</body>
</html>