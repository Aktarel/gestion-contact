<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- On incorpore les ressources statiques (javascript / css ) -->
<jsp:include page="../../commun/ressources.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter d'une adresse</title>
</head>
<body>
	<jsp:include page="../../commun/navbar.jsp"></jsp:include>


	<div class="container">
		<h1>Formulaire d'ajout d'une adresse</h1>
		<form action="<c:url value="/adresse/creer-1"/>" method="post">
			<br>

			<div class="form-group">
				<label for="numero">Entrez le numero de rue</label> <input type="text"
					class="form-control"  placeholder="Entrez le num�ro de la rue"   name="numero" />
			</div>
			<br>
			<div class="form-group">
				<label for="rue">Entrez la rue</label> <input
					class="form-control"  placeholder="Entrez le nom de la rue"  type="text" name="rue" />
			</div>
			<br>
			<div class="form-group">
				<label for="ville">Entrez la ville</label> <input
					class="form-control" placeholder="Entrez le nom d'une ville"   type="text" name="ville" />
			</div>
			<br>
			<div class="form-group">
				<label for="codePostal">Entrez le code postal</label> <input
					 class="form-control" placeholder="Entrez un code postal" type="text" name="codePostal" />
			</div>
			<br> <input class="btn btn-default btn-lg" type="submit"
				 class="form-control" value="Soumettre" />
		</form>
	</div>

</body>
</html>