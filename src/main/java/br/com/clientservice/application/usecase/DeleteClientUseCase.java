package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.UserNotFoundException;
import br.com.clientservice.application.port.in.IDeleteClientUseCase;
import br.com.clientservice.application.port.out.IDeleteClientService;
import br.com.clientservice.application.port.out.IFindByIdClientService;
import br.com.clientservice.infrastructure.config.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class DeleteClientUseCase implements IDeleteClientUseCase {

    private final IDeleteClientService iDeleteClientService;
    private final IFindByIdClientService iFindByIdClientService;

    @Override
    public void execute(Long id) {
        if (id != null){
            iFindByIdClientService.execute(id)
                    .orElseThrow(() -> new UserNotFoundException("Usuario com ID: " + id + " não localizado na base de dados"));
            iDeleteClientService.execute(id);
        }else{
            throw new BusinessExceptoin("ID do usuario não pode ser null");
        }
    }
}
