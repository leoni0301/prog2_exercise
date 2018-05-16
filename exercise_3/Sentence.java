import java.util.Arrays;
import java.util.Scanner;

public class Sentence {

	// Instanzvariable vom Typ String-Array
	private String[] tokens;

	// Konstruktor
	Sentence ( String[] tokens ){
		this.tokens = tokens;
	}

	// Instanzmethode length
	private int length(){
		return this.tokens.length; 	//Was ist hier der Unterschied zwischen tokens.length und this.tokens.length?
	}

	// Instanzmethode getToken
	public String getToken(int i) {
		return this.tokens[i];			//Vereinfacht
	}

	// Instanzmethode setToken
	private void setToken(int i, String t){
		this.tokens[i] = t;					//Alte Methode hat nicht das eigentliche Sentence-Objekt editiert
	}
	

	// Instanzmethode equals
	private boolean equals(Sentence otherSent){
		
		//So weit ich die Aufgabe lese sollen die Sätz nicht sortiert werden
		boolean status = Arrays.equals(this.tokens, otherSent.tokens);
		return status;
	}

	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String[] tokens1 = scanner.nextLine().split(" ");
		scanner.close();

		// create instances
		Sentence Sent = new Sentence(tokens1);
		String [] newSent = new String[] {"Das", "ist", "ein", "Satz"};
		Sentence otherSent = new Sentence(newSent);

		// Aufruf: Instanzmethode length
		System.out.println("Der Satz beinhaltet " + Sent.length() + " Wörter.");
		// Aufruf: Instanzmethode getToken
		System.out.println("Das Wort \"" + Sent.getToken(0) + "\" befindet sich an der gesuchten Stelle.");
		// Aufruf: Instanzmethode equals
		System.out.println("Sind die Sätze äquivalent? " + Sent.equals(otherSent));
		// Aufruf: Instanzmethode setToken
		Sent.setToken(2, "Hallo");
		// Erneutes prüfen auf equality
		System.out.println("Sind die Sätze äquivalent? " + Sent.equals(otherSent));
	}
}