package it.unisa.bowling;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unisa.exceptions.IllegalFrameException;

public class FrameTest {

	/*****************************/
	
	@Test
	public void testGetSetFirst() {
		Frame frame = new Frame();
		frame.setFirst_throw(2);
		int first_throw = frame.getFirst_throw();
		assertEquals(2, first_throw);
	}
	@Test
	public void testGetSetSecond() {
		Frame frame = new Frame();
		frame.setSecond_throw(4);
		int second_throw = frame.getSecond_throw();
		assertEquals(4, second_throw);
	}
	
	@Test(expected = IllegalFrameException.class)
	public void testMoreThanTenFrame() throws IllegalFrameException {
		new Frame(7, 4);
	}
	@Test(expected = IllegalFrameException.class)
	public void testLessThanTenZeroFirst() throws IllegalFrameException {
		new Frame(-1, 4);
	}
	@Test(expected = IllegalFrameException.class)
	public void testLessThanTenZeroSecond() throws IllegalFrameException {
		new Frame(7, -1);
	}
	
	
	@Test
	public void testGetTotal() throws IllegalFrameException {
		Frame frame = new Frame(2, 4);
		int total = frame.getTotal();
		assertEquals(6, total);
	}
	
	@Test
	public void testIsStrike() throws IllegalFrameException {
		Frame frame = new Frame(10, 0);
		boolean strike = frame.isStrike();
		assertEquals(strike, true);
	}
	@Test
	public void testIsNotStrike() throws IllegalFrameException {
		Frame frame = new Frame(9, 0);
		boolean strike = frame.isStrike();
		assertEquals(strike, false);
	}
	

}
