package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.UserNotFoundException;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.in.IFindByIdClientUseCase;
import br.com.clientservice.application.port.out.IFindByIdClientService;
import br.com.clientservice.infrastructure.config.UseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@AllArgsConstructor
@Slf4j
public class FindByIdClientUseCase implements IFindByIdClientUseCase {

    private final IFindByIdClientService iFindByIdClientService;

    @Override
    public ClientModel execute(Long id) {
        if (id != null) {
            var model = iFindByIdClientService.execute(id);
            if (model.isPresent()) {
                return model.get();
            } else {
                log.error("Usuario com ID: " + id + " nao localizado!");
                throw new UserNotFoundException("Usuario com ID: " + id + " nao localizado!");
            }
        }else {
            log.error("ID não pode ser null");
            throw new BusinessExceptoin("ID não pode ser null");
        }
    }
}
