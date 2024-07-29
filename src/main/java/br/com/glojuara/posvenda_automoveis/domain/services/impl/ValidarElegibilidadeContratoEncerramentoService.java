package br.com.glojuara.posvenda_automoveis.domain.services.impl;

import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;
import br.com.glojuara.posvenda_automoveis.domain.entities.Status;
import br.com.glojuara.posvenda_automoveis.domain.excepctions.ContratoEncerradoException;
import br.com.glojuara.posvenda_automoveis.domain.services.ValidarElegibilidadeContratoService;
import org.springframework.stereotype.Service;

@Service
public class ValidarElegibilidadeContratoEncerramentoService implements ValidarElegibilidadeContratoService {
    @Override
    public void validar(Contrato contrato) {

        System.out.println("Validando encerramento de contrato");


        if (Status.ENCERRADO.equals(contrato.getStatus())) {
            throw new ContratoEncerradoException("Contrato encerrado");
        }

    }
}
