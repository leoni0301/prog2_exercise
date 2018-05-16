public class Token {

        int id; // Position im Satz
        String surface; // orthographischen Wortform
        String lemma; // Grundform des Tokens
        String pos; // Wortart
        int head; // Kopf eines Wortes
        String rel; // Art der Beziehung zwischen Abhaengigem und Kopf


        // Konstruktor
        Token ( int id, String surface, String lemma, String pos, int head, String rel ){

            this.id = id;
            this.surface = surface;
            this.lemma = lemma;
            this.pos = pos;
            this.head = head;
            this.rel = rel;

        }
        
        //ist jetzt auf this bezogen
        private boolean equals(Token token2) {

            boolean status1 = this.surface.equals(token2.surface);
            boolean status2 = this.lemma.equals(token2.lemma);
            boolean status3 = this.pos.equals(token2.pos);
            return status1 && status2 && status3;
        }


    public static void main(String[] args) {

            Token token1 = new Token(1, "Mann", "Mann", "AR", 2, "NK");
            Token token2 = new Token(2, "Mann", "Mann", "NN", 3, "SB");
            // String [] Sent = new String[] {"Der", "Mann", "hat", "angerufen,", "der", "gestern", "da", "war"};
            System.out.println(token1.equals(token2));
        }

}