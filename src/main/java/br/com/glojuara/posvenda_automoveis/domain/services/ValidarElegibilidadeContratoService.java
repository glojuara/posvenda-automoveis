package br.com.glojuara.posvenda_automoveis.domain.services;

import br.com.glojuara.posvenda_automoveis.domain.entities.Contrato;

public interface ValidarElegibilidadeContratoService {

    void validar(Contrato contrato);

}
