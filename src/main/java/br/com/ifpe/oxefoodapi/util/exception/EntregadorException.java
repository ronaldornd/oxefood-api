package br.com.ifpe.oxefoodapi.util.exception;

public class EntregadorException extends RuntimeException {
    public static final String MSG_FRETE_BARATO = "O valor do frete é muito baixo";

    public EntregadorException(String msg) {
        super(String.format(msg));
    }
}
