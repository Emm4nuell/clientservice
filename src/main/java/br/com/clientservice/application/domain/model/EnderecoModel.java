package br.com.clientservice.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoModel {
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}
