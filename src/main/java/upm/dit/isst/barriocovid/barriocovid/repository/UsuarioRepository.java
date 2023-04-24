package upm.dit.isst.barriocovid.barriocovid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upm.dit.isst.barriocovid.barriocovid.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    List<Usuario> findByUsuarioId(Long usuarioId);

    @Query("select u from Usuario u where u.usuarioId=?1")
    Usuario encontrarUsuario(Long usuarioId);

    @Query("select u from Usuario u where u.email=?1")
    Usuario findByEmail(String email);
}

