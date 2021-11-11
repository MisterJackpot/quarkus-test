package br.com.misterjackpot.service;

import br.com.misterjackpot.model.Ordem;
import br.com.misterjackpot.model.Usuario;
import br.com.misterjackpot.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;
    @Inject
    UsuarioService usuarioService;

    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Usuario usuario = usuarioService.buscar(ordem.getUserId())
                .orElseThrow();

        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw new RuntimeException("O usuário logado é diferente do userId");
        }

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> listar() {
        return ordemRepository.listAll();
    }
}
