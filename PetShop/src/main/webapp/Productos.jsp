<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>

</head>
<body>

<jsp:include page="Header.jsp" />
<h1>Modulo Productos</h1>

<form action="Productos" method="post" enctype="multipart/form-data">
	<div>
		<label>Nombre del achivo:</label><input type="text" name="nombreArch">
		<input type="file" value="Examinar" name="archivo">
	</div>
	<div>
		<input type="submit" name="cargar" value="Cargar">
	</div>
	
	
	
	
<form action="Productos" method="post" >
<fieldset>
	<legend>Datos del Producto</legend>
	
	<div class="divformulario">
		<label class="labelformulario">Iva de la compra: </label>
		<input   type="number" name="IvaC" value="Iva compra" >
	</div>
	
	<div class="divformulario" >
		<label class="labelformulario">Nombre del producto: </label>
		<input  type="text" name="NomC" value="Nombre producto" >
	</div>
	
	<div  class="divformulario">
		<label class="labelformulario">Precio del Producto: </label>
		<input  type="number" name="PreC" value="Precio Compra">
	</div>
	
	<h5>Ingrese el codigo del producto para consultar</h5>
	<div  class="divformulario">
		<label class="labelproducto" >Codigo del producto: </label>
		<input type="number" name="codP" value="Codigo Producto" >
	</div>
	
	<div  class="divformulario">
		<input class="botonformulario" type="submit" name="consultar" value="consultar" >
		<input class="botonformulario" type="submit" name="actualizar" value="actualizar" >
	</div>
	
</fieldset>
</form>
	
	
	
	
	
	
</form>

</body>
</html>