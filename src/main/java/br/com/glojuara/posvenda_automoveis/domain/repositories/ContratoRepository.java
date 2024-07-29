package br.com.glojuara.posvenda_automoveis.domain.repositories;

import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;

import java.util.UUID;

public interface ContratoRepository {
    Contrato buscar(UUID referenciaExterna);

}
