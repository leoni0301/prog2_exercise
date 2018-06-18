package graphs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GraphTester {
    public static void main(String[] args) throws IOException, InvalidNodeException {
        String filename = "./example_graph.txt";

        //Graph withAdjacencyMatrix = new GraphWithAdjacencyMatrix(filename);
        Graph withAdjacencyList = new GraphWithAdjacencyList(filename);
        
        List<Graph> graphs = new ArrayList<>();
        List<String> names = new ArrayList<>();
        
        //graphs.add(withAdjacencyMatrix);
        graphs.add(withAdjacencyList);
        
        names.add("adjacency matrix");
        names.add("adjacency list");
        
        for (int i = 0; i < 1; i++) {
            Graph g = graphs.get(i);
            String name = names.get(i);
            
            // now a few example tests
            System.out.println("Some tests for " + name + " implementation");

            System.out.println("contains edge between Berg and Mount_Everest (should be true): " + g.containsEdge("Berg", "Mount_Everest"));
            System.out.println("contains edge between Mount_Everest and Berg (should be false): " + g.containsEdge("Mount_Everest", "Berg"));
            System.out.println("contains edge between Berg and Himalaya (should be false): " + g.containsEdge("Berg", "Himalaya"));
            
            System.out.println();
        }       
    }
}
