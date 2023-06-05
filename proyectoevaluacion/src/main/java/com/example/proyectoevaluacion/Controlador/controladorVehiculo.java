package com.example.proyectoevaluacion.Controlador;

import com.example.proyectoevaluacion.Entidad.Vehiculo;
import com.example.proyectoevaluacion.Entidad.Ventas;
import com.example.proyectoevaluacion.Servicio.servicioVehiculo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class controladorVehiculo {

    private servicioVehiculo servicio;

    private controladorVehiculo(servicioVehiculo servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarVehiculos")
    public ArrayList<Vehiculo> listarVehi(){
        return servicio.listarVehiculo();
    }

    @GetMapping("/buscarVehiculo/{codigoVeh}")
    public Vehiculo buscarVehiculo(@PathVariable("codigoVeh") String codigoVeh){
        return servicio.buscarVehiculo(codigoVeh);
    }

    @GetMapping("/buscarMarca/{marca}")
    public ArrayList<Vehiculo> buscarMarca(@PathVariable("marca") String m){
        return servicio.buscarMarca(m);
    }

    @PostMapping("/agregarMarca")
    public String agregarMarca(@RequestBody Vehiculo vehiculo){
        return servicio.agregarVehiculo(vehiculo);
    }

    @PutMapping("/actualizarVehiculo")
    public String actualizarVehiculo(@RequestBody Vehiculo vehiculo){return servicio.actualizarVehiculo(vehiculo);
    }

    @DeleteMapping("/eliminarVehiculo/{codigoVeh}")
    public String eliminarVehiculo(@PathVariable("codigoVeh") String codigoVeh){
        return servicio.eliminarVehiculo(codigoVeh);
    }

}
