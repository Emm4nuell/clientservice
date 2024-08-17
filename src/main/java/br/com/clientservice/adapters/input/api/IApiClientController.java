package br.com.clientservice.adapters.input.api;

import br.com.clientservice.adapters.input.api.request.RequestClient;
import br.com.clientservice.adapters.input.api.response.ResponseClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/api/")
public interface IApiClientController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    ResponseEntity<Void> created(@RequestBody RequestClient requestClient);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("clients/{id}")
    ResponseEntity<ResponseClient> findById(@PathVariable("id") Long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("clients")
    ResponseEntity<List<ResponseClient>> findAll();
}
