import java.util.Arrays;

public class Sentence {

  // Instanzvariable vom Typ String-Array
  private String[] tokens;

  // Konstruktor
  Sentence(String[] tokens) {
    this.tokens = tokens;
  }

  // Instanzmethode length
  public int length() {
    return this.tokens.length;
  }

  // Instanzmethode getToken
  public String getToken(int i) {
    return this.tokens[i];
  }

  // Instanzmethode setToken
  public void setToken(int i, String t) {
    this.tokens[i] = t;
  }


  // Instanzmethode equals
  public boolean equals(Sentence otherSent){

    return Arrays.equals(this.tokens, otherSent.tokens);
  }
}