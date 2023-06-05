package com.example.proyectoevaluacion.Controlador;

import com.example.proyectoevaluacion.Entidad.Cliente;
import com.example.proyectoevaluacion.Servicio.servicioCliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class controladorCliente {
    private servicioCliente servicio;

    public controladorCliente(servicioCliente servicio){
        this.servicio = servicio;
    }
    @GetMapping("/listarCliente")
    public ArrayList<Cliente> listarClientes(){return servicio.listarClientes();
    }

    @GetMapping("/buscarCliente/{doc}")
    public Cliente bucarCliente(@PathVariable("doc") String documento){return servicio.buscarCliente(documento);
    }

    @GetMapping("/buscarTelefono/{telefono}")
    public ArrayList<Cliente> buscarTelefono(@PathVariable("telefono") String t){return servicio.buscarTelefono(t);}

    //@PostMapping("/agregarCliente")
    //public String agregarCliente(@RequestBody Cliente cliente){
    //    return servicio.agregarCliente(cliente);
    //}

    @PostMapping("/agregarCliente/{documento}") //Ej: http://localhost:8080/agregarCotizacion/usu4/pro4?cantSolicitada=2&idMoneda=USD
    public String agregarCliente(@PathVariable("documento")  @RequestBody Cliente cliente) {
        return servicio.agregarCliente(cliente);
    }

    @PutMapping("/actualizarCliente")
    public String actualizarCliente(@RequestBody Cliente cliente){
        return servicio.actualizarCliente(cliente);
    }

    @DeleteMapping("/eliminarCliente/{doc}")
    public String eliminarCliente(@PathVariable("doc") String documento){
        return servicio.eliminarCliente(documento);
    }
}
