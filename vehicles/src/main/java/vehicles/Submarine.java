package vehicles;

import java.util.Set;

public class Submarine extends Vehicle {

	private Double maxDepth;
	private Set<Car> cars;

	public Double getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(Double maxDepth) {
		this.maxDepth = maxDepth;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Set<Car> getCars() {
		return cars;
	}

}
