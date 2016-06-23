/**
 * Tax class calculates the products' tax amount.
 *
 * @author Vanessa Esli Tovar
 */ 

public class Tax{
    
    private float basicTaxRate;
    private float importedTaxRate;
    
    /**
     * Construcor.
     *
     * @param basicTaxRate the desired basic sales tax rate
     * @param importedTaxRate the desired imported tax rate
     */
    public Tax(float basicTaxRate, float importedTaxRate){
        this.basicTaxRate = basicTaxRate;
        this.importedTaxRate = importedTaxRate;
    }
    
    /**
     * Calculates the amount of tax that should be charged for this Product
     *
     * @param quantity amount of the same product user wishes to calculate the total tax for
     * @param price price of the product user whishes to calculate tax for
     * @param notExempt notExempt status of the product--if product is not exempt from the basic sales tax, then true
     * @param imported imported status of the product--if product is imported, then true
     */    
    public float calcTax(int quantity, float price, boolean notExempt, boolean imported){
        
        float totalPrice = quantity * price; // total price without tax
        float totalTax = 0.0f;
        if (notExempt)
            totalTax += totalPrice * basicTaxRate;
        if (imported)
            totalTax += totalPrice * importedTaxRate;
        
        return totalTax;
    }
    
    
    
    /**
     * Getter method for the basic tax rate.
     */   
    public float getBasicTaxRate(){
        return this.basicTaxRate;
    }
    
    /**
     * Getter method for imported tax rate.
     */
    public float getImportedTaxRate(){
        return this.importedTaxRate;
    }
    
    /**
     * Setter method for basic tax rate.
     *
     * @param basicTaxRate desired basic sales tax rate
     */
    public void setBasicTaxRate(float basicTaxRate){
        this.basicTaxRate = basicTaxRate;
    }
    
    /**
     * Setter method for imported tax rate.
     *
     * @param importedTaxRate desired imported tax rate
     */
    public void setImportedTaxRate(float importedTaxRate){
        this.importedTaxRate = importedTaxRate;
    }
    
    
    public static void main(String[] args){
        
    }
    
}