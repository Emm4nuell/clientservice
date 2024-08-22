package br.com.clientservice.adapters.output.feign.endereco;

import br.com.clientservice.adapters.output.feign.endereco.api.IApiEnderecoController;
import br.com.clientservice.adapters.output.feign.endereco.api.request.RequestEnderecoFeign;
import br.com.clientservice.application.domain.model.EnderecoModel;
import br.com.clientservice.application.port.out.ICreateEnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateEnderecoService implements ICreateEnderecoService {

    private final ObjectMapper mapper;
    private final IApiEnderecoController iApiEnderecoController;

    @Override
    public String execute(EnderecoModel idEndereco) {
        var request = iApiEnderecoController.create(mapper.convertValue(idEndereco, RequestEnderecoFeign.class));
        return request.getHeaders().getLocation().getPath();
    }
}
