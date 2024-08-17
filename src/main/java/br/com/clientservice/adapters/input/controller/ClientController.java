package br.com.clientservice.adapters.input.controller;

import br.com.clientservice.adapters.input.api.IApiClientController;
import br.com.clientservice.adapters.input.api.request.RequestClient;
import br.com.clientservice.adapters.input.api.response.ResponseClient;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.in.ICreateClientUseCase;
import br.com.clientservice.application.port.in.IFindAllClientUseCase;
import br.com.clientservice.application.port.in.IFindByIdClientUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ClientController implements IApiClientController {

    private final ICreateClientUseCase iCreateClientUseCase;
    private final IFindByIdClientUseCase iFindByIdClientUseCase;
    private final IFindAllClientUseCase iFindAllClientUseCase;
    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<Void> created(RequestClient requestClient) {
        var model = iCreateClientUseCase.execute(mapper.convertValue(requestClient, ClientModel.class));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(model.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<ResponseClient> findById(Long id) {
        var response = mapper.convertValue(iFindByIdClientUseCase.execute(id), ResponseClient.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<List<ResponseClient>> findAll() {
        var response = iFindAllClientUseCase.execute().stream()
                .map(e -> mapper.convertValue(e, ResponseClient.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
