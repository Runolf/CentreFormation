package com.centreFormat.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.centreFormat.repository.StagiairesRepository;
import com.centreFormat.models.Stagiaires;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	  @Autowired
	  StagiairesRepository SR;
		
	  
	  @Override 
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    
		  //User du modèle
		  Optional<Stagiaires> user = SR.findByEmail(email);
		    
		  //User Spring security vide.
		  Optional<JwtUserDetails> userDetails = Optional.empty();

		  
		  //User du modèle transformé en user de Spring Security (JWT User Detailsl)
		  if(user.isPresent()) {
			  //Have to find the statut. Statut = role
			  userDetails = Optional.of(new JwtUserDetails(user.get().getIdStagiaire(),user.get().getEmail(),user.get().getPassword()));
			  																															//user.get().getUserRole()
		  }
		  
		  //Erreur si login n'existe pas
		  if (!userDetails.isPresent()) {
			  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", email));
		  }

		  return userDetails.get();
	  }
}
