package br.com.clientservice.application.port.out;

import br.com.clientservice.application.domain.model.ClientModel;

import java.util.Optional;

public interface IFindByCpfClientService {
    Optional<ClientModel> execute(String cpf);
}
