package crg.rla.section14199;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity != 0) {
            int inBasket = list.getOrDefault(item, 0);
            if (inBasket + quantity < 0) {
                //prevent attempt to 'unreserve' more than reserved
                return 0;
            }
            if (item.reserve(quantity) == 0) {
                System.out.println("Error reserving " + quantity + " for " +
                        item.getName() + ", please try again.");
                return 0;
            }
            if (inBasket + quantity == 0) {
                list.remove(item);
                return quantity;
            }
            list.put(item, inBasket + quantity);
            return quantity;
        }
        return 0;
    }

    public void checkOut(StockList stockList) {
        double totalCost = 0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
            item.getKey().reserve(-item.getValue());
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        System.out.println(this);
        System.out.printf("That cost you: $%.2f\n", totalCost);
        System.out.println("Thank you for shopping at CodeMart.\n" +
                "Come again soon," + name +".\n");
        list.clear();
    }


    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains " + list.size() +
                (list.size() == 1 ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost " + String.format("%.2f", totalCost);
    }
}
