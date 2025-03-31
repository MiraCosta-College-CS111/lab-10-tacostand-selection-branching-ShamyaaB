public class TacoStand
{
    /* CONSTANT VARIABLES */
	public static final String BAR = "----------------------------------------";
	public static final int ASADA_OPTION = 1, POLLO_OPTION = 2, LENGUA_OPTION = 3, ULTIMATE_OPTION = 4;

	/* STATIC VARIABLES */
	private static int numAsada = 0, numPollo = 0, numLengua = 0, numUltimate = 0;
	private static double totalFunds = 0;

	/**
	 * Sets the store to zero for use in automated testing.
	 */
	public static void initialize()
	{
		numAsada = numPollo = numLengua = numUltimate = 0;
		totalFunds = 0.0D;
	}

	/**
	 * Outputs menu options (kinds of tacos) customer can use to order
	 */
	public static void printMenu()
	{
		System.out.println("Menu options:\n" + TacoStand.BAR);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", 2.5);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)", 1.75);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 3, "Lengua (Beef Tongue)", 3.0);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 4, "Ultimate Taco", 18.0);
		System.out.println(TacoStand.BAR);
	}
	
	/**
	 * Returns a summary (all static variables) of the CURRENT status of the taco stand
	 */
	public static String getStatus()
	{
		return String.format("%s%nMCC Taco Stand Status%n%s%n" +
			"%-23s$%-7.2f%n%s%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n%s",
			TacoStand.BAR, TacoStand.BAR, 
			"Funds Available:", TacoStand.totalFunds, TacoStand.BAR,
			"# of Asada Left:", TacoStand.numAsada,
			"# of Pollo Left:", TacoStand.numPollo,
			"# of Lengua Left:", TacoStand.numLengua,
			"# of Ultimate Left:", TacoStand.numUltimate, TacoStand.BAR);
	}

	/**
	 * Increases totalFunds static variable
	 */
	public static void addTotalFunds(int funds)
	{
		TacoStand.totalFunds += funds;
	}
	
	/**
	 * Checks if budget is within total funds and orders supplies.
	 */
	public static boolean orderSupplies(double budget)
	{
		if(budget <= TacoStand.totalFunds) 
		{
			int tacosEach = (int)(Math.round(budget / 0.75 / 4)); // tacos cost 75 cents each in supplies

			TacoStand.totalFunds -= budget;
	
			TacoStand.numAsada += tacosEach;
			TacoStand.numPollo += tacosEach;
			TacoStand.numLengua += tacosEach;
			TacoStand.numUltimate += tacosEach;

			return true;
		}
		else 
		{
			return false;
		}
	}

	/**
	 * Checks if the requested number of tacos is available.
	 */
	public static boolean areTacosAvailable(int tacoOption, int numTacos)
	{
		switch (tacoOption) 
		{
			case ASADA_OPTION:
				return numAsada >= numTacos;
			case POLLO_OPTION:
				return numPollo >= numTacos;
			case LENGUA_OPTION:
				return numLengua >= numTacos;
			case ULTIMATE_OPTION:
				return numUltimate >= numTacos;
			default:
				return false;
		}
	}

	/**
	 * Updates totalFunds based on kind and number of tacos.
	 */
	public static void updateTotalFunds(int tacoOption, int numTacos)
	{
		if (!areTacosAvailable(tacoOption, numTacos))
		{
			System.out.println("ERROR: Not enough tacos available.");
			return; // prevents negative taco count
		}

		double cost;

		switch(tacoOption)
		{
			case TacoStand.ASADA_OPTION:
				cost = 2.5;
				TacoStand.numAsada -= numTacos;
				break;
			case TacoStand.POLLO_OPTION:
				cost = 1.75;
				TacoStand.numPollo -= numTacos;
				break;
			case TacoStand.LENGUA_OPTION:
				cost = 3.0;
				TacoStand.numLengua -= numTacos;
				break;
			case TacoStand.ULTIMATE_OPTION:
				cost = 18.0;
				TacoStand.numUltimate -= numTacos;
				break;
			default:
				cost = 0;
				break;
		}

		TacoStand.totalFunds += cost * numTacos;
	}
}