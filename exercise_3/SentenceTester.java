public class SentenceTester {

  private static void testSentence(){

    // create instances
    String[] firstSent = new String[]{"Der", "Mann", "hat"};
    String[] secondSent = new String[]{"Der", "Mann", "hat"};
    Sentence sent = new Sentence(firstSent);
    Sentence otherSent = new Sentence(secondSent);

    // Aufruf: Instanzmethode length
    System.out.println("Der Satz beinhaltet " + sent.length() + " Wörter.");
    // Aufruf: Instanzmethode equals
    System.out.println("Sind die Sätze äquivalent? " + sent.equals(otherSent));
    // Aufruf: Instanzmethode setToken
    sent.setToken(1, "Hund");
    // Erneutes prüfen auf equality
    System.out.println("Sind die Sätze äquivalent? " + sent.equals(otherSent));
  }

  private static void testTokenSentence() {
    // create instances
    Token Token1 = new Token(1, "Der", "der", "ART", 2, "NK");
    Token Token2 = new Token(2, "Mann", "Mann", "NN", 3, "SB");
    Token Token3 = new Token(3, "hat", "haben", "VAFIN", 0, "");
    Token[] firstSent = new Token[]{Token1, Token2, Token3};
    Token[] secondSent = new Token[]{Token1, Token2, Token3};
    TokenSentence sent = new TokenSentence(firstSent);
    TokenSentence otherSent = new TokenSentence(secondSent);

    // Aufruf: Instanzmethode length
    System.out.println("Der Satz beinhaltet " + sent.length() + " Wörter.");
    // Aufruf: Instanzmethode equals
    System.out.println("Sind die Sätze äquivalent? " + sent.equals(otherSent));
    // Aufruf: Instanzmethode setToken
    sent.setToken(0, Token3);
    // Erneutes prüfen auf equality
    System.out.println("Sind die Sätze äquivalent? " + sent.equals(otherSent));
  }

  public static void main(String[] args) {

    //testSentence();

    testTokenSentence();
  }
}
