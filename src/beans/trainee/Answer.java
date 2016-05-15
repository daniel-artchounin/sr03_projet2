package beans.trainee;

public abstract class Answer {
	private int orderNumber;
	private String value;
	private boolean active;
	
	public Answer(int orderNumber, String value, boolean active){
		this.setOrderNumber(orderNumber);
		this.setValue(value);
		this.setActive(active);
	}
	
	public Answer(){
		this.orderNumber = 0;
		this.value = null;
		this.active = false;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}