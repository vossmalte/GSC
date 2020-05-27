package aufgaben;

public abstract class BingoAufgabe extends Aufgabe {

	protected BingoAufgabe(Blatt blatt) {
		super(blatt);
	}
	
	/**
	 * prüfe, ob außenliegende Joker durch ein Bingo erreicht werden
	 */
	public abstract void checkBingo();

}
