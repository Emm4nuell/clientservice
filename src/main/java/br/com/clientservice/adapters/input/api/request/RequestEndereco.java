package br.com.clientservice.adapters.input.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEndereco {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}
