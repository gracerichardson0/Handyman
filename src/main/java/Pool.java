public class Pool extends Contract {
	public static final double BASE_COST = 10.00;
   public static final double COST_FOR_CLEANING = 40.00;
   public static final double COST_FOR_CHEMICALS = 20.00;
   public static final double CHEMICALS_PER_POOL = 0.5;
	private boolean clean;
	private boolean chemicals;
	
	public Pool(String name, String address, boolean clean, boolean chemicals) {
		super (name, address);
		this.clean = clean;
		this.chemicals = chemicals;
	}
   
	public boolean getChemicals() {return this.chemicals;}
   
	public double cost() {
		return BASE_COST + ((this.clean) ? COST_FOR_CLEANING : 0) + ((this.chemicals) ? COST_FOR_CHEMICALS : 0);
	}
	
	public String toString () {
		return super.toString() + "\n" +
			"Pool Contract for: \n" + super.toString() + "\nCost: " + String.format("$%.2f", this.cost());	}
}