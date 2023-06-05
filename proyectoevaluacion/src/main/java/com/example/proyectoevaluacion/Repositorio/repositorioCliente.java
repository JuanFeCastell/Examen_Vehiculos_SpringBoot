package com.example.proyectoevaluacion.Repositorio;

import com.example.proyectoevaluacion.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface repositorioCliente extends JpaRepository<Cliente, String> {

    ArrayList<Cliente> findByTelefono(String telefono);


}
