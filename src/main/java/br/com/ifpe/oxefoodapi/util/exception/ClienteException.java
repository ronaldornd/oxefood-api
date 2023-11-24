package br.com.ifpe.oxefoodapi.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)

public class ClienteException extends RuntimeException {
    public static final String MSG_FONE_CELULAR_INVALIDO = "O telefone não é válido, favor verificar";

    public ClienteException(String msg) {

        super(String.format(msg));
    }
}
