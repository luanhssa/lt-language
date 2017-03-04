package lexicon;

import static lexicon.TCategory.MAIN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class LexicalAnalyzer {
	
	private List<String> lines;
	private String filepath;
	private int currLine, currColumn;
	private String line;
	private final char LINE_BREAK = System.getProperty("line.separator").charAt(0);
	
	public LexicalAnalyzer(String filepath) {
		this.lines = new ArrayList<String>();
		this.filepath = filepath;
	}
	
	/**
	 * reads the file and converts its lines to a list
	 */
	public void readFile() {
		try(Stream<String> stream = Files.lines(Paths.get(filepath))) {
			lines = stream.collect(Collectors.toList());
		} catch(IOException e) {
			e.printStackTrace();
		}
		currLine = 0;
		currColumn = 0;
	}
	
	/**
	 * checks if it has more tokens
	 * @return true of false
	 */
	public boolean hasNext() {
		if(!lines.isEmpty() && currLine < lines.size()) {
			line = lines.get(currLine);
			line = line.replace('\t', ' ');
			
			if(isWhitespace(line.substring(currColumn))) {
				currLine++;
				currColumn = 0;
				while(currLine < lines.size()) {
					line = lines.get(currLine);
					if(isWhitespace(line)) {
						currLine++;
					} else {
						return true;
					}
				}
			} else if(currColumn < line.length()){
				return true;
			} else {
				System.out.println(line);
				currLine++;
				currColumn = 0;
				while(currLine < lines.size()-1) {
					line = lines.get(currLine);
					if(isWhitespace(line)) {
						currLine++;
					} else {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * checks if the given string has white spaces
	 * @param string the string that needs to check
	 * @return true if found a whitespace at the beginning of the given string
	 */
	private boolean isWhitespace(String string) {
		return string.matches("\\s*");
	}
	
	/**
	 * Skip all white spaces and tabs until it finds a character
	 */
	public void skipWhitspaces() {
		String line =  lines.get(currLine);
		while(line.charAt(currColumn) == ' ' || line.charAt(currColumn) == '\t') {
			if(currColumn < line.length()) {
				currColumn++;
			} else {
				if(currLine < lines.size()) {
					currLine++;
					line = lines.get(currLine);
				}
			}
		}
	}

	private boolean isDigit(char c) {
		return Character.toString(c).matches("\\d");
	}
	
	private char nextChar() {
		currColumn++;
		
		if(currColumn < line.length()) {
			return line.charAt(currColumn);
		} else {
			return LINE_BREAK;
		}
	}
	
	/**
	 * reads the lines to find a token and returns it
	 * @return the token
	 */
	public Token nextToken() {
		//TODO
		char currChar;
		String tValue = "";
		Token token = null;
		
		if(currLine >= lines.size())
			return token;
		
		skipWhitspaces();
		
		currChar = line.charAt(currColumn);

		// Gets digit tokens (int, float, double)
		if(isDigit(currChar)) {
			tValue += currChar;
			currChar = nextChar();
			while(isDigit(currChar)) {
				tValue += currChar;
				currChar = nextChar();
			}
			if(currChar == '.') {
				tValue += currChar;
				currChar = nextChar();
				while(isDigit(currChar)) {
					tValue += currChar;
					currChar = nextChar();
				}
			}
			
		}
		if(tValue == "") {
			switch(currChar) {
			case '"':			// Cchar token
				//TODO
				break;
			case '/':			// division token (/, /=)
				//TODO
				break;
			case '<':			// less then token (<, <=)
				//TODO
				break;
			case '>':			// bigger then token (>, >=)
				//TODO
				break;
			case '=':			// assignment or comparison token (=, ==)
				//TODO
				break;
			case '+':			// plus token (+, +=)
				//TODO
				break;
			case '*':			// multiply token (*, *=)
				//TODO
				break;
			case '(':
				//TODO
				break;
			case ')':
				//TODO
				break;
			case '[':
				//TODO
				break;
			case ']':
				//TODO
				break;
			}
		}
		
		
/*
		line = lines.get(currLine);
		currChar = line.charAt(currColumn); 
		while(currChar != ' ') {
			if(currColumn < line.length()) {
				tValue += line.substring(currColumn, currColumn+1);
				currColumn++;
				if(currColumn >= line.length()) {
					break;
				}
				currChar = line.charAt(currColumn);
			} else {
				if(currLine < lines.size()) {
					currLine++;
					line = lines.get(currLine);
					currColumn = 0;
				}
				break;
			}
		}
*/
		
		token = new Token(tValue, currLine+1, currColumn-tValue.length()+1);
		currColumn++;
		return token;
	}
	
	public static void main(String[] args) {
		// TEST
		LexicalAnalyzer la = new LexicalAnalyzer("./example/helloworld.lt");
		la.readFile();
		Token token;
		while(la.hasNext()) {
			token = la.nextToken();
			if(token != null) {
				System.out.println(token);
			}
		}
	}
}
