package lexicon;

import java.util.HashMap;
import java.util.Map;
import static lexicon.TCategory.*;

public class LexicalTable {

	public static Map<String, TCategory> lexemeMap = new HashMap<String, TCategory>();
	
	static {
		
		/******* Reserved Words ********/
		/*******************************/
		
		lexemeMap.put("main", MAIN);
		lexemeMap.put("id", ID);
		lexemeMap.put("void", TVOID);
		lexemeMap.put("int", TINT);
		lexemeMap.put("bool", TBOOL);
		lexemeMap.put("char", TCHAR);
		lexemeMap.put("cchar", TCCHAR);
		lexemeMap.put("dec", TDEC);
		lexemeMap.put("read", RWREAD);
		lexemeMap.put("print", RWPRINT);
		lexemeMap.put("if", RWIF);
		lexemeMap.put("else", RWELSE);
		lexemeMap.put("elseif", RWELSEIF);
		lexemeMap.put("iterator", RWIT);
		lexemeMap.put("do", RWDO);
		lexemeMap.put("while", RWWHILE);
		lexemeMap.put("return", RWRETURN);

		lexemeMap.put("True", CONSTBOOL);
		lexemeMap.put("False", CONSTBOOL);
		lexemeMap.put("and", OPBOOLAND);
		lexemeMap.put("or", OPBOOLOR);
		lexemeMap.put("not", OPBOOLNOT);
		lexemeMap.put("\"", CONSTCHAR);
		lexemeMap.put("\'", CONSTCHAR);
		
		/******* Operators *************/
		/*******************************/
		
		lexemeMap.put("+", OPARITADIT);
		lexemeMap.put("-", OPARITADIT);
		lexemeMap.put("*", OPARITMULT);
		lexemeMap.put("/", OPARITMULT);
		lexemeMap.put("^", OPARITEXP);
		lexemeMap.put("+", OPARITADIT);

		lexemeMap.put("<", OPREL);
		lexemeMap.put(">", OPREL);
		lexemeMap.put("<=", OPREL);
		lexemeMap.put(">=", OPREL);
		lexemeMap.put("==", OPREL);

		lexemeMap.put("=", OPATRIB);
		lexemeMap.put("+=", OPATRIBADIT);
		lexemeMap.put("/=", OPATRIBDIV);
		lexemeMap.put("-=", OPATRIBSUB);
		lexemeMap.put("*=", OPATRIBMULT);
		lexemeMap.put("++", OPCONC);
		
		/******* Delimiters ************/
		/*******************************/
		
		lexemeMap.put("(", PARAMBEGIN);
		lexemeMap.put(")", PARAMEND);
		lexemeMap.put("{", ESCBEGIN);
		lexemeMap.put("}", ESCEND);
		lexemeMap.put("[", ARRAYBEGIN);
		lexemeMap.put("]", ARRAYEND);
		lexemeMap.put("/#", COMMENT);
		lexemeMap.put("#/", COMMENT);
		lexemeMap.put("#", COMMENT);
		
		/******* Terminator ************/
		/*******************************/
		
		lexemeMap.put(";", TERM);
		
		/******* Separator *************/
		/*******************************/
		
		lexemeMap.put(",", SEP);
		
		// UNKNOWN TYPE
		lexemeMap.put("UNKNOWN", UNKNOWN);
		
	}
	
	public static boolean isLexem(String s) {
		return lexemeMap.containsKey(s);
	}
}
