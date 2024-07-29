package br.com.glojuara.posvenda_automoveis.domain.entities;

import br.com.glojuara.posvenda_automoveis.domain.excepctions.NumeroContratoInvalidoException;
import org.apache.logging.log4j.util.Strings;

public class NumeroContratoVO {

    private static int TAMANHO_CONTRATO = 6;

    private final String valor;

    public NumeroContratoVO(String valor) {
        validar(valor);
        this.valor = valor;
    }

    private void validar(String valor) {
        if (Strings.isBlank(valor) || TAMANHO_CONTRATO != valor.length()) {
            throw new NumeroContratoInvalidoException("O numero do contrato deve ter exatos 6 digitos");
        }
    }

    public String getValor() {
        return valor;
    }
}
