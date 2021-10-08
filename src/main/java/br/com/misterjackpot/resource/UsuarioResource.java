package br.com.misterjackpot.resource;

import br.com.misterjackpot.model.Usuario;
import br.com.misterjackpot.repository.UsuarioRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario){
        usuarioRepository.persist(usuario);
    }
}
