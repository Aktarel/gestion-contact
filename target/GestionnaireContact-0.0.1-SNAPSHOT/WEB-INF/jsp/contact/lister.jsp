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

		<!-- Main component for a primary marketing message or call to action -->

		<c:if test="${message != null}">
			<div class="${message.type.correspondance}" >
				<button type="button" class="close" data-dismiss="alert" >×</button>
				${message.content}
			</div>
		</c:if>

		<div class="row">
			<div class="col-md-11">
				<h1>La liste des contacts</h1>
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
					<th>Nom</th>
					<th>Email</th>
					<th>Date de naissance</th>
					<th>Adresse</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="contact" items="${contacts}">
					<tr
						<c:if test="${ contact.actif == true }">style="background-color:#90EE90;"</c:if>
						<c:if test="${ contact.actif == false }">style="background-color:#FFBABA;"</c:if>>
						<td><c:out value="${contact.nomContact}"></c:out></td>
						<td><c:out value="${contact.email}"></c:out></td>
						<td><c:out value="${contact.dateNaissanceToString}"></c:out></td>
						<td><c:out value="${contact.adresse}" /></td>
						<td width="5%"><a
							href="maj-0?idContact=<c:out value='${contact.idContact}' />"><img
								width="24" height="24"
								src="<c:url value="/images/contact/edit.png"/>"></img></a> <a
							href="supprimer?idContact=<c:out value='${contact.idContact}' />"><img
								width="24" height="24"
								src="<c:url value="/images/contact/delete.png"/>"></img></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>





	</div>



</body>
</html>