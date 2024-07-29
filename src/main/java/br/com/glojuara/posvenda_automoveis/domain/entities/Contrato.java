package br.com.glojuara.posvenda_automoveis.domain.entities;

import java.util.UUID;

public class Contrato {

    private UUID identificadorCliente;
    private NumeroContratoVO numero;

    private Status status;

    public Contrato(String identificadorCliente, String numero) {
        this(identificadorCliente, numero, Status.NOVO);
    }

    public Contrato(String identificadorCliente, String numero, Status status) {
        this.numero = new NumeroContratoVO(numero);
        this.identificadorCliente = UUID.fromString(identificadorCliente);
        this.status = status;
    }

    public String getIdentificadorCliente() {
        return identificadorCliente.toString();
    }
    public String getNumeroContrato() {
        return numero.getValor();
    }

    public Status getStatus() {
        return status;
    }
}