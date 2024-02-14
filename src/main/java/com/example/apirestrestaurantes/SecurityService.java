package com.example.apirestrestaurantes;

import org.springframework.stereotype.Service;

/**
 * Servicio encargado de validar tokens de seguridad en la aplicación.
 *
 * <p>
 * Esta clase contiene el método {@link #validateToken(String)} que permite validar la autenticidad de un token.
 * </p>
 *
 * @see org.springframework.stereotype.Service
 *
 * @author Jorge Olmedo Jimenez
 * @version 1.0
 * @since 2024-02-14
 */
@Service
public class SecurityService {

    /**
     * Valida la autenticidad de un token.
     *
     * @param token El token a validar.
     * @return {@code true} si el token es válido, {@code false} si no lo es.
     */
    public Boolean validateToken(String token) {
        return (token.equals("t0k3n"));
    }
}
