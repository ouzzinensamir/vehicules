package ma.sqli.vehicles.service.display;

import ma.sqli.vehicles.model.Door;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class DisplayService {

	private static StringBuilder display(Vehicle vehicle) {
		StringBuilder vehicleDisplay = new StringBuilder();
		vehicleDisplay.append(displayFront());
		displayDoorsAndBackOfTheVehicle(vehicle, vehicleDisplay);
		return vehicleDisplay;
	}
	
	private static String displayFront() {
		return "  _\n";
	}
	
	public static String getStatus(Vehicle vehicle, double length) {
		String status = "";
		if(!vehicle.hasDoorOpened()) {
			status = status + "DOORS OK, MOVING. The "+vehicle.getVehicleId().toUpperCase() +" will consume "+ adjustConsumptionByAddingTwoZerosAfterDot(vehicle.getConsumption(length))+" L";
		}else {
			status = status + "DOORS KO, BLOCKED \n"+ display(vehicle).toString();
		}
		return status;
	}
	
	private static String adjustConsumptionByAddingTwoZerosAfterDot(double consumption) {
		return  String.valueOf((int) consumption).concat(".00");
	}
	
	private static void displayDoorsAndBackOfTheVehicle(Vehicle vehicle, StringBuilder vehicleDisplay) {
		int numberOfDoors = vehicle.getDoors().size();
		for(Door door : vehicle.getDoors()) {
			if(door.getId() %2 != 0) {
				displayLeftDoors(door, vehicleDisplay);
				displayBack(door, vehicleDisplay, numberOfDoors);
			}else {
				displayRightDoors(door, vehicleDisplay, numberOfDoors);
			}
		}
	}
	
	private static void displayLeftDoors(Door door, StringBuilder vehicleDisplay) {
		if(!door.isOpened()) {
			vehicleDisplay.append(" |");
		}else {
			vehicleDisplay.append(" /");
		}
	}
	
	private static void displayBack(Door door, StringBuilder vehicleDisplay, int numberOfDoors) {
		if(numberOfDoors == door.getId() + 1) {
			vehicleDisplay.append("_");
		}
	}
	
	private static void displayRightDoors(Door door, StringBuilder vehicleDisplay, int numberOfDoors) {
		if(door.getId() < numberOfDoors) {
			vehicleDisplay.append(" ");
		}
		if(!door.isOpened()) {
			vehicleDisplay.append("|");
		}else {
			vehicleDisplay.append("\\");
		}
		if(door.getId() != numberOfDoors) {
			vehicleDisplay.append("\n");
		}
	}
}
