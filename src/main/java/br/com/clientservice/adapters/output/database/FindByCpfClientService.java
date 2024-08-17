package br.com.clientservice.adapters.output.database;

import br.com.clientservice.adapters.output.database.repository.IClientRepository;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.out.IFindByCpfClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByCpfClientService implements IFindByCpfClientService {

    private final IClientRepository iClientRepository;
    private final ObjectMapper mapper;

    @Override
    public Optional<ClientModel> execute(String cpf) {
        return Optional.ofNullable(mapper.convertValue(iClientRepository.findByCpf(cpf), ClientModel.class));
    }
}
