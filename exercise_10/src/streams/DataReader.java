package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ex11.streams.Token;

public class DataReader {
	public static List<Token> readTokensFromFile(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filename));
		
		List<Token> tokens = new ArrayList<>();
		
		for (String line : lines) {
			if (!line.isEmpty()) {
				String[] splitted = line.split("\t");
				Token t = new Token(splitted[0], splitted[1], splitted[2], Double.parseDouble(splitted[3]));
				tokens.add(t);
			}
		}
		
		return tokens;
	}
	
	public static void main(String[] args) throws IOException {

		List<Token> tokens = readTokensFromFile("schachnovelle.corpus");
		
		// implement stream computations here
		List<Token> namedEntityTokens = tokens.stream().filter(t -> t.getNamedEntityType() != "NONE").collect(Collectors.toList());

    //List<Token> distinctPosTokens = tokens.stream().distinct()

    Stream<String> charStream = tokens.stream().map(t -> t.getContent()).flatMap(s -> Stream.of(s.split("")));
    Stream<String> distinctCharStream = charStream.distinct();
	}
}
