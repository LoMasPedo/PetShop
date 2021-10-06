
$(document).ready(function(){

	function listarVentas(){
	
	$.ajax({
	type:"post",
	url:"ReportesVentas",
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

listarVentas();
/*$('.listaVentas').on('click',function(){
	listarVentas();
});*/

})