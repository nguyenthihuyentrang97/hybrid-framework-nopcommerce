package javaBasic;

public class Topic_14_String_Format {

	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";

	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";

	public static String REWARD_POINTS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";

	public static String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";

	public static String DOWNLOADABLE_PRODUCT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Downloadable products']";

	public static String BACK_IN_STOCK_SUBSCIPTION_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Back in stock subscriptions']";

	// Set 1 biến chung để gọi tất cả các Locator (fomat giống, khác bởi tên page)

	public static String DYNAMIC_SIDE_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

	// Set 1 locator để đại diện cho các page (Header / Sidebar/ Footer)

	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {

		clickToLink(ADDRESS_LINK);

		clickToLink(BACK_IN_STOCK_SUBSCIPTION_LINK, "Customer info");

		clickToLink(ADDRESS_LINK, "account-navigation", "Addresses");
	}


	public static void clickToLink(String locator) {

		System.out.println("Click to: " + locator);
	}
//
//		// 1 tham số động
//	public static void clickToLink(String dynamicLocator, String pageName) {
//
//		// dynamicLoctor = //div[contains(@class,'account-navigation')]//a[text()='%s']
//
//		String locator = String.format(dynamicLocator, pageName);
//	}
//
//		// 2 tham số động
//	public static void clickToLink(String dynamicLocator, String areaName, String firstName) {
//
//		// dynamicLoctor = //div[contains(@class,'account-navigation')]//a[text()='%s']
//
//		String locator = String.format(dynamicLocator, areaName, firstName);
//	}

	
	// 1 - n tham số động
	public static void clickToLink(String dynamicLocator, String... params) {

		String locator = String.format(dynamicLocator, (Object[]) params);
	}
}
