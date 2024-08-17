package br.com.clientservice.application.port.out;

import br.com.clientservice.application.domain.model.ClientModel;

import java.util.List;

public interface IFindAllClientsService {
    List<ClientModel> execute();
}
