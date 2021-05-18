<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- Importamos la libreria de etiquetas --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba con JSTL</title>
</head>
<body>
	<c:set var="contador" scope="application" value="${ contador + 1 }"></c:set>
	<h1>Demostración de seguimiento</h1>
	<%-- Visualizar la cuenta para esta página --%>
	 Ud. ha visualizado esta página ${contador} ${(contador > 1) ? "veces." : "vez."} 
	<br>
	<hr>
	<%-- Mostrar un mensaje al visitar cada 7 veces --%>
	<c:if test="${contador % 7 == 0}">
	   <div>
	     Estas recargando muchas veces
	   </div>
	</c:if>
	
</body>
</html>