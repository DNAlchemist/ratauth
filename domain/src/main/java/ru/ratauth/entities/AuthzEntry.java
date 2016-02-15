package ru.ratauth.entities;

import lombok.*;

import java.util.*;

/**
 * @author mgorelikov
 * @since 01/11/15
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthzEntry {
  private String id;
  private String authCode;
  private Long codeTTL;
  private Date created;
  private String refreshToken;
  private Long refreshTokenTTL;//created together with authCode
  private @Singular("scope") Set<String> scopes;
  private String relyingParty;//identifier
  private String identityProvider;//identifier
  private @Singular Set<String> resourceServers;//identifiers
  private String userInfo;//base jwt
  private @Singular Set<Token> tokens;

  public void addToken(Token token) {
    if(this.tokens == null  || this.tokens.isEmpty())
      this.tokens = new HashSet<>();
    this.tokens.add(token);
  }

  public Long codeExpiresIn() {
    if(created == null || codeTTL == null)
      return null;
    return created.getTime() + codeTTL;
  }

  public Long refreshTokenExpiresIn() {
    return created.getTime() + refreshTokenTTL;
  }

  public Token getLatestToken() {
    if(tokens == null)
      return null;
    return tokens.stream()
        .sorted((el1,el2) -> el1.expiresIn().compareTo(el2.expiresIn()))
        .findFirst().orElse(null);
  }
}
