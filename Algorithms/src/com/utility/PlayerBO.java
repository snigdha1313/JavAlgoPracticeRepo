package com.utility;

import java.util.ArrayList;
import java.util.List;

public class PlayerBO {

	private List<Integer> playerList = new ArrayList<Integer>();

	public List<Integer> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Integer> playerList) {
		this.playerList = playerList;
	}

//This method should add the oversBowled passed as the argument in to the List
	public void addOversDetails(int oversBowled) {
		this.playerList.add(oversBowled);
	}

	/*
	 * This method should return the number of balls bowled by the player Number of
	 * balls bowled can be calculated based on the sum of (oversBowled *6) available
	 * in the playerList. For Example: List contains[5,10,5]
	 * NoOfBallsBowled=(5+10+5)*6=120 so this method should return 120 If list is
	 * empty return 0
	 */
	public int getNoOfBallsBowled() {
		int totalOvers = 0;
		if (playerList.isEmpty())
			return 0;
		for (int i = 0; i < playerList.size(); i++) {
			totalOvers += playerList.get(i);
		}
		return totalOvers*6;

	}

}