package it.unisa.bowling;

import java.util.Random;

import it.unisa.exceptions.NotTenFramesException;

public class Game {
	private Frame[] frames;
	private int firstBonusThrow = 10, secondBonusThrow = 10;
	
	public Game() {
		
	}
	
	public Game(Frame[] frames) throws NotTenFramesException{
		if(frames.length != 10) {
			throw new NotTenFramesException();
		}
		this.frames = frames;
	}

	public Frame[] getFrames() {
		return frames;
	}

	public void setFrames(Frame[] frames) throws NotTenFramesException{
		if(frames.length != 10) {
			throw new NotTenFramesException();
		}
		this.frames = frames;
	}

	public int getScore() {
		int score = 0;
		for(Frame frame: frames) {
			score += frame.getTotal();
		}
		return score;
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		int[] realScore = new int[10];
		int total = 0;
		for (int i = 0; i < 10; i ++) {
			
			if(frames[i].isSpear()) {
				if(i < 9) {
					realScore[i] = 10 + frames[i+1].getFirst_throw();
				}
				else {
					realScore[i] = 10 + firstBonusThrow;
				}
			}	
			
			else if(frames[i].isStrike()) {				
				if(i == 9) {
					realScore[9] = 10 + firstBonusThrow + secondBonusThrow;
				}
				else if (i == 8) {
					if(frames[i + 1].isStrike()) {
						realScore[8] = 10 + 10 + firstBonusThrow;
					}
					else {
						realScore[8] = 10 + frames[9].getTotal();
					}		
				}
				else {
					if(frames[i + 1].isStrike()) {
						realScore[i] = 10 + 10 + frames[i+2].getFirst_throw();
					}
					else {
						realScore[i] = 10 + frames[i + 1].getTotal();
					}
				}
			}
			
			else {
				realScore[i] = frames[i].getTotal();
			}
			
		}
		
		for (int i = 0; i < 10 ; i ++) {
			total += realScore[i];
		}
		
		return total;
	}
	
	

	
	
	
	
	
	
}
