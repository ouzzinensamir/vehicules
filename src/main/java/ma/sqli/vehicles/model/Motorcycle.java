package ma.sqli.vehicles.model;

import ma.sqli.vehicles.fuel.Fuel;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class Motorcycle extends Vehicle{

	public Motorcycle(String vehicleType) {
		super(vehicleType);
	}
	
	public Motorcycle(String vehicleType, Fuel fuel, String doorsNumber) {
		super(vehicleType, fuel, doorsNumber);
	}

	@Override
	protected boolean isDoorsNumberValid() {
		if(sDoorsNumber != null && !sDoorsNumber.isEmpty()) {
			try {
				int doorsNumber= Integer.valueOf(sDoorsNumber);
				return doorsNumber == 0;
			} catch(NumberFormatException nfe) {
				return false;
			}
		}
		return false;
	}

	@Override
	public double getConsumption(double length) {
		return length/16;
	}
}
