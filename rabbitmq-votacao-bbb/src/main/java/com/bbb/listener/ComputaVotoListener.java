package com.bbb.listener;

import com.bbb.dto.VotoRequest;
import com.bbb.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ComputaVotoListener {

    private final VotoService votoService;

    @RabbitListener(queues = "computar-voto.queue")
    public void processMessage(VotoRequest request) {
        System.out.println("Consumindo messagem de votação para o candidato numero " + request.getIdCandidato());
        votoService.salvar(request);
    }
}
