package crg.rla.section14199;

public class MainChallenge {
        /*

    Modify the program so that adding items to the shopping basket doesn't
    actually reduce the stock count but, instead, reserves the requested
    number of items. DONE

    You will need to add a "reserved" field to the StockItem class to store the
    number of items reserved. DONE

    Items can continue to be added to the basket, but it should not be possible to
    reserve more than the available stock of any item. An item's available stock
    is the stock count less the reserved amount. DONE

    The stock count for each item is reduced when a basket is checked out, at which
    point all reserved items in the basket have their actual stock count reduced.

    Once checkout is complete, the contents of the basket are cleared. DONE

    It should also be possible to "unreserve" items that were added to the basket
    by mistake. DONE - same command 'addToBasket' [basket] and 'reserve' [stockItem]

    The program should prevent any attempt to unreserve more items than were
    reserved for a basket. DONE - in scenario, negative value in Basket Integer denied

    Add code to Main that will unreserve items after they have been added to the basket,
    as well as unreserving items that have not been added to make sure that the code
    can cope with invalid requests like that.

    After checking out the baskets, display the full stock list and the contents of each
    basket that you created.

     */
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", .86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62.50, 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        //Testing stocklist (copy pasted)
        System.out.println(stockList);

        System.out.println("\nThat looks tasty (adding a reservation):");
        Basket timsBasket = new Basket("Tim");
        timsBasket.addToBasket(stockList.get("cake"), 1);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("cake").getReserved());

        System.out.println("\nAdding additional cake:");
        timsBasket.addToBasket(stockList.get("cake"), 6);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("cake").getReserved());

        System.out.println("\nToo much cake! (unreserving):");
        timsBasket.addToBasket(stockList.get("cake"), 5);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("cake").getReserved());

        System.out.println("\nCutting back on cake (unreserve number too big):");
        timsBasket.addToBasket(stockList.get("cake"), -10);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("cake").getReserved());

        System.out.println("\nCutting back on cake:");
        timsBasket.addToBasket(stockList.get("cake"), -5);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("cake").getReserved());

        System.out.println("\nCutting back on juice (not added to cart):");
        timsBasket.addToBasket(stockList.get("juice"), -2);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("juice").getReserved());

        System.out.println("\nI could use more doors (reserving number too big):");
        timsBasket.addToBasket(stockList.get("door"), 10);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("door").getReserved());

        System.out.println("\nThat's a shame:");
        timsBasket.addToBasket(stockList.get("door"), 4);
        System.out.println(timsBasket);
        System.out.println("Reserved: " + stockList.get("door").getReserved());

        System.out.println("\nStock list unaffected.");
        System.out.println(stockList);

        System.out.println("\nAwaiting checkout...");
        timsBasket.checkOut(stockList);
        System.out.println("\nStock list affected.");
        System.out.println(stockList);

    }
}
