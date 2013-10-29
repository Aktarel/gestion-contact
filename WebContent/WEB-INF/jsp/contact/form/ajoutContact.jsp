<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- On incorpore les ressources statiques (javascript / css ) -->
<jsp:include page="../../commun/ressources.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un contact</title>
</head>
<body>
	<jsp:include page="../../commun/navbar.jsp"></jsp:include>


	<div class="container">
		<h1>Formulaire d'ajout d'un contact</h1>
		<form action="<c:url value="/contact/creer-1"/>" method="post">
			<br>

			<div class="form-group">
				<label for="nom">Entrez le nom du contact</label>
				 <input class="form-control" type="text"		name="nom" />
					
			</div>
			<br>
			<div class="form-group">
				<label for="dateNaissance">Entrez la date de naissance</label> 
				<input	class="form-control" type="date" pattern="^\d{1,2}/\d{1,2}/\d{4}$" name="dateNaissance" />
			</div>
			<br>
			<div class="form-group">
				<label for="email">Entrez l'email du contact</label> <input
					class="form-control" pattern="^[\w._%+-]+@[\w.-]+\.[a-zA-Z]{2,4}$" type="text" name="email" />
			</div>
			<br>
			<div class="form-group">
				<label for="adresses">Selectionnez l'adresse du contact</label> 
				<select	class="form-control" name="adresse" >
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