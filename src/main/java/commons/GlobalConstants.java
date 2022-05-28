// Chứa những biến dùng chung cho toàn bộ framework
package commons;

import java.io.File;

public class GlobalConstants {
	public static final String  DEV_PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String  DEV_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String  TESTING_SERVE = "https://testing.nopcommerce.com/";
	public static final String  STAGING_SERVE = "https://staging.nopcommerce.com/";
	
	public static final long  SHORT_TIMEOUT = 5;
	public static final long  LONG_TIMEOUT = 30;
	public static final long  RETRY_TEST_FAIL = 3;
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	

}
