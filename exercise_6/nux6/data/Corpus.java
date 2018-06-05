package data;

import io.CorpusReader; // (1b)
import java.io.*;	// (1b)


import java.util.ArrayList;

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
	// (1a)
	// your
	// implementation
	// here
    
    }



    /* load a  stored corpus. each line is a sentence. the words in each
    sentence are tab-separated (see split)*/
    private void load(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
        this.content = new ArrayList<>();

        String line = null;
        while ((line = br.readLine()) != null) {
            this.content.add(line.split("\t"));
        }
        br.close();
    }

    /*when writing, separate each word in a sentence array by tabs*/
    public void save(String filename) throws IOException {
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
