package br.com.clientservice.application.port.in;

import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.domain.model.EnderecoModel;

public interface ICreateClientUseCase {
    ClientModel execute(ClientModel cliente);
}
