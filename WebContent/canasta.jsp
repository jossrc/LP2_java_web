<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="width: 70%; height: auto; float: left;">
		<h1>Carrito de compra</h1>
		<br>
		

		<a href="" class="btn btn-primary">Continuar comprando <span class="glyphicon glyphicon-repeat"></span></a>
	</div>
	<div style="width: 29%; height: 400px; float: left; border: 1px solid">
		<h1>Resumen de pedido</h1>
		<hr>
		<%-- muestra la variable global enviada desde el Listener --%>
		<label>Sub total S/.  </label>
		<hr>
		<form action="">
			<button class="btn btn-primary">Procesar compra <span class="glyphicon glyphicon-ok"></span> </button>
		</form>


	</div>

</body>
</html>

