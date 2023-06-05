package com.example.proyectoevaluacion.Servicio;

import com.example.proyectoevaluacion.Entidad.Vehiculo;
import com.example.proyectoevaluacion.Repositorio.repositorioVehiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class servicioVehiculo {
    private repositorioVehiculo repositorio;

    public servicioVehiculo(repositorioVehiculo repositorio){
        this.repositorio = repositorio;
    }


    public ArrayList<Vehiculo> listarVehiculo(){

        return  (ArrayList<Vehiculo>) repositorio.findAll();
    }

    public Vehiculo buscarVehiculo(String codigoVeh){
        if(repositorio.findById(codigoVeh).isPresent())
            return repositorio.findById(codigoVeh).get();
        else
            return null;
    }

    public ArrayList<Vehiculo> buscarMarca(String marca){

        return repositorio.findByMarca(marca);
    }

    public String agregarVehiculo(Vehiculo vehiculo){
        if(repositorio.findById(vehiculo.getCodigoVeh()).isPresent())
            return "El vehiculo ya se encuentra registrado";
        else return "El vehiculo se resgistro exitosamente";
    }

    public String actualizarVehiculo(Vehiculo vehiculo){
        if(repositorio.findById(vehiculo.getCodigoVeh()).isPresent()){
            repositorio.save(vehiculo);
            return "El vehiculo se ha actualizado";
        } else{
            return "El vehiculo no se encuentra registrado";
        }
    }


    public String eliminarVehiculo(String codigoVeh){
        if (repositorio.findById(codigoVeh).isPresent()){
            repositorio.deleteById(codigoVeh);
            return "Vehiculo eliminado";
        }
        else {
            return "El vehiculo no se encuentra registrado";
        }
    }
}
