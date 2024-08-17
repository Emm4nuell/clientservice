package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.in.IFindAllClientUseCase;
import br.com.clientservice.application.port.out.IFindAllClientsService;
import br.com.clientservice.infrastructure.config.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class FindAllClientsUseCase implements IFindAllClientUseCase {

    private final IFindAllClientsService iFindAllClientsService;

    @Override
    public List<ClientModel> execute() {
        return iFindAllClientsService.execute();
    }
}
