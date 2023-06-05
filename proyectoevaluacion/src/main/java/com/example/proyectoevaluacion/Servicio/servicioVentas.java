package com.example.proyectoevaluacion.Servicio;

import com.example.proyectoevaluacion.Entidad.Cliente;
import com.example.proyectoevaluacion.Entidad.Vehiculo;
import com.example.proyectoevaluacion.Entidad.Ventas;
import com.example.proyectoevaluacion.Repositorio.repositorioCliente;
import com.example.proyectoevaluacion.Repositorio.repositorioVehiculo;
import com.example.proyectoevaluacion.Repositorio.repositorioVentas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servicioVentas {

    private repositorioVentas repositorio;
    private repositorioCliente ClienteRepo;
    private repositorioVehiculo VehiculoRepo;


    public servicioVentas(repositorioVentas repositorio, repositorioCliente clienteRepo, repositorioVehiculo vehiculoRepo){
        this.repositorio = repositorio;
        ClienteRepo = clienteRepo;
        VehiculoRepo = vehiculoRepo;
    }

    public List<Ventas> listarVentas() {
        return repositorio.findAll();
    }

    //public String agregarVentas(String doc, String codigoVeh) {
    //    Ventas v = new Ventas();
    //    if (ClienteRepo.findById(doc).isPresent() && VehiculoRepo.findById(codigoVeh).isPresent()) {
    //        Cliente cli = ClienteRepo.findById(doc).get();
    //        Vehiculo veh = VehiculoRepo.findById(codigoVeh).get();
    //        v.setCliente(cli);
    //        v.setVehiculo(veh);
    //        repositorio.save(v);
    //        return  "Venta Registrada";
    //    } else{
    //        return "La venta no se registro";
    //    }
    //}


    //AGREGAR VENTAS
    public String agregarVentas(String documento, String codigoVeh) {
        Optional<Cliente> clienteOptional = ClienteRepo.findById(documento);
        Optional<Vehiculo> vehiculoOptional = VehiculoRepo.findById(codigoVeh);

        if (clienteOptional.isPresent() && vehiculoOptional.isPresent()) {
            Cliente cliente  = clienteOptional.get();
            Vehiculo vehiculo = vehiculoOptional.get();

            Ventas ventas = new Ventas(cliente, vehiculo);
            repositorio.save(ventas);
            return "Venta registrada exitosamente.";
        } else {
            return "ERROR AL REGISTRAR VENTA. Usuario o producto no encontrado.";
        }
    }


    //ACTUALIZAR VENTAS
    public Ventas actualizarVentas(Ventas ventas) {
        // verificar si la cotizacion existe en la base de datos
        Optional<Ventas> ventasExistente = repositorio.findById(ventas.getCodigoVen());

        if (ventasExistente.isPresent()) {
            // actualizar los datos de la venta existente
            Ventas ventasActualizada = ventasExistente.get();
            ventasActualizada.setCliente(ventas.getCliente());
            ventasActualizada.setVehiculo(ventas.getVehiculo());
            // guardar la venta actualizada en la base de datos
            return repositorio.save(ventasActualizada);
        } else {
            throw new RuntimeException("La venta no existe.");
        }
    }

    public String eliminarVentas(String codigoVen) {
        if (repositorio.existsById(Integer.valueOf(codigoVen))) {
            repositorio.deleteById(Integer.valueOf(codigoVen));
            return "Venta eliminada exitosamente.";
        } else {
            return "La venta no se encuentra registrada.";
        }
    }

    public Ventas buscarVentas(String codigoVen) {
        return repositorio.findById(Integer.valueOf(codigoVen)).orElse(null);
    }

    public List<Object[]> datosventas(){
        return repositorio.findDatosVentas();
    }
}
