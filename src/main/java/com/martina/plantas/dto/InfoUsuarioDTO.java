package com.martina.plantas.dto;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoUsuarioDTO extends UsernamePasswordAuthenticationToken implements Serializable {

	private String getNombre;
	private String getApellido;
	
	public InfoUsuarioDTO(Object principal, Object credenciales, Collection <? extends GrantedAuthority> autoridades, String nombre, String apellido) {
		super(principal, credenciales, autoridades);
		this.getNombre= nombre;
		this.getApellido= apellido;
	}
}
