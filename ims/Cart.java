package ims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Cart {
    private List<CartProduct> products;
    Scanner scanner = new Scanner(System.in);
    InventoryManagement inventory = new InventoryManagement();
    
    
    
    public Cart() {
        products = new ArrayList<>();
    }
    public void addProduct() {
    	if(inventory.getproductList().isEmpty()) {
    		
    	}
    	else {
    		System.out.print("Enter Product ID Want to add: ");
            int pd = scanner.nextInt();
            try {
                Product product = inventory.searchProduct(pd);
                System.out.println("Enter  the Quantity to add ");
                int qq=scanner.nextInt();
                if(product.getQuantityInStock()<qq) {                        	
                }else {
                	products.add(new CartProduct(product.getProductId(),product.getName(),product.getPrice(),qq));
                	inventory.updateProduct(product.getProductId(),product.getName(),product.getPrice(),-qq);
                	
                }
                
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            }
    	}
    	
    }
    
    // Method to 
    public CartProduct removeProduct() throws ProductNotFoundException {
    	if (!products.isEmpty()) {
    		
    		System.out.print("Enter Product ID to remove the Product from Cart: ");
            int idd = scanner.nextInt();
    		Iterator<CartProduct> iterator = products.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                CartProduct product = iterator.next();
                if (product.getProductId() == idd) {
                    iterator.remove();
                    inventory.updateProduct(product.getProductId(),product.getName(),product.getPrice(),+product.getQuantityInStock());
                    System.out.println(product);
                    System.out.println("Removed from the cart");
                    return product;
                }
            }
            
            if (!found) {
                throw new ProductNotFoundException("Product with ID " + idd + " not found in the cart.");
            }
    	}
    	else {
    		System.out.println("Cart is Empty......");
    		System.out.println();
    	}
        
		return null;
    }
    public void removeProduct1(int productId) throws ProductNotFoundException {
        Iterator<CartProduct> iterator = products.iterator();
        while (iterator.hasNext()) {
            CartProduct product = iterator.next();
            if (product.getProductId() == productId) {
                iterator.remove();
                break;
            }
        }
        
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
        	Collections.sort(products);
            for (CartProduct product : products) {
                System.out.println(product);
            }
        }
    }
}

