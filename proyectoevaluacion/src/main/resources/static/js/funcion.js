$(document).ready(function() {
  const clienteListados = document.querySelector(".clienteListados");
  // usuariosListados.innerHTML="<option value='1'>|-Nombre--Email-|</option>"

  $.ajax({
    url: "http://localhost:8080/listarCliente",
    type: "GET",
    datatype: "JSON",
    success: function(response) {
      Object.values(response).forEach(cliente => {
        clienteListados.innerHTML +=
          '<option value="' +
          cliente["documento"] +
          '">' +
          cliente["direccion"] +
          " -- "    +
          cliente["nombre"] +
          " -- "    +
          cliente["telefono"] +
          "</option>";
      });
    }
  });

  const seleccionVeh = document.querySelector(".seleccionVeh");
  // seleccionPro.innerHTML="<option value='1'>|-Nombre--Precio-|</option>"

  $.ajax({
    url: "http://localhost:8080/listarVehiculos",
    type: "GET",
    datatype: "JSON",
    success: function(response) {
      Object.values(response).forEach(vehiculo => {
        seleccionVeh.innerHTML +=
          '<option value=" ' +
          vehiculo["codigoVeh"] +
          ' ">' +
          vehiculo["marca"] +
          " -- " +
          vehiculo["precio"] +
           " -- $" +
          vehiculo["nit"] +
          "</option>";
      });
    }
  });

  const selectVen = document.querySelector(".selectVen");
  // seleccionCot.innerHTML="<option value='1'>|-Fecha--USUARIO(FK)-PRODUCTO(FK)-|</option>"

  $.ajax({
    url: "http://localhost:8080/detallesVentas",
    type: "GET",
    datatype: "JSON",
    success: function(response) {
      Object.values(response).forEach(ventas => {
        selectVen.innerHTML +=
          '<option value=" ' +
          ventas["codigo_ven"] +
          ' ">' +
          ventas["fecha"] +
          " -- " +
          ventas["documento"] +
          " -- " +
          ventas["nombre"] +
          " -- " +
          ventas["codigo_veh"] +
          " -- " +
          ventas["modelo"] +
          "</option>";
      });
    }
  });


  // Buscar VENTA por ID
  $(".buscarForm").submit(function(event) {
    event.preventDefault();

    var codigoVen = $(".codigoVen").val();

    $.ajax({
      type: "GET",
      url: "http://localhost:8080/buscarVentas/" + codigoVen,
      success: function(response) {
        if (response != null) {
          // La cotización se encontró, puedes procesar los datos de la cotización aquí
          var ventasHTML = '<tr>' +
            '<td>' + response.codigoVen + '</td>' +

            '</tr>';

          $(".resultadoVentas tbody").html(ventasHTML);
        } else {
          alert("No se encontró la venta con el codigo escrito");
        }
      },
      error: function(error) {
        alert("Error al buscar la venta: " + error.responseText);
      }
    });
  });



  // Agregar Ventas
  $(".agregarForm").submit(function(event) {
    event.preventDefault();

    var documento = $(".documento").val();
    var codigoVeh = $(".codigoVeh").val();



    $.ajax({
      type: "POST",
      url: "http://localhost:8080/agregarVentas/" + documento + "/" + codigoVeh,
      success: function(response) {
        alert(response);
      },
      error: function(error) {
        alert("Error al agregar la venta: " + error.responseText);
      }
    });
  });


  // Agregar Cotización
  //$(".agregarForm").submit(function(event) {
  //  event.preventDefault();
//
  //  var idUsuario = $(".idUsuario").val();
  //  var codigoProducto = $(".codigoProducto").val();
  //  var cantSolicitada = $(".cantSolicitada").val();
  //  var idMoneda = $(".idMoneda").val();
//
  //  var data = {
  //    idUsuario: idUsuario,
  //    codigoProducto: codigoProducto,
  //    cantSolicitada: cantSolicitada,
  //    idMoneda: idMoneda
  //  };
//
  //  $.ajax({
  //    type: "POST",
  //    url: "http://localhost:8080/agregarCotizacion/"+idUsuario+"/"+codigoProducto+"?cantSolicitada="+cantSolicitada+"&idMoneda="+idMoneda,
  //    data: data,
  //    success: function(response) {
  //      alert(response);
  //    },
  //    error: function(error) {
  //      alert("Error al agregar la cotización: " + error.responseText);
  //    }
  //  });
  //});

  // Actualizar Cotización
  $(".actualizarForm").submit(function(event) {
    event.preventDefault();

    var idCotizacion = $(".idCotizacion").val();
    var cantSolicitada = $(".nuevaCantSolicitada").val();
    var idMoneda = $(".nuevoIdMoneda").val();

    var data = {
      cantSolicitada: cantSolicitada,
      idMoneda: idMoneda
    };

    $.ajax({
      type: "PUT",
      url: "http://localhost:8080/actualizarCotizacion/" + idCotizacion,
      data: JSON.stringify(data),
      contentType: "application/json",
      success: function(response) {
        alert("Cotización actualizada exitosamente.");
      },
      error: function(error) {
        alert("Error al actualizar la cotización: " + error.responseText);
      }
    });
  });

  // Eliminar Cotización
  $(".eliminarForm").submit(function(event) {
    event.preventDefault();

    var codigoVen = $(".eliminarcodigoVen").val();

    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/eliminarVentas/" + codigoVen,
      success: function(response) {
        if (response) {
          alert("Cotización eliminada exitosamente.");
        } else {
          alert("No se encontró la cotización con la ID especificada.");
        }
      },
      error: function(error) {
        alert("Error al eliminar la venta: " + error.responseText);
      }
    });
  });

});
