package com.example.proyectoevaluacion.Repositorio;

import com.example.proyectoevaluacion.Entidad.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface repositorioConcesionario extends JpaRepository<Concesionario, String> {
    ArrayList<Concesionario> findByDireccion(String direccion);
}
