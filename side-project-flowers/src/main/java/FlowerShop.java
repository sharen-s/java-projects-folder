import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerShop {

    private static List<Items> flowers = new ArrayList<>();
    public static void main(String[] args)  {
        System.out.println("Total Sales: $" + loadFile());
        for (Items flowerShopOrder : flowers) {
            System.out.println(flowerShopOrder);
        }
    }

    public static BigDecimal loadFile() {
        BigDecimal total = BigDecimal.ZERO;
        File file = new File("FlowerInput.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineArr = line.split("\\,");
                Items flowerShopOrder = new Items(lineArr[0], Integer.parseInt(lineArr[1]));
                flowers.add(flowerShopOrder);
                total = total.add(flowerShopOrder.getSubtotal());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problem with file");
        } return total.setScale(2, RoundingMode.HALF_UP);
    }

    public static boolean sameDayDelivery (Items flowerShopOrder, boolean isSameDayDelivery, String zipCode) {
        boolean isSameDay = flowerShopOrder.getSubtotal().compareTo(new BigDecimal("2000")) == 1;
        int zipcode = Integer.parseInt(zipCode);
        if (!isSameDayDelivery) {
            return false;
        } else {
            flowerShopOrder.getSubtotal().add(new BigDecimal(5.99));
        } if (!isSameDay) {
            if (zipcode >= 20000 && zipcode <= 29999) {
                flowerShopOrder.getSubtotal().add(new BigDecimal(3.99));
            }
            if (zipcode >= 30000 && zipcode <= 39999) {
                flowerShopOrder.getSubtotal().add(new BigDecimal(6.99));
            }
            if (zipcode >= 10000 && zipcode <= 19999) {
                flowerShopOrder.getSubtotal().add(new BigDecimal(0.00));
            }
        } else {
            flowerShopOrder.getSubtotal().add(new BigDecimal(19.99));
        }
        return true;
    }
}
