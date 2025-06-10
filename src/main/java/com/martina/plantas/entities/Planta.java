/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.martina.plantas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "planta")
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanta")
    private Integer idPlanta;
    @Size(max = 40)
    @Column(name = "nombrePlanta")
    private String nombrePlanta;
    @Column(name = "cantLecturas")
    private Integer cantLecturas;
    @Column(name = "alertasMedidas")
    private Integer alertasMedidas;
    @Column(name = "alertasRojas")
    private Integer alertasRojas;
    @Column(name = "sensoresDeshab")
    private Integer sensoresDeshab;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @JoinColumn(name = "pais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paises pais;

    public Planta() {
    }

    public Planta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public Integer getCantLecturas() {
        return cantLecturas;
    }

    public void setCantLecturas(Integer cantLecturas) {
        this.cantLecturas = cantLecturas;
    }

    public Integer getAlertasMedidas() {
        return alertasMedidas;
    }

    public void setAlertasMedidas(Integer alertasMedidas) {
        this.alertasMedidas = alertasMedidas;
    }

    public Integer getAlertasRojas() {
        return alertasRojas;
    }

    public void setAlertasRojas(Integer alertasRojas) {
        this.alertasRojas = alertasRojas;
    }

    public Integer getSensoresDeshab() {
        return sensoresDeshab;
    }

    public void setSensoresDeshab(Integer sensoresDeshab) {
        this.sensoresDeshab = sensoresDeshab;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
}
