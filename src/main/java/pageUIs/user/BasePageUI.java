package pageUIs.user;

public class BasePageUI {
	
	public static final String ADDRESSES_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String MY_ORDER_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Orders']";
	public static final String MY_REWARD_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	
	//Dynamic link
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";

}
