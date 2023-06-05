package com.example.proyectoevaluacion.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @Column(length = 30, unique = true)
    private String codigoVeh;


    @Column(length = 50, nullable = false)
    private String marca;


    @Column(length = 50, nullable = false)
    private String modelo;


    @Column(length = 50, nullable = false)
    private String precio;

    //RELACIONES
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ventas> ventas;




    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nit", referencedColumnName = "nit", nullable = false)
    @JsonIgnore
    private Concesionario concesionario;


    public Vehiculo(){

    }

    public Vehiculo(String codigoVeh, String marca, String modelo, String precio) {
        this.codigoVeh = codigoVeh;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getCodigoVeh() {
        return codigoVeh;
    }

    public void setCodigoVeh(String codigoVeh) {
        this.codigoVeh = codigoVeh;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Set<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Ventas> ventas) {
        this.ventas = ventas;
    }
}
