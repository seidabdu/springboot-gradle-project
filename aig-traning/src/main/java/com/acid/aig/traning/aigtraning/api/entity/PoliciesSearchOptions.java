package com.acid.aig.traning.aigtraning.api.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "Search options for policies")
public class PoliciesSearchOptions implements Serializable {
  @ApiModel(description = "Options defining the kind of fetching to do")
  public enum FetchType { ALL, ONLY_FOR_EXISTING_CUSTOMERS, SINGLE_CUSTOMER }
  
  @ApiModelProperty("The type of fetching to do")
  private FetchType fetchType = FetchType.ALL;
  
  @ApiModelProperty("The customer id to fetch")
  private long customerId = Long.MIN_VALUE;
  
  public FetchType getFetchType() {
    return fetchType;
  }
  
  public void setFetchType(FetchType fetchType) {
    this.fetchType = fetchType;
  }
  
  public long getCustomerId() {
    return customerId;
  }
  
  public void setCustomerId(long customerId) {
    if (customerId >= 0) {
      // If a customer id is set then switch our fetch type to SINGLE_CUSTOMER
      this.fetchType = FetchType.SINGLE_CUSTOMER;
      this.customerId = customerId;
    }
    else {
      this.customerId = Long.MIN_VALUE;
    }
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}