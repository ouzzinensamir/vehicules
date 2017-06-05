package ma.sqli.vehicles.model.abstractmodel;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.vehicles.exceptions.IllegalNumberOfDoorsException;
import ma.sqli.vehicles.fuel.Fuel;
import ma.sqli.vehicles.model.Door;

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

	protected int getDoorsNumber() throws IllegalNumberOfDoorsException{
		if(isDoorsNumberValid()) {
			return Integer.valueOf(sDoorsNumber);
		}else {
			throw new IllegalNumberOfDoorsException("The number of doors is not valid for this vehicle");
		}
	}
	
	public boolean hasDoorOpened() {
		for(Door door : doors) {
			if(door.isOpened()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return the vehicleId
	 */
	public String getVehicleId() {
		return vehicleId;
	}
	
	/**
	 * @return the doors
	 */
	public List<Door> getDoors() {
		return doors;
	}

	/**
	 * @param doors the doors to set
	 */
	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}

	/**
	 * @return the fuel
	 */
	public Fuel getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	
	protected abstract boolean isDoorsNumberValid() throws IllegalNumberOfDoorsException;
	public abstract double getConsumption(double length);
}
