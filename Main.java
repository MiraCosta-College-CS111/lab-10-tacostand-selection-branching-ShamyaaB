// PARTNER NAME: N/A
// PARTNER NAME: N/A
// CS111 SECTION #:
// DATE: 2/19/25

public class Main
{

	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
    {
        //DECLARATION + INITIALIZATION SECTION
        TacoStand.initialize();

        //INPUT + CALCULATION + OUTPUT SECTION
        TacoStand.addTotalFunds(20);
        TacoStand.orderSupplies(15);

        System.out.println("OPENING UP THE STAND...");
        System.out.println(TacoStand.getStatus() + "\n\n");

        Main.printWelcome();
        System.out.println("\n");

        Main.takeOrder();
        // Call takeOrder more times if you'd like! (once everything works once though!)

        System.out.println("--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
    }

    /**
     * Outputs welcome message to start program that user sees
     */
    public static void printWelcome()
    {
        UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
        UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
        UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
        UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
        UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
        UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
        UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
        // ASCII art credit:
        // https://mizbizbby.tumblr.com/post/12937794639/happy-taco-ascii-art-for-taco-thursday
    }

    /**
     * Prints menu and prompts user for input for kind of taco and number in order. If tacos are available,
     * will update total funds and confirm order with user, otherwise error message given
     */
    public static void takeOrder()
    {
        //DECLARATION + INITIALIZATION SECTION
        int option, numTacosOrdered;

        //INPUT SECTION
        TacoStand.printMenu();
        option = UtilityBelt.readInt("Enter choice> ", 1, 4);
        if (option < 1 || option > 4) {
            System.out.println("ERROR: please enter value between 1 - 4");
            option = UtilityBelt.readInt("Enter choice> ", 1, 4);
        }

        numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);
        if (numTacosOrdered < 1 || numTacosOrdered > 50) {
            System.out.println("ERROR: please enter value between 1 - 50");
            numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);
        }

        //CALCULATION + OUTPUT SECTION
        if(TacoStand.areTacosAvailable(option, numTacosOrdered))
        {
            TacoStand.updateTotalFunds(option, numTacosOrdered);
            Main.printConfirmation(numTacosOrdered);
        }
        else
        {
            System.out.println("We don't have that many tacos, sorry! Try again :(");
        }
    }

    /**
     * Prints confirmation message that varies based on number of tacos in order (low = 1-2, medium 3-5, large 6+)
     * 
     * @param numTacos
     */
    public static void printConfirmation(int numTacos)
    {
        if(numTacos >= 1 && numTacos <= 2) //small order 
        {
            // With small, medium, and large order, I just changed the print output to what *I* wanted it to say rather than what the videos told us to write
            System.out.println("That's a small order, but that's alright!");
        }
        else 
        {
            if(numTacos >= 3 && numTacos <= 5) //medium order
            {
                System.out.println("Here you go, buen provecho!"); 
            }
            else //large order
            {
                System.out.println("Wow! That's a big order!");
            }
        }
        
        // Print taco emojis
        for(int i = 0; i < numTacos; i++)
        {
            System.out.print("🌮");
        }
        
        System.out.println();
        System.out.println();
    }
}