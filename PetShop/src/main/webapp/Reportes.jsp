<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>
<link rel="stylesheet" href="css/Opciones.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>

<jsp:include page="Header.jsp" />

<h1>Modulo Reportes</h1>
<div class=contenedorBotonesReporte>
<a class="botonReporte listaUsuarios" href="ReportesUsuarios.jsp">Listado de Usuarios</a>
<a class="botonReporte listaClientes" href="ReportesClientes.jsp">Listado de Clientes</a>
<a class="botonReporte listaVentas" href="ReportesVentas.jsp">Listado de Ventas</a>
</div>


<table id="tabla" class="tablaReportes"></table>

</body>
</html>