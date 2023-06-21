package pageObjects.saurcelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saurcelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPO extends BasePage {
    WebDriver driver;
    public ProductPO(WebDriver driver){
        this.driver = driver;
    }

    public void selectItemInProductSortDropdown(String textItem) {
        waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
        selectItemInDefaultDropdown(driver,ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
    }

    public boolean isProductNameSortByAscending() {
        // Khai báo ra 1 ArrayList để chứa các product name trên UI
        ArrayList<String> productUIList = new ArrayList<String>();

        //Lấy ra hết tất cả các text product name
        List<WebElement> productNameText = getElements(driver,ProductPageUI.PRODUCT_NAME_TEXT);

        //Dung vong lap de getText và add vào ArrayList trên
        for (WebElement productName: productNameText){
            productUIList.add(productName.getText());
            System.out.println("Product Name trên UI: " + productName.getText());
        }

        //Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ có đúng hay không
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product: productUIList){
            productSortList.add(product);
        }

        // Sort cái productSortList
        Collections.sort(productSortList);
        for  (String productName:productSortList ){
            System.out.println("Product Name sau khi sort: "+ productName);
        }

        // So sánh 2 List đã bằng nhau
        return  productSortList.equals(productUIList);
    }

    public boolean isProductNameSortByDescending() {
        // Khai báo ra 1 ArrayList để chứa các product name trên UI
        ArrayList<String> productUIList = new ArrayList<String>();

        //Lấy ra hết tất cả các text product name
        List<WebElement> productNameText = getElements(driver,ProductPageUI.PRODUCT_NAME_TEXT);

        //Dung vong lap de getText và add vào ArrayList trên
        for (WebElement productName: productNameText){
            productUIList.add(productName.getText());
            System.out.println("Product Name trên UI: " + productName.getText());
        }

        //Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ có đúng hay không
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product: productUIList){
            productSortList.add(product);
        }

        // Sort cái productSortList
        Collections.sort(productSortList);

        for  (String productName:productSortList ){
            System.out.println("Product Name sau khi ASC: "+ productName);
        }

        // Revert cái productSortList
        Collections.reverse(productSortList);

        for  (String productName:productSortList ){
            System.out.println("Product Name sau khi DESC: "+ productName);
        }

        // So sánh 2 List đã bằng nhau
        return  productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByAscending() {
        ArrayList<Float> productUIList = new ArrayList<Float>();

        List<WebElement> productPriceText = getElements(driver,ProductPageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice: productPriceText){
/*            String priceText = productPrice.getText();
            //Xóa kí tự $
            priceText.replace("$","");
            //Convert qua kiểu Float
            Float priceTextFload = Float.parseFloat(priceText);*/

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$","")));
            System.out.println("Product Name trên UI: " + productPrice.getText());
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product: productUIList){
            productSortList.add(product);
        }

        Collections.sort(productSortList);

        for  (Float productPrice:productSortList ){
            System.out.println("Product Name sau khi ASC: "+ productPrice);
        }

        return  productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByDescending() {
        ArrayList<Float> productUIList = new ArrayList<Float>();

        List<WebElement> productPriceText = getElements(driver,ProductPageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice: productPriceText){

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$","")));
            System.out.println("Product Name trên UI: " + productPrice.getText());
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product: productUIList){
            productSortList.add(product);
        }

        Collections.sort(productSortList);

        for  (Float productPrice:productSortList ){
            System.out.println("Product Price sau khi ASC: "+ productPrice);
        }
        Collections.reverse(productSortList);

        for  (Float productPrice:productSortList ){
            System.out.println("Product Price sau khi DESC: "+ productPrice);
        }

        return  productSortList.equals(productUIList);
    }
}
