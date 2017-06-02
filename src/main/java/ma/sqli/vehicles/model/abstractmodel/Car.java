package ma.sqli.vehicles.model.abstractmodel;

import ma.sqli.vehicles.VehicleType;
import ma.sqli.vehicles.fuel.Fuel;

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
	public String displayStatus(int length) {
		String status = "";
		if(!hasDoorOpened()) {
			status = status + " DOORS OK, MOVING. The "+VehicleType.CAR.toString() +" will consume "+ getConsumption(length)+" L";
		}
		return status;
	}

	@Override
	protected double getConsumption(int length) {
		int consumption = length/33;
		return round(consumption, 2);
	}

	@Override
	public String draw(String status) {
		return null;
	}
	
}
