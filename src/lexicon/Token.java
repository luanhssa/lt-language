package lexicon;


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
		//TODO
		return null;
	}
	
	
    @Override
    public String toString() {
        return "<" + this.line + "," + this.column + "> " + this.token + " = '" + this.value + "'";
    }
}
