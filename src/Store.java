
public class Store {

	private String name;
	private String address;
	private String owner;
	private Milk diaryProducts;
	private int flag;

	public Store(String name, String address, String owner, Milk diaryProducts, int flag) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.diaryProducts = diaryProducts;
		this.flag = flag;
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
