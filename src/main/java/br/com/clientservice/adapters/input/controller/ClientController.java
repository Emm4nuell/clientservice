package br.com.clientservice.adapters.input.controller;

import br.com.clientservice.adapters.input.api.IApiClientController;
import br.com.clientservice.adapters.input.api.request.RequestClient;
import br.com.clientservice.application.domain.model.ClientModel;
import br.com.clientservice.application.port.in.ICreateClientUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class ClientController implements IApiClientController {

    private final ICreateClientUseCase iCreateClientUseCase;
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
}
