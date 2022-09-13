package javaBasic;

public class Topic_14_String_Format {

	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";

	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";

	public static String REWARD_POINTS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";

	public static String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";

	public static String DOWNLOADABLE_PRODUCT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Downloadable products']";

	public static String BACK_IN_STOCK_SUBSCIPTION_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Back in stock subscriptions']";

	// Set 1 biến chung để gọi tất cả các Locator

	public static String DYNAMIC_LOCATOR = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

	public static void main(String[] args) {

		clickToSideBarLink(BACK_IN_STOCK_SUBSCIPTION_LINK, "Customer info");
	}

	public static void clickToSideBarLink(String dynamicLocator, String pageName) {

		// dynamicLoctor = //div[contains(@class,'account-navigation')]//a[text()='%s']

		String locator = String.format(dynamicLocator, pageName);
	}
}
