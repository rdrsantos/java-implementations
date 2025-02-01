package com.bbb.service;

import com.bbb.dto.VotoRequest;
import com.bbb.entity.Candidato;
import com.bbb.entity.Voto;
import com.bbb.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class VotoService {

    private final RabbitTemplate rabbitTemplate;
    private final VotoRepository repository;

    public void processaVoto(VotoRequest request) {
        rabbitTemplate.convertAndSend(
                "computar-voto.ex",
                "",
                request
        );
    }

    public void salvar(VotoRequest request) {
        Voto voto = new Voto();
        voto.setCandidato(new Candidato(request.getIdCandidato()));
        voto.setDataHora(LocalDateTime.now());
        repository.save(voto);
    }
}
