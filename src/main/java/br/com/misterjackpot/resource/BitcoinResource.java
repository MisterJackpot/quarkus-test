package br.com.misterjackpot.resource;

import br.com.misterjackpot.model.Bitcoin;
import br.com.misterjackpot.service.BitcoinService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
public class BitcoinResource {

    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar(){
        return bitcoinService.listar();
    }
}
