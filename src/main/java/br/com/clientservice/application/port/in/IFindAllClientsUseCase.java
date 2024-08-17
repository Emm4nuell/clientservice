package br.com.clientservice.application.port.in;

import br.com.clientservice.application.domain.model.ClientModel;

import java.util.List;

public interface IFindAllClientsUseCase {
    List<ClientModel> execute();
}
