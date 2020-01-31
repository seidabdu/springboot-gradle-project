package com.acid.aig.traning.aigtraning.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An API Entity class representing a Policy
 * @author Eric Deandrea June 2017
 */
@ApiModel(description = "A Policy")
@JacksonXmlRootElement(localName = "Policy")
@SuppressWarnings("serial")
public class Policy implements Serializable {
  @ApiModelProperty(name = "id", required = true, readOnly = true, value = "The policy id")
  @JsonProperty("id")
  @JacksonXmlProperty(localName = "id")
  private long policyId;

  @ApiModelProperty(required = true, readOnly = true, value = "The customer id")
  private long customerId;

  @ApiModelProperty("The name of the policy")
  @JacksonXmlCData
  private String policyName;

  @ApiModelProperty("The policy coverage limit")
  private BigDecimal coverageLimit;

  @ApiModelProperty("The type of coverage")
  private PolicyCoverageType coverageType;

  @ApiModelProperty("Attributes of the policy")
  private final Map<String, String> attributes = new HashMap<>();

  /**
   * Get the policy id
   * @return The policy id
   */
  public long getPolicyId() {
    return policyId;
  }

  /**
   * Sets the policy id
   * @param policyId The policy id
   */
  public void setPolicyId(long policyId) {
    this.policyId = policyId;
  }

  /**
   * Gets the customer id
   * @return The customer id
   */
  public long getCustomerId() {
    return customerId;
  }

  /**
   * Sets the customer id
   * @param customerId The customer id
   */
  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  /**
   * Gets the policy name
   * @return The policy name
   */
  public String getPolicyName() {
    return policyName;
  }

  /**
   * Sets the policy name
   * @param policyName The policy name
   */
  public void setPolicyName(String policyName) {
    this.policyName = policyName;
  }

  /**
   * Gets the coverage limit
   * @return The coverage limit
   */
  public BigDecimal getCoverageLimit() {
    return coverageLimit;
  }

  /**
   * Sets the coverage limit
   * @param coverageLimit The coverage limit
   */
  public void setCoverageLimit(BigDecimal coverageLimit) {
    this.coverageLimit = coverageLimit;
  }

  /**
   * Gets the {@link PolicyCoverageType}
   * @return The {@link PolicyCoverageType}
   */
  public PolicyCoverageType getCoverageType() {
    return coverageType;
  }

  /**
   * Sets the {@link PolicyCoverageType}
   * @param coverageType The {@link PolicyCoverageType}
   */
  public void setCoverageType(PolicyCoverageType coverageType) {
    this.coverageType = coverageType;
  }

  /**
   * Gets the attributes
   * @return The attributes
   */
  public Map<String, String> getAttributes() {
    return Collections.unmodifiableMap(this.attributes);
  }

  /**
   * Sets the attributes, over-writing any attributes that were previously stored
   * @param attributes The attributes
   */
  public void setAttributes(Map<String, String> attributes) {
    this.attributes.clear();
    addAttributes(attributes);
  }

  /**
   * Adds attributes to the existing attributes
   * @param attributes The attributes
   */
  public void addAttributes(Map<String, String> attributes) {
    if (attributes != null) {
      this.attributes.putAll(attributes);
    }
  }

  /**
   * Adds a single attribute
   * @param name The attribute name
   * @param value The attribute value
   */
  public void addAttribute(String name, String value) {
    if (StringUtils.isNotBlank(name)) {
      this.attributes.put(name, value);
    }
    else {
      this.attributes.remove(name);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.policyId);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj == this) {
      return true;
    }

    if (obj.getClass() != getClass()) {
      return false;
    }

    Policy rhs = (Policy) obj;
    return new EqualsBuilder().append(this.policyId, rhs.policyId).isEquals();
   }
}
