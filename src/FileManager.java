import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {	
	// Deserializes and returns the object within a file. 
	public Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
	
	// Serializes an object into a file.
	public void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }
	
	// Reads a file of Strings into an ArrayList<String> and returns it.
	public ArrayList<String> readStringFile(String fileName) {
		ArrayList<String> str = new ArrayList<>();
		String line;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    while ((line = br.readLine()) != null) {
		        str.add(line);
		    }
	    	br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
}
