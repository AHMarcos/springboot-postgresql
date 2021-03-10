package com.marcosalarcon.backendapirest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    private static final long serialVersionUID = 1L;

}
