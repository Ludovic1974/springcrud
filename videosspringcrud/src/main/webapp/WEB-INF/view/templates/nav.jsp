<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Java
			Spring Crud</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a
					class="nav-link ${menu == 'portada' ? 'active' : ''}"
					aria-current="page" href="${pageContext.request.contextPath}/">Portada</a>
				</li>
				<li class="nav-item"><a
					class="nav-link ${menu == 'lista_libros' ? 'active' : ''}"
					href="${pageContext.request.contextPath}/book/list">Gestionar
						libros</a></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/category/list"
					class="nav-link ${menu == 'lista_categorias' ? 'active' : ''}">Gestionar
						categorías</a></li>

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/user/list"
					class="nav-link ${menu == 'lista_usuarios' ? 'active' : ''}">Gestionar
						usuarios</a></li>
			</ul>
			<form:form action="${pageContext.request.contextPath}/logout"
				class="d-flex" method="POST">
				<input type="submit" class="btn btn-outline-danger" value="Cerrar sesión"/>
			</form:form>
		</div>
	</div>
</nav>