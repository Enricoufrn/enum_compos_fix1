package entities;

public class OrderItem {
	private Integer quantity;
	private Product product;
	
	public OrderItem() {		
	}

	public OrderItem(Integer quantity,Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public double getProductPrice() {
		return product.getPrice();
	}
	
	public double subTotal() {
		return quantity*product.getPrice();
	}
}
