import java.util.HashMap;

/**
 * ProdcutCategory class holds a HashMap which contains all the Products that are
 * exempt from the basic sales tax.
 *
 * @author Vanessa Esli Tovar
 */ 

public class ProductCategory{
    private HashMap<String, String> exemptCategory;
    
    /**
     * Constructor that allows the user to input a HashMap from another file.
     */ 
    public ProductCategory(HashMap exemptCategory){
        this.exemptCategory = exemptCategory;
    }
    
    /**
     * Constructor 
     */ 
    public ProductCategory(){
        this.exemptCategory = new HashMap<String, String>();
    }
    
    /**
     * Getter method for getting the exempt category of the given product name.
     * @param productName name of the product the user wants to get the exempt category of
     */ 
    public boolean getExemptCategory(String productName){
        String[] temp = productName.split("\\s+");
        
        for (int i=0; i<temp.length; i++){
            if( this.exemptCategory.containsKey(temp[i].toLowerCase()) ){
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Adds the given product and its exempt category name to the HashMap exemptCategory.
     *
     * @param prodcutName name of the product user wants to add
     * @param exemptCategoryName name of the exempt category name (ex: food, books, medical...)
     */ 
    public boolean addProduct(String productName, String exemptCategoryName){
        if(this.exemptCategory.containsKey(productName) ){
            return false;
        }
        else{
            this.exemptCategory.put(productName, exemptCategoryName);
            return true;
        }
    }
    
    /**
     * Changes the prodcut name (key) in the HashMap exemptCategory.
     * @param productName the name of the product whose exempt category user wants to change
     * @param exemptCategoryName the name of the exempt category user wants to change the prodcut to
     *
     * Example: [chocolate][food] --> [chocolate][medical]
     *          ProductCategory.changeProductExemptCategory("chocolate", "medical");
     */ 
    public boolean changeProductExemptCategory(String productName, String exemptCategoryName){
        if(this.exemptCategory.containsKey(productName)){
            this.exemptCategory.put(productName, exemptCategoryName);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Removes prodcut from the HashMap exemptCategory.
     *
     * @param productName name of the product user wants to remove
     */ 
    public boolean removeProduct(String productName){
        if(this.exemptCategory.containsKey(productName)){
            this.exemptCategory.remove(productName);
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        
    } 
}