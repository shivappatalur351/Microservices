package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.exception.NoStockException;
import com.model.Product;

//use appropriate annotation to configure ShoppingService as a Service
@Service
public class ShoppingService {

	@GetMapping("/exception")
	public double calculateCost(Product product) throws NoStockException {
		double totalCost = 0.0;
		// fill the code
		// cost=quantity*costperkg

		System.out.println(product.getCostPerKg() + " " + product.getQuantity() + " ");

		Map<String, Integer> ml = getProductStock();

		// int q=product.getQuantity();
		// && product.getQuantity()<=ml.hashCode()

		// if(product.getQuantity()==ml.get(getProductStock())){
		String str = product.getProductName();
		int qty = ml.get(str);

		if (ml.containsKey(product.getProductName()) && (product.getQuantity() >= 1 && product.getQuantity() <= qty)) {

			if (product.getProductName().equalsIgnoreCase("Apple") && product.getQuantity() >= 1) {

				product.setCostPerKg(250.00);
				totalCost = product.getQuantity() * product.getCostPerKg();
			} else if (product.getProductName().equalsIgnoreCase("Orange") && product.getQuantity() >= 1) {

				product.setCostPerKg(90.00);
				totalCost = product.getQuantity() * product.getCostPerKg();
			} else if (product.getProductName().equalsIgnoreCase("Jackfruit") && product.getQuantity() >= 1) {

				product.setCostPerKg(75.00);
				totalCost = product.getQuantity() * product.getCostPerKg();
			} else if (product.getProductName().equalsIgnoreCase("Mango") && product.getQuantity() >= 1) {

				product.setCostPerKg(60.00);
				totalCost = product.getQuantity() * product.getCostPerKg();
			} else if (product.getProductName().equalsIgnoreCase("Grapes") && product.getQuantity() >= 1) {

				product.setCostPerKg(150.00);
				totalCost = product.getQuantity() * product.getCostPerKg();
			}
		}

		else {
			System.out.println("hello I am Exception Handler~!!!!!");

			throw new NoStockException("No Enough stock for product");
			// throw exception error

			// ShoppingController.exceptionHandler(e);

		}

		return totalCost;
	}

	// Dont change this code

	public static Map<String, Integer> getProductStock() {
		Map<String, Integer> stock = new HashMap<String, Integer>();
		stock.put("Apple", 50);
		stock.put("Grapes", 10);
		stock.put("Orange", 30);
		stock.put("Mango", 75);
		stock.put("JackFruit", 25);
		return stock;
	}
}
