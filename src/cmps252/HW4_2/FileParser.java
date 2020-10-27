package cmps252.HW4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	public  static List<Customer> getCustomers(String file) throws FileNotFoundException{
		List<Customer> customers = new ArrayList<Customer>();
		try(Scanner scanner = new Scanner(new File(file))){
			int count= 0;
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(count++==0) 
					continue;
				String[]fields=line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				if (fields == null)
					continue;
				Customer customer = new Customer(clean(fields[0]),clean(fields[1]),clean(fields[2]),clean(fields[3]),clean(fields[4]),clean(fields[5]),clean(fields[6]),clean(fields[7]),clean(fields[8]),clean(fields[9]),clean(fields[10]), clean(fields[11]));
				customers.add(customer);		
				
				
			}
			
			
		}
		return customers;
				
	}

	private static String clean(String string) {
		// TODO Auto-generated method stub
		return string.substring(1,string.length()-1);
	}
}
