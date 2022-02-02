package objectRepository;

import org.openqa.selenium.By;

public class HomePageElements {
    public static final By ITEM1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static final By INVENTORY_ITEM_PRICE = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item'][1]/div[@class='inventory_item_description']//div[@class='pricebar']//div[@class='inventory_item_price']");
    public static final By INVENTORY_ITEM_NAME = By.xpath("//div[@class='inventory_list']/div[@class='inventory_item'][1]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div[@class='inventory_item_name']");
    public static final By CARTS_BTN = By.xpath("//a[@class='shopping_cart_link']");

}
