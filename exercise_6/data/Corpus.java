package data;

import io.CorpusReader; // (1b)
import java.io.*;	// (1b)

// repräsentiert ein Korpus, aus dem n-Gramme extrahiert werden können

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Corpus {

    /* An ArrayList of String-Arrays. Each String-Array is a tokenized sentence*/
    private ArrayList<String[]> content;

    private Corpus(ArrayList<String[]> content){

        this.content = content;
    }

    public Corpus(String filename) throws IOException {
        this.load(filename);
    }

    public static Corpus readCorpusFromFile(String filename) {
        // we get a list of sentence strings from a method
	// of the CorpusReader class.
        ArrayList<String> content = CorpusReader.readCorpus(filename);

        ArrayList<String[]> tokenizeSent = new ArrayList<>();
        for (String i : content) {
            if (!i.isEmpty()){
                String[] newarr = i.split(" ");
                tokenizeSent.add( newarr );
            }
        }
        return new Corpus(tokenizeSent);
    }



    /* load a  stored corpus. each line is a sentence. the words in each
    sentence are tab-separated (see split)*/
    private void load(String filename) throws IOException {

        Path p = Paths.get(filename);
        this.content = new ArrayList<>();
        List<String> myLines = Files.readAllLines(p);
        for (String line : myLines) {
            this.content.add(line.split("\t"));
            }
    }

    /*when writing, separate each word in a sentence array by tabs*/
    public void save(String filename) throws IOException {

//        Path op = Paths.get(filename);
//        Charset cs = Charset.forName ( "UTF−8" ) ;
//
//        for (String[] s : this.content) {
//
//
//            Files.write(op, String.join("\t", s) + "\n" , cs, StandardOpenOption.CREATE_NEW);
//
//        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));

        for (String[] s : this.content) {
            bw.write(String.join("\t", s)+"\n");
        }

        bw.close();
    }

    public ArrayList<String[]> getCorpus() {
        return this.content;
    }
}

