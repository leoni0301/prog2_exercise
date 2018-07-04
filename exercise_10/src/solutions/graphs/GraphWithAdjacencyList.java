package solutions.graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphWithAdjacencyList implements Graph {
    private Map<String, List<String>> adjacencyList = new HashMap<>();
    
    public GraphWithAdjacencyList(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        
        String[] nodes = lines.get(0).split(" ");
        
        for (String node : nodes) {
            addNode(node);
        }
        
        for (String edge : lines.subList(1, lines.size())) {
            String[] splitted = edge.split(" ");
            String sourceNode = splitted[0];
            String targetNode = splitted[1];
            
            adjacencyList.get(sourceNode).add(targetNode);
        }
    }
    
    @Override
    public boolean containsEdge(String sourceNode, String targetNode) throws InvalidNodeException {
        if (!adjacencyList.containsKey(sourceNode)) {
            throw new InvalidNodeException("");
        }        
        
        if (adjacencyList.get(sourceNode).contains(targetNode)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public Collection<String> getNeighbours(String i) throws InvalidNodeException {
        if (!adjacencyList.containsKey(i)) {
            throw new InvalidNodeException("");
        }        
        
        List<String> neighbours = adjacencyList.get(i);
        
        return neighbours;
    }

    @Override
    public boolean addEdge(String sourceNode, String targetNode) throws InvalidNodeException {
        if (!adjacencyList.containsKey(sourceNode) || !adjacencyList.containsKey(targetNode)) {
            throw new InvalidNodeException("");
        }        
        
        if (containsEdge(sourceNode, targetNode)) {
            return false;
        }
        else {
            adjacencyList.get(sourceNode).add(targetNode);

            return true;            
        }       
    }
    
    @Override
    public boolean addNode(String i) {

    	if (!adjacencyList.containsKey(i)) {
            adjacencyList.put(i, new ArrayList<String>());
            return true;
        }
        else {
            return false;
        }
    }           
}