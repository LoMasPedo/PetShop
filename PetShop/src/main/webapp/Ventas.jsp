<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>
<link rel="stylesheet" href="css/Ventas.css">
</head>
<body>

<jsp:include page="Header.jsp" />

<h1>Modulo Ventas</h1>

<%!
String mensaje="";
float canT1,canT2,canT3;
float vlrT1,vlrT2,vlrT3,totalVenta,totalIva,totalConIva,vlrU1,vlrU2,vlrU3;
long cedulaCliente = 0, cedulaUsuario=0, codigoProducto1,codigoProducto2,codigoProducto3;
String NombreProducto1, NombreProducto2, NombreProducto3;
String estado="enabled",nombreCliente,nombreUsuario,conSec;
%>

<%

if(request.getParameter("cedula_cliente")!=null)
{
	cedulaCliente=Long.parseLong(request.getParameter("cedula_cliente"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("cedula_usuario")!=null)
{
	cedulaUsuario=Long.parseLong(request.getParameter("cedula_usuario"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("nombre_cliente")!=null)
{
	nombreCliente=request.getParameter("nombre_cliente");
	mensaje="";
	estado="enabled";
}

if(request.getParameter("nombre_usuario")!=null)
{
	nombreUsuario=request.getParameter("nombre_usuario");
	mensaje="";
	estado="enabled";
}


if(request.getParameter("consec")!=null)
{
	conSec=request.getParameter("consec");
	mensaje="";
	estado="enabled";
}



if(request.getParameter("nomP1")!=null)
{
	NombreProducto1=request.getParameter("nomP1");
	mensaje="";
	estado="enabled";
}

if(request.getParameter("codP1")!=null)
{
	codigoProducto1=Long.parseLong(request.getParameter("codP1"));
	mensaje="";
	estado="enabled";
}



if(request.getParameter("vlrt1")!=null)
{
	vlrT1=Float.parseFloat(request.getParameter("vlrt1"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("vlru1")!=null)
{
	vlrU1=Float.parseFloat(request.getParameter("vlru1"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("nomP2")!=null)
{
	NombreProducto2=request.getParameter("nomP2");
	mensaje="";
	estado="enabled";
}
if(request.getParameter("codP2")!=null)
{
	codigoProducto2=Long.parseLong(request.getParameter("codP2"));
	mensaje="";
	estado="enabled";
}


if(request.getParameter("vlrt2")!=null)
{
	vlrT2=Float.parseFloat(request.getParameter("vlrt2"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("vlru2")!=null)
{
	vlrU2=Float.parseFloat(request.getParameter("vlru2"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("nomP3")!=null)
{
	NombreProducto3=request.getParameter("nomP3");
	mensaje="";
	estado="enabled";
}

if(request.getParameter("codP3")!=null)
{
	codigoProducto3=Long.parseLong(request.getParameter("codP3"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("vlrt3")!=null)
{
	vlrT3=Float.parseFloat(request.getParameter("vlrt3"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("vlru3")!=null)
{
	vlrU3=Float.parseFloat(request.getParameter("vlru3"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("men")!=null)
{
	cedulaCliente=0;
	mensaje=request.getParameter("men");
	estado="enabled";
}

if(request.getParameter("men")!=null)
{
	cedulaUsuario=0;
	mensaje=request.getParameter("men");
	estado="enabled";
}


if(request.getParameter("totalventa")!=null)
{
	totalVenta=Float.parseFloat(request.getParameter("totalventa"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("totaliva")!=null)
{
	totalIva=Float.parseFloat(request.getParameter("totaliva"));
	mensaje="";
	estado="enabled";
}


if(request.getParameter("totalconiva")!=null)
{
	totalConIva=Float.parseFloat(request.getParameter("totalconiva"));
	mensaje="";
	estado="enabled";
}


if(request.getParameter("cantidadp1")!=null)
{
	canT1=Float.parseFloat(request.getParameter("cantidadp1"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("cantidadp2")!=null)
{
	canT2=Float.parseFloat(request.getParameter("cantidadp2"));
	mensaje="";
	estado="enabled";
}

if(request.getParameter("cantidadp3")!=null)
{
	canT3=Float.parseFloat(request.getParameter("cantidadp3"));
	mensaje="";
	estado="enabled";
}



%>

<div class="padre">
	<div class="hijo">
	
	<h2> <%=mensaje %> </h2>
	
	<!--  pueden usar esta lib para los estilos https://getbootstrap.com/docs/5.1/forms/overview/ copie el ejemplo del formulario
	de aqui tome el ejemplo para centrar el formulario https://devcode.la/tutoriales/como-centrar-un-div-con-css/ -->
		<form action="Ventas" method="post" >
			<fieldset>
			
		<table class="no-bordes">
		   <tr>
		      
		      
		      <th>
		         <label class="labelformulario" >Cedula Usuario: </label>
		      </th>
		      <th>
		         <input type="number" name="cedula_usuario" value="<%=cedulaUsuario%>" required <%=estado%>>
		      </th>
		      <th>
		         <input class="botonformulario" type="submit" name="consultar_usuario" value="Consultar Usuario" >
		      </th>
		      <th>
		         <label class="labelformulario">Usuario: </label>
		      </th>
		      <th>
		         <input   type="text" name="nombre_usuario" value="<%=nombreUsuario%>" required>
		      </th>
		      <th>
		         <label class="labelformulario">Consec: </label>
		      </th>
		      <th>
		         <input  type="text" name="consec" value="<%=conSec%>" required>
		      </th>
			</tr>
		    <tr>
		      <th>
		         <label class="labelformulario" >Cedula Cliente: </label>
		      </th>
		      <th>
		         <input type="number" name="cedula_cliente" value="<%=cedulaCliente%>" required <%=estado%>>
		      </th>
		      <th>
		         <input class="botonformulario" type="submit" name="consultar_cliente" value="Consultar Cliente" >
		      </th>
		      <th>
		         <label class="labelformulario">Cliente: </label>
		      </th>
		      <th>
		         <input   type="text" name="nombre_cliente" value="<%=nombreCliente%>" required>
		      </th>
		      
		      
		   </tr>
		</table>
		
		<br/>
		

		
		
		<br/>
		<table class="no-bordes productos-tabla">
		<tr>
			<th>Cod. producto<th>
			<th><th>
			<th>Nombre Producto<th>
			<th class="cantidad">Cant.<th>
			<th>Vlr. Unitario.<th>
			<th>Vlr. Total.<th>
		</tr>
		<tr>
			<th>
				<input type="number" name="codP1" value="<%=codigoProducto1%>" required>
			<th>
			<th>
				<input class="botonformulario" type="submit" name="consultar_p1" value="Consultar" >
			<th>
			<th>
				<input type="text" name="nomP1" value="<%=NombreProducto1%>" required>
			<th>
			<th class="cantidad">
				<input type="number" name="cantidadp1" value="<%=canT1%>" required>
			<th>
			<th>
				<input type="number" name="vlru1" value="<%=vlrU1%>" required>
			<th>
			<th>
				<input type="number" name="vlrt1" value="<%=vlrT1%>" required>
			<th>
			
		</tr>
		<tr>
			<th>
				<input type="number" name="codP2" value="<%=codigoProducto2%>" required>
			<th>
			<th>
				<input class="botonformulario" type="submit" name="consultar_p2" value="Consultar" >
			<th>
			<th>
				<input type="text" name="nomP2" value="<%=NombreProducto2%>" required>
			<th>
			<th class="cantidad">
				<input type="number" name="cantidadp2" value="<%=canT2%>" required>
			<th>
			<th>
				<input type="number" name="vlru2" value="<%=vlrU2%>" required>
			<th>
			<th>
				<input type="number" name="vlrt2" value="<%=vlrT2%>" required>
			<th>
			
		</tr>
		<tr>
			<th>
				<input type="number" name="codP3" value="<%=codigoProducto3%>" required>
			<th>
			<th>
				<input class="botonformulario" type="submit" name="consultar_p3" value="Consultar" >
			<th>
			<th>
				<input type="text" name="nomP3" value="<%=NombreProducto3%>" required>
			<th>
			<th class="cantidad">
				<input type="number" name="cantidadp3" value="<%=canT3%>" required>
			<th>
			<th>
				<input type="number" name="vlru3" value="<%=vlrU3%>" required>
			<th>
			<th>
				<input type="number" name="vlrt3" value="<%=vlrT3%>" required>
			<th>
			
		</tr>
		
		
		</table>
		
	<div class="contiene-cierre-tabla">
	<table class="no-bordes cierre-tabla">
		<tr>
			<th></th>
			<th>Total Venta</th>
			<th>	
				<input type="number" name="totalventa" value="<%=totalVenta%>" required>
		    </th>
		</tr>
		<tr>
			<th></th>
			<th>Total IVA</th>
			<th>
				<input type="number" name="totaliva" value="<%=totalIva%>" required>
			</th>
		</tr>
		<tr>
			<th></th>
			<th> Total Con Iva</th>
			<th>
				<input type="number" name="totalconiva" value="<%=totalConIva%>" required> 
			</th>
		</tr>
		
			<th><input class="botonformulario" type="submit" name="calcular" value="Calcular" > </th>
			<th><input class="botonformulario" type="submit" name="confirmar" value="Confirmar" > </th>
	</table>
	</div>
	

			</fieldset>
		</form>
	</div>
</div>


</body>
</html>