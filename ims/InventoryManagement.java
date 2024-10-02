package ims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InventoryManagement {
    private List<Product> productList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    
    
    //getter and setter for the productlist;
    public List<Product> getproductList() {
    	return productList;
    }
    
    
    
    // Method to add a new product to the inventory (INCOMPLETE)
    public void addProduct() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Product Name: ");
        String name = scanner.next();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        productList.add(new Product(productId,name , price , quantity));
        
        System.out.println("Product added Sucessfully......\n");
        
        // Add new product to inventory (complete this)
    }
    public void addProduct(CartProduct pro) {
    	productList.add(new Product(pro.getProductId(),pro.getName() , pro.getPrice()/pro.getQuantityInStock() , pro.getQuantityInStock()));
    }

    
    
    // Method to search for a product by ID (INCOMPLETE)
    public Product searchProduct(int productId) {
        Iterator<Product> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId() == productId) {
                return product; // Product found
            }
        }

        // If product not found, throw custom exception
        throw new ProductNotFoundException("Product with ID " + productId + " not found.");
    }

    
    
    // Method to update a product's details (INCOMPLETE)
    public void updateProduct() {
        if(productList.isEmpty()) {
        	System.out.println("there are no products yet.....");
        }
        else {
        	System.out.print("Enter Product ID to update: ");
            int productId = scanner.nextInt();

            try {
                Product product = searchProduct(productId);
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                product.setPrice(newPrice); // Complete setter in Product class

                System.out.print("Enter new quantity in stock: ");
                int newQuantity = scanner.nextInt();
                product.setQuantityInStock(newQuantity); // Complete setter in Product class

                System.out.println("Product updated successfully!");
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void updateProduct(int id , String aame,double price ,int qua ) {
    	for(int j =0;j<productList.size();j++) {
    		if(productList.get(j).getProductId()==id) {
    			productList.get(j).setQuantityInStock(productList.get(j).getQuantityInStock()+qua);
    		}
    	}
    	
    }
    public void removeProducts(int id) {
    	Iterator<Product> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId() == id) {
                iterator.remove();
                System.out.println("Removed discontinued product: " + product.getName());
            }
        }
    }

    // Method to remove discontinued products (COMPLETE)
    public void removeDiscontinuedProducts() {
        Iterator<Product> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getQuantityInStock() == 0) {
                iterator.remove();
                System.out.println("Removed discontinued product: " + product.getName());
            }
        }
    }

    
    
    // Method to display all products in inventory (COMPLETE)
    public void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
        	Collections.sort(productList);
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    // Main method to run the menu-driven application (INCOMPLETE)
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Cart cart = new Cart(); // Cart operations can be added here
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean b=true;

        System.out.println("\n=== Inventory Management System ===");
        System.out.println("1. Add Product");
        System.out.println("2. Search Product by ID");
        System.out.println("3. Update Product");
        System.out.println("4. Remove Discontinued Products");
        System.out.println("5. Remove the product ");
        System.out.println("6. Display All Products");
        System.out.println("7. Add to Cart");
        System.out.println("8. Remove Product from the Cart ");
        System.out.println("9. Display All Products in the Cart");
        System.out.println("0. Exit");
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inventory.addProduct();
                    break;
                    
                    
                    
                case 2:
                	if(inventory.getproductList().isEmpty()) {
                		System.out.println("there are no products yet .....");
                	}
                	else {
                		System.out.print("Enter Product ID to search: ");
                        int productId = scanner.nextInt();
                        try {
                            Product product = inventory.searchProduct(productId);
                            System.out.println("Product found: " + product+"\n");
                            
                        } catch (ProductNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                	}
                    break;
                    
                    
                case 3:
                    inventory.updateProduct();
                    break;
                    
                    
                case 4:
                    inventory.removeDiscontinuedProducts();
                    break;
                    
                    
                case 5:
                	System.out.print("Enter the product id to remove : ");
                    int pid = scanner.nextInt();
                    inventory.removeProducts(pid);
                    cart.removeProduct1(pid);
                    break;
                    
                    
                    
                case 6:
                	inventory.displayAllProducts();
                	break;
                	
                	
                	
                	
                	
                case 7:
                	
                    cart.addProduct();
                	break;
                	
                	
                	
                case 8:
                     cart.removeProduct();      
                    break;
                    
                    
                    
                case 9:
                	cart.displayCart();   
                	
                    break;
                    
                    
                    
                case 0 :
                	System.out.println("Exiting...");
                	b=false;
                	break;
                	
                	
                	
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (b);
        scanner.close();
    }
}
