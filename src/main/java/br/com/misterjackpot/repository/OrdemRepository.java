package br.com.misterjackpot.repository;

import br.com.misterjackpot.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

}
