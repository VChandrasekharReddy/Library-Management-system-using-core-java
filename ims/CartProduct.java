package ims;

public class CartProduct implements Comparable<CartProduct>{
    private int productId;
    private String name;
    private double price;
    private int quantityInStock;

    // Constructor (COMPLETE)
    public CartProduct(int productId, String name, double price, int quantityInStock) {
        this.setProductId(productId);
        this.setName(name);
        this.setPrice(price);
        this.setQuantityInStock(quantityInStock);
    }
    // Getters and Setters (INCOMPLETE - Fill in missing methods)
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public int compareTo(CartProduct other) {
		return this.getProductId()-other.getProductId();
	}

    
    // Complete getters and setters for name, price, quantityInStock
	   @Override
	    public String toString() {
	        return "Product ID: " + productId + ", Name: " + name + ", Price: $" + price + ", Stock: " + quantityInStock;
	    }

 
}

