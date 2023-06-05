package com.example.proyectoevaluacion.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name= "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 30)
    private Integer codigoVen;

    @Column(name = "fecha")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

//Atributos con el que relaciona

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false)
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigoVeh", referencedColumnName = "codigoVeh", nullable = false)
    @JsonIgnore
    private Vehiculo vehiculo;


    public Ventas(){

    }

    public Ventas(Integer codigoVen, LocalDate fecha, Cliente cliente, Vehiculo vehiculo) {
        this.codigoVen = codigoVen;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }


    public Ventas(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }
    
    public Integer getCodigoVen() {
        return codigoVen;
    }

    public void setCodigoVen(Integer codigoVen) {
        this.codigoVen = codigoVen;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
