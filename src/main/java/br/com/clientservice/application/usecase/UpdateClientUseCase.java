package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.UserNotFoundException;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.in.IUpdateClientUseCase;
import br.com.clientservice.application.port.out.ICreateClientService;
import br.com.clientservice.application.port.out.IFindByIdClientService;
import br.com.clientservice.infrastructure.config.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class UpdateClientUseCase implements IUpdateClientUseCase {

    private final IFindByIdClientService iFindByIdClientService;
    private final ICreateClientService iCreateClientService;

    @Override
    public void execute(Long id, ClientModel model) {
        if (model != null && id != null){
            var check = iFindByIdClientService.execute(id)
                    .orElseThrow(() -> new UserNotFoundException("Usuario com ID: " + id + " nao localizado"));
            model.setId(check.getId());
            model.setData_cadastro(check.getData_cadastro());
            iCreateClientService.execute(model);
        }else {
            throw new BusinessExceptoin("Usuario não pode ser null CPF: " +model.getCpf() + " ID: " +id);
        }
    }
}
