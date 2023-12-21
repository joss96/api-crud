package com.api.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.crud.entity.Cliente;
import com.api.crud.entity.ListaCompra;
import com.api.crud.entity.ListaCompraDetalle;
import com.api.crud.repository.ClienteRepository;
import com.api.crud.repository.ListaCompraDetalleRepository;
import com.api.crud.repository.ListaCompraRepository;
import com.api.crud.service.ListaCompraDetalleService;

@Service
public class ListaCompraDetalleServiceImpl implements ListaCompraDetalleService{
	
	private ListaCompraDetalleRepository repository;
	
	private ClienteRepository clienteRepository;
	
	private ListaCompraRepository listaCompraRepository;
	
	private ListaCompraDetalleServiceImpl(ListaCompraDetalleRepository repository,ClienteRepository clienteRepository, ListaCompraRepository listaCompraRepository) {
		this.repository = repository;
		this.clienteRepository = clienteRepository;
		this.listaCompraRepository = listaCompraRepository;
	}

	@Override
	public ListaCompraDetalle crear(ListaCompraDetalle lista) {
		return repository.save(lista);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public ListaCompraDetalle modificar(Integer id,ListaCompraDetalle lista) {
		Optional<ListaCompraDetalle> optional = obtenerPorId(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("La lista con id:"+id+" no existe");
		}
		lista.setIdListaCompraDetalle(id);
		return repository.save(lista);
	}

	@Override
	public Optional<ListaCompraDetalle> obtenerPorId(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<ListaCompra> obtenerPorIdCliente(Integer id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if(optionalCliente.isEmpty()) {
			throw new RuntimeException("La lista con id:"+id+" no existe");
		}
		return listaCompraRepository.findByCliente(optionalCliente.get());
	}


	
	
	
	
	
	
	
}
