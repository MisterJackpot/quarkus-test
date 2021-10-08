package br.com.misterjackpot.service;

import br.com.misterjackpot.model.Bitcoin;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
@RequestScoped
public interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar();

}
