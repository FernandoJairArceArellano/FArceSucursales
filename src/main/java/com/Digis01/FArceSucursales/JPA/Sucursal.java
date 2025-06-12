package com.Digis01.FArceSucursales.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSucursal")
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    @Temporal(TemporalType.TIME)
    private Date horarioApertura;
    @Temporal(TemporalType.TIME)
    private Date horarioCierre;
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "EmpresaId")
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(Date horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public Date getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(Date horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
