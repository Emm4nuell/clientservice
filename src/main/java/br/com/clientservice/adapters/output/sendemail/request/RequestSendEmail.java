package br.com.clientservice.adapters.output.sendemail.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestSendEmail implements Serializable {
    private String nome;
    private String email;
}
