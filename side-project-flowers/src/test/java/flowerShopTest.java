import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class flowerShopTest {

    @Test

    public void subtotal_calculation_is_correct() {
        Items actual = new Items("Elite", 12);
        BigDecimal expected = new BigDecimal("55.87");
        Assert.assertEquals(actual.getSubtotal(),expected);

        Items actual1 = new Items("Nuptial", 18);
        BigDecimal expected1 = new BigDecimal("73.81");
        Assert.assertEquals(actual1.getSubtotal(),expected1);
    }
}
