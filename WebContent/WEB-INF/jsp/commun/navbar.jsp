<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Static navbar -->
<div class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Gestionnaire de contact</a>
	</div>
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="<c:url value="/contact/lister"/>"><img width="28" height="28" alt="Liste contact" src="<c:url value="/images/contact/list.png"/>" /></a></li>
			<li><a href="<c:url value="/adresses/lister"/>"><img width="28" height="28" alt="Liste adresses" src="<c:url value="/images/adresse/list.png"/>" /></a></li>
		</ul>

	</div>
	<!--/.nav-collapse -->
</div>
