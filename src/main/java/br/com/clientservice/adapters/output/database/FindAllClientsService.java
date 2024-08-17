package br.com.clientservice.adapters.output.database;

import br.com.clientservice.adapters.output.database.repository.IClientRepository;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.out.IFindAllClientsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindAllClientsService implements IFindAllClientsService {

    private final IClientRepository iClientRepository;
    private final ObjectMapper mapper;

    @Override
    public List<ClientModel> execute() {
        List<ClientModel> clients = iClientRepository.findAll().stream()
                .map(e -> mapper.convertValue(e, ClientModel.class)).collect(Collectors.toList());
        return clients;
    }
}
