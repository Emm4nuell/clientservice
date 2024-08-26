package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.CpfAlreadyExistsException;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.domain.model.EnderecoModel;
import br.com.clientservice.application.domain.model.SendEmailModel;
import br.com.clientservice.application.port.in.ICreateClientUseCase;
import br.com.clientservice.application.port.out.*;
import br.com.clientservice.infrastructure.config.UseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@UseCase
@AllArgsConstructor
@Slf4j
public class CreateClientUseCase implements ICreateClientUseCase {

    private final ICreateClientService iCreateClientService;
    private final IFindByCpfClientService iFindByCpfClientService;
    private final ISendEmailAtivacaoService iSendEmailAtivacaoService;

    @Override
    public ClientModel execute(ClientModel cliente) {

        if (cliente != null){
            var modelcpf = iFindByCpfClientService.execute(cliente.getCpf());
            if (modelcpf.isEmpty()){
                    cliente.setData_cadastro(LocalDateTime.now());
                    var saveClient = iCreateClientService.execute(cliente);
                    var sendEmail = SendEmailModel.builder()
                            .nome(cliente.getNome())
                            .email(cliente.getEmail())
                            .build();
                    iSendEmailAtivacaoService.execute(sendEmail);
                    return saveClient;
            }else {
                log.error("CPF já cadastrado: " + cliente.getCpf());
                throw new CpfAlreadyExistsException("CPF já cadastrado: " + cliente.getCpf());
            }
        }else {
            log.error("BusinessExceptoin: Erro ao cadastrar cliente com cpf: " + cliente.getCpf());
            throw new BusinessExceptoin("BusinessExceptoin: Erro ao cadastrar cliente com cpf: " + cliente.getCpf());
        }
    }
}
