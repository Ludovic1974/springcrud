<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<div class="row">
				<div class="col-4">
					<form:form action="save" method="post" modelAttribute="user">
						<fieldset>
							<legend>${titulo}</legend>

							<div class="mb-3">
								<c:choose>
									<c:when test="${param.username == null}">
								<form:label path="username" cssClass="form-label">Nombre de perfil<span
										class="asterix">*</span></form:label>
										<form:input path="username" cssClass="form-control" />
									</c:when>
									<c:otherwise>
								<form:label path="username" cssClass="form-label">Nombre de perfil</form:label>
										<form:input path="username" cssClass="form-control"
											disabled="true" />
										<form:hidden path="username" />
									</c:otherwise>
								</c:choose>

								<form:errors path="username" cssClass="errors" />
								<form:hidden path="enabled" />
							</div>
							<div class="mb-3">
								<form:label path="name" cssClass="form-label">Nombre</form:label>
								<form:input path="name" cssClass="form-control" />
								<form:errors path="name" cssClass="errors" />
							</div>
							<div class="mb-3">
								<form:label path="surname" cssClass="form-label">Apellido</form:label>
								<form:input path="surname" cssClass="form-control" />
								<form:errors path="surname" cssClass="errors" />
							</div>
							<div class="mb-3">
								<form:label path="email" cssClass="form-label">Email<span
										class="asterix">*</span></form:label>
								<form:input path="email" cssClass="form-control" />
								<form:errors path="email" cssClass="errors" />
							</div>
							<div class="mb-3">
								<form:label path="password" cssClass="form-label">Contraseña<span
										class="asterix">*</span></form:label>
								<form:password path="password" cssClass="form-control" />
								<form:errors path="password" cssClass="errors" />
								<c:if test="${equalPasswords != null}">
									<span class="errors">${equalPasswords}</span>
								</c:if>
							</div>
							<div class="mb-3">
								<form:label path="confirmPassword" cssClass="form-label">Repetir contraseña<span
										class="asterix">*</span></form:label>
								<form:password path="confirmPassword" cssClass="form-control" />
								<form:errors path="confirmPassword" cssClass="errors" />

							</div>

							<button type="submit" class="btn btn-primary">Validar</button>

						</fieldset>
					</form:form>
				</div>
				<div class="col-8">
					<h1>Tabla de usuarios</h1>
					<div class="accordion accordion-flush" id="accordionPages">
						<c:if test="${how_many > 0}">
							<c:forEach items="${users}" var="user">
								<div class="accordion-item">
									<h2 class="accordion-header" id="heading${user.username}">
										<button class="accordion-button" type="button"
											data-bs-toggle="collapse"
											data-bs-target="#collapse${user.username}"
											aria-expanded="true" aria-controls="collapse${user.username}">
											${user.username}</button>
									</h2>
								</div>
								<div id="collapse${user.username}"
									class="accordion-collapse collapse"
									aria-labelledby="heading${user.username}"
									data-bs-parent="#accordionPages">
									<div class="accordion-body">
										<table class="table table-striped">
											<tr>

												<th>Nombre</th>
												<th>Apellido</th>
												<th>Email</th>
												<th>Modificado</th>
												<th>Activado</th>
												<th colspan="4">Acciones</th>
											</tr>
											<c:url var="loan_books" value="loan_books">
												<c:param name="username" value="${user.username}" />
											</c:url>
											<c:url var="delete" value="delete">
												<c:param name="username" value="${user.username}" />
											</c:url>
											<c:url var="edit" value="edit">
												<c:param name="username" value="${user.username}" />
											</c:url>
											<c:url var="role" value="role">
												<c:param name="username" value="${user.username}" />
											</c:url>
											<tr>
												<td>${user.name}</td>
												<td>${user.surname}</td>
												<td>${user.email}</td>
												<td><fmt:formatDate type="both"
														value="${user.updatedAt}" dateStyle="long"
														timeStyle="short" /></td>
												<td>${user.enabled==true ? "Activado":"Desactivado"}</td>
												<td><a href="${loan_books}"
													title="Consultar listado de libros prestados a ${user.name}">
														<button type="submit" class="btn btn-primary btn-sm">Gestionar</button>
												</a></td>
												<td><a href="${edit}" title="Actualizar ${user.name}">
														<button type="submit" class="btn btn-success btn-sm">Modificar</button>
												</a></td>
												<td><a href="${delete}" title="Borrar ${user.name}">
														<button type="submit" class="btn btn-danger btn-sm"
															onclick="if(!(confirm('¿Seguro que quieres eliminar el registro?'))) return false">Borrar</button>
												</a></td>

												<td><a href="${role}"
													title="Gestionar permisos de ${user.name}">
														<button type="submit" class="btn btn-info btn-sm">Permisos</button>
												</a></td>
											</tr>
										</table>
										<c:if test="${user.books.size() > 0}">
											<table class="table table-striped table-dark">
												<tr>
													<th>ID</th>
													<th>Libro</th>
													<th>Autor</th>
													<th>Año de adquisición</th>
												</tr>
												<c:forEach items="${user.books}" var="book">
													<tr>
														<th>${book.id}</th>
														<td>${book.title}</td>
														<td>${book.author}</td>
														<td>${book.bookDetails.purchaseYear}</td>
													</tr>
												</c:forEach>
											</table>
										</c:if>

									</div>
								</div>

							</c:forEach>
						</c:if>
						<c:if test="${how_many == 0}">
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button" type="button">No hay
										ningun usuario registrado</button>
								</h2>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function pinta(id) {
			document.getElementById(id).style.backgroundColor = "#d2d2d2";
		}

		function vuelve(id) {
			document.getElementById(id).style.backgroundColor = "WHITE";
		}
	</script>


	<jsp:include page="/WEB-INF/view/templates/footer.jsp">
		<jsp:param name="web" value="ludoviclaisnez.com" />
	</jsp:include>
</body>
</html>