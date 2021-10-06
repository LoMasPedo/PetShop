
$(document).ready(function(){

	function listarClientes(){
	
	$.ajax({
	type:"post",
	url:"ReportesClientes",
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

})