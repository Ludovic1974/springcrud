<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/templates/head.jsp"></jsp:include>
</head>
<body class="d-flex flex-column h-100 text-center">
	<jsp:include page="/WEB-INF/view/templates/nav.jsp"></jsp:include>

	<div class="flex-shrink-0">
		<div class="container">
			<div class="row">
				<div class="col-8 mx-auto">
					<h1 class="text-center">${titulo}</h1>
					<p class="text-center">${descripcion}</p>
					
					<p class="text-center">
					<security:authorize access="isAuthenticated()">
					Te saludamos querido <security:authentication property="principal.username"/>
					</security:authorize>. Por desgracia, no tienes acceso a todas los secretos de nuestra web. 
					<br/>
					${lorem}<br/>
					<a href="${pageContext.request.contextPath}/" title="Volver al inicio">Inicio</a>
					
					
					</p>
			
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/view/templates/footer.jsp">
		<jsp:param name="web" value="ludoviclaisnez.com" />
	</jsp:include>
</body>
</html>