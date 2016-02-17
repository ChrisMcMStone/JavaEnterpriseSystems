package vehicles;

public class Submarine extends Vehicle {

	private Double maxDepth;
	private Car carLoad;

	public Double getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(Double maxDepth) {
		this.maxDepth = maxDepth;
	}

	public Car getCarLoad() {
		return carLoad;
	}

	public void setCarLoad(Car carLoad) {
		this.carLoad = carLoad;
	}
}
