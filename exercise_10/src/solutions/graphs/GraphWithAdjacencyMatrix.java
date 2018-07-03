package solutions.graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GraphWithAdjacencyMatrix implements Graph {
    private int[][] adjacencyMatrix;
    private HashMap<String, Integer> nodeToIndexMap = new HashMap<>();
    private ArrayList<String> indexToNodeMap = new ArrayList<>();
    
    public GraphWithAdjacencyMatrix(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
                
        String[] nodes = lines.get(0).split(" ");

        adjacencyMatrix = new int[nodes.length][nodes.length];
        
        for (String node : nodes) {
            addNode(node);
        }

        for (String edge : lines.subList(1, lines.size())) {
            String[] splitted = edge.split(" ");
            String sourceNode = splitted[0];
            String targetNode = splitted[1];
            
            try {
				addEdge(sourceNode, targetNode);
			} catch (InvalidNodeException e) {
				// We know this never gets called, because we just added all nodes
				// to the graph
				e.printStackTrace();
			}
        }
    }
    
    @Override
    public boolean containsEdge(String sourceNode, String targetNode) throws InvalidNodeException {
        if (!nodeToIndexMap.containsKey(sourceNode)) {
            throw new InvalidNodeException("");
        }

        int sourceIdx = nodeToIndexMap.get(sourceNode);
        int targetIdx = nodeToIndexMap.get(targetNode);

        if (adjacencyMatrix[sourceIdx][targetIdx] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public Collection<String> getNeighbours(String node) throws InvalidNodeException {
        if (!nodeToIndexMap.containsKey(node)) {
            throw new InvalidNodeException("");
        }
        
        int sourceIdx = nodeToIndexMap.get(node);
        
        List<String> neighbours = new ArrayList<>();
        
        for (int j = 0; j < nodeToIndexMap.size(); j++) {
            if (adjacencyMatrix[sourceIdx][j] == 1) {
                neighbours.add(indexToNodeMap.get(j));
            }
        }
        
        return neighbours;
    }

    @Override
    public boolean addEdge(String sourceNode, String targetNode) throws InvalidNodeException {
        if (!nodeToIndexMap.containsKey(sourceNode) || ! nodeToIndexMap.containsKey(targetNode)) {
            throw new InvalidNodeException("");
        }
        else {
        	Integer sourceIdx = nodeToIndexMap.get(sourceNode);
        	Integer targetIdx = nodeToIndexMap.get(targetNode);
            if (adjacencyMatrix[sourceIdx][targetIdx] == 1) {
            	return false;
            }
            else {
            	adjacencyMatrix[sourceIdx][targetIdx] = 1;
            	return true;            
            }       
        }
    }

    @Override
    public boolean addNode(String node) {      
        if (nodeToIndexMap.containsKey(node)) {
            return false;
        }
        
        int newIdx = indexToNodeMap.size();
        
        nodeToIndexMap.put(node, newIdx);
        indexToNodeMap.add(node);
        
        if (newIdx >= adjacencyMatrix.length) {
            int[][] newAdjacencyMatrix = new int[newIdx + 1][newIdx + 1];
            
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                for (int k = 0; k < adjacencyMatrix.length; k++) {
                    newAdjacencyMatrix[j][k] = adjacencyMatrix[j][k];
                }
            }
            
            adjacencyMatrix = newAdjacencyMatrix;    
        }
        return true;

    }
}
