package entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Docente {
	private int idDocente, estado;
	private String nombres, apellidos, fechaNacimiento, fechaIngreso, dni, direccion;
}