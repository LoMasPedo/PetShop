<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>
<link rel="stylesheet" href="css/Opciones.css">
</head>
<body>

<jsp:include page="Header.jsp" />
<h1>Modulo Productos</h1>

<%!
String mensaje="";
long CodigoProducto=0;
double IvaCompra= 0;
double PrecioCompra= 0;
String NombreProducto="";
%>

<%
if(request.getParameter("codP")!=null)
{
	CodigoProducto= Long.parseLong(request.getParameter("codP"));
	IvaCompra = Double.parseDouble(request.getParameter("IvaC"));
	NombreProducto = request.getParameter("NomC");
	PrecioCompra = Double.parseDouble(request.getParameter("PreC"));
	mensaje="";
}
%>
<%
if(request.getParameter("men")!=null)
{
	CodigoProducto= 0;
	IvaCompra = 0;
	NombreProducto = "";
	PrecioCompra = 0;	
	mensaje=request.getParameter("men");
}
%>
<div class="padre">
<div class="hijo">
<h2><%=mensaje %></h2>
<form action="Productos" method="post" enctype="multipart/form-data">
	<div>
		<label>Nombre del achivo:</label><input type="text" name="nombreArch">
		<input type="file" value="Examinar" name="archivo">
	</div>
	<div>
		<input type="submit" name="cargar" value="Cargar">
	</div>	
</form>

<h2><%=mensaje%></h2>

<form action="Productos" method="post" >
	<fieldset>
		<legend>Datos del Producto</legend>
		
		<div class="divformulario">
			<label class="labelformulario">Iva de la compra: </label>
			<input   type="number" name="IvaC" value="<%=IvaCompra%>" >
		</div>
		
		<div class="divformulario" >
			<label class="labelformulario">Nombre del producto: </label>
			<input  type="text" name="NomC" value="<%=NombreProducto%>"  >
		</div>
		
		<div  class="divformulario">
			<label class="labelformulario">Precio del Producto: </label>
			<input  type="number" name="PreC" value="<%=PrecioCompra%>">
		</div>
		
		<h5>Ingrese el codigo del producto para consultar</h5>
		<div  class="divformulario">
			<label class="labelproducto" >Codigo del producto: </label>
			<input type="number" name="codP" value="<%=CodigoProducto%>" >
		</div>
		
		<div  class="divformulario">
			<input class="botonformulario" type="submit" name="consultar" value="Consultar" >
			<input class="botonformulario" type="submit" name="actualizar" value="Actualizar" >
		</div>	
			
	</fieldset>
</form>
</div>
</div>
</body>
</html>