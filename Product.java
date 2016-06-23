
/**
 * Prodcut class holds the products' name, quantity, price, and imported tax status
 * (whether the product is exempt from the tax or not).
 *
 * @author Vanessa Esli Tovar
 */ 

public class Product{
    // fields
    private String name;
    private int quantity;
    private float price;
    private boolean imported; //does imported tax apply to this product?
    
    public Product(String name, int quantity, float price, boolean imported){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imported = imported;
    }

    /**
     * Getter method for the product name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter method for the product quantity.
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Getter method for the product price.
     */
    public float getPrice(){
        return this.price;
    }

    /**
     * Getter method for the product's imported tax status.
     */
    public boolean isImported(){
        return this.imported;
    }

    public static void main(String[] args){
       
    
    }
}