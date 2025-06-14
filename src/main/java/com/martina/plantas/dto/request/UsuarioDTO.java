
package com.martina.plantas.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Martina
 */
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ]+( [a-zA-ZÁÉÍÓÚáéíóúñÑ]+)*$", message = "El nombre solo puede contener letras y espacios")
    @Length(min=3, max=20)
    private String nombre;
    
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ]+( [a-zA-ZÁÉÍÓÚáéíóúñÑ]+)*$", message = "El apellido solo puede contener letras y espacios")
    @Length(min=4, max=30)
    private String apellido;
    
     @Email(message="formato de email invalido")
    private String mail;
     
     @Pattern(
    regexp = "^(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{8,}$",
    message = "La contraseña debe tener al menos 8 caracteres y un carácter especial"
)
    private String clave;

    public UsuarioDTO(String nombre, String apellido, String mail, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
     
     
}
