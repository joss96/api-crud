package com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.entity.Cliente;
import com.api.crud.entity.ListaCompra;

import java.util.List;


public interface ListaCompraRepository extends JpaRepository<ListaCompra, Integer> {
	List<ListaCompra> findByCliente(Cliente cliente);
}
