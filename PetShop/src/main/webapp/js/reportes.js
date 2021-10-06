
$(document).ready(function(){

	function listarClientes(){
	
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Clientes"},
	success:function(result){
		console.log(result)
		var tabla=document.querySelector("#tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th class='th1'>Cedula</th>
		<th class='th1'>Nombre</th>
		<th class='th1'>Correo Electronico</th>
		<th class='th1'>Direccion</th>
		<th class='th1'>Telefono</th>
		</tr>`
		for(let clien of result){
		tabla.innerHTML+=`<tr>
		<td class='td1'>${clien.cedula_cliente}</td>
		<td class='td1'>${clien.nombre_cliente}</td>
		<td class='td1'>${clien.email_cliente}</td>
		<td class='td1'>${clien.direccion_cliente}</td>
		<td class='td1'>${clien.telefono_cliente}</td>
		</tr>`
		}
		}
		});	
	}

$('.listaClientes').on('click',function(){
	listarClientes()
});
//////////////////////////////////////////////////////////

	function listarVentas(){
	
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Ventas"},
	success:function(result){
		console.log(result);
		var totalventa=0;
		var tabla=document.querySelector("#tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th class='th1'>Cedula</th>
		<th class='th1'>Nombre</th>
		<th class='th1'>Valor Total</th>
		</tr>`
		for(let venta of result){
		 totalventa+=venta.valor_venta;
		
			tabla.innerHTML+=`<tr>
			<td class='td1'>${venta.cedula_cliente}</td>
			<td class='td1'>${venta.nombre_cliente}</td>
			<td class='td1'>${venta.valor_venta}</td>
			</tr>`
		}
		
		tabla.innerHTML+=`<tr>
			<td class='td1'></td>
			<td class='td1 reporteVentasTotal'>Total Ventas $</td>
			<td class='td1 reporteventalTotalValor'>${totalventa}</td>
			</tr>`
		
		
		}
		});	
	}


$('.listaVentas').on('click',function(){
	listarVentas();
});

///////////////////////

function listarUsuarios(){
	
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Usuarios"},
	success:function(result){
		console.log(result)
		var tabla=document.querySelector("#tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th class='th1'>pendiente...</th>
		</tr>`
		}
		});	
	}


$('.listaUsuarios').on('click',function(){
	listarUsuarios();
});

})