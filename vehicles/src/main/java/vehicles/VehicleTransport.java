package vehicles;

import java.util.Set;

public class VehicleTransport extends Vehicle {
	private Set<Vehicle> vehicles;

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
