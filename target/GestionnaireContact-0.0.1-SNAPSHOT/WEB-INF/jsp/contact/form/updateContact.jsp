<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- On incorpore les ressources statiques (javascript / css ) -->
<jsp:include page="../../commun/ressources.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un contact</title>

<c:set var="browser" value="${header['User-Agent']}" scope="session"/>
</head>
<body>
	<jsp:include page="../../commun/navbar.jsp"></jsp:include>


	<div class="container">
		<h1>Formulaire de mise à jour d'un contact</h1>
		<form action="<c:url value="/contact/maj-1" />" method="post">
			<br>
			<input type="hidden" value="${contact.idContact}" name="idContact" />
			<div class="form-group">
				<label for="nomContact">Entrez le nom du contact</label> <input type="text"
					 class="form-control" placeholder="Entrez le nom du contact" name="nomContact" value="${contact.nomContact}" />
			</div>
			<br>
			<div class="form-group">
				<label for="dateNaissance">Entrez la date de naissance</label> <input
					class="form-control" type="date" name="dateNaissance" pattern="^\d{1,2}/\d{1,2}/\d{4}$" value="<c:choose><c:when test="${fn:contains(header['user-agent'], 'Chrome')}">${contact.dateNaissanceDateValue}</c:when><c:otherwise>${contact.dateNaissanceToString}</c:otherwise></c:choose>"  />
			</div>
			<br>
			<div class="form-group">
				<label for="email">Entrez l'email du contact</label> <input
					class="form-control" placeholder="Entrez l'email du contact"	 pattern="^[\w._%+-]+@[\w.-]+\.[a-zA-Z]{2,4}$" type="text" name="email" value="${contact.email}"  />
			</div>
			<br>
			<div class="form-group">
				<label for="idAdresse">Selectionnez l'adresse du contact</label> 
				<select class="form-control" name="idAdresse" >
					<c:forEach var="adresse" items="${adresses}">
						<option value="${adresse.idAdresse}"><c:out value="${adresse}"></c:out></option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label for="isActive">Est actif ?</label> <input
					type="checkbox" name="isActive" <c:if test="${contact.actif}"> checked </c:if> />
			</div>
			<br> <input class="btn btn-default btn-lg" type="submit"
				value="Soumettre" />
		</form>
	</div>

</body>
</html>