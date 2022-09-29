<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<div class="col-4 mx-auto">
					<p>${descripcion}</p>
					<form:form action="confirm_loan" method="post" modelAttribute="user">
						<fieldset>
							<legend>${titulo}</legend>
							<form:hidden path="username" />
							<form:hidden path="email" />
							<form:hidden path="name" />
							<form:hidden path="surname" />
							<form:hidden path="password" />
							<form:hidden path="confirmPassword" />
							<form:hidden path="enabled" />

							<div class="mb-3">
								<form:label path="name" cssClass="form-label">Nombre</form:label>
								<form:input path="name" cssClass="form-control" disabled="true" />
						
							</div>

							<div class="mb-3">
								<form:label path="email" cssClass="form-label">Email</form:label>
								<form:input path="email" cssClass="form-control" disabled="true" />					
							</div>
							
							<div class="mb-3">
							<div class="form-switch text-start">
								<form:label path="books" cssClass="form-check-label">Libros prestados</form:label><br/>
								<form:checkboxes path="books" cssClass="form-check-input mx-3" 
								items="${booklist}" itemLabel="title" itemValue="title" delimiter="<br/>" />	
								<form:errors path="books" cssClass="errors"/>
								</div>
											
							</div>


							<button type="submit" class="btn btn-primary">Validar</button>

						</fieldset>
					</form:form>
				</div>

			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/view/templates/footer.jsp">
		<jsp:param name="web" value="ludoviclaisnez.com" />
	</jsp:include>
</body>
</html>