package com.martina.plantas.repository;
import com.martina.plantas.entities.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	//PARA EL LOGIN
	Optional<Usuario> findByMail(String mail);
}
