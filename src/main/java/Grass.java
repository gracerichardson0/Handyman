public class Grass extends Contract {
   public static final double SMALL_LOT_MAX_SIZE = .5;
   public static final double SMALL_LOT_COST = 50;
   public static final double LARGE_LOT_COST = 60;
	public static final double TRIM_COST = 10;
   public static final double MIN_LOT_ACRE_SIZE = 0.2;
   public static final double MAX_LOT_ACRE_SIZE = 1;
   public static final double DEFAULT_LOT_ACRE_SIZE = 0.25;
   public static final double GAS_PER_ACRE = 0.25;
	private boolean trim;
	private double lotSize;
	
	public Grass(String name, String address, boolean trim, double lotSize) {
		super(name, address);
		this.trim = trim;
		this.lotSize = (lotSize >= MIN_LOT_ACRE_SIZE && lotSize <= MAX_LOT_ACRE_SIZE)? lotSize : DEFAULT_LOT_ACRE_SIZE;
	}
   
	public double getLotSize() {return this.lotSize;}
	public double cost() {
		return ((trim) ? TRIM_COST : 0 ) +
				 ((lotSize < SMALL_LOT_MAX_SIZE) ? SMALL_LOT_COST : LARGE_LOT_COST);
	}
	
	public String toString() {
		return super.toString() + "\n"+
			"Lawn Care Contract for: \n" + super.toString() + "\nCost: " + String.format("$%.2f", this.cost());
	}
}
