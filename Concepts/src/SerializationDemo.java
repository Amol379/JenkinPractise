import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) {
		// serialize();
		deserialize();
	}

	private static void serialize() {
		Vendor ven = new Vendor(1, "Amol", "a@gmail.com");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("a.text")))) {
			oos.writeObject(ven);
			System.out.println("serialization completed..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deserialize() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("a.text")))) {
			Object obj = ois.readObject();
			Vendor vendor = (Vendor) obj;
			System.out.println(vendor.getId() + " .. " + vendor.getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
