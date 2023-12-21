package com.api.crud.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Error implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mensaje;
	private Date fecha;
	
	public Error(String mensaje) {
		this.mensaje = mensaje;
		this.fecha = new Date();
	}
}
