import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Parser class reads the .txt input file and stored its contents in
 * ArrayList<String> rawData.
 * 
 * @author Vanessa Esli Tovar
 */

public class Parser{
	// declaring field(s)
	private ArrayList<String> rawData;
	
	/**
	 * Class constructor.
	 */
	public Parser(){
		// ArrayList of Strings that stores input.
		this.rawData = new ArrayList<String>();
	}

	/**
	 * Reads the .txt input and stores the input in ArrayList rawData as it appears in the input
	 * ex: ["1 book at 12.49", "1 music CD at 14.99", ..., "1 chocolate bar at 0.85"]
	 */
	public void readInput(String filename){
		String line = null;
		try{
			FileReader fileReader = new FileReader(filename);
			// wrap FileReader in BufferedReader in order to be able to deal with
			// the data one line at a time
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			// while the line being read is not null, add it to rawData.
			while((line = bufferReader.readLine()) != null){
				rawData.add(line);
			}
			bufferReader.close();
		}

		catch(FileNotFoundException ex){
			System.out.println("Unable to open file " + filename);
		}

		catch(IOException ex) {
           System.out.println(
               "Error reading file " + filename);
       }
	}

	/**
	 * Getter that returns the rawData.
	 */ 

	public ArrayList<String> getRawData(){
		return this.rawData;
	}



	public static void main(String[] args){
		
	}
}