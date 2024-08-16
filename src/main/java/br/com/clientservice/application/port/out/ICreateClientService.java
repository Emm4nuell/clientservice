package br.com.clientservice.application.port.out;

import br.com.clientservice.application.domain.model.ClientModel;

public interface ICreateClientService {
    ClientModel execute(ClientModel model);
}
