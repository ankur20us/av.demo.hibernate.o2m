package av.demo.hibernate.o2m.modal;

public class Customer {

	private int customerId;
	private String customerName;
	private int foreignVendorId;

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, int foreignVendorId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.foreignVendorId = foreignVendorId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getForeignVendorId() {
		return foreignVendorId;
	}

	public void setForeignVendorId(int foreignVendorId) {
		this.foreignVendorId = foreignVendorId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", foreignVendorId="
				+ foreignVendorId + "]\n";
	}
	
	

}
