package com.utility;

import java.util.ArrayList;
import java.util.List;

public class RMCBO {

	private List<Integer> rainfallList = new ArrayList<Integer>();

	public List<Integer> getRainfallList() {
		return rainfallList;
	}

	public void setRainfallList(List<Integer> rainfallList) {
		this.rainfallList = rainfallList;
	}

	// This method should add the recordedRainfall passed as argument into the
	// rainfallList
	public void addRainfallDetails(int recordedRainfall) {
		this.rainfallList.add(recordedRainfall);
		// type your logic here
	}

	/*
	 * This method should return the average rain fall based on the recordedRainfall
	 * values available in the rainfallList averageRainfall can be calculated based
	 * on the following formula averageRainfall= (sum of all values in the list /
	 * size of the list)
	 * 
	 * For Example: if the list contains the following recorded rainfall
	 * [6,15,20,50] averageRainfall= (6+25+20+50) / 4 = 22.75
	 * 
	 */
	public double findAverageRainfallOccured() {
		double averageRainfall = -1;
		int sum = 0;
		// type your logic here
		if (this.rainfallList.size() > 0) {
			for (int i = 0; i < this.rainfallList.size(); i++) {
				sum += rainfallList.get(i);
			}
			averageRainfall = sum / rainfallList.size();
		}
		return averageRainfall;

	}
}
