package br.com.ifpe.oxefoodapi.util.exception;

public class FornecedorException extends RuntimeException {
    public static final String MSG_VALOR_MERCADO_BAIXO = "O valor de mercado é muito baixo!";

    public FornecedorException(String msg) {
        super(String.format(msg));
    }
}
