package com.example.proyectoevaluacion.Servicio;

import com.example.proyectoevaluacion.Entidad.Cliente;
import com.example.proyectoevaluacion.Entidad.Concesionario;
import com.example.proyectoevaluacion.Repositorio.repositorioCliente;
import com.example.proyectoevaluacion.Repositorio.repositorioConcesionario;

import java.util.ArrayList;

public class servicioConcesionario {
    private repositorioConcesionario repositorio;

    public servicioConcesionario(repositorioConcesionario repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Concesionario> listarConcesionario() {

        return (ArrayList<Concesionario>) repositorio.findAll();
    }

    public Concesionario buscarConcesionario(String nit) {
        if (repositorio.findById(nit).isPresent())
            return repositorio.findById(nit).get();
        else
            return null;
    }

    public ArrayList<Concesionario> buscarDireccion(String direccion) {

        return repositorio.findByDireccion(direccion);
    }

    public String agregarConcesionaro(Concesionario concesionario) {
        if (repositorio.findById(concesionario.getNit()).isPresent())
            return "El concesionario ya se encuentra registrado";
        else
            repositorio.save(concesionario);
        return "El cliente se registro exitosamente";
    }

    public String actualizarConcesionario(Concesionario concesionario) {
        if (repositorio.findById(concesionario.getNit()).isPresent()) {
            repositorio.save(concesionario);
            return "El concesionario se ha actualizado";
        } else {
            return "El concesionario no se encuentra registrado";
        }
    }

    public String eliminarConcesionario(String nit) {
        if (repositorio.findById(nit).isPresent()) {
            repositorio.deleteById(nit);
            return "Concensionario eliminado";
        } else {
            return "Concesionario no se encuentra registrado";
        }
    }
}
