package com.example.easynotes.model;


import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "events")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"Fecha"},
allowGetters = true)
public class Event {
	

	public Event(){
 	   
    }

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;
    
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date Fecha;
    
   

	private int sala;


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

public Date getFecha() {
	return Fecha;
}


public void setFecha(Date fecha) {
	Fecha = fecha;
}

public int getSala() {
	return sala;
}


public void setSala(int sala) {
	this.sala = sala;
}


   
  
}
