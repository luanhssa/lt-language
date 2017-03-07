package lexicon;

public enum TCategory {
	
	MAIN(1),
	ID(2),
	TVOID(3),
	TINT(4),
	TLONG(5),
	TBOOL(6),
	TCHAR(7),
	TCCHAR(8),
	TDEC(9),
	ESCBEGIN(10),
	ESCEND(11),
	PARAMBEGIN(12),
	PARAMEND(13),
	ARRAYBEGIN(14),
	ARRAYEND(15),
	COMMENT(16),
	TERM(17),
	SEP(18),
	CONSTINT(19),
	CONSTDEC(20),
	CONSTBOOL(21),
	CONSTCHAR(22),
	CONSTCCHAR(23),
	RWREAD(24),
	RWPRINT(25),
	RWIF(26),
	RWELSE(27),
	RWELSEIF(28),
	RWIT(29),
	RWDO(30),
	RWWHILE(31),
	RWRETURN(32),
	OPATRIB(33),
	OPATRIBADIT(34),
	OPATRIBMULT(35),
	OPATRIBDIV(36),
	OPATRIBSUB(37),
	OPBOOLAND(38),
	OPBOOLOR(39),
	OPBOOLNOT(40),
	OPARITADIT(41),
	OPARITMULT(42),
	OPARITEXP(43),
	OPNEGUN(44),
	OPREL(45),
	OPCONC(46),
	VARIABLE(47),
	UNKNOWN(48);
	
	
	private int value;
	
	
	private TCategory(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
