package br.com.glojuara.posvenda_automoveis.domain.services.impl;

import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;
import br.com.glojuara.posvenda_automoveis.domain.entities.Status;
import br.com.glojuara.posvenda_automoveis.domain.services.ValidarElegibilidadeContratoService;
import org.springframework.stereotype.Service;

@Service
public class ValidarElegibilidadeContratoAjuizamentoService implements ValidarElegibilidadeContratoService {
    @Override
    public void validar(Contrato contrato) {

        System.out.println("Validando ajuizamento de contrato");

        if (Status.AJUIZADO.equals(contrato.getStatus())) {
            throw new RuntimeException("Contrato Ajuízado");
        }

    }
}
