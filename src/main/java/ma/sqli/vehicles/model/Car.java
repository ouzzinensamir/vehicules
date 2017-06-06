package ma.sqli.vehicles.model;

import ma.sqli.vehicles.exceptions.IllegalNumberOfDoorsException;
import ma.sqli.vehicles.fuel.Fuel;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class Car extends Vehicle{

	public Car(String vehicleType, Fuel fuel, String doorsNumber) {
		super(vehicleType, fuel, doorsNumber);
		initializeDoors();
	}
	
	protected void initializeDoors() {
		if(isDoorsNumberValid()) {
			try {
				for(int i = 1; i<=getDoorsNumber() ;i++) {
					doors.add(new Door(i, true));
				}
			} catch (IllegalNumberOfDoorsException e) {
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
		int consumption = (int) length/33;
		return consumption;
	}

}
