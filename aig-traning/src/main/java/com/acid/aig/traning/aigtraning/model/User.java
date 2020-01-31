package com.acid.aig.traning.aigtraning.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class User {
	@Id
	private String employeeId;
  private String lanId;

  @Column(unique = true, nullable = false)
  @Email(message = "Invalid email address specified")
  private String emailAddress;
  private boolean enabled;

  @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "users_and_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  public String getEmployeeId() {
  		return this.employeeId;
  }

  public void setEmployeeId(String employeeId) {
  		this.employeeId = employeeId;
  }

  public String getLanId() {
    return this.lanId;
  }

  public void setLanId(String lanId) {
    this.lanId = lanId;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Set<Role> getRoles() {
    return this.roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.employeeId);
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

    User rhs = (User) obj;
    return new EqualsBuilder().append(this.employeeId, rhs.employeeId).isEquals();
  }
}
