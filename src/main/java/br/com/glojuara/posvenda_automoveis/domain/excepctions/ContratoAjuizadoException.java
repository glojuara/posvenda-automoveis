package br.com.glojuara.posvenda_automoveis.domain.excepctions;

public class ContratoAjuizadoException extends RuntimeException {
    public ContratoAjuizadoException(String message) {
        super(message);
    }
}
