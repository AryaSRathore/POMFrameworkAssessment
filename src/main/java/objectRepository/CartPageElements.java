package objectRepository;

import org.openqa.selenium.By;

public class CartPageElements {
    public static final By ITEM_NAME = By.xpath("//a/div[@class='inventory_item_name']");
    public static final By ITEM_PRICE = By.xpath("//div/div[@class='item_pricebar']/div[@class='inventory_item_price']");
    public static final By CHECKOUT = By.xpath("//button[@id='checkout']");
    public static final By CART_COLUMN = By.xpath("//div[@class='cart_item']");
}
