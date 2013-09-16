<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- On incorpore les ressources statiques (javascript / css ) -->
<jsp:include page="../commun/ressources.jsp"></jsp:include>

<title>Bienvenue sur le gestionnaire de contact</title>
</head>
<body>

	<div id="container">

		<jsp:include page="../commun/navbar.jsp"></jsp:include>

		<!-- Main component for a primary marketing message or call to action -->

		<h4>La liste des contacts</h4>
		<c:forEach var="contact" items="${contacts}">
			<h5>
				<br>
				<c:out value="${contact.nomContact}"></c:out>
				<a
					href="supprimer.htm?idContact=<c:out value='${contact.idContact}' />">
					Suppression </a>
			</h5>
		</c:forEach>
	</div>

</body>
</html>