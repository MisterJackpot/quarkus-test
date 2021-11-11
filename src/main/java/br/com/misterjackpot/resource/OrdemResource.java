package br.com.misterjackpot.resource;

import br.com.misterjackpot.model.Ordem;
import br.com.misterjackpot.repository.OrdemRepository;
import br.com.misterjackpot.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;

@Path("/ordens")
public class OrdemResource {

    @Inject
    OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes({MediaType.APPLICATION_JSON})
    public void inserir(@Context SecurityContext securityContext, Ordem ordem){
        ordemService.inserir(securityContext, ordem);
    }
}
