package com.example.proyectoevaluacion.Repositorio;

import com.example.proyectoevaluacion.Entidad.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface repositorioVentas extends JpaRepository<Ventas,Integer> {

    @Query(value=" select ven.codigo_ven, ven.fecha, cli.documento, cli.nombre, veh.codigo_veh, veh.modelo from ventas as ven inner join cliente as cli on ven.documento = cli.documento inner join vehiculo as veh on ven.codigo_veh = veh.codigo_veh", nativeQuery = true)
    List<Object[]> findDatosVentas();

   //Optional<Ventas> findByIdVentas(Integer codigoVen);

}
