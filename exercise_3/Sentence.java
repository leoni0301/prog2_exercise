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
            return tokens.length;
        }

        // Instanzmethode getToken
        public String getToken(int i) {
            String token = "";
            for (int j = 0; j < tokens.length; j++) {
                token += tokens[i];
                break;
            }
            return token;
        }

        // Instanzmethode setToken
        private void setToken(int i, String t){
            for (int j = 0; j < this.tokens.length; j++) {
                String token = this.tokens[i]; // Token at the position i
                String sent = Arrays.toString(this.tokens);
                String newSent = sent.replace(token,t);
                System.out.println("Das Wort \"" + token + "\" wird durch \"" + t + "\" ersetzt: " + newSent);
                break;
            }
        }

         // Instanzmethode equals
        private boolean equals(Sentence otherSent){

            Arrays.sort(this.tokens);
            Arrays.sort(otherSent.tokens);

            boolean status = Arrays.equals(this.tokens, otherSent.tokens);
            return status;
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a sentence: ");
            String[] tokens1 = scanner.nextLine().split(" ");
            // System.out.println("Enter a sentence: ");
            // String[] tokens2 = scanner.nextLine().split(" ");
            scanner.close();

            // create instances
            Sentence Sent = new Sentence(tokens1);
            String [] newSent = new String[] {"Das", "ist", "ein", "Satz"};
            Sentence otherSent = new Sentence(newSent);

            // Example: Der Mann hat angerufen, der gestern da war.
            // Aufruf: Instanzmethode length
            System.out.println("Der Satz beinhaltet " + Sent.length() + " Wörter.");
            // Aufruf: Instanzmethode getToken
            System.out.println("Das Wort \"" + Sent.getToken(1) + "\" befindet sich an der gesuchten Stelle.");
            // Aufruf: Instanzmethode setToken
            Sent.setToken(2, "Hallo");
            // Aufruf: Instanzmethode equals
            System.out.println("Sind die Sätze äquivalent? " + Sent.equals(otherSent));

    }
}
