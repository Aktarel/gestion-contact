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

	<jsp:include page="../commun/navbar.jsp"></jsp:include>

	<div class="container">


		<div class="row">
			<div class="col-md-11">
				<h1>La liste des adresses</h1>
			</div>
			<div class="col-md-1 add">
				<a href="creer-0"><img width="32" height="32"
					src="<c:url value="/images/contact/new.png"/>"></img></a>
			</div>
		</div>
		<br>
		<p></p>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>Numéro + Rue</th>
					<th>Ville</th>
					<th>Code postal</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:out value="${adresse}"></c:out>
				<c:forEach var="adresse" items="${adresses}">
					<tr >
						<td><c:out value="${adresse.numero}"></c:out> <c:out value="${adresse.rue}"></c:out></td>
						<td><c:out value="${adresse.ville}"></c:out></td>
						<td><c:out value="${adresse.codePostal}"></c:out></td>
						<td width="5%" ><a
							href="supprimer?idAdresse=<c:out value='${adresse.idAdresse}' />"><img
								width="24" height="24"
								src="<c:url value="/images/contact/delete.png"/>"></img></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>





	</div>



</body>
</html>