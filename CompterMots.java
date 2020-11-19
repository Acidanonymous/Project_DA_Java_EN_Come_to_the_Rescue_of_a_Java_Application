import java.util.*;
import java.io.*;

public class CompterMots {
 
	public static void main(String[] argv) throws IOException {
        Map<String, Integer> table = new HashMap<>();

        
        FileInputStream fstream = new FileInputStream("c:\\symptoms.txt");
 // selction fichier
		try (BufferedReader entree = new BufferedReader(new FileReader("c:\\symptoms.txt"))) {
            // mise en cache
			for (String ligne = entree.readLine(); ligne != null; ligne = entree
					.readLine()) {
				for (String symptom : ligne.split(" ")) {
 
					if ( table.containsKey( symptom ) ) {
						table.put( symptom , table.get(symptom) + 1 );
					}
					else {
						table.put( symptom , 1 );
					}
 
				}
			}
		
		}
 
	
		 Map<String, Integer> OrderTable = new TreeMap<>(table);
		 System.out.println();
		 
		 FileWriter writer = new FileWriter ("result.out");
		 for (Map.Entry<String, Integer> entry : OrderTable.entrySet()) {
				String symptom = entry.getKey();
				int nombre = entry.getValue();
				System.out.println(symptom + ":" + nombre);
				writer.write(symptom + ":" + nombre + "\n");
			}
		 
		
			writer.close();
	}
	
}