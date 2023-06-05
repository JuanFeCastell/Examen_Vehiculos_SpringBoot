package com.example.proyectoevaluacion.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(length = 30)
    private String documento;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50, unique = true)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String direccion;

    //RELACIONES
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ventas> ventas;


    public Cliente(){

    }

    public Cliente(String documento, String nombre, String telefono, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Set<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Ventas> ventas) {
        this.ventas = ventas;
    }
}
