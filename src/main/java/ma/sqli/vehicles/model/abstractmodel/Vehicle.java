package ma.sqli.vehicles.model.abstractmodel;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.vehicles.Fuel;

public abstract class Vehicle {
	
	protected String vehicleId;
	protected Fuel fuel;
	protected String sDoorsNumber;
	protected List<Door> doors = new ArrayList<>();

	public Vehicle(String vehicleType, Fuel fuel, String doorsNumber) {
		super();
		this.vehicleId = vehicleType;
		this.fuel = fuel;
		this.sDoorsNumber = doorsNumber;
	}
	
	public Vehicle(String vehicleType) {
		this.vehicleId = vehicleType;
	}

	protected int getDoorsNumber() throws Exception{
		if(isDoorsNumberValid()) {
			return Integer.valueOf(sDoorsNumber);
		}else {
			throw new Exception("PApapapapa");
		}
	}
	
	protected boolean hasDoorOpened() {
		for(Door door : doors) {
			if(door.isOpened()) {
				return true;
			}
		}
		return false;
	}
	
	public void closeDoorWithId(String id) {
		int idOfDoor = Integer.parseInt(id);
		for(Door door : doors) {
			if(door.getId() == idOfDoor) {
				door.close();
				break;
			}
		}
	}
	
	public void openDoorWithId(String id) {
		int idOfDoor = Integer.parseInt(id);
		for(Door door : doors) {
			if(door.getId() == idOfDoor) {
				door.open();
				break;
			}
		}
	}
	
	protected abstract boolean isDoorsNumberValid();
	public abstract String displayStatus(int length);
	protected abstract double getConsumption(int length);
	
	/**
	 * @return the vehicleId
	 */
	public String getVehicleId() {
		return vehicleId;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) {
	    	throw new IllegalArgumentException();
	    }

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
