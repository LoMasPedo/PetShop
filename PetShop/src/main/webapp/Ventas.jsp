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

<h1>Modulo Ventas</h1>

<%!
String mensaje="";
int canT1,canT2,canT3;
float vlrT1,vlrT2,vlrT3,totalVenta,totalIva,totalConIva;
long cedulaCliente = 0, codigoProducto1,codigoProducto2,codigoProducto3;
String estado="enabled",nombreCliente,conSec;
%>

<%
if(request.getParameter("cedula_cliente")!=null)
{
	cedulaCliente=Long.parseLong(request.getParameter("cedula_cliente"));
	mensaje="";
	estado="disabled";
}
%>

<%
if(request.getParameter("men")!=null)
{
	cedulaCliente=0;
	mensaje=request.getParameter("men");
	estado="enabled";
}
%>

<div class="padre">
	<div class="hijo">
	
	<!-- <h2> <%=mensaje %> </h2>-->
	
	<!--  pueden usar esta lib para los estilos https://getbootstrap.com/docs/5.1/forms/overview/ copie el ejemplo del formulario
	de aqui tome el ejemplo para centrar el formulario https://devcode.la/tutoriales/como-centrar-un-div-con-css/ -->
		<form action="Ventas" method="post" >
			<fieldset>
				<div  class="divformulario">
					<label class="labelformulario" >Cedula: </label>
					<input type="number" name="cedula_cliente" value="<%=cedulaCliente%>" required <%=estado%>>
					<input class="botonformulario" type="submit" name="consultar_cliente" value="Consultar Cliente" >
				</div>
				<div class="divformulario">
					<label class="labelformulario">Cliente: </label>
					<input   type="text" name="nombre_cliente"" value="<%=nombreCliente%>" required>
				</div>
				<div class="divformulario" >
					<label class="labelformulario">Consec: </label>
					<input  type="text" name="consec" value="<%=conSec%>" required>
				</div>
				<div  class="divformulario">
					<label class="labelformulario">Nombre: </label>
					<input  type="text" name="nombre_cliente" value="<%=nombreCliente%>" required>
				</div>
				<div>
					<label class="labelformulario">Codigo del producto: </label>
					<label class="labelformulario">Nombre Producto: </label>
					<label class="labelformulario">Cant.: </label>
					<label class="labelformulario">Vlr. Total: </label>
				</div>
				<div class="divformulario">
					<input type="number" name="codP1" value="<%=codigoProducto1%>" required>
					<input class="botonformulario" type="submit" name="consultar_p1" value="Consultar" >
					<input type="number" name="cantidadp1" value="<%=canT1%>" required>
					<input type="number" name="vlrt1" value="<%=vlrT1%>" required>
				</div>
				<div class="divformulario">
					<input type="number" name="codP2" value="<%=codigoProducto2%>" required>
					<input class="botonformulario" type="submit" name="consultar_p2" value="Consultar" >
					<input type="number" name="cantidadp2" value="<%=canT2%>" required>
					<input type="number" name="vlrt2" value="<%=vlrT2%>" required>
				</div>
				<div class="divformulario">
					<input type="number" name="codP3" value="<%=codigoProducto3%>" required>
					<input class="botonformulario" type="submit" name="consultar_p3" value="Consultar" >
					<input type="number" name="cantidadp3" value="<%=canT3%>" required>
					<input type="number" name="vlrt3" value="<%=vlrT3%>" required>
				</div>
				<div class="divformulario">
					<label class="labelformulario">Total Venta: </label>
					<input type="number" name="totalventa" value="<%=totalVenta%>" required>
					<label class="labelformulario">Total IVA: </label>
					<input type="number" name="totaliva" value="<%=totalIva%>" required>
					<label class="labelformulario">Total con IVA: </label>
					<input type="number" name="totalconiva" value="<%=totalConIva%>" required>
				</div>
				<div  class="divformulario">
					<input class="botonformulario" type="submit" name="confirmas" value="Confirmar" >
				</div>
			</fieldset>
		</form>
	</div>
</div>


</body>
</html>