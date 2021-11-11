package br.com.misterjackpot.resource;

import br.com.misterjackpot.model.Usuario;
import br.com.misterjackpot.repository.UsuarioRepository;
import br.com.misterjackpot.service.UsuarioService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario){
        usuarioService.inserir(usuario);
    }
}
