package br.com.clientservice.adapters.output.database;

import br.com.clientservice.adapters.output.database.repository.IClientRepository;
import br.com.clientservice.application.port.out.IDeleteClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientSerive implements IDeleteClientService {

    private final IClientRepository repository;

    @Override
    public void execute(Long id) {
        repository.deleteById(id);
    }
}
