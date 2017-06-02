package ma.sqli.vehicles;

import java.util.Map;

import ma.sqli.vehicles.inputparser.DoorsStateController;
import ma.sqli.vehicles.inputparser.InputVehiclesBuilder;
import ma.sqli.vehicles.inputparser.LengthParser;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

/************
The aim of the exercise is to pass all the test cases bellow.
It's about vehicles and their consumption. Each vehicle has a different consumption according to its Fuel type :
 - Diesel: 5%
 - Gasoline: 6%
 - Hybrid: 3%

A vehicle is displayed as bellow. Please respect the door's numbers as in the schema : 
        _
door 1 | | door 2
door 3 |_| door 4

*************/

public class Vehicles {
	
	private String vehicles;
	
	public Vehicles(String vehicles) {
		this.vehicles = vehicles;
	}
	
	public String move(String string, String string2, String string3) {
		Vehicle vehicle = getVehicleFromVehicleId(string);
		closeTheDoorsSpecified(string2, vehicle);
		int length = LengthParser.getLength(string3);
		return vehicle.displayStatus(length);
	}

	private Vehicle getVehicleFromVehicleId(String vehicleId) {
		InputVehiclesBuilder inputVehiclesParser = new InputVehiclesBuilder(vehicles);
		Map<String, Vehicle> allVehiclesFromInput = inputVehiclesParser.getAllVehiclesFromInput();
		return allVehiclesFromInput.get(vehicleId);
	}
	
	private void closeTheDoorsSpecified(String numbersOfClosedDoors, Vehicle vehicle) {
		if(vehicle != null) {
			DoorsStateController.closeTheDoorsSpecifiedByUser(numbersOfClosedDoors, vehicle);
		}
	}
	
}
