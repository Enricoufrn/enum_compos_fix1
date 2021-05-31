package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Instance client
		System.out.println("Enter cliente data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		String date = sc.next();
		Client client = new Client(name,email,sdf.parse(date));
		
		// Instance Order
		System.out.println("Enter order data:");
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(),status,client);
		
		// Instance OrderItems
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.print("Product name:");
			String productName = sc.next();
			System.out.print("Product price:");
			double price = sc.nextDouble();
			System.out.print("Quantity:");
			int quantity = sc.nextInt();
			Product product = new Product(productName,price);
			OrderItem orderItem = new OrderItem(quantity,product);
			order.addItem(orderItem);
		}
		
		// Show order summary
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: "+order.getMoment());
		System.out.println("Order status: "+order.getStatus());
		System.out.println("Client: "+client.getName()+" ("+sdf.format(client.getBirthDate())+") - "+client.getEmail());
		System.out.println("Order items:");
		System.out.println(order);
		System.out.printf("Total price: $%.2f",order.total());
	}

}
