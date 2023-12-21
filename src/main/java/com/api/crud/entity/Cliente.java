package com.api.crud.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    private int idCliente;
    
    @Column(nullable = false, length = 50)
    private String nombre;
    
    @Column(nullable = false)
    private boolean activo;

}
