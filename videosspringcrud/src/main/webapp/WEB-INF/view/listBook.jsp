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
					<p>${descripcion_form}</p>
					<form:form action="save" method="post" modelAttribute="book">
						<fieldset>
							<legend>${titulo_form}</legend>

							<div class="mb-3">
								<form:label path="title" cssClass="form-label">Título <span
										class="asterix">*</span>
								</form:label>
								<form:input id="title" path="title" cssClass="form-control"
									onmouseover="pinta('title')" onmouseout="vuelve('title')" />
								<form:errors path="title" cssClass="errors" />
								<form:hidden path="id" />
								<form:hidden path="bookDetails.id" />
							</div>

							<div class="mb-3">
								<form:label path="author" cssClass="form-label">Author <span
										class="asterix">*</span>
								</form:label>
								<form:input id="author" path="author" cssClass="form-control"
									onmouseover="pinta('author')" onmouseout="vuelve('author')" />
								<form:errors path="author" cssClass="errors" />
							</div>

							<div class="mb-3">
								<form:label path="bookDetails.publicationYear"
									cssClass="form-label">Año de publicación <span
										class="asterix">*</span>
								</form:label>
								<form:input id="publicationYear"
									path="bookDetails.publicationYear" cssClass="form-control"
									onmouseover="pinta('publicationYear')"
									onmouseout="vuelve('publicationYear')" />
								<form:errors path="bookDetails.publicationYear"
									cssClass="errors" />
							</div>

							<div class="mb-3">
								<form:label path="bookDetails.purchaseYear"
									cssClass="form-label">Año de compra <span
										class="asterix">*</span>
								</form:label>
								<form:input id="purchaseYear" path="bookDetails.purchaseYear"
									cssClass="form-control" onmouseover="pinta('purchaseYear')"
									onmouseout="vuelve('purchaseYear')" />
								<form:errors path="bookDetails.purchaseYear" cssClass="errors" />
							</div>

							<div class="mb-3">
								<form:label path="bookDetails.pageNumber" cssClass="form-label">Número de páginas <span
										class="asterix">*</span>
								</form:label>
								<form:input id="pageNumber" path="bookDetails.pageNumber"
									cssClass="form-control" onmouseover="pinta('pageNumber')"
									onmouseout="vuelve('pageNumber')" />
								<form:errors path="bookDetails.pageNumber" cssClass="errors" />
							</div>




							<button type="submit" class="btn btn-primary">Validar</button>

						</fieldset>
					</form:form>
				</div>
				<div class="col-8">
					<h1>${titulo}</h1>
					<p>${descripcion}</p>
					<table class="table table-striped">
						<tr>
							<th>Título</th>
							<th>Autor</th>
							<th>Modificado</th>
							<th>Publicado</th>
							<th>Comprado</th>
							<th>Páginas</th>
							<th colspan="2">Acciones</th>

						</tr>
						<c:if test="${how_many > 0}">
							<c:forEach items="${books}" var="book">
								<c:url var="delete" value="delete">
									<c:param name="id" value="${book.id}" />
								</c:url>
								<c:url var="edit" value="edit">
									<c:param name="id" value="${book.id}" />
								</c:url>
								<tr>
									<td>${book.title}</td>
									<td>${book.author}</td>
									<td><fmt:formatDate value="${book.updatedAt}" type="both"
											dateStyle="long" timeStyle="short" /></td>
									<td>${book.bookDetails.publicationYear}</td>
									<td>${book.bookDetails.purchaseYear}</td>
									<td>${book.bookDetails.pageNumber}</td>
									<td><a href="${edit}" title="Actualizar ${book.title}"><button
												type="submit" class="btn btn-success">Modificar</button></a></td>
									<td><a href="${delete}" title="Borrar ${book.title}"><button
												type="submit" class="btn btn-danger"
												onclick="if(!(confirm('¿Seguro que quieres eliminar el registro?'))) return false">Borrar</button></a></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${how_many == 0}">
							<tr>
								<td colspan="8">La tabla no contiene registros</td>
							</tr>
						</c:if>
					</table>




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