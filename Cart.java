import java.util.ArrayList;

/**
 * Cart class creates the Product objects and stores them in ArrayList<Product> productList.
 * It also creates a ArrayList<Float> which stores the total cost (including tax) of the
 * Products in productList.
 *
 * @author Vanessa Esli Tovar
 */

public class Cart{
    private ArrayList<Product> productList;
    private ArrayList<Float> costsList;
    private float totalCost;
    private float totalTax;
    
    /**
     * Constructor
     */
    public Cart(){
        this.productList = new ArrayList<Product>();
        this.costsList = new ArrayList<Float>();
        this.totalCost = 0.0f;
        this.totalTax = 0.0f;
    }

    /**
     * Adds product to productList.
     *
     * @param name name of the product beind added
     * @param quanity quanity of the product being added
     * @param price price of the product being added (without tax)
     * @param imported imported status of the product being added
     * @param tax tax of the product being added
     */    
    public void addProduct(String name, int quantity, float price, boolean imported, float tax){
        productList.add(new Product(name, quantity, price, imported));
        costsList.add(new Float((quantity*price))+tax);
        totalCost += quantity * price;
        totalTax += tax;
    }
    
    /**
     * Getter methods for productList.
     */
    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    /**
     * Getter method for costList.
     */
    public ArrayList<Float> getCostsList(){
        return this.costsList;
    }
    
    /**
     * Getter method for total cost.
     */
    public float getTotalCost(){
        return totalCost;
    }
    
    /**
     * Getter method for total tax.
     */
    public float getTotalTax(){
        return totalTax;
    }
    
    
    public static void main(String[] args){
        
    }
}