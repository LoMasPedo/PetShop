<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>
<link rel="stylesheet" href="css/Opciones.css">

<script>

function validacion() {
	var resultado = window.confirm("Desea confirmar la accion?");
	return resultado;
}

</script>




</head>
<body>

<jsp:include page="Header.jsp" />
<h1>Modulo Clientes</h1>

<%!
String mensaje="";
long cedulaCliente=0;
String direccionCliente="",emailCliente="",nombreCliente="",telefonoCliente="", estado="enabled";
%>

<%
if(request.getParameter("cedula_cliente")!=null)
{
	cedulaCliente=Long.parseLong(request.getParameter("cedula_cliente"));
	direccionCliente = request.getParameter("direccion_cliente");
	emailCliente = request.getParameter("email_cliente");
	nombreCliente = request.getParameter("nombre_cliente");
	telefonoCliente = request.getParameter("telefono_cliente");
	mensaje="";
	estado="disabled";
}
%>
<%
if(request.getParameter("men")!=null)
{
	cedulaCliente=0;
	direccionCliente="";
	emailCliente="";
	nombreCliente="";
	telefonoCliente="";
	mensaje=request.getParameter("men");
	estado="enabled";
}
%>

<div class="padre">
<div class="hijo">
<h2><%=mensaje %></h2>

<!--  pueden usar esta lib para los estilos https://getbootstrap.com/docs/5.1/forms/overview/ copie el ejemplo del formulario
de aqui tome el ejemplo para centrar el formulario https://devcode.la/tutoriales/como-centrar-un-div-con-css/ -->
<form action="Clientes" method="post" onsubmit="return validacion()">
<fieldset>
	<legend>Datos del Cliente:</legend>
	<div  class="divformulario">
		<label class="labelformulario" >Cedula: </label>
		<input type="number" name="cedula_cliente" value="<%=cedulaCliente%>" required <%=estado%>></div>
		<input type="hidden" name="cedula_cliente" value="<%=cedulaCliente%>">
	<div class="divformulario">
		<label class="labelformulario">Direccion: </label>
		<input   type="text" name="direccion_cliente" value="<%=direccionCliente%>" required>
	</div>
	<div class="divformulario" >
		<label class="labelformulario">Correo Electronico: </label>
		<input  type="text" name="email_cliente" value="<%=emailCliente%>" required>
	</div>
	<div  class="divformulario">
		<label class="labelformulario">Nombre: </label>
		<input  type="text" name="nombre_cliente" value="<%=nombreCliente%>" required>
	</div>
	<div class="divformulario">
		<label class="labelformulario">Telefono: </label>
		<input type="number" name="telefono_cliente" value="<%=telefonoCliente%>" required>
	</div>
	<div  class="divformulario">
		<input class="botonformulario" type="submit" name="registrar" value="registrar" >
		<input class="botonformulario" type="submit" name="actualizar" value="actualizar" >
		<input class="botonformulario" type="submit" name="eliminar" value="eliminar" > </div>
</fieldset>
</form>
<form action="Clientes" method="post">
   <fieldset>
      <legend>Consultar</legend>
      <div class="divformulario">
      <label class="labelformulario">cedula: </label>
      <input  type="number" name="cedula_cliente" required placeholder= "Solo campos num�ricos"></div>
      <div ><input class="botonformulario" type="submit" name="consultar" value="consultar" ></div>
   </fieldset>
</form>

</div>
</div>
</body>
</html>