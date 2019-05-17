package it.unisa.bowling;

import it.unisa.exceptions.IllegalFrameException;

public class Frame {

	private int first_throw, second_throw;
	
	public Frame () {
	}
	
	public Frame (int first_throw, int second_throw) throws IllegalFrameException {
		if(first_throw+second_throw > 10) {
			throw new IllegalFrameException();
		}
		if(first_throw < 0 || second_throw < 0 ) {
			throw new IllegalFrameException();
		}
		
		this.first_throw = first_throw;
		this.second_throw = second_throw;
	}

	public int getFirst_throw() {
		return first_throw;
	}

	public void setFirst_throw(int first_throw) {
		this.first_throw = first_throw;
	}

	public int getSecond_throw() {
		return second_throw;
	}

	public void setSecond_throw(int second_throw) {
		this.second_throw = second_throw;
	}
	
	public int getTotal(){
		return first_throw + second_throw;
	}

	public boolean isStrike() {
		// TODO Auto-generated method stub
		if(first_throw == 10) {
			return true;
		}
		return false;
	}
	public boolean isSpear() {
		// TODO Auto-generated method stub
		if(!isStrike()) {
			return first_throw + second_throw == 10;
		}
		return false;
	}
	
}
