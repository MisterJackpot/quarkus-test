package br.com.misterjackpot.repository;

import br.com.misterjackpot.model.Usuario;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public void adicionar(Usuario usuario){
        usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
        usuario.setRole(validarUsername(usuario.getUsername()));
        this.persist(usuario);
    }

    private String validarUsername(String username) {
        if(username.equals("admin")){
            return "admin";
        }else{
            return "user";
        }
    }
}
