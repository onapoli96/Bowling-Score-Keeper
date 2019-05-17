package it.unisa.bowling;

import static org.junit.Assert.*;


import org.junit.Test;

import it.unisa.exceptions.IllegalFrameException;
import it.unisa.exceptions.NotTenFramesException;


public class GameTest {
	
	private Frame[] frames;
	
	@Test
	public void testGameScore() throws NotTenFramesException, IllegalFrameException {
		
		frames = new Frame[10];
		
		frames[0] = new Frame(3,6);
		frames[1] = new Frame(7,2);
		frames[2] = new Frame(3,6);
		frames[3] = new Frame(4,4);
		frames[4] = new Frame(5,3);
		frames[5] = new Frame(3,3);
		frames[6] = new Frame(4,5);
		frames[7] = new Frame(8,1);
		frames[8] = new Frame(2,6);
		frames[9] = new Frame(1,5);
		
		Game game = new Game(frames);	
		int score = game.getScore();
		assertEquals(81, score);		
	}
	
	@Test
	public void testSetFrames() throws NotTenFramesException, IllegalFrameException {		
		frames = new Frame[10];
		
		frames[0] = new Frame(3,6);
		frames[1] = new Frame(7,2);
		frames[2] = new Frame(3,6);
		frames[3] = new Frame(4,4);
		frames[4] = new Frame(5,3);
		frames[5] = new Frame(3,3);
		frames[6] = new Frame(4,5);
		frames[7] = new Frame(8,1);
		frames[8] = new Frame(2,6);
		frames[9] = new Frame(1,5);
		
		Game game = new Game();
		game.setFrames(frames);
		assertArrayEquals(game.getFrames(), frames);
		
	}
	
	@Test(expected = NotTenFramesException.class)
	public void testLessThanTenFrames() throws NotTenFramesException, IllegalFrameException {		
		frames = new Frame[1];
		frames[0] = new Frame(3,6);
		new Game(frames);
				
	}
	
	@Test(expected = NotTenFramesException.class)
	public void testMoreThanTenFrames() throws NotTenFramesException, IllegalFrameException {		
		frames = new Frame[1];
		frames[0] = new Frame(3,6);
		Game game = new Game();
		game.setFrames(frames);			
	}
	
	@Test
	public void testgetTotal() throws NotTenFramesException, IllegalFrameException {		
		frames = new Frame[10];
		
		frames[0] = new Frame(4,6);
		frames[1] = new Frame(7,2);
		frames[2] = new Frame(3,6);
		frames[3] = new Frame(4,4);
		frames[4] = new Frame(10,0);
		frames[5] = new Frame(3,3);
		frames[6] = new Frame(4,5);
		frames[7] = new Frame(10,0);
		frames[8] = new Frame(10,0);
		frames[9] = new Frame(1,5);
		
		Game game = new Game(frames);	
		int score = game.getTotal();
		assertEquals(117, score);	
	}
	
	@Test
	public void testPerfectGame() throws NotTenFramesException, IllegalFrameException {		
		frames = new Frame[10];
		
		frames[0] = new Frame(10,0);
		frames[1] = new Frame(10,0);
		frames[2] = new Frame(10,0);
		frames[3] = new Frame(10,0);
		frames[4] = new Frame(10,0);
		frames[5] = new Frame(10,0);
		frames[6] = new Frame(10,0);
		frames[7] = new Frame(10,0);
		frames[8] = new Frame(10,0);
		frames[9] = new Frame(10,0);
		
		Game game = new Game(frames);	
		int score = game.getTotal();
		assertEquals(300, score);
		
	}

}
