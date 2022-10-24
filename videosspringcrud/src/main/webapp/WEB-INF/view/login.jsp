<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/templates/head.jsp"></jsp:include>
<link
	href="${pageContext.request.contextPath}/assets/css/login.css"
	rel="stylesheet" type="text/css" />
</head>
<body class="d-flex flex-column h-100 text-center">
	<div class="flex-shrink-0">
		<section class="h-100 gradient-form" style="background-color: #eee;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-xl-10">
						<div class="card rounded-3 text-black">
							<div class="row g-0">
								<div class="col-lg-6">
									<div class="card-body p-md-5 mx-md-4">

										<div class="text-center">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
												style="width: 185px;" alt="logo">
											<h4 class="mt-1 mb-5 pb-1">${titulo}</h4>
										</div>
										<form:form action="${pageContext.request.contextPath}/autorizado" method="POST"> 
											<p>Puedes conectarte para acceder a tu cuenta</p>

											<div class="form-outline mb-4">
												<label class="form-label" for="form2Example11">Usuario</label>
												<input type="text" name="username" id="form2Example11"
													class="form-control"
													placeholder="Nombre de usuario que usaste al crear la cuenta" />
											</div>
											
											<div class="form-outline mb-4">
												<label class="form-label" for="form2Example22">Contraseña</label>
												<input type="password" id="form2Example22" name="password" 
													class="form-control" />
											</div>
											<div class="text-center pt-1 mb-5 pb-1">
												<input
													class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3"
													type="submit" value="Validar" /><br/>													
													<c:if test="${param.error != null }">													
													<span class="errors">Usuario o contraseña incorrectos</span>
													</c:if>
													<c:if test="${param.logout != null }">													
													<span class="errors">!Hasta pronto¡</span>
													</c:if>
													<c:if test="${param.error == null }">													
													<br/>
													</c:if>
													
											</div>
										</form:form>
									</div>
								</div>
								<div
									class="col-lg-6 d-flex align-items-center gradient-custom-2">
									<div class="text-white px-3 py-4 p-md-5 mx-md-4">
										<h4 class="mb-4">Estamos viendo como crear/instalar
											funciones de inicio</h4>
										<p class="small mb-0">${descripcion}.Lorem ipsum dolor sit
											amet, consectetur adipisicing elit, sed do eiusmod tempor
											incididunt ut labore et dolore magna aliqua. Ut enim ad minim
											veniam, quis nostrud exercitation ullamco laboris nisi ut
											aliquip ex ea commodo consequat.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>


</body>
</html>