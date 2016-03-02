package ru.ratauth.entities;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mgorelikov
 * @since 02/11/15
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentityProvider {
  /**
   * unique primary key
   */
  private String id;
  /**
   * unique name
   */
  private String name;
}
