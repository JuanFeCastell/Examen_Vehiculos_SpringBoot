package com.example.proyectoevaluacion.Controlador;

import com.example.proyectoevaluacion.Entidad.Cliente;
import com.example.proyectoevaluacion.Entidad.Concesionario;
import com.example.proyectoevaluacion.Servicio.servicioCliente;
import com.example.proyectoevaluacion.Servicio.servicioConcesionario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class controladorConcesionario {

    private servicioConcesionario servicio;

    public controladorConcesionario(servicioConcesionario servicio){
        this.servicio = servicio;
    }
    @GetMapping("/listarConcesionario")
    public ArrayList<Concesionario> listarCon(){return servicio.listarConcesionario();
    }

    @GetMapping("/buscarConcesionario/{nit}")
    public Concesionario bucarConcesionario(@PathVariable("nit") String nit){return servicio.buscarConcesionario(nit);
    }

    @GetMapping("/buscarTelefono/{Direccion}")
    public ArrayList<Concesionario> buscarDireccion(@PathVariable("direccion") String d){return servicio.buscarDireccion(d);}

    @PostMapping("/agregarConcesionario")
    public String agregarConcesionario(@RequestBody Concesionario concesionario){
        return servicio.agregarConcesionaro(concesionario);
    }

    @PutMapping("/actualizarConcesionario")
    public String actualizarConcesionario(@RequestBody Concesionario concesionario){
        return servicio.actualizarConcesionario(concesionario);
    }

    @DeleteMapping("/eliminarConcesionario/{nir}")
    public String eliminarConcesionario(@PathVariable("nit") String nit){
        return servicio.eliminarConcesionario(nit);
    }
}
