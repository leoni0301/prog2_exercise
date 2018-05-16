import java.util.Arrays;
import java.util.Scanner;

public class TokenSentence {

	// Instanzvariable vom Typ String-Array
	private Token[] tokens;

	// Konstruktor
	TokenSentence ( Token[] tokens ){
		this.tokens = tokens;
	}

	// Instanzmethode length
	private int length(){
		return this.tokens.length; 
	}

	// Instanzmethode getToken
	public Token getToken(int i) {
		return this.tokens[i];	
	}

	// Instanzmethode setToken
	private void setToken(int i, Token t){
		this.tokens[i] = t;	
	}
	

	// Instanzmethode equals
//Instanzmethode equals
	public boolean equals(TokenSentence otherSent){
		
		if(otherSent.length() != this.length()) {
			return false;
		}else {
			for(int i=0; i < this.length();i++) {
				if(this.getToken(i).equals(otherSent.getToken(i)) == false){
					return false;
				}
			}
			return true;
		}
	}

	
	public static void main(String[] args) {

		// create instances
		Token Token1 = new Token(1,"Der","der","ART",2,"NK");
		Token Token2 = new Token(2,"Mann", "Mann","NN",3,"SB");
		Token Token3 = new Token(3,"hat", "haben", "VAFIN", 0,"");
		Token[] firstSent = new Token[] {Token1, Token2, Token3};
		Token[] secondSent = new Token[] {Token1, Token2, Token3};
		TokenSentence Sent = new TokenSentence(firstSent);
		TokenSentence otherSent = new TokenSentence(secondSent);

		// Aufruf: Instanzmethode length
		System.out.println("Der Satz beinhaltet " + Sent.length() + " Wörter.");
		// Aufruf: Instanzmethode equals
		System.out.println("Sind die Sätze äquivalent? " + Sent.equals(otherSent));
		// Aufruf: Instanzmethode setToken
		Sent.setToken(0, Token3);
		// Erneutes prüfen auf equality
		System.out.println("Sind die Sätze äquivalent? " + Sent.equals(otherSent));
	}
}