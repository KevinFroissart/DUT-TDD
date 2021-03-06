package TP2;

public class BowlingGame {

	private int score;
	private int coefLancer;
	private int nbLancersCompteDouble;
	private int nbJeu;
	private String histo;

	public BowlingGame() {
		this.score = 0;
		this.nbLancersCompteDouble = 0;
		this.coefLancer = 1;
		this.histo = "";
	}

	public void majNbLancersCompteDouble (int i) {
		if (nbJeu < 9 || i < 0) nbLancersCompteDouble += i;
	}
	
	public void majCoefLancer () {
		if (nbLancersCompteDouble < 1) coefLancer = 1;
		else if (nbLancersCompteDouble == 3) {
			coefLancer = nbLancersCompteDouble;
			majNbLancersCompteDouble(-2);
		}
		else {
			coefLancer = 2;
			majNbLancersCompteDouble(-1);
		}
	}
	
	public void roll (int pins) {
        score += pins * coefLancer;
        majCoefLancer();
    }
	
	public String toString () {
		return histo.trim();
	}

    public int score () {
        return score;
    }

    public void addHisto(String s) {
    	histo += s;
    }
    
    public void next() {
    	nbJeu++;
    }
}