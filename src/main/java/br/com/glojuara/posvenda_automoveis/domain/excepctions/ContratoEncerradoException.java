package br.com.glojuara.posvenda_automoveis.domain.excepctions;

public class ContratoEncerradoException extends RuntimeException {
    public ContratoEncerradoException(String message) {
        super(message);
    }
}
