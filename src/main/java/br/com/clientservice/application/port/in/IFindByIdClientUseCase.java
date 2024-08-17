package br.com.clientservice.application.port.in;

import br.com.clientservice.application.domain.model.ClientModel;

public interface IFindByIdClientUseCase {
    ClientModel execute(Long id);
}
