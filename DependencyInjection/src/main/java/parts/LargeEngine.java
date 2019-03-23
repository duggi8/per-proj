package parts;

public class LargeEngine implements Engine {

	private int horsePower;
	
	public LargeEngine(int horsePower) {
		super();
		this.horsePower = horsePower;
	}

	public void startEngine() {
		System.out.println("started Large "+ horsePower + "engine" );
	}

	
}
