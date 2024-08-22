package br.com.clientservice.adapters.output.feign.endereco.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEnderecoFeign {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}
