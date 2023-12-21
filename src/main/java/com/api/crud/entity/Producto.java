package com.api.crud.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    private int idProducto;
    
    @Column(length = 15)
    private String clave;
    
    @Column(length = 150)
    private String descripcion;
    
    @Column(nullable = false)
    private boolean activo;
	
}
