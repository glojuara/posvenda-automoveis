package br.com.glojuara.posvenda_automoveis.domain.services.impl;

import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;
import br.com.glojuara.posvenda_automoveis.domain.entities.NumeroContratoVO;
import br.com.glojuara.posvenda_automoveis.domain.entities.Status;
import br.com.glojuara.posvenda_automoveis.domain.services.ContratoService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Service
public class
ContratoServiceImpl implements ContratoService {

    private static final Random RANDOM = new Random();

    @Override
    public Set<Contrato> buscarContratos(UUID identificadorCliente) {
        return null;
    }

    @Override
    public Optional<Contrato> buscarContrato(NumeroContratoVO numeroContrato) {
        Contrato contrato = new Contrato(UUID.randomUUID().toString(), numeroContrato.getValor(), getRandomStatus());
        return Optional.of(contrato);
    }

    private static Status getRandomStatus() {
        Status[] values = Status.values();
        int randomIndex = RANDOM.nextInt(values.length);
        return values[randomIndex];
    }


}
