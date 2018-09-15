public abstract class Person {
   private String GNumber;
   private String name;
   
   public Person(String GNumber, String name) {
      setGNumber(GNumber); 
      setName(name); 
   }
   
   public String getGNumber() { return this.GNumber; }
   public String getName() { return this.name; }
   
   public boolean setGNumber(String GNumber) {
      if(!GNumber.equals("")) {
         this.GNumber = GNumber;
         return true;
      }
      else return false;
   }
   
   public boolean setName(String name) {
      if(!name.equals("")) {
         this.name = name;
         return true;
      }
      else return false;
   }   
   
   public String toString() {
      return "Name: " + this.getName() + "\nGNumber: " + this.getGNumber();
   }
}



