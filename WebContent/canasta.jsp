<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<section>

		<c:if test="${cantiArticulos == 0 }">
			<h1>No hay productos</h1>
			<a href="catalogo.jsp" class="btn btn-primary">Realizar Compra <span
				class="glyphicon glyphicon-repeat"></span></a>
		</c:if>

		<c:if test="${cantiArticulos != 0}">


			<div style="width: 70%; height: auto; float: left;">
				<h1>Carrito de compra</h1>

				<%-- Listado de los detalles --%>
				<div class="container mt-4">
					<div class="table-responsive text-nowrap">
						<table id="table" class="table table-hover">
							<thead>
								<tr class="table-dark">
									<th scope="col"></th>
									<th scope="col">Nombre</th>
									<th scope="col">Cantidad</th>
									<th scope="col">Precio</th>
									<th scope="col">Importe</th>
									<th></th>
								</tr>
							</thead>
							<tbody>

								<%-- Proveniente del servlet (atributo) --%>
								<c:forEach items="${ carro }" var="d">

									<tr>
										<td>${d.idprod }</td>
										<td>${d.nomprod }</td>
										<td>${d.cantidad }</td>
										<td><fmt:setLocale value="es_PE" /> <fmt:formatNumber
												type="currency" value="${d.preciovta }" /></td>										
										<td><fmt:setLocale value="es_PE" /> <fmt:formatNumber
												type="currency" value="${d.importe }" /></td>
										<td>
										 <form action="venta" method="post">
										 	<input type="hidden" name="cod" value="${d.idprod}">
										 	<button class="btn nav-link" name="opcion" value="quitar">Eliminar</button>
										 </form>
										</td>	
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>

				<br> <a href="prod?opcion=cargar" class="btn btn-primary">Continuar comprando
					<span class="glyphicon glyphicon-repeat"></span>
				</a>
			</div>
			<div
				style="width: 29%; height: 400px; float: left; border: 1px solid">
				<h1>Resumen de pedido</h1>
				<hr>
				<%-- muestra la variable global enviada desde el Listener --%>
				<label>Sub total (${cantArticulos}) <fmt:setLocale
						value="es_PE" /> <fmt:formatNumber type="currency"
						value="${subTotalVenta}" />
				</label>
				<hr>
				<form action="">
					<button class="btn btn-primary" name="opcion" value="finalizar">
						Procesar compra <span class="glyphicon glyphicon-ok"></span>
					</button>
				</form>
			</div>
		</c:if>

	</section>



</body>
</html>

