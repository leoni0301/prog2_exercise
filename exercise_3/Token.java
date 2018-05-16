public class Token {
        
        // Instanzvariablen
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
        
       // Instanzmethode equals
        private boolean equals(Token token) {

            boolean status1 = this.surface.equals(token.surface);
            boolean status2 = this.lemma.equals(token.lemma);
            boolean status3 = this.pos.equals(token.pos);
            return status1 && status2 && status3;
        }

}
