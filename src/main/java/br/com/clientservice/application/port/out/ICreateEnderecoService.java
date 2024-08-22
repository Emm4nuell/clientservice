package br.com.clientservice.application.port.out;

import br.com.clientservice.application.domain.model.EnderecoModel;

public interface ICreateEnderecoService {
    String execute(EnderecoModel idEndereco);
}
