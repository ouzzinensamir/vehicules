package ma.sqli.vehicles.service.doorservice;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.vehicles.model.Door;
import ma.sqli.vehicles.model.abstractmodel.Vehicle;

public class DoorService {

	public List<Door> getAllOpenedDoors(Vehicle vehicle) {
		List<Door> openedDoors = new ArrayList<>();
		if(vehicle != null) {
			for(Door door : vehicle.getDoors()) {
				if(door.isOpened()) {
					openedDoors.add(door);
				}
			}
		}
		return openedDoors;
	}
	
	public void closeTheDoorsSpecifiedByUser(String numbersOfClosedDoors, Vehicle vehicle) {
		String[] numbers = numbersOfClosedDoors.split(" ");
		for(String s : numbers) {
			closeDoorWithId(s, vehicle);
		}
	}
	
	public void openTheDoorsSpecifiedByUser(String numbersOfClosedDoors, Vehicle vehicle) {
		String[] numbers = numbersOfClosedDoors.split(" ");
		for(String s : numbers) {
			openDoorWithId(s, vehicle);
		}
	}
	
	private void closeDoorWithId(String id, Vehicle vehicle) {
		int idOfDoor = Integer.parseInt(id);
		for(Door door : vehicle.getDoors()) {
			if(door.getId() == idOfDoor) {
				door.close();
				break;
			}
		}
	}
	
	private void openDoorWithId(String id, Vehicle vehicle) {
		int idOfDoor = Integer.parseInt(id);
		for(Door door : vehicle.getDoors()) {
			if(door.getId() == idOfDoor) {
				door.open();
				break;
			}
		}
	}
}
