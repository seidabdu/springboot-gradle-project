//package com.acid.aig.traning.aigtraning.api.entity;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import org.apache.commons.lang3.builder.ToStringBuilder;
//
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
///**
// * A collection of {@link Policy}s
// * @author Eric Deandrea February 2017
// */
//@SuppressWarnings("serial")
//@JacksonXmlRootElement(localName = "Policies")
//@ApiModel(description = "A collection of policies")
//public class Policies implements Serializable {
//  @JacksonXmlElementWrapper(localName = "PolicyList")
//  @JacksonXmlProperty(localName = "Policy")
//  @ApiModelProperty(required = true, value = "The list of policies")
//  private final List<Policy> policyList = new ArrayList<>();
//
//  public Policies() {
//    super();
//  }
//
//  public Policies(Collection<Policy> policies) {
//    this();
//    addPolicies(policies);
//  }
//
//  public Policies(Policy... policies) {
//    this();
//    addPolicies(policies);
//  }
//
//  /**
//   * Gets the number of policies
//   * @return The number of policies
//   */
//  @ApiModelProperty(readOnly = true, value = "The number of policies")
//  public int getNumPolicies() {
//    return this.policyList.size();
//  }
//
//  /**
//   * Gets the list of {@link Policy}s
//   * @return The list of {@link Policy}s (wrapped in {@link Collections#unmodifiableList(List)})
//   */
//  public List<Policy> getPolicyList() {
//    return Collections.unmodifiableList(this.policyList);
//  }
//
//  /**
//   * Adds policies
//   * @param policies The policies to add
//   */
//  public void addPolicies(Collection<Policy> policies) {
//    this.policyList.addAll(Optional.ofNullable(policies).orElseGet(Collections::emptyList));
//  }
//
//  /**
//   * Adds policies
//   * @param policies The policies to add
//   */
//  public void addPolicies(Policy... policies) {
//    this.policyList.addAll(Optional.ofNullable(policies).map(Arrays::asList).orElseGet(Collections::emptyList));
//  }
//
//  /**
//   * Clears the policies
//   */
//  public void clearPolicies() {
//    this.policyList.clear();
//  }
//
//  @Override
//  public String toString() {
//    return ToStringBuilder.reflectionToString(this);
//  }
//}
