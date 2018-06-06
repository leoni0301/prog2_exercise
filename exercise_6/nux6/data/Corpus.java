package data;

import io.CorpusReader;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Corpus {

  /* An ArrayList of String-Arrays. Each String-Array is a tokenized sentence*/
  private ArrayList<String[]> content;

  private Corpus(ArrayList<String[]> content) {
    this.content = content;
  }

  public Corpus(String filename) throws IOException {
    this.load(filename);
  }

  public static Corpus readCorpusFromFile(String filename) {
    // we get a list of sentence strings from a method
    // of the CorpusReader class.
    ArrayList<String> content = CorpusReader.readCorpus(filename);

    ArrayList<String[]> sentences = new ArrayList<>();
    for (String i : content) {
      String trimmed = i.trim();
      if (!trimmed.equals("")) {
        sentences.add(trimmed.split(" "));
      }
    }

    return new Corpus(sentences);
  }

  /* load a  stored corpus. each line is a sentence. the words in each
  sentence are tab-separated (see split)*/
  private void load(String filename) throws IOException {
    Path p1 = Paths.get(filename);
    Charset charset = Charset.defaultCharset();
    BufferedReader br = Files.newBufferedReader(p1, charset);

    this.content = new ArrayList<>();

    String line = null;
    while ((line = br.readLine()) != null) {
      String trimmed = line.trim();
      if (!trimmed.equals("")){
        this.content.add(trimmed.split("\t"));
      }
    }

    br.close();
  }

  /*when writing, separate each word in a sentence array by tabs*/
  public void save(String filename) throws IOException {
    Path p1 = Paths.get(filename);
    BufferedWriter bw = Files.newBufferedWriter(p1, Charset.forName("UTF-8"));

    for (String[] s : this.content) {
      bw.write(String.join("\t", s) + "\n");
    }

    bw.close();
  }

  public ArrayList<String[]> getCorpus() {
    return this.content;
  }
}
