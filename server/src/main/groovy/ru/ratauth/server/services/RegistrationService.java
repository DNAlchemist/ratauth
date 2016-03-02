package ru.ratauth.server.services;

import ru.ratauth.interaction.RegistrationRequest;
import ru.ratauth.interaction.TokenResponse;
import ru.ratauth.providers.registrations.dto.RegResult;
import rx.Observable;

/**
 * @author mgorelikov
 * @since 29/01/16
 */
public interface RegistrationService {
  Observable<RegResult> register(RegistrationRequest request);
  Observable<TokenResponse> finishRegister(RegistrationRequest request);
}
