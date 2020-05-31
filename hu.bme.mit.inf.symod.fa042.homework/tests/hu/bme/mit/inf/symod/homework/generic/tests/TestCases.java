package hu.bme.mit.inf.symod.homework.generic.tests;

import org.junit.Test;

public class TestCases {
	public static void main(String[] args) {
		TestCases testCases = new TestCases();
		try{ testCases.base1(); }catch(AssertionError e) {}try{ testCases.base2(); }catch(AssertionError e) {}try{ testCases.optionCycle(); }catch(AssertionError e) {}try{ testCases.checkSetStartTime(); }catch(AssertionError e) {}try{ testCases.checkSetBonusTime(); }catch(AssertionError e) {}try{ testCases.checkEffectSetStartTime(); }catch(AssertionError e) {}try{ testCases.checkEffectSetBonusTime(); }catch(AssertionError e) {}try{ testCases.checkResetInOptions(); }catch(AssertionError e) {}try{ testCases.checkStartInGame(); }catch(AssertionError e) {}
	}
	
	@Test(timeout=10000)
	public void base1() {
		TesterAPI c = new TesterAPI("base1","Basic test: Pressing each button.");
	c.pushBlack();
	c.pushWhite();
	c.pushMod();
	c.pushStart();
	System.out.println("base1 Succeeded!");
	}
	
	@Test(timeout=10000)
	public void base2() {
		TesterAPI c = new TesterAPI("base2","Basic test: Waiting for 3 sec.");
	c.clockForward(3000);
	System.out.println("base2 Succeeded!");
	}
	
	@Test(timeout=10000)
	public void optionCycle() {
		TesterAPI c = new TesterAPI("optionCycle","By pushing the MOD button in the menu each options are available, and are set to the default values.");
	c.expectText("Ready to play");
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Initial time");
	c.expectWhiteNumber(90);
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Increment time");
	c.expectWhiteNumber(30);
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Ready to play");
	System.out.println("optionCycle Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkSetStartTime() {
		TesterAPI c = new TesterAPI("checkSetStartTime","Checking the upper and lower bounds of the target option. First, the value is increased from default to maximal, plus one more time to check if it stops. Then, it decreased to minimal and checked again it it stops.");
	c.pushMod();
	c.expectWhiteNumber(90);
	c.pushWhite();
	c.expectWhiteNumber(120);
	c.pushWhite();
	c.expectWhiteNumber(150);
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.expectWhiteNumber(540);
	c.pushWhite();
	c.expectWhiteNumber(570);
	c.pushWhite();
	c.expectWhiteNumber(600);
	c.pushWhite();
	c.expectBeep(true);
	c.expectWhiteNumber(600);
	c.pushBlack();
	c.expectWhiteNumber(570);
	c.pushBlack();
	c.expectWhiteNumber(540);
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.expectWhiteNumber(120);
	c.pushBlack();
	c.expectWhiteNumber(90);
	c.pushBlack();
	c.expectWhiteNumber(60);
	c.pushBlack();
	c.expectWhiteNumber(60);
	c.expectBeep(true);
	System.out.println("checkSetStartTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkSetBonusTime() {
		TesterAPI c = new TesterAPI("checkSetBonusTime","Checking the upper and lower bounds of the target option. First, the value is increased from default to maximal, plus one more time to check if it stops. Then, it decreased to minimal and checked again it it stops.");
	c.pushMod();
	c.pushMod();
	c.expectWhiteNumber(30);
	c.pushWhite();
	c.expectWhiteNumber(35);
	c.pushWhite();
	c.expectWhiteNumber(40);
	c.pushWhite();
	c.pushWhite();
	c.expectWhiteNumber(50);
	c.pushWhite();
	c.expectWhiteNumber(55);
	c.pushWhite();
	c.expectWhiteNumber(60);
	c.pushWhite();
	c.expectBeep(true);
	c.expectWhiteNumber(60);
	c.pushBlack();
	c.expectWhiteNumber(55);
	c.pushBlack();
	c.expectWhiteNumber(50);
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.expectWhiteNumber(10);
	c.pushBlack();
	c.expectWhiteNumber(5);
	c.pushBlack();
	c.expectWhiteNumber(0);
	c.pushBlack();
	c.expectWhiteNumber(0);
	c.expectBeep(true);
	System.out.println("checkSetBonusTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkEffectSetStartTime() {
		TesterAPI c = new TesterAPI("checkEffectSetStartTime","Checks the result of changeing the initial time for player Global.");
	c.pushMod();
	c.expectText("Initial time");
	c.expectWhiteNumber(90);
	c.pushWhite();
	c.expectText("Initial time");
	c.expectWhiteNumber(120);
	c.pushMod();
	c.pushMod();
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.expectWhiteNumber(120);
	c.clockForward(3000);
	c.expectWhiteNumber(117);
	c.pushWhite();
	c.expectBeep(true);
	c.expectText("Black moves");
	c.expectBlackNumber(120);
	c.clockForward(3000);
	c.expectBlackNumber(117);
	System.out.println("checkEffectSetStartTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkEffectSetBonusTime() {
		TesterAPI c = new TesterAPI("checkEffectSetBonusTime","Checks the result of changeing the initial time for player Global.");
	c.pushMod();
	c.pushMod();
	c.expectText("Increment time");
	c.expectWhiteNumber(30);
	c.pushWhite();
	c.expectText("Increment time");
	c.expectWhiteNumber(35);
	c.pushMod();
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.expectWhiteNumber(90);
	c.expectBlackNumber(90);
	c.pushWhite();
	c.expectBeep(true);
	c.expectText("Black moves");
	c.pushBlack();
	c.expectBeep(true);
	c.expectText("White moves");
	c.expectWhiteNumber(125);
	c.expectBlackNumber(125);
	System.out.println("checkEffectSetBonusTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkResetInOptions() {
		TesterAPI c = new TesterAPI("checkResetInOptions","Checking the effect of pushing the START/RESET button in the options.");
	c.pushMod();
	c.expectText("Initial time");
	c.expectWhiteNumber(90);
	c.pushWhite();
	c.expectText("Initial time");
	c.expectWhiteNumber(120);
	c.pushStart();
	c.expectText("Ready to play");
	System.out.println("checkResetInOptions Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkStartInGame() {
		TesterAPI c = new TesterAPI("checkStartInGame","Checking the START/RESET button in the game");
	c.expectText("Ready to play");
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.pushStart();
	c.expectText("Ready to play");
	System.out.println("checkStartInGame Succeeded!");
	}
	
}
