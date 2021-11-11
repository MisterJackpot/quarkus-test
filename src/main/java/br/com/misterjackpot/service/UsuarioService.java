package br.com.misterjackpot.service;

import br.com.misterjackpot.model.Ordem;
import br.com.misterjackpot.model.Usuario;
import br.com.misterjackpot.repository.OrdemRepository;
import br.com.misterjackpot.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> buscar(Long usuarioId) {
        return usuarioRepository.findByIdOptional(usuarioId);
    }

    public void inserir(Usuario usuario) {
        usuarioRepository.adicionar(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.listAll();
    }
}
