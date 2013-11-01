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
		<h1>Bienvenue à vous, cher visiteur</h1>
		<h2>Résumé</h2>
		<p>Ce projet est une application de gestion de contact permettant
			de mettre en valeurs les technologies du web</p>

		<h2>Objectifs</h2>
		<p>L'objectif principal est de mettre en valeur nos compétences et notre savoir faire dans l'élaboration d'IHM.
			</br>
			Il était question de mettre en valeur la forme (technologies) plûtot que l'aspect fonctionnel (le gestionnaire de contact)
			tout en faisant des choix cohérents dans l'élaboration des fonctionnalités.
		</p>
		<h2>Sources</h2>
		<p>Les sources sont disponibles à cette adresse : <a href="http://github.com/Aktarel/gestion-contact">ici</a></p>
		<h2>Technologies employés</h2>
		<ul id="technos">
			<li id="spring"><a href="http://projects.spring.io/spring-framework">Spring
					Framework 3</a></li>
			<li id="java"><a href="http://jstl.java.net">JSTL</a></li>
			<li id="apache"><a href="http://logging.apache.org/log4j/">Log4J</a></li>
			<li id="apache"><a href="http://maven.apache.org">Maven 3</a></li>
			<li id="bootstrap"><a href="http://getbootstrap.com">Bootstrap</a></li>
			<li id="git"><a href="http://git-scm.com/">Git</a></li>
			<li id="github"><a href="http://github.com/">GitHub</a></li>
			<li id="gae"><a href="https://developers.google.com/appengine">Google
					App Engine</a></li>
		</ul>
		<h2>Auteurs</h2>
		<p>Cette application a été réalisée par deux élève-ingénieurs de
			l'ESIEA :
		<ul>
			<li>Nicolas LEBEC</li>
			<li>Remy OUADAH</li>
		</ul>
		</p>
		<h2>Licence MIT</h2>
		<p>Copyright © Nicolas LEBEC | Remy OUADAH </br> Permission is hereby granted, free of
			charge, to any person obtaining a copy of this software and
			associated documentation files (the "Software"), to deal in the
			Software without restriction, including without limitation the rights
			to use, copy, modify, merge, publish, distribute, sublicense, and/or
			sell copies of the Software, and to permit persons to whom the
			Software is furnished to do so, subject to the following conditions:
			The above copyright notice and this permission notice shall be
			included in all copies or substantial portions of the Software. The
			Software is provided "as is", without warranty of any kind, express
			or implied, including but not limited to the warranties of
			merchantability, fitness for a particular purpose and
			noninfringement. In no event shall the authors or copyright holders
			be liable for any claim, damages or other liability, whether in an
			action of contract, tort or otherwise, arising from, out of or in
			connection with the software or the use or other dealings in the
			Software.</p>
	</div>

</body>
</html>