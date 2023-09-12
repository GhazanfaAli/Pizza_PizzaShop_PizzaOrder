
import java.util.ArrayList;
import java.util.Arrays;

class Pizza {
    private String flavour;
    private short price;

    public Pizza(String flavour, short price) {
        this.flavour = flavour;
        this.price = price;
    }

    public String getFlavour() {
        return flavour;
    }

    public short getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return flavour;
    }
}

class PizzaShop {
    String shopName;
    private ArrayList<Pizza> flavoursOffered;
    private int phoneNo;

    public PizzaShop(String shopName, ArrayList<Pizza> flavoursOffered, int phoneNo) {
        this.shopName = shopName;
        this.flavoursOffered = flavoursOffered;
        this.phoneNo = phoneNo;
    }

    public void displayFlavourswithPrice() {
        System.out.println("Pizzas offered from shop :  " + shopName + ":");
        for (Pizza pizza : flavoursOffered) {
            System.out.println(pizza.getFlavour() + " - $" + pizza.getPrice());
        }
    }

    public String getShopName() {
        return shopName;
    }

    public short calculateAmount(String[] pizzas) {
        short amount = 0;
        for (String pizzaFlavour : pizzas) {
            for (Pizza pizza : flavoursOffered) {
                if (pizza.getFlavour().equals(pizzaFlavour)) {
                    amount += pizza.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}

class PizzaOrders {
    private PizzaShop orderFrom;
    private String[] pizzaSelected;
    private short totalAmount;
    private float deliveryTime = 23;

    public PizzaOrders(PizzaShop orderFrom) {
        this.orderFrom = orderFrom;
    }

    public void displayFlavours() {
        orderFrom.displayFlavourswithPrice();
    }

    public void makeOrder(String... pizzaFlavours) {
        pizzaSelected = pizzaFlavours;
    }

    public void calculateTotalAmount() {
        totalAmount = orderFrom.calculateAmount(pizzaSelected);
    }

    public void printOrder() {
        System.out.println();
        System.out.println("Order from " + orderFrom.shopName);
        System.out.println("Selected Pizzas:");
        for (String pizzaFlavour : pizzaSelected) {
            System.out.println(pizzaFlavour);

        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Delivery Time: " + deliveryTime + " minutes");
        System.out.println("____________________________");

    }
}

class PizzaMain {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("flavour1", (short) 232);
        Pizza pizza2 = new Pizza("flavour2", (short) 132);
        Pizza pizza3 = new Pizza("flavour3", (short) 432);
        Pizza pizza4 = new Pizza("flavour4", (short) 632);

        ArrayList<Pizza> shop1Flavours = new ArrayList<>(Arrays.asList(pizza1, pizza2));
        ArrayList<Pizza> shop2Flavours = new ArrayList<>(Arrays.asList(pizza3, pizza4));

        PizzaShop pizzaShop1 = new PizzaShop("shop1", shop1Flavours, 123456789);
        PizzaShop pizzaShop2 = new PizzaShop("shop2", shop2Flavours, 987654321);

        PizzaOrders pizzaOrders1 = new PizzaOrders(pizzaShop1);
        PizzaOrders pizzaOrders2 = new PizzaOrders(pizzaShop2);

        pizzaOrders1.makeOrder("flavour1", "flavour2");
        System.out.println();
        pizzaOrders2.makeOrder("flavour3", "flavour4");

        pizzaOrders1.calculateTotalAmount();
        System.out.println();

        pizzaOrders2.calculateTotalAmount();


        pizzaOrders1.displayFlavours();
        pizzaOrders2.displayFlavours();

        pizzaOrders1.printOrder();
        pizzaOrders2.printOrder();



    }
}

