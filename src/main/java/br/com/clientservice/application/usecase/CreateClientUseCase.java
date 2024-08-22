package br.com.clientservice.application.usecase;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.CpfAlreadyExistsException;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.domain.model.EnderecoModel;
import br.com.clientservice.application.port.in.ICreateClientUseCase;
import br.com.clientservice.application.port.out.ICreateClientService;
import br.com.clientservice.application.port.out.ICreateEnderecoService;
import br.com.clientservice.application.port.out.IDeleteEnderecoSerice;
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
    private final ICreateEnderecoService iCreateEnderecoService;
    private final IDeleteEnderecoSerice iDeleteEnderecoSerice;

    @Override
    public ClientModel execute(ClientModel cliente, EnderecoModel endereco) {

        if (cliente != null){

            var modelcpf = iFindByCpfClientService.execute(cliente.getCpf());

            if (modelcpf.isEmpty()){

                var path = iCreateEnderecoService.execute(endereco);
                String[] idEndereco = path.split("/");

                try {
                    cliente.setId_endereco(Long.parseLong(idEndereco[idEndereco.length -1]));
                    cliente.setData_cadastro(LocalDateTime.now());
                    return iCreateClientService.execute(cliente);
                }catch (Exception e){
                    iDeleteEnderecoSerice.execute(cliente.getId_endereco());
                    log.error("BusinessExceptoin: Erro ao cadastrar cliente com cpf: " + cliente.getCpf());
                    throw new BusinessExceptoin("Erro ao cadastrar cliente com CPF: " + cliente.getCpf());
                }

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
