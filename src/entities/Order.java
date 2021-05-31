package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status,Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public String getMoment() {
		return sdf.format(moment);
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public String getClientName() {
		return client.getName();
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total = 0;
		for(OrderItem ordIt: items) {
			total += ordIt.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(OrderItem ordIt: items) {
			sb.append(ordIt.getProductName()+", ");
			sb.append("$"+String.format("%.2f",ordIt.getProductPrice())+", ");
			sb.append("Quantity: "+ordIt.getQuantity()+", ");
			sb.append("Subtotal: $"+String.format("%.2f",ordIt.subTotal())+"\n");
		}
		return sb.toString();
	}
}
