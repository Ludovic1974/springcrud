<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/templates/head.jsp"></jsp:include>
</head>
<body class="d-flex flex-column h-100 text-center">
	<jsp:include page="/WEB-INF/view/templates/nav.jsp"></jsp:include>
	<div class="flex-shrink-0">
		<div class="container-fluid">
			<div class="row mt-4">
				<div class="col-lg-4">
					<fieldset>
						<legend>${titulo}</legend>
						<p>${descripcion}</p>
						<form:form action="save" method="post" modelAttribute="user">
							<div class="mb-3">
								<form:label path="username" cssClass="form-label">Nombre de perfil</form:label>
									<c:choose>
									<c:when test="${param.username == null}">
										<form:input path="username" cssClass="form-control" />
										
									</c:when>
									<c:otherwise>
										<form:input path="username" cssClass="form-control"	disabled="true" />
										<form:hidden path="username" />
									</c:otherwise>
								</c:choose>
								<form:errors path="username" cssClass="error" />
								<form:hidden path="enabled" />
							</div>
							<div class="mb-3">
								<form:label path="name" cssClass="form-label">Nombre</form:label>
								<form:input path="name" cssClass="form-control" />
								<form:errors path="name" cssClass="error" />
							</div>
							<div class="mb-3">
								<form:label path="surname" cssClass="form-label">Apellido</form:label>
								<form:input path="surname" cssClass="form-control" />
								<form:errors path="surname" cssClass="error" />
							</div>
							<div class="mb-3">
								<form:label path="email" cssClass="form-label">Email</form:label>
								<form:input path="email" cssClass="form-control" />
								<form:errors path="email" cssClass="error" />
							</div>
							<div class="mb-3">
								<form:label path="password" cssClass="form-label">Contraseña</form:label>
								<form:password path="password" cssClass="form-control" />
								<form:errors path="password" cssClass="error" />
							</div>
							<div class="mb-3">
								<form:label path="confirmPassword" cssClass="form-label">Repetir contraseña</form:label>
								<form:password path="confirmPassword" cssClass="form-control" />
								<form:errors path="confirmPassword" cssClass="error" />
							</div>
							<button type="submit" class="btn btn-primary">Validar</button>
						</form:form>
					</fieldset>
				</div>
				<div class="col-lg-8">
					<fieldset>
						<legend>Lista de usuarios</legend>
						<table class="table table-striped">
							<tr>
								<th>Nombre perfil</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Email</th>
									<th>Modificado</th>	
								<th>Activado</th>
								<th colspan="2">Acciones</th>
							</tr>
							<c:if test="${how_many > 0}">
								<c:forEach items="${users}" var="user">

									<c:url var="delete" value="delete">
										<c:param name="username" value="${user.username}" />
									</c:url>
									<c:url var="edit" value="edit">
										<c:param name="username" value="${user.username}" />
									</c:url>

									<tr>
										<td>${user.username}</td>
										<td>${user.name}</td>
										<td>${user.surname}</td>
										<td>${user.email}</td>
											<td><fmt:formatDate type="both" value="${user.updatedAt}"
												dateStyle="long" timeStyle="short" /></td>	
										<td>${user.enabled==true ? "Activado":"Desactivado"}</td>

										<td><a href="${edit}" title="Actualizar ${user.name}">
												<button type="submit" class="btn btn-success btn-sm">Modificar</button>
										</a></td>
										<td><a href="${delete}" title="Borrar ${user.name}">
												<button type="submit" class="btn btn-danger btn-sm"
													onclick="if(!(confirm('¿Seguro que quieres eliminar el registro?'))) return false">Borrar</button>
										</a></td>

									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${how_many == 0}">
								<tr>
									<td colspan="7">La tabla no contiene registros</td>
								</tr>
							</c:if>

						</table>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp">
		<jsp:param name="web" value="campus2b.com" />
	</jsp:include>
</body>
</html>