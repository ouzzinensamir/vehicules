package ma.sqli.vehicles.display;

import ma.sqli.vehicles.model.Door;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class DisplayService {

	private static StringBuilder display(Vehicle vehicle) {
		StringBuilder vehicleDisplay = new StringBuilder();
		int numberOfDoors = vehicle.getDoors().size();
		vehicleDisplay.append(displayFront());
		for(Door door : vehicle.getDoors()) {
			if(door.getId() %2 != 0) {
				if(!door.isOpened()) {
					vehicleDisplay.append(" |");
				}else {
					vehicleDisplay.append(" /");
				}
				if(numberOfDoors == door.getId() + 1) {
					vehicleDisplay.append("_");
				}
			}else {
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
}
