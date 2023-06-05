package com.example.proyectoevaluacion.Repositorio;

import com.example.proyectoevaluacion.Entidad.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface repositorioVehiculo extends JpaRepository<Vehiculo, String> {

    ArrayList<Vehiculo> findByMarca(String marca);

     Optional<Vehiculo> findByCodigoVeh(String codigoVeh);

}
