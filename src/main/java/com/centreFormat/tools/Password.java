package com.centreFormat.tools;
import org.mindrot.jbcrypt.BCrypt;

public class Password {
	
	private String pswd;
	private String hashAndSalt;
	
	static public String hashMe(String pswdToHash) {
		return BCrypt.hashpw(pswdToHash, BCrypt.gensalt(12));
	}

	public Password(String pswd) {
		this.pswd = pswd;
	}
	
	/***
	 * Premier hash à réaliser.
	 * Initialise hashAndSalt. 
	 * @author Runolf
	 * @return hashAndSalt : password hashé et salé
	 */
	public String firstHash() {
		return hashAndSalt = BCrypt.hashpw(pswd, BCrypt.gensalt(12));
	}
	
	public void setHash(String h) {
		hashAndSalt = h;
	}
	
	public String getHash() {
		return hashAndSalt;
	}
	
	
	public boolean isCorrect() {
		if(BCrypt.checkpw(pswd, hashAndSalt)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
