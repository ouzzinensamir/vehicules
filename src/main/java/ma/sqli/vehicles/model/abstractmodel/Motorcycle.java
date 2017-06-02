package ma.sqli.vehicles.model.abstractmodel;

import ma.sqli.vehicles.Fuel;

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
	public String displayStatus(int parcours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double getConsumption(int parcours) {
		// TODO Auto-generated method stub
		return 0;
	}
}
