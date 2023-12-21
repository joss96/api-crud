package com.api.crud.config;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.entity.ListaCompra;
import com.api.crud.entity.ListaCompraDetalle;
import com.api.crud.service.ListaCompraDetalleService;

@RestController
@RequestMapping("/lista-compras")
public class ListaController {
	
	private ListaCompraDetalleService service;
	
	private ListaController(ListaCompraDetalleService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ListaCompraDetalle crear(@RequestBody ListaCompraDetalle lista) {
		return service.crear(lista);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	ListaCompraDetalle modificar(Integer id, @RequestBody ListaCompraDetalle lista) {
		return service.crear(lista);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void borrar(@PathVariable Integer id) {
		service.eliminar(id);
	}
	
	@GetMapping("cliente/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	List<ListaCompra> obtenerPorCliente(@PathVariable Integer id) {
		return service.obtenerPorIdCliente(id);
	}
	
	
}
