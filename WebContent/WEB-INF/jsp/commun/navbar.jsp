<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Static navbar -->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-inner">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Gestionnaire de contact</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
			
				<li <c:if test="${ section == 'contact' }">class="active"</c:if> ><a href="<c:url value="/contact/lister"/>"><img
						width="28" height="28" alt="Liste contact"
						src="<c:url value="/images/contact/list.png"/>" /></a></li>
				<li <c:if test="${ section == 'adresse' }">class="active"</c:if>><a href="<c:url value="/adresse/lister"/>"><img
						width="28" height="28" alt="Liste adresses"
						src="<c:url value="/images/adresse/list.png"/>" /></a></li>
			</ul>

		</div>
	</div>
	<!--/.nav-collapse -->
</div>

<br><br><br><br>