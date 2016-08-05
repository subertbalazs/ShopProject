
public class Store {

	private String name;
	private String address;
	private String owner;
	private Milk[] diaryProducts;
	private int flag;

	public Store(String name, String address, String owner, Milk[] diaryProducts) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.diaryProducts = diaryProducts;
	}

	public Store(String name, String address, String owner) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getOwner() {
		return owner;
	}
}
