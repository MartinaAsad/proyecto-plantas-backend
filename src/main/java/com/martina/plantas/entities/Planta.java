
package com.martina.plantas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "planta")
@Data
@NoArgsConstructor

public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idPlanta")
    private int idPlanta;
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
    @Id
    @Basic(optional = false)
    @Column(name = "Usuario_idUsuario")
    private Integer usuarioidUsuario;
    
}
