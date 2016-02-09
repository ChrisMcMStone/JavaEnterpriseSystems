package vehicles;

public class LGV extends Vehicle {
	/**
	 * 
	 */
	private Double maxWeight;
	
	/**
	 * 
	 */
	private Integer numberOfAxles;

	/**
	 * 
	 * @return
	 */
	public Double getMaxWeight() {
		return maxWeight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getNumberOfAxles() {
		return numberOfAxles;
	}

	/**
	 * 
	 * @param numberOfAxles
	 */
	public void setNumberOfAxles(Integer numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}
}
