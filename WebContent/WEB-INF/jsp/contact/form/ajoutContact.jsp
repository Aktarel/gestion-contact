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
		<form action="/gc/contact/creer-1" method="post">
			<br>

			<div class="form-group">
				<label for="nom">Entrez le nom du contact</label> <input type="text"
					name="nom" />
			</div>
			<br>
			<div class="form-group">
				<label for="nom">Entrez la date de naissance</label> <input
					type="text" name="dateNaissance" />
			</div>
			<br>
			<div class="form-group">
				<label for="nom">Entrez l'email du contact</label> <input
					type="text" name="email" />
			</div>
			<br> <input class="btn btn-default btn-lg" type="submit"
				value="Soumettre" />
		</form>
	</div>

</body>
</html>