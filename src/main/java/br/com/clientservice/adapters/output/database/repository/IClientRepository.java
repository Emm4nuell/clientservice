package br.com.clientservice.adapters.output.database.repository;

import br.com.clientservice.adapters.output.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByCpf(String cpf);
}
