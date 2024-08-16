package br.com.clientservice.adapters.output.database.repository;

import br.com.clientservice.adapters.output.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreateClientRepository extends JpaRepository<ClientEntity, Long> {
}
