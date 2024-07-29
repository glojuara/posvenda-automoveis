package br.com.glojuara.posvenda_automoveis.domain.usecases.impl;


import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;
import br.com.glojuara.posvenda_automoveis.domain.entities.NumeroContratoVO;
import br.com.glojuara.posvenda_automoveis.domain.services.ContratoService;
import br.com.glojuara.posvenda_automoveis.domain.services.ValidarElegibilidadeContratoService;
import br.com.glojuara.posvenda_automoveis.domain.usecases.ValidarEligibilidadeContratoAlteracaoModalidadeUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ValidarEligibilidadeContratoAlteracaoModalidadeUseCaseImpl implements ValidarEligibilidadeContratoAlteracaoModalidadeUseCase {

    private final ContratoService contratoService;
    private final List<ValidarElegibilidadeContratoService> validadores;

    public ValidarEligibilidadeContratoAlteracaoModalidadeUseCaseImpl(ContratoService contratoService, List<ValidarElegibilidadeContratoService> validadores) {
        this.contratoService = contratoService;
        this.validadores = validadores;
    }

    @Override
    public void execute(String numeroContrato) {
        NumeroContratoVO numeroContratoVO = new NumeroContratoVO(numeroContrato);

        Optional<Contrato> contrato = contratoService.buscarContrato(numeroContratoVO);
        if (contrato.isEmpty()) {
            throw new RuntimeException("Contrato não encontrado");
        }

        validarElegibilidade(contrato.get());

    }

    private void validarElegibilidade(Contrato contrato) {
        validadores.parallelStream()
                .forEach(validador -> validador.validar(contrato));

    }
}
