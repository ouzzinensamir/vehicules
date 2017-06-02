package ma.sqli.vehicles.inputparser;

import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class DoorsStateUpdater {
	
	public static void closeTheDoorsSpecifiedByUser(String numbersOfClosedDoors, Vehicle vehicle) {
		String[] numbers = numbersOfClosedDoors.split(" ");
		for(String s : numbers) {
			vehicle.closeDoorWithId(s);
		}
	}
	
	public static void openTheDoorsSpecifiedByUser(String numbersOfClosedDoors, Vehicle vehicle) {
		String[] numbers = numbersOfClosedDoors.split(" ");
		for(String s : numbers) {
			vehicle.openDoorWithId(s);
		}
	}
}
