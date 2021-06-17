package com.centreFormat.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUserDetails implements UserDetails  {
	  private static final long serialVersionUID = 5155720064139820502L;

	  private final int id;
	  private final String email;
	  private final String pass;
	  
	  //pour la gestion des rôles
	  //private final Collection<? extends GrantedAuthority> authorities;
	  
	  public JwtUserDetails(int id, String email, String pass) {
		    this.id = id;
		    this.email = email;
		    this.pass = pass;

		   // List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		    
		    /*
		    String[] roles = role.split(",");
		    for(String r:roles) {
		    	authorities.add(new SimpleGrantedAuthority(r));
		    }

		    this.authorities = authorities;
		    */
		  }
	  
	  @JsonIgnore
	  public int getId() {
	    return id;
	  }

	  @Override
	  public String getUsername() {
	    return email;
	  }

	  @JsonIgnore
	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @JsonIgnore
	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @JsonIgnore
	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @JsonIgnore
	  @Override
	  public String getPassword() {
	    return pass;
	  }

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
		  return null;
		  //return authorities;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }
}
