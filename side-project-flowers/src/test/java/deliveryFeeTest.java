import org.junit.Assert;
import org.junit.Test;

public class deliveryFeeTest {

    @Test

    public void delivery_fee_works_correctly() {

        Items actual = new Items("Elegant", 24);
        boolean expected = FlowerShop.sameDayDelivery(actual, true, "29999");
        Assert.assertEquals(true, expected);
    }

    @Test

    public void delivery_fee_not_offered_works_correctly() {
        Items actual = new Items("Elegant", 24);
        boolean expected = FlowerShop.sameDayDelivery(actual, false, "19999");
        Assert.assertEquals(false, expected);
    }
}
