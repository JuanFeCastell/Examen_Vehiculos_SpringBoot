package com.example.proyectoevaluacion.Controlador;


import com.example.proyectoevaluacion.Entidad.Ventas;
import com.example.proyectoevaluacion.Servicio.servicioVentas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class controladorVentas {

   private servicioVentas servicio;

   public controladorVentas(servicioVentas servicio){
      this.servicio = servicio;
   }

   @GetMapping("/listarVentas")
   public List<Ventas> listarVentas(){
      return servicio.listarVentas();
   }

   //@PostMapping("/agregarPrestamo/{cli}/{veh}")
   //public String agregarPrestamo(@PathVariable String cli, String veh){return servicio.agregarVentas(cli,veh);
   //}

   @PostMapping("/agregarVentas/{documento}/{codigoVeh}") //Ej: http://localhost:8080/agregarCotizacion/usu4/pro4?cantSolicitada=2&idMoneda=USD
   public String agregarVentas(@PathVariable("documento") String documento, @PathVariable("codigoVeh") String codigoVeh) {
      return servicio.agregarVentas(documento, codigoVeh);
   }


   @PutMapping("/actualizarVentas/{codigoVen}") //EJ: http://localhost:8080/actualizarCotizacion/6
   //JSON Ej:
   // {
   //    "cantSolicitada": 12,
   //    "idMoneda": "USD"
   //}
   public ResponseEntity<Ventas> actualizarCotizacion(@PathVariable Integer codigoVen, @RequestBody Ventas ventas) {
      ventas.setCodigoVen(codigoVen);
      Ventas ventasActualizada = servicio.actualizarVentas(ventas);
      return ResponseEntity.ok(ventasActualizada);
   }

   @GetMapping("/detallesVentas")
   public List<Map<String, Object>> datosVentas(){
      List<Object[]> lista = servicio.datosventas();
      List<Map<String, Object>> json = new ArrayList<>();

      for(Object[] objects : lista) {
         Map<String, Object> datos = new LinkedHashMap<>();
         datos.put("codigo_ven", objects[0]);
         datos.put("fecha", objects[1]);
         datos.put("documento", objects[2]);
         datos.put("nombre", objects[3]);
         datos.put("codigo_veh", objects[4]);
         datos.put("modelo", objects[5]);
         json.add(datos);
      }

      for (Map<String, Object> j : json){
         System.out.println(j);
      }
      return json;
   }

   @DeleteMapping("/eliminarVentas/{codigoVen}") //EJ: http://localhost:8080/eliminarCotizacion/4
   public String eliminarVentas(@PathVariable("codigoVen") String codigoVen) {
      return servicio.eliminarVentas(codigoVen);
   }


   @GetMapping("/buscarVentas/{codigoVen}") //EJ: http://localhost:8080/buscarCotizaciones/1
   public Ventas buscarVentas(@PathVariable("codigoVen") String codigoVen) {
      return servicio.buscarVentas(codigoVen);
   }




}
