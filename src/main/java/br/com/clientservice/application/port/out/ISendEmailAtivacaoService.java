package br.com.clientservice.application.port.out;

import br.com.clientservice.application.domain.model.SendEmailModel;

public interface ISendEmailAtivacaoService {
    void execute(SendEmailModel model);
}
