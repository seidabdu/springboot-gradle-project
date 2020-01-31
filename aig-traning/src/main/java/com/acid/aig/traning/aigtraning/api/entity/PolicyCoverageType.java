package com.acid.aig.traning.aigtraning.api.entity;

import io.swagger.annotations.ApiModel;

/**
 * Defines different coverage types a policy could have
 * @author Eric Deandrea June 2017
 */
@ApiModel(description = "Different coverage types a policy could have")
public enum PolicyCoverageType {
  /**
   * All Coverage
   */
  ALL,
  
  /**
   * Some Coverage
   */
  SOME,
  
  /**
   * Only a little coverage
   */
  LITTLE;
}
