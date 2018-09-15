import javax.swing.JOptionPane;
public class AITHandyman {
	public static final int MAX_NUM_CUSTOMERS = 100;
   
	public static void main (String[] args) {
		Contract[] contracts = new Contract[MAX_NUM_CUSTOMERS];
		boolean quit = false;
		do {
         switch (getMenuOption()) {
            case 1:
               contracts[Contract.getNumContracts()] = addContract();
               break;
				case 2:
               printInvoices(contracts);
               break;
				case 3:
               JOptionPane.showMessageDialog(null, 
						"Chemicals needed:  " 
                  + (Pool.CHEMICALS_PER_POOL * chemicals(contracts))
                  + " gallons");
               break;
				case 4:
               JOptionPane.showMessageDialog(null, 
                  "Gas needed:  "
                  + (Grass.GAS_PER_ACRE * acreage(contracts))
                  + " gallons");
               break;
				default:
               quit = true;
			}
		} while (!quit);
	}

	private static int getMenuOption() {
		int choice;
		do {
         try {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
               "Welcome Handyman Services Inc! What do you need?\n"
               + "   1. Add a new customer\n"
               + "   2. Print invoices\n"
               + "   3. Calculate chemicals needed\n"
               + "   4. Calculate gas needed\n"
               + "   5. Quit?"
             ));
         }
         catch (NumberFormatException e) {
            choice = 0;
         }
         if (choice < 1 || choice > 5) {
            JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.");
          }
		} while (choice < 1 || choice > 5);
		return choice;
	}
	
	private static void printInvoices (Contract[] list) {
		String invoice = "***Invoices to Send***\n";
		double total = 0;
      
      if (Contract.getNumContracts() > 0) {
   		for (int i = 0; i < Contract.getNumContracts(); i++) {
   			invoice += (i+1) + ". " + list[i] + "\n\n";
   			total += list[i].cost();
   		}
   		JOptionPane.showMessageDialog(null, invoice + "Total to collect: " + String.format("$%.2f", total));
      }
      else {
         JOptionPane.showMessageDialog(null, "There are no invoices to send at this time.");
      }
	}
	private static int chemicals(Contract[] list) {
		int count = 0;
		for (int i = 0; i < Contract.getNumContracts(); i++) {
         if (list[i] instanceof Pool && ((Pool)list[i]).getChemicals()) {
            count++;
         }
      }
		return count;
	}
   
	private static double acreage(Contract [] list) {
		double total = 0;
		for (int i = 0; i < Contract.getNumContracts(); i++) {
         if (list[i] instanceof Grass)	{
				total += ((Grass)list[i]).getLotSize();
         }
      }
		return total;
	}
		  
	public static Contract addContract() {
		Contract aContract;
		
		String name = JOptionPane.showInputDialog("Enter new customer name:");
		String address = JOptionPane.showInputDialog("Enter new customer address:");
		
		Object[] options = {"Pool Care", "Lawn Care"};
		
		switch (JOptionPane.showOptionDialog(null,
    		"What type of service is requested?","A New Customer",
    		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
    		null,options,options[0])) {
			
			case JOptionPane.YES_OPTION:
            aContract = new Pool(name, address, answerYesNo("Clean Pool?"),
				answerYesNo("Check/Add Chemicals?"));
				break;
			case JOptionPane.NO_OPTION:
            aContract = new Grass(name, address, answerYesNo("Trim Lawn?"),
            answerRange("Enter the size of the lot (in acres)", Grass.MIN_LOT_ACRE_SIZE, Grass.MAX_LOT_ACRE_SIZE));
				break;
			default: JOptionPane.showMessageDialog(null, "No customer added");
            aContract = null;
		}
	   return aContract;
	}

	private static boolean answerYesNo(String prompt) {
		return JOptionPane.showConfirmDialog(null, prompt)==JOptionPane.YES_OPTION;
	}
   
   private static double answerRange(String prompt, double minValue, double maxValue) {
      double value;
      do {
         try {
            value = Double.parseDouble(JOptionPane.showInputDialog(null, prompt));
         }
         catch(NumberFormatException e) {
            value = minValue - 1;
         }
         if (value < minValue || value > maxValue) {
            JOptionPane.showMessageDialog(null, "Invalid value. Please enter a value between " + minValue + " and " + maxValue);
         }
      } while (value < minValue || value > maxValue);  
      
      return value;    
   }   
}
													 
		