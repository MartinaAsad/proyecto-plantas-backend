/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.martina.plantas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "paises")

public class Paises implements Serializable {

    @Size(max = 100)
    @Column(name = "nombrePais")
    private String nombrePais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<Planta> plantaCollection;

    public Paises() {
    }

    public Paises(String nombrePais, String imagen, Integer id, Collection<Planta> plantaCollection) {
        this.nombrePais = nombrePais;
        this.imagen = imagen;
        this.id = id;
        this.plantaCollection = plantaCollection;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Planta> getPlantaCollection() {
        return plantaCollection;
    }

    public void setPlantaCollection(Collection<Planta> plantaCollection) {
        this.plantaCollection = plantaCollection;
    }
    
    
}
    
    
    

