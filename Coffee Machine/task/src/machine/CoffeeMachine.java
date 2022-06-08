package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static String currentState;
    final static String FILL = "fill";
    final static String BUY = "buy";
    final static String TAKE = "take";
    final static String REMAINING = "remaining";
    final static String EXIT = "exit";

    static Scanner input = new Scanner(System.in);

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;


    public static void printState(int water, int milk, int coffeeBeans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println("Write action");
    }
    public static void switchState (String choiceAction) {
        switch (choiceAction) {
            case (BUY):
                currentState = BUY;
                buying();
                break;
            case (FILL):
                currentState = FILL;
                filling();
                break;
            case (TAKE):
                currentState = TAKE;
                taking();
                break;
            case (REMAINING):
                currentState = REMAINING;
                remaining();
                break;
        }
    }

    public static void buying() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String chosenCoffee = input.next();
        switch (chosenCoffee) {
            case ("1"):
                makeEspresso();
                break;
            case ("2"):
                makeLatte();
                break;
            case ("3"):
                makeCappuccino();
            case ("back"):
                break;
        }
    }

    public static void makeEspresso() {
        String missingResource = "";
        if (water < 250) missingResource = "water";
        if (cups < 1) missingResource = "cups";
        if (coffeeBeans < 16) missingResource = "coffeeBeans";
        if (missingResource == "") {
            water -= 250;
            coffeeBeans -= 16;
            cups -= 1;
            money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        } else System.out.println("Sorry, not enough " + missingResource + "!");

    }

    public static void makeLatte() {
        String missingResource = "";
        if (water < 350) missingResource = "water";
        if (milk < 75) missingResource = "milk";
        if (cups < 1) missingResource = "cups";
        if (coffeeBeans < 20) missingResource = "coffeeBeans";
        if (missingResource == "") {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            cups -= 1;
            money += 7;
            System.out.println("I have enough resources, making you a coffee!");
        } else System.out.println("Sorry, not enough " + missingResource + "!");

    }

    public static void makeCappuccino() {
        String missingResource = "";
        if (water < 200) missingResource = "water";
        if (milk < 100) missingResource = "milk";
        if (cups < 1) missingResource = "cups";
        if (coffeeBeans < 12) missingResource = "coffeeBeans";
        if (missingResource == "") {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cups -= 1;
            money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        } else System.out.println("Sorry, not enough " + missingResource + "!");
    }

    public static void taking() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    public static void filling() {
        System.out.println("Write how many ml of water you want to add: ");
        water += input.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += input.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeans += input.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cups += input.nextInt();
    }

    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void action() {
        switch (currentState) {
            case BUY:
                buying();
                break;
            case TAKE:
                taking();
                break;
            case FILL:
                filling();
        }
    }

    public static void readInput(){
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String choiceAction = input.next();
        if (choiceAction.equals(EXIT)) System.exit(0);
        switchState(choiceAction);
    }

    public static void main(String[] args) {
        while (true) {
            readInput();
        }
    }
}