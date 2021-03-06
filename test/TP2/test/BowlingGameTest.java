package TP2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;

import TP2.BowlingGame;
import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void score_should_return_the_sum_of_knocked_pins () {
		BowlingGame game = playOnNewGame("7 2 | 4 4 | 1 3 |");
		assertEquals(21, game.score());
	}

	@Test
	public void score_should_take_the_spare_bonus () {
		BowlingGame game = playOnNewGame("6 / | 4 ");
		assertEquals(18, game.score());
	}


	@Test
	public void score_should_take_the_strike_bonus () {
		BowlingGame game = playOnNewGame("X | 4 5");
		assertEquals(28, game.score());
	}

	@Test
	public void score_should_take_multiple_bonus () {
		BowlingGame game = playOnNewGame("X | 4 / | 1 0");
		assertEquals(32, game.score());
	}

	@Test
	public void score_for_maximum_score () {
		BowlingGame game = playOnNewGame("X | X | X | X | X | X | X | X | X | X X X");
		assertEquals(300, game.score());
	}
	
	@Test
	public void should_return_histo () {
		String histo = "X | 4 / | 1 0";
		BowlingGame game = playOnNewGame(histo);
		assertEquals(histo, game.toString());
	}

	private BowlingGame playOnNewGame(String string) {
		int oldShot = 0;
		BowlingGame game = new BowlingGame();
		String[] lance = string.split("|");
		for(int nbLance = 0; nbLance < lance.length; nbLance++) {
			String[] coup = lance[nbLance].split(" ");
			for(int nbCoup = 0; nbCoup < coup.length; nbCoup++) {
				if(coup[nbCoup].equals("|")) {
					game.next();
					game.addHisto("| ");
					break;
				}
				if(coup[nbCoup].matches("X")) {
					game.majNbLancersCompteDouble(2);
					game.roll(10);
					game.addHisto("X ");
				}
				else if(coup[nbCoup].matches("/")) {
					game.majNbLancersCompteDouble(1);
					game.roll(10 - oldShot);
					game.addHisto("/ ");
				}
				else {
					oldShot = Integer.parseInt(coup[nbCoup]);
					game.roll(oldShot);
					game.addHisto(oldShot + " ");
				}
			}
		}
		return game;
	}
}