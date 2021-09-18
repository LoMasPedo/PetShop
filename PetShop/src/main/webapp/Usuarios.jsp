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

<%!
	String mensaje="";
	String email_usuario="",nombre_usuario="",password="",usuario="",   estado="enabled";
	long cedula=0;
%>

<%
if(request.getParameter("Cedula_usuario")!=null){
	cedula=Integer.parseInt(request.getParameter("Cedula_usuario"));
	email_usuario= request.getParameter("Email_usuario");
	nombre_usuario=request.getParameter("Nombre_usuario");
	password=request.getParameter("Password");
	usuario=request.getParameter("Usuarios");
	estado="disabled";
}
%>

<%
if(request.getParameter("men")!=null){
	cedula=0;
	email_usuario="";
	nombre_usuario="";
	password="";
	usuario="";
	mensaje=request.getParameter("men");
}
%>

<style>
.padre {
  height: auto;
  /*IMPORTANTE*/
  display: flex;
  justify-content: center;
  align-items: center;
  /*border:1px solid gray;*/
}

.hijo {
  width: 400px;
}

.divformulario{
 margin: 10px;
}

.labelformulario
{
min-width: 150px;
display:inline-block;
}

.botonformulario{
     display: inline-block;
    font-weight: 400;
    text-align: center;
  
    border: 1px solid transparent;
    padding: .375rem .75rem;
    font-size: 1rem;
    line-height: 1.5;
    border-radius: .25rem;
    color: #fff;
    background-color: #2ba3ac;
    margin:10px;
}

</style>

<div class="padre">
<div class="hijo">
<h2><%=mensaje %></h2>

<!--  pueden usar esta lib para los estilos https://getbootstrap.com/docs/5.1/forms/overview/ copie el ejemplo del formulario
de aqui tome el ejemplo para centrar el formulario https://devcode.la/tutoriales/como-centrar-un-div-con-css/ -->

<form action="Usuarios" method="post" >
<fieldset>
	<legend>Datos del Usuario:</legend>
	
	<div  class="divformulario">
		<label class="labelformulario" >Cédula: </label>
		<input type="number" name="Cedula_usuario" value="<%=cedula%>" required <%=estado%>>
	</div>
	
	<input type="hidden" name="Cedula_usuario" value="<%=cedula%>">
	
	<div class="divformulario">
		<label class="labelformulario">Correo Electronico: </label>
		<input   type="text" name="Email_usuario" value="<%=email_usuario%>" required>
	</div>
	
	<div class="divformulario" >
		<label class="labelformulario">Nombre Completo: </label>
		<input  type="text" name="Nombre_usuario" value="<%=nombre_usuario%>" required>
	</div>
	
	<div  class="divformulario">
		<label class="labelformulario">Contraseña: </label>
		<input  type="text" name="Password" value="<%=password%>" required>
	</div>
	
	<div class="divformulario">
		<label class="labelformulario">Usuario: </label>
		<input type="text" name="Usuario" value="<%=usuario%>" required>
	</div>
	
	<div  class="divformulario">
		<input class="botonformulario" type="submit" name="registrar" value="registrar" >
		<input class="botonformulario" type="submit" name="actualizar" value="actualizar" >
		<input class="botonformulario" type="submit" name="eliminar" value="eliminar" > 
	</div>
	
</fieldset>
</form>
<form action="Usuarios" method="post">
   <fieldset>
      <legend>Consultar</legend>
      <div class="divformulario">
      <label class="labelformulario">Cedula: </label>
      <input  type="text" name="Cedula_usuario" required></div>
      <div ><input class="botonformulario" type="submit" name="consultar" value="consultar" ></div>
   </fieldset>
</form>

</div>
</div>
</body>
</html>