<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lister contact</title>
</head>

<!-- Le javascript
 ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<link rel="stylesheet"	href="<c:url value="/css/bootstrap-theme.min.css"/>">
<link href="/css/bootstrap-responsive.css" rel="stylesheet">

<script src="<c:url value="/js/jquery/jquery.js" />"></script>
<script src="<c:url value="/js/bootstrap/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/bootstrap/transition.js"/>"></script>
<script src="<c:url value="/js/bootstrap/alert.js"/>"></script>
<script src="<c:url value="/js/bootstrap/modal.js"/>"></script>
<script src="<c:url value="/js/bootstrap/dropdown.js"/>"></script>
<script src="<c:url value="/js/bootstrap/scrollspy.js"/>"></script>
<script src="<c:url value="/js/bootstrap/tab.js"/>"></script>
<script src="<c:url value="/js/bootstrap/tooltip.js"/>"></script>
<script src="<c:url value="/js/bootstrap/popover.js"/>"></script>
<script src="<c:url value="/js/bootstrap/button.js"/>"></script>
<script src="<c:url value="/js/bootstrap/collapse.js"/>"></script>
<script src="<c:url value="/js/bootstrap/carousel.js"/>"></script>
<script src="<c:url value="/js/bootstrap/typeahead.js"/>"></script>


<body>



<div class="container">

      <!-- Static navbar -->
      <div class="navbar navbar-default">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Gestionnaire de contact</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Mes contacts</a></li>
            <li><a href="#">Affichage contact</a></li>
          </ul>

        </div><!--/.nav-collapse -->
      </div>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">

		<h2>La liste des contacts</h2>
		<c:forEach var="contact" items="${contacts}">
		<p>
			<br>
			<c:out value="${contact.nomContact}"></c:out>
			<a	href="supprimer.htm?idContact=<c:out value='${contact.idContact}' />">
				Suppression </a>
		</p>
		</c:forEach>
      </div>

    </div> <!-- /container -->

</body>
</html>