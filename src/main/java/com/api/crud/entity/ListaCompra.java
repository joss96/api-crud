package com.api.crud.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ListaCompra")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListaCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLista;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Cliente cliente;
    
    @Column(nullable = false, length = 50)
    private String nombre;
    
    @Column(insertable = true, updatable = false)
	@CreationTimestamp
    private LocalDateTime fechaRegistro;
    
    @Column(insertable = true, updatable = true)
	@CreationTimestamp
    private LocalDateTime fechaUltimaActualizacion;
    
    @Column(nullable = false)
    private boolean activo;

}
