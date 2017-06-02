package ma.sqli.vehicles.model.abstractmodel;

import java.text.DecimalFormat;

import ma.sqli.vehicles.VehicleType;
import ma.sqli.vehicles.fuel.Fuel;

public class Truck extends Vehicle{

	
	public Truck(String vehicleType, Fuel fuel, String doorsNumber) {
		super(vehicleType, fuel, doorsNumber);
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
	public String displayStatus(int length) {
		String status = "";
		if(!hasDoorOpened()) {
			status = status + " DOORS OK, MOVING. The "+VehicleType.TRUCK.toString() +" will consume "+ getConsumption(length)+" L";
		}
		return status;
	}

	@Override
	protected double getConsumption(int length) {
		int consumption = length/16;
		return Double.parseDouble(new DecimalFormat("##.####").format(consumption));
	}

	@Override
	public String draw(String status) {
		// TODO Auto-generated method stub
		return null;
	}
}
