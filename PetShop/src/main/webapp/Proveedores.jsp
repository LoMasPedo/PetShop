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
%>
<%
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
font-style: #2ba3ac
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
<form action="Proveedores" method="post" >
<fieldset>
	<legend>Datos Proveedor:</legend>
	<div  class="divformulario">
		<label class="labelformulario" >NIT: </label>
		<input type="number" name="Nit_Proveedor" value="<%=nit_proveedor%>" required <%=estado%>></div>
		<input type="hidden" name="Nit_Proveedor" value="<%=nit_proveedor%>">
	<div class="divformulario">
		<label class="labelformulario">Nombre Proveedor: </label>
		<input   type="text" name="Ciudad_Proveedor" value="<%=nombre_proveedor%>" required placeholder="nombre_proveedor">
	</div>
	<div class="divformulario" >
		<label class="labelformulario">Direccion: </label>
		<input  type="text" name="Direccion_Proveedor" value="<%=direccion_proveedor%>" required>
	</div>
	<div  class="divformulario">
		<label class="labelformulario">Telefono: </label>
		<input  type="text" name="Nombre_Proveedor" value="<%=telefono_proveedor%>" required>
	</div>
	<div class="divformulario">
		<label class="labelformulario">Ciudad: </label>
		<input type="number" name="Telefono_Proveedor" value="<%=ciudad_proveedor%>" required>
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
      <input  type="text" name="Nit_Proveedor" required></div>
      <div ><input class="botonformulario" type="submit" name="consultar" value="consultar" ></div>
   </fieldset>
</form>

</div>
</div>


</body>
</html>