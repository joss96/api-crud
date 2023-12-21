package com.api.crud.entity;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ListaCompraDetalle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListaCompraDetalle implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
    private int idListaCompraDetalle;
    
    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "codigoProducto", nullable = false)
    private List<Producto> producto;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLista", nullable = false)
    private ListaCompra listaCompra;
    
    @Column(nullable = false)
    private int cantidad;
	
}
