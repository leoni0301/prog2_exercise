import java.util.Arrays;
import java.util.Scanner;

public class TokenSentence {

	// Instanzvariable vom Typ Token-Array
	private Token[] tokens;

	// Konstruktor
	public TokenSentence ( Token[] tokens ){
		this.tokens = tokens;
	}

	// Instanzmethode length
	public int length(){
		return this.tokens.length; 
	}

	// Instanzmethode getToken
	public Token getToken(int i) {
		return this.tokens[i];	
	}

	// Instanzmethode setToken
	public void setToken(int i, Token t){
		this.tokens[i] = t;	
	}
	

	// Instanzmethode equals
	public boolean equals(TokenSentence otherSent){
		//ungleich bei verschiedener Länge
		if(otherSent.length() != this.length()) {
			return false;
		}else {
			//Vergleich von jedem Token mit Token.equals()
			for(int i=0; i < this.length();i++) {
				if(this.getToken(i).equals(otherSent.getToken(i)) == false){
					return false;
				}
			}
			return true;
		}
	}
}
