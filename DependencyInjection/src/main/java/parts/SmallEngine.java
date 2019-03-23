package parts;

public class SmallEngine implements Engine{

	private int horsePower;
	
	public SmallEngine(int horsePower) {
		super();
		this.horsePower = horsePower;
	}
	public void startEngine() {
		System.out.println("started Small "+ horsePower + "engine" );
	}

}
