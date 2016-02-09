package vehicles;

public class Car extends Vehicle {

	private Double maxSpeed;
	private Boolean isFourWheelDrive;

	public Double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public Boolean getIsFourWheelDrive() {
		return isFourWheelDrive;
	}
	public void setIsFourWheelDrive(Boolean isFourWheelDrive) {
		this.isFourWheelDrive = isFourWheelDrive;
	}
}
