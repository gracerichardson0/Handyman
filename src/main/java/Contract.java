public abstract class Contract {
	private String name;
	private String address;
	private static int numContracts = 0;
	
	public Contract (String name, String address) {
      this.name = name;
		this.address = address;
		numContracts++;
	}
	
	public static int getNumContracts() { return numContracts; }
   
	public String toString() {
      return "Customer:  " + this.name + "\nAddress:  " + this.address;
   }
	
	public abstract double cost();

}
	