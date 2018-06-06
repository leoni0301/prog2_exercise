package models.nGram;

import data.NGram;
//import models.RandomSelector;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class NGramModel {

    Logger log = Logger.getGlobal();
    private int n;
    private Map<NGram, Integer> counts = new HashMap<>();
    private NGramModel subModel;


    public NGramModel(int n) {
        log.info("Constructing NGramModel:"+n);
        this.n = n;

	// (2c)
	// your implementation
	// here

    }

    public void train(ArrayList<String[]> corpus) {
        log.info("training NGramModel: "+this.n);
        if (this.subModel != null) {
            this.subModel.train(corpus);
        }

        for (String[] s : corpus) {
            addNGrams(s);
        }
    }

    private void addNGrams(String[] input) {

        NGram nGram = new NGram(input);
        if (!counts.containsKey(nGram)){
            counts.put(nGram, 1);
        } else {
            counts.put(nGram, counts.get(nGram) + 1);
        }
    }


    public void save(String filename) throws IOException {
	// (2c)
	// your implementation
	// here
        filename += this.n;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));

        for (Map.Entry<NGram, Integer> entry : this.counts.entrySet()) {
            bw.write(entry.getKey().toString()+"\t"+entry.getValue()+"\n");
        }

        bw.close();


    }

    public void load(String filename) throws IOException {
	// (2b)
	// your implementation
	// here
    }
}
