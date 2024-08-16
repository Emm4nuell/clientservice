package br.com.clientservice.adapters.output.database;

import br.com.clientservice.adapters.output.database.entity.ClientEntity;
import br.com.clientservice.adapters.output.database.repository.ICreateClientRepository;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.out.ICreateClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientService implements ICreateClientService {

    private final ObjectMapper mapper;
    private final ICreateClientRepository iCreateClientRepository;

    @Override
    public ClientModel execute(ClientModel model) {
        var entity = iCreateClientRepository.save(mapper.convertValue(mapper, ClientEntity.class));
        return mapper.convertValue(entity, ClientModel.class);
    }
}
