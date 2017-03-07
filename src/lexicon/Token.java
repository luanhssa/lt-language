package lexicon;

import static lexicon.LexicalTable.*;

/**
 * 
 * @author luan
 */
public class Token {
	private final TCategory token;
	private final String value;
	private int line;
	private int column;
	
	public Token(TCategory token, String value, int line, int column) {
		this.token = token;
		this.value = value;
		this.line = line;
		this.column = column;
	}
	
	public Token(String value, int line, int column) {
		this.token = AnalyzeCategory(value);
		this.value = value;
		this.line = line;
		this.column = column;
	}
	
	public static TCategory AnalyzeCategory(String value) {
		TCategory tc = null;
		
		if(value.charAt(0) == '"') {
			tc = lexemeMap.get("\"");
			
		} else if(value.charAt(0) == '\'') {
			tc = lexemeMap.get("\'");
			
		} else if(isLexem(value)) {
			tc = lexemeMap.get(value);
			
		} else if(value.matches("[+-]?([0-9]*[.])?[0-9]+")) {
			tc = lexemeMap.get("id");
			
		} else if(value.matches("\\w+")) {
			tc = TCategory.VARIABLE;
			
		} else {
			tc = TCategory.UNKNOWN;
		}
		
		return tc;
	}
	
	
    @Override
    public String toString() {
        return "<" + this.line + "," + this.column + "> " + this.token + " = '" + this.value + "'";
    }
}
