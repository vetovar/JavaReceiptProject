import java.util.ArrayList;

/**
 * Main class contains methods that tie all the other classes
 * (Parser, ProductCategory, Product, Tax, Cart, Reciept) together.
 *
 * @author Vanessa Esli Tovar
 */

public class Main{
    
    private Parser parser;
    private Cart cart;
    private Tax tax;
    private ProductCategory productCategory;
    private Reciept reciept;
    
    /**
     * Constructor.
     */
    public Main(String filename, float basicTaxRate, float importedTaxRate){
        parser = new Parser();
        cart = new Cart();
        tax = new Tax(basicTaxRate, importedTaxRate);
        productCategory = new ProductCategory();
        reciept = new Reciept();
        
        init(filename);
    }
    
    /**
     * Creates product categories, calls method to read the input, calls
     * method that creates and adds products.
     * 
     * @param filename name of the input file 
     */
    private void init(String filename){
        // create product cateogries 
        // hard coded key-value for this project 
        productCategory.addProduct("book", "books");
        productCategory.addProduct("books", "books");
        productCategory.addProduct("chocolate", "food");
        productCategory.addProduct("chocolates", "food");
        productCategory.addProduct("pills", "medical");
        
        // read input
        parser.readInput(filename);
        
        // addProducts
        try {
            this.addProducts(parser.getRawData());
        } catch (Exception e) {
            System.out.println("Check input integrity");
        }
        
        this.generateReceipt();

    }
    
    /**
     * Creates and adds products using the rawData created in Parser class,
     * and addProduct() method in the Cart class.
     * 
     * @param rawData ArrayList<String> of data
     */
	private void addProducts(ArrayList<String> rawData){
		for(int i = 0; i < rawData.size(); i++) {
			// split row at every space and store in array temp
			String[] temp = rawData.get(i).split("\\s+");
			
			String name = "";
		    int quantity = 0;
    		float price = 0;
    		boolean imported = false;
            
            // quantity is always the first
    		quantity = Integer.parseInt(temp[0]);
    		price = Float.parseFloat(temp[temp.length-1]);
    		
    		// don't need to check fist item (quantity) and last item (price)
    		for (int j=1; j<temp.length-2; j++){
    		    if (temp[j].equals("imported")){
    		        imported = true;
    		        if (j == 1){ // leave imported at the begining  
    		            name = name + temp[j] + " ";
    		        } 
                    else{ // move it to the begining 
    		            name = "imported "+name;
    		        }
    		    }
    		    else{
    		        name = name + temp[j] + " ";
    		    }
    		    
    		}
    		// removes the last character in the name (the extra space)
    		name = name.substring(0, name.length()-1);
    		
    		boolean notExempt = !productCategory.getExemptCategory(name);
    		
    		System.out.println("Product: "+name+" and its notExempt status is "+notExempt+", imported: "+imported);
    		float totalTax = tax.calcTax(quantity, price, notExempt, imported);
    		cart.addProduct(name, quantity, price, imported, totalTax);
		}
	}
    
    /**
     * Generates reciept using methods in the Cart class and Reciept class.
     */
    private void generateReceipt(){
        ArrayList<Product> productList = cart.getProductList();
        ArrayList<Float> costsList = cart.getCostsList();
        for (int i=0; i<productList.size(); i++){
            String quantity = ""+productList.get(i).getQuantity();
            String name = ""+productList.get(i).getName();
            String cost = ""+Math.round(costsList.get(i) * 100.0) / 100.0;
            //String cost = ""+costsList.get(i);
            
            reciept.addLine(quantity+" "+name+": "+cost);
        }
        
        reciept.addLine("Total Taxes: "+Math.round(cart.getTotalTax() * 100.0) / 100.0);
        reciept.addLine("Total: "+ Math.round((cart.getTotalTax()+cart.getTotalCost()) * 100.0) / 100.0);
        // print reciept
    }
    
    /**
     * Saves the reciept in a .txt file by calling methods in the Reciept class.
     * 
     * @param outputFileName the desired name of the output file name (ex: "output1.txt")
     */
    public void saveReciept(String outputFileName){
        this.reciept.printReciept();
        this.reciept.save(outputFileName);
    }
    
    /**
     * Main method.
     */
    public static void main(String[] args){
        String filename = "";
        System.out.println(args[0]);
        
		if (args.length > 0){
			filename = args[0];
		}
		else{
			filename = "input1.txt";
		}
		
		float basicTaxRate = 0.1f;
		float importedTaxRate = 0.05f;
        System.out.println("Basic Tax: "+basicTaxRate);
        System.out.println("Import Tax: "+importedTaxRate);
        System.out.println("=====================");
        
        Main m = new Main(filename, basicTaxRate, importedTaxRate);
        m.saveReciept("output.txt"); // "output.txt" is the output file name which the user can change here
    }
}