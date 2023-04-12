package multi;

public class MockVO2 {
	
	private String owner_first_name;
	private String car_make;
	private String car_model;
	private String car_model_year;
	private String car_vin;
	private String car_color;
	
	public String getOwner_first_name() {
		return owner_first_name;
	}
	public void setOwner_first_name(String owner_first_name) {
		this.owner_first_name = owner_first_name;
	}
	public String getCar_make() {
		return car_make;
	}
	public void setCar_make(String car_make) {
		this.car_make = car_make;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public String getCar_model_year() {
		return car_model_year;
	}
	public void setCar_model_year(String car_model_year) {
		this.car_model_year = car_model_year;
	}
	public String getCar_vin() {
		return car_vin;
	}
	public void setCar_vin(String car_vin) {
		this.car_vin = car_vin;
	}
	public String getCar_color() {
		return car_color;
	}
	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}
	
	@Override
	public String toString() {
		return "MockVO2 [owner_first_name=" + owner_first_name + ", car_make=" + car_make + ", car_model=" + car_model
				+ ", car_model_year=" + car_model_year + ", car_vin=" + car_vin + ", car_color=" + car_color + "]";
	}
	
}