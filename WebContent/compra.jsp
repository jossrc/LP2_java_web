<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	

	<fieldset class="container">
		<legend style="background-color: silver;">Formulario de
			compras</legend>
		<form action="venta" method="post">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td></td>
							</tr>
						</table>
					</td>

					<td>
						<table>
							<tr>
								<td><label>Cod producto:</label> </td>
								<td><label>${existeProducto.id}</label> <a
									href="#"><img src="img/lupa.png" alt="">
								</a></td>
							</tr>
							<tr>
								<td>Descripción : </td>
								<td><label>${existeProducto.descripcion}</label></td>
							</tr>
							<tr>
								<td>Precio :</td>
								<td><label>
								<fmt:setLocale value="es_PE"/>
                				<fmt:formatNumber type="currency" value="${existeProducto.precio }" />  
                				</label></td>
							</tr>
							<tr>
								<td>Cantidad a comprar:</td>
								<td><input class="form-control" type="number" value="1" name="cantidad" min="1"
									max=""></td>
							</tr>

							<tr>
								<td>
									<button class="btn btn-primary" name="opcion" value="agregar">
										Agregar compra <span class="glyphicon glyphicon-shopping-cart"></span>
									</button>
							</tr>

						</table>
					</td>

				</tr>
			</table>


		</form>
	</fieldset>
	<br>

</body>
</html>