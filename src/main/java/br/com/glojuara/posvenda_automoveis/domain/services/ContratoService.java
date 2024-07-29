package br.com.glojuara.posvenda_automoveis.domain.services;

import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;
import br.com.glojuara.posvenda_automoveis.domain.entities.NumeroContratoVO;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ContratoService {

    Set<Contrato> buscarContratos(UUID identificadorCliente);
    Optional<Contrato> buscarContrato(NumeroContratoVO numeroContrato);

}
