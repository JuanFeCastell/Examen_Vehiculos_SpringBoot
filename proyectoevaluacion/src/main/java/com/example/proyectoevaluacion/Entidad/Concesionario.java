package com.example.proyectoevaluacion.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "concesionario")
public class Concesionario {

    @Id
    @Column(length = 30)
    private String nit;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50, unique = true)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String direccion;



    //RELACIONES
    @OneToMany(mappedBy = "concesionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehiculo> vehiculo;

    public Concesionario(){

    }

    public Concesionario(String nit, String nombre, String telefono, String direccion) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Set<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }
}
