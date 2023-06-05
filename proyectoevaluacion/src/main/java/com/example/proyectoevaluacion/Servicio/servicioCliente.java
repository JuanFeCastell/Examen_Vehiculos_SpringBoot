package com.example.proyectoevaluacion.Servicio;

import com.example.proyectoevaluacion.Entidad.Cliente;
import com.example.proyectoevaluacion.Entidad.Vehiculo;
import com.example.proyectoevaluacion.Entidad.Ventas;
import com.example.proyectoevaluacion.Repositorio.repositorioCliente;
import com.example.proyectoevaluacion.Repositorio.repositorioVehiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class servicioCliente {

    private repositorioCliente repositorio;

    public servicioCliente(repositorioCliente repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Cliente> listarClientes(){

        return (ArrayList<Cliente>) repositorio.findAll();
    }

    public Cliente buscarCliente(String doc){
        if (repositorio.findById(doc).isPresent())
            return repositorio.findById(doc).get();
        else
            return null;
    }

    public ArrayList<Cliente> buscarTelefono(String telefono){

        return repositorio.findByTelefono(telefono);
    }

    public String agregarCliente(Cliente cliente){
        if(repositorio.findById(cliente.getDocumento()).isPresent())
            return "El cliente ya se encuentra registrado";
        else
            repositorio.save(cliente);
        return "El cliente se registro exitosamente";
    }



    public String actualizarCliente(Cliente cliente){
        if (repositorio.findById(cliente.getDocumento()).isPresent()){
            repositorio.save(cliente);
            return "El cliente se ha actualizado";
        } else {
            return "El cliente no se encuentra registrado";
        }
    }

    //public String agregarCliente(String documento, String nombre, String telefono, String direccion) {
//
    //    if (repositorio.findById(cliente.getDocumento()).isPresent()) {
    //        Cliente cliente = new Cliente(documento, nombre, telefono, direccion);
    //        repositorio.save(cliente);
    //        return "Cotización registrada exitosamente.";
    //    } else {
    //        return "ERROR AL REGISTRAR COTIZACIÓN. Usuario o producto no encontrado.";
    //    }
    //}

    public String eliminarCliente(String doc){
        if(repositorio.findById(doc).isPresent()){
            repositorio.deleteById(doc);
            return "Cliente eliminado";
        } else{
            return "Cliente no se encuentra registrado";
        }
    }



}
