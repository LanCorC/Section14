package crg.rla.section14199;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        quantityStock = 0;
    }

    public int getReserved() {
        return reserved;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public int reserve(int quantity) {
        int newReserve = reserved + quantity;
        if (newReserve > quantityStock || newReserve < 0 || quantity == 0) {
            return 0;
        }
        reserved = newReserve;
        return quantity;
    }

    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityStock + quantityStock;
        if (newQuantity >= 0 && newQuantity >= reserved) {
            this.quantityStock = newQuantity;
        }
        if (newQuantity < reserved) {
            System.out.println("Process failure - not enough items available");
        }
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering StockItem.compareTo()");
        if (this == o) {
            return 0;
        }

        if (o!= null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price " + price  + ". Reserved: " + reserved;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }
}
