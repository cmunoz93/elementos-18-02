/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1801;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    
    @Id
    private Long cuenta; 
    private String nombre; 
    
    @Column(name="correo")
    private String email; 

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario() {
    }

    public Usuario(Long cuenta, String nombre, String email) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario(Long cuenta) {
        this.cuenta = cuenta;
    }
    
    
    
}