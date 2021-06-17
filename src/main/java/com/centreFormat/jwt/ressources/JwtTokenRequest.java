package com.centreFormat.jwt.ressources;

import java.io.Serializable;

/**
 * Construit l'objet Token jwt avec le username et le password de l'user.  
 * Attention que les params utilisés dans le constructeur sont les mots 
 * à utiliser en json dans postman ou angular. 
 * @param username et password
 * @author Runolf
 *
 */
public class JwtTokenRequest implements Serializable{
	private static final long serialVersionUID = -5616176897013108345L;
	
	private String email;
	private String pass;
	
    public JwtTokenRequest() {
        super();
    }

	public JwtTokenRequest(String email, String pass) { // params = postman
		super();
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
    
    
	
}
