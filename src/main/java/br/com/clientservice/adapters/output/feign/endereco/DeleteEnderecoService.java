package br.com.clientservice.adapters.output.feign.endereco;

import br.com.clientservice.adapters.output.feign.endereco.api.IApiEnderecoController;
import br.com.clientservice.application.port.out.IDeleteEnderecoSerice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteEnderecoService implements IDeleteEnderecoSerice {

    private final IApiEnderecoController iApiEnderecoController;

    @Override
    public void execute(Long idEndereco) {
        iApiEnderecoController.delete(idEndereco);
    }
}
