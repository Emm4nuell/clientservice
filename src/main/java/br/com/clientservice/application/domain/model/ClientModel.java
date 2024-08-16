package br.com.clientservice.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientModel {
    private Long id;
    private String nome;
    private String parentesco;
    private String cpf;
    private String rg;
    private Date data_nascimento;
    private String telefone;
    private String celular;
    private String email;
    private LocalDateTime data_cadastro;
}
