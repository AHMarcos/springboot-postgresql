package com.marcosalarcon.backendapirest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;


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
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private LocalDateTime createAt;

    @Column(name = "ip_at")
    private String ip = InetAddress.getLocalHost().getHostAddress();


    public Cliente(String HostName) throws UnknownHostException {
        this.ip = HostName;
    }

    public Cliente() throws UnknownHostException {

    }


    //    @PrePersist
//    public void prePersist(){ createAt = new Date(); }

//    private static final long serialVersionUID = 1L;

}
