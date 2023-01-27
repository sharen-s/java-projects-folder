import java.math.BigDecimal;
import java.math.RoundingMode;

public class Items {

    public String bouquetType;
    public int numberOfRoses;
    public BigDecimal subtotal;

    public Items (String bouquetType, int numberOfRoses){
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
        this.subtotal = BigDecimal.ZERO;
        totalPrice();
    }

    private void addToTotal (double initialAmount) {
        this.subtotal = this.subtotal.add(new BigDecimal(initialAmount));
    }

    private void totalPrice() {
        addToTotal(19.99);
        addToTotal(numberOfRoses * 2.99);
    }

    public BigDecimal getSubtotal() {
        return this.subtotal.setScale(2, RoundingMode.HALF_UP);
    }


    public String toString() {
        return "ORDER - " + "{" + this.bouquetType + "} - {" + this.numberOfRoses + "} roses - {$" + getSubtotal() + "}";
    }
}


