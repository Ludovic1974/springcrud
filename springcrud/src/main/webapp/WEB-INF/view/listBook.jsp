<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<h1 class="text-center mb-4">${titulo}</h1>
					<p class="text-start mb-4">${descripcion}</p>
					

					<fieldset>
						<legend>Lista de libros</legend>
						<table class="table table-striped">
							<tr>
								<th>Título</th>
								<th>Autor</th>
								<th>Actualizar</th>
								<th>Borrar</th>

							</tr>
							<c:if test="${how_many > 0}">
								<c:forEach items="${books}" var="book">
									
									<tr>
										<td>${book.title}</td>
										<td>${book.author}</td>
										<td><a href="#"
											title="Actualizar ${book.title} con id ${book.id}">
												<button type="submit" class="btn btn-success">Modificar</button>
										</a></td>
										<td><a href="#"
											title="Borrar ${book.title} con id ${book.id}">
												<button type="submit" class="btn btn-danger"
													onclick="if(!(confirm('¿Seguro que quieres eliminar el registro?'))) return false">Borrar</button>
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