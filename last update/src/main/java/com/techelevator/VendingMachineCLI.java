package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT};
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed money";
	private static final String SUB_MENU_OPTION_PURCHASE = "Purchase";
	private static final String SUB_MENU_OPTION_END = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_PURCHASE,
			SUB_MENU_OPTION_END };
	private static final String MONEY_MENU_OPTION_ONE = "Feed 1 dollar";
	private static final String MONEY_MENU_OPTION_TWO = "Feed 2 dollars";
	private static final String MONEY_MENU_OPTION_FIVE = "Feed 5 dollars";
	private static final String MONEY_MENU_OPTION_TEN = "Feed 10 dollars";
	private static final String[] MONEY_MENU_OPTIONS = { MONEY_MENU_OPTION_ONE, MONEY_MENU_OPTION_TWO,
			MONEY_MENU_OPTION_FIVE, MONEY_MENU_OPTION_TEN };
	private static VendingMachine vm = null;
	private Menu menu;






	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vm.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true) {
					System.out.println("Your balance is " + vm.balance);
					String submenuChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (submenuChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						String moneyMenuChoice = (String) menu.getChoiceFromOptions(MONEY_MENU_OPTIONS);
						if (moneyMenuChoice.equals(MONEY_MENU_OPTION_ONE)) {
							vm.feedMoney(1);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TWO)) {
							vm.feedMoney(2);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_FIVE)) {
							vm.feedMoney(3);
						} else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TEN)) {
							vm.feedMoney(4);
						}
					} else if (submenuChoice.equals(SUB_MENU_OPTION_PURCHASE)) {
						vm.displayInventory();
						System.out.println("Please input your selection");
						Scanner selection = new Scanner(System.in);
						String guestSelection = selection.nextLine().toUpperCase();
						vm.purchase(guestSelection);
					} else if (submenuChoice.equals(SUB_MENU_OPTION_END)) {
						vm.completeTransaction();

						break;
					}
				}
			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT))
			{

				System.exit(0);

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		vm = new VendingMachine(new Inventory().fileImporter());
		cli.run();
	}
}

