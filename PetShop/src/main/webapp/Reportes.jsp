<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>
<link rel="stylesheet" href="css/Opciones.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reportes.js"></script>
</head>
<body>

<jsp:include page="Header.jsp" />

<h1>Modulo Reportes</h1>
<div class=contenedorBotonesReporte>
<button class="botonReporte listaClientes">Listado de Clientes</button>
<button class="botonReporte listaVentas">Listado de Ventas</button>
<button class="botonReporte listaUsuarios">Listado de Usuarios</button>
</div>


<table id="tabla" class="tablaReportes"></table>

</body>
</html>