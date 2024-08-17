package br.com.clientservice.adapters.output.database;

import br.com.clientservice.adapters.output.database.repository.IClientRepository;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.out.IFindByIdClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByIdClientService implements IFindByIdClientService {

    private final IClientRepository iClientRepository;
    private final ObjectMapper mapper;

    @Override
    public Optional<ClientModel> execute(Long id) {
        return Optional.ofNullable(mapper.convertValue(iClientRepository.findById(id), ClientModel.class));
    }
}
