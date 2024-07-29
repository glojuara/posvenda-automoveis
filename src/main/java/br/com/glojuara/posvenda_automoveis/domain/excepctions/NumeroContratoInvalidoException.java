package br.com.glojuara.posvenda_automoveis.domain.excepctions;

public class NumeroContratoInvalidoException extends RuntimeException {
    public NumeroContratoInvalidoException(String message) {
        super(message);
    }
}
