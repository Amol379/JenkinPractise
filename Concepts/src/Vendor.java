import java.io.Serializable;

public class Vendor implements Serializable {
	private int id;
	private String name;
	private String mail;
	private String mb;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Vendor(int id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", mail=" + mail + "]";
	}

}
