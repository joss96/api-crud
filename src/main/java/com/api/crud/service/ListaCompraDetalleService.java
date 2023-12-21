package com.api.crud.service;

import java.util.List;
import java.util.Optional;

import com.api.crud.entity.ListaCompra;
import com.api.crud.entity.ListaCompraDetalle;

public interface ListaCompraDetalleService {
	ListaCompraDetalle crear(ListaCompraDetalle lista);
	ListaCompraDetalle modificar(Integer id,ListaCompraDetalle lista);
	void eliminar(Integer id);
	Optional<ListaCompraDetalle> obtenerPorId(Integer id);
	
	List<ListaCompra> obtenerPorIdCliente(Integer id);
	
}
