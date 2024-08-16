package br.com.clientservice.adapters.input.api;

import br.com.clientservice.adapters.input.api.request.RequestClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("v1/client/")
public interface IApiClientController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    ResponseEntity<Void> created(@RequestBody RequestClient requestClient);
}
