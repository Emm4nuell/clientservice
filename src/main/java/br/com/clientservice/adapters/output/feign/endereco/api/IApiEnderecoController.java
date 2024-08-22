package br.com.clientservice.adapters.output.feign.endereco.api;

import br.com.clientservice.adapters.output.feign.endereco.api.request.RequestEnderecoFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "endereco-service", url = "localhost:8082/v1/endereco/")
public interface IApiEnderecoController {

    @PostMapping("create")
    ResponseEntity<Void> create(@RequestBody RequestEnderecoFeign model);

    @DeleteMapping("delete/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
