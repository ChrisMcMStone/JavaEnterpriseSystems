package vehicles;

public class Aeroplane extends Vehicle {

	private Double length;
	private Double wingSpan;
	private Double maxHeight;
	
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWingSpan() {
		return wingSpan;
	}
	public void setWingSpan(Double wingSpan) {
		this.wingSpan = wingSpan;
	}
	public Double getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(Double maxHeight) {
		this.maxHeight = maxHeight;
	}
}
