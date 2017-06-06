package ma.sqli.vehicles;

import java.util.Map;

import ma.sqli.vehicles.model.abstractmodel.Vehicle;
import ma.sqli.vehicles.service.display.DisplayService;
import ma.sqli.vehicles.service.doorservice.DoorService;
import ma.sqli.vehicles.service.inputparser.InputVehiclesBuilder;
import ma.sqli.vehicles.service.inputparser.LengthParser;

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
	
	private String vehiclesInput;
	
	public Vehicles(String vehicles) {
		this.vehiclesInput = vehicles;
	}
	
	public String move(String string, String string2, String string3) {
		Vehicle vehicle = getVehicleFromVehicleId(string);
		closeTheDoorsSpecifiedByUser(string2, vehicle);
		double length = LengthParser.getLength(string3);
		return DisplayService.getStatus(vehicle, length);
	}

	private Vehicle getVehicleFromVehicleId(String vehicleId) {
		InputVehiclesBuilder inputVehiclesParser = new InputVehiclesBuilder(vehiclesInput);
		Map<String, Vehicle> allVehiclesFromInput = inputVehiclesParser.getAllVehiclesFromInput();
		if(allVehiclesFromInput != null) {
			return allVehiclesFromInput.get(vehicleId);
		}else {
			return null;
		}
	}
	
	private void closeTheDoorsSpecifiedByUser(String numbersOfClosedDoors, Vehicle vehicle) {
		if(vehicle != null && numbersOfClosedDoors != null && !numbersOfClosedDoors.isEmpty()) {
			DoorService doorsStateController = new DoorService();
			doorsStateController.closeTheDoorsSpecifiedByUser(numbersOfClosedDoors, vehicle);
		}
	}
	
}
