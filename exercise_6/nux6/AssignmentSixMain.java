import data.Corpus;
import models.nGram.NGramModel;

//import models.nGram.SentenceLengthModel;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentSixMain {
  static Logger log = Logger.getGlobal();

  private static void testCorpus_readCorpusFromFile() {
//    Path currentRelativePath = Paths.get("");
//    String s = currentRelativePath.toAbsolutePath().toString();
//    System.out.println("Current relative path is: " + s);

    Corpus corpus = Corpus.readCorpusFromFile("nux6/de.txt");
  }

  public static void main(String[] args) throws IOException {

    testCorpus_readCorpusFromFile();

//    log.setLevel(Level.INFO);
//    String corpus_file = args[0] + "/corpus.save";
//    boolean corpus_init = true;
//
//    int n = 5;
//
//    Corpus corpus;
//
//    NGramModel ngrammodel = new NGramModel(n);
//
//    if (corpus_init) {
//      log.info("reading corpus");
//      corpus = Corpus.readCorpusFromFile(args[0] + "/de.txt");
//
//      log.info("saving corpus to file");
//      corpus.save(corpus_file);
//
//      log.info("train word ngram model");
//      ngrammodel.train(corpus.getCorpus());
//
//      log.info("saving word ngram model");
//      ngrammodel.save(args[0] + "/ngrammodel");
//
//
//    } // we load prepared data
//    else {
//      log.info("loading stuff  from file");
//      ngrammodel.load(args[0] + "/ngrammodel");
//      //sl.load(args[0]+"/slmodel");
//
//    }
  }
}
