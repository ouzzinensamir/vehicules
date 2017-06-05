package ma.sqli.vehicles.service.inputparser;

import java.util.HashMap;
import java.util.Map;

import ma.sqli.vehicles.factory.VehicleFactory;
import ma.sqli.vehicles.fuel.Fuel;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class InputVehiclesBuilder {

	private String vehiclesInputToParse;
	
	public InputVehiclesBuilder(String vehiclesInputToParse) {
		super();
		this.vehiclesInputToParse = vehiclesInputToParse;
	}

	private String[] parseInput() {
		String[] vehicles = new String[]{};
		if(vehiclesInputToParse != null && !vehiclesInputToParse.isEmpty()) {
			vehicles = vehiclesInputToParse.trim().split(",");
			return vehicles;
		}
		return vehicles;
	}
	
	public Map<String, Vehicle> getAllVehiclesFromInput() {
		Map<String, Vehicle> vehiclesFromInput = new HashMap<>();
		String[] inputs = parseInput();
		for(String input : inputs) {
			if(!input.isEmpty()) {
				Vehicle vehicle = createVehicleFromInput(input);
				vehiclesFromInput.put(vehicle.getVehicleId(), vehicle);
			}
		}
		return vehiclesFromInput;
	}
	
	private Vehicle createVehicleFromInput(final String input) {
		String[] parameters = input.trim().split(":");
		String vehicleId = parameters[0];
		String fuel = parameters[1];
		String numberOfDoors = parameters[2];
		VehicleFactory vehicleFactory = new VehicleFactory();
		return vehicleFactory.getVehicle(vehicleId, getFuelFromInput(fuel), numberOfDoors);
	}
	
	private static Fuel getFuelFromInput(final String input) {
		if(input != null) {
			for(Fuel fuel : Fuel.values()) {
				if(fuel.toString().equalsIgnoreCase(input)) {
					return fuel;
				}
			}
		}
		return null;
	}
}
