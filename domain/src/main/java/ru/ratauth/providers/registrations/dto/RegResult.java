package ru.ratauth.providers.registrations.dto;

import lombok.*;

import java.util.Map;

/**
 * @author mgorelikov
 * @since 28/01/16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegResult {
  private Status status;
  private Map<String, Object> data;//login

  public enum Status {
    SUCCESS,
    FAILED,
    NEED_APPROVAL
  }
}
