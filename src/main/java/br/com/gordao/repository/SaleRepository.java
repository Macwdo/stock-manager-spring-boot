package br.com.gordao.repository;

import br.com.gordao.entity.Sale;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SaleRepository extends CrudRepository<Sale, UUID> {
}
