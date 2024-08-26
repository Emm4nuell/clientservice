package br.com.clientservice.adapters.output.sendemail;

import br.com.clientservice.adapters.output.sendemail.request.RequestSendEmail;
import br.com.clientservice.application.domain.model.SendEmailModel;
import br.com.clientservice.application.port.out.ISendEmailAtivacaoService;
import br.com.clientservice.infrastructure.constants.RabbitMqConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

@Service
@AllArgsConstructor
@Slf4j
public class SendEmailService implements ISendEmailAtivacaoService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    @Override
    public void execute(SendEmailModel model) {
        var request = mapper.convertValue(model, RequestSendEmail.class);
        try {
            rabbitTemplate.convertAndSend(
                    RabbitMqConstants.SEND_EMAIL_EXCHANGE,
                    RabbitMqConstants.EMAIL_ROUTING_KEY,
                    mapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            log.error("JSON fornecido não está no formato esperado EMAIL:  " + request.getEmail());
            throw new RuntimeException("JSON fornecido não está no formato esperado EMAIL:  " + request.getEmail());
        } catch (RuntimeException e){
            log.error("Conexao SendEmail com o RabbitMq recusada EMAIL = " + model.getEmail());
            throw new RuntimeException("Conexao SendEmail com o RabbitMq recusada EMAIL = " + model.getEmail());
        }
    }
}
