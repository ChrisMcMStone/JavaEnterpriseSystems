package vehicles;

public class Vehicle {
	private Integer id;
	private Integer version;
	private String make;
	private String model;
	private String type;

	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getVersion() {
		return this.version;
	}
	
	/**
	 * 
	 * @param version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMake() {
		return make;
	}

	/**
	 * 
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * 
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}
