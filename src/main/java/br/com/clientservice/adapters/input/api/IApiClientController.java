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
    @GetMapping("client/{id}")
    ResponseEntity<ResponseClient> findById(@PathVariable("id") Long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("clients")
    ResponseEntity<List<ResponseClient>> findAll();

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("client/update/{id}")
    ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody RequestClient request);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("client/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
