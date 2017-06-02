package ma.sqli.vehicles.factory;

import ma.sqli.vehicles.VehicleType;
import ma.sqli.vehicles.fuel.Fuel;
import ma.sqli.vehicles.model.abstractmodel.Car;
import ma.sqli.vehicles.model.abstractmodel.Motorcycle;
import ma.sqli.vehicles.model.abstractmodel.Truck;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class VehicleFactory {

	public Vehicle getVehicle(String vehicleId, Fuel fuel, String doorsNumber) {
		if(vehicleId.equalsIgnoreCase(VehicleType.CAR.toString())) {
			return new Car(vehicleId, fuel, doorsNumber);
		}
		
		if(vehicleId.equalsIgnoreCase(VehicleType.TRUCK.toString())) {
			return new Truck(vehicleId, fuel, doorsNumber);
		}
		
		if(vehicleId.equalsIgnoreCase(VehicleType.MOTORCYCLE.toString())) {
			return new Motorcycle(vehicleId, fuel, doorsNumber);
		}
		
		return null;
	}
}
