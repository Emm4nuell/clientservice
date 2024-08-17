package br.com.clientservice.application.port.in;

import br.com.clientservice.application.domain.model.ClientModel;

public interface IUpdateClientUseCase {
    void execute(Long id, ClientModel model);
}
