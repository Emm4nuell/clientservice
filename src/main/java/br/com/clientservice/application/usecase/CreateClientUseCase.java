package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.CpfAlreadyExistsException;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.in.ICreateClientUseCase;
import br.com.clientservice.application.port.out.ICreateClientService;
import br.com.clientservice.application.port.out.IFindByCpfClientService;
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

    @Override
    public ClientModel execute(ClientModel model) {
        if (model != null){
            var modelcpf = iFindByCpfClientService.execute(model.getCpf());
            if (modelcpf.isEmpty()){
                model.setData_cadastro(LocalDateTime.now());
                return iCreateClientService.execute(model);
            }else {
                log.error("CPF já cadastrado: " + model.getCpf());
                throw new CpfAlreadyExistsException("CPF já cadastrado: " + model.getCpf());
            }
        }else {
            log.error("BusinessExceptoin: Erro ao cadastrar cliente com cpf: " + model.getCpf());
            throw new BusinessExceptoin("BusinessExceptoin: Erro ao cadastrar cliente com cpf: " + model.getCpf());
        }
    }
}
