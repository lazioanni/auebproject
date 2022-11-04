<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Teacher Sign up  Successfully</title>
</head>
<body>
	<p>	Teacher: ${insertedTeacher.emailId} <br>
	 	${insertedTeacher.firstname} <br>
	 	${insertedTeacher.lastname} <br>
	 	${insertedTeacher.subject} <br>
	 	${insertedTeacher.rank} <br>
	   	successfully sign up!
	   	</p>
	
	<a href="/teachers-app1/index.jsp">Επιστροφή</a>

</body>
</html>