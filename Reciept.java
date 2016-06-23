import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Reciept class contains the methods to print the reciept in the terminal as
 * well as a method to save the reciept to a .txt file.
 *
 * @author Vanessa Esli Tovar
 */

public class Reciept{
	private float totalTax;
	private double totalCost;
	private ArrayList<String> output;

	/**
	 * Constructor.
	 */
	public Reciept(){
		this.output = new ArrayList<String>();
	}
	
	/**
	 * Adds a line (type String) to the ArrayList<String> output.
	 *
	 * @param s Line of type String that user wishes to add to the ArrayList output.
	 */
	public void addLine(String s){
		this.output.add(s);
	}
	
	/**
	 * To string method.
	 */
	public String toString(){
		StringBuffer buffer = new StringBuffer();
     	for (String s : this.output){
     		// append every string in this.output
			buffer.append(s);
			// add new line character after adding a string
			buffer.append("\n");
		}
     	
     	return buffer.toString();
	}
	
	/**
	 * Prints the reciept to the terminal.
	 */
	public void printReciept(){
		System.out.println("=====================");
		System.out.println("OUTPUT:");

		for (String s : this.output){
			System.out.println(s);
		}
		System.out.println("=====================");
	}
	
	/**
	 * Saves the output in a .txt file.
	 */
	public void save(String outputFileName){
		try {

			String content = this.toString();

			File file = new File(outputFileName);

			// if the file doesn't already exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}