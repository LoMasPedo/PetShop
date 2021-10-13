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
<h1>Modulo Proveedores</h1>

<%!
String mensaje="";
long nit_proveedor=0;
String ciudad_proveedor="",direccion_proveedor="",nombre_proveedor="",telefono_proveedor="", estado="enabled";
%>

<%
if(request.getParameter("Nit_Proveedor")!=null)
{
	nit_proveedor=Long.parseLong(request.getParameter("Nit_Proveedor"));
	ciudad_proveedor = request.getParameter("Ciudad_Proveedor");
	direccion_proveedor = request.getParameter("Direccion_Proveedor");
	nombre_proveedor = request.getParameter("Nombre_Proveedor");
	telefono_proveedor = request.getParameter("Telefono_Proveedor");
	mensaje="";
	estado="disabled";
}
else
if(request.getParameter("men")!=null)
{
	nit_proveedor=0;
	ciudad_proveedor="";
	direccion_proveedor="";
	nombre_proveedor="";
	telefono_proveedor="";
	mensaje=request.getParameter("men");
	estado="enabled";
}
else
	{
	
	nit_proveedor=0;
	ciudad_proveedor="";
	direccion_proveedor="";
	nombre_proveedor="";
	telefono_proveedor="";
	mensaje="";
	estado="enabled";
	
	}
%>

<div class="padre">
<div class="hijo">
<h2><%=mensaje %></h2>

<!--  pueden usar esta lib para los estilos https://getbootstrap.com/docs/5.1/forms/overview/ copie el ejemplo del formulario
de aqui tome el ejemplo para centrar el formulario https://devcode.la/tutoriales/como-centrar-un-div-con-css/ -->
<form action="Proveedores" method="post" >
<fieldset>
	<legend>Datos Proveedor:</legend>
	<div  class="divformulario">
		<label class="labelformulario" >NIT: </label>
		<input type="number" name="Nit_Proveedor" value="<%=nit_proveedor%>" required <%=estado%>></div>
		<input type="hidden" name="Nit_Proveedor" value="<%=nit_proveedor%>">
	<div class="divformulario">
		<label class="labelformulario">Nombre Proveedor: </label>
		<input   type="text" name="Nombre_Proveedor" value="<%=nombre_proveedor%>" required placeholder="nombre_proveedor">
	</div>
	<div class="divformulario" >
		<label class="labelformulario">Direccion: </label>
		<input  type="text" name="Direccion_Proveedor" value="<%=direccion_proveedor%>" required>
	</div>
	<div  class="divformulario">
		<label class="labelformulario">Telefono: </label>
		<input  type="number" name="Telefono_Proveedor" value="<%=telefono_proveedor%>" required>
	</div>
	<div class="divformulario">
		<label class="labelformulario">Ciudad: </label>
		<input type="text" name="Ciudad_Proveedor" value="<%=ciudad_proveedor%>" required>
	</div>
	<div  class="divformulario">
		<input class="botonformulario" type="submit" name="registrar" value="registrar" >
		<input class="botonformulario" type="submit" name="actualizar" value="actualizar" >
		<input class="botonformulario" type="submit" name="eliminar" value="eliminar" > </div>
</fieldset>
</form>
<form action="Proveedores" method="post">
   <fieldset>
      <legend>Consultar</legend>
      <div class="divformulario">
      <label class="labelformulario">NIT Proveedor: </label>
      <input  type="number" name="Nit_Proveedor" required placeholder= "Solo campos numéricos"></div>
      <div ><input class="botonformulario" type="submit" name="consultar" value="consultar" ></div>
   </fieldset>
</form>

</div>
</div>


</body>
</html>