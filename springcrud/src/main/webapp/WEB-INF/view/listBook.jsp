<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						<form:form action="save" method="post" modelAttribute="book">
							<div class="mb-3">
								<form:label path="title" cssClass="form-label">Título<span
										class="asterix">*</span>
								</form:label>
								<form:input id="title" path="title" cssClass="form-control"
									onmouseover="pinta('title')" onmouseout="vuelve('title')" />
								<form:errors path="title" cssClass="error" />														
							</div>
							<div class="mb-3">
								<form:label path="author" cssClass="form-label">Autor<span
										class="asterix">*</span>
								</form:label>
								<form:input id="author" path="author" cssClass="form-control"
									onmouseover="pinta('author')" onmouseout="vuelve('author')" />
								<form:errors path="author" cssClass="error" />
							</div>							
							<button type="submit" class="btn btn-primary">Validar</button>
						</form:form>
					</fieldset>
				</div>
				<div class="col-lg-8">

					<fieldset>
						<legend>Listado de libros</legend>
						<table class="table table-striped">
							<tr>
								<th width="28%">Título</th>
								<th width="22%">Autor</th>
								
								<th colspan="2" width="8%">Acciones</th>

							</tr>
							<c:if test="${how_many > 0}">
								<c:forEach items="${books}" var="book">
									
									<tr>
										<td>${book.title}</td>
										<td>${book.author}</td>
										
										<td colspan="2"><a href="#"
											title="Actualizar ${book.title} con id ${book.id}">
												<button type="submit" class="btn btn-success btn-sm">M</button>
										</a><a href="#"
											title="Borrar ${book.title} con id ${book.id}">
												<button type="submit" class="btn btn-danger btn-sm"
													onclick="if(!(confirm('¿Seguro que quieres eliminar el registro?'))) return false">X</button>
										</a></td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${how_many == 0}">
								<tr>
									<td colspan="4">La tabla no contiene registros</td>
								</tr>
							</c:if>

						</table>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp">
		<jsp:param name="web" value="ludoviclaisnez.com" />
	</jsp:include>
</body>
</html>