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
			<div class="row mt-4">
				<div class="col-4">
					<form:form action="add_role" method="post" modelAttribute="role">
						<fieldset>
							<legend>${titulo}</legend>
							<p>${descripcion}</p>
							<div class="mb-3">
								<form:label path="user.username" cssClass="form-label">Nombre de perfil
								</form:label>
								<form:input path="user.username" cssClass="form-control"
									disabled="true" value="${user.username}" />
								<form:errors path="user.username" cssClass="errors" />
								<form:hidden path="user.username" value="${user.username}" />
							</div>
							<div class="mb-3">
								<form:label path="authority" cssClass="form-label">Rol<span
										class="asterix">*</span>
								</form:label>
								<form:select path="authority" cssClass="form-control">
									<c:forEach items="${rolelist}" var="role">
										<form:option value="${role}" label="${role}" />
									</c:forEach>
								</form:select>
								<form:errors path="authority" cssClass="errors" />
							</div>
							<button type="submit" class="btn btn-primary">Validar</button>
						</fieldset>
					</form:form>
				</div>
				<div class="col-8">
					<h1>Detalles acerca de este usuario</h1>
					<table class="table table-striped">
						<tr>
							<th>Nombre de perfil</th>
							<td>${user.username}</td>
						</tr>
						<tr>
							<th>Nombre</th>
							<td>${user.name}</td>
						</tr>
						<tr>
							<th>Apellido</th>
							<td>${user.surname}</td>
						</tr>
						<tr>
							<th>Email</th>
							<td>${user.email}</td>
						</tr>
						<tr>
							<th>Habilitado</th>
							<td>${user.enabled==true? "Sí" : "No"}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/view/templates/footer.jsp">
		<jsp:param name="web" value="ludoviclaisnez.com" />
	</jsp:include>
</body>
</html>