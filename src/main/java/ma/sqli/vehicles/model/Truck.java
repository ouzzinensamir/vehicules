package ma.sqli.vehicles.model;

import ma.sqli.vehicles.fuel.Fuel;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class Truck extends Vehicle{

	
	public Truck(String vehicleType, Fuel fuel, String doorsNumber) {
		super(vehicleType, fuel, doorsNumber);
		initializeDoors();
	}

	protected void initializeDoors() {
		if(isDoorsNumberValid()) {
			try {
				for(int i = 1; i<=getDoorsNumber() ;i++) {
					doors.add(new Door(i, false));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected boolean isDoorsNumberValid() {
		if(sDoorsNumber != null && !sDoorsNumber.isEmpty()) {
			try {
				int doorsNumber= Integer.parseInt(sDoorsNumber);
				return doorsNumber > 0 && doorsNumber %2 == 0;
			} catch(NumberFormatException nfe) {
				return false;
			}
		}
		return false;
	}

	@Override
	public double getConsumption(double length) {
		return length/20;
	}

}
