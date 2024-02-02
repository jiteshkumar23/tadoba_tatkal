package booking;

import org.testng.annotations.Test;

public class KillChrome {

	@Test
	private static void KillChromeMethod() throws Exception {

		try {
			System.out.println("Kill Start");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Thread.sleep(1000);
			System.out.println("Killed chromedriver");

		} catch (Exception e) {
			System.out.println("Error in killing chromedriver");
			e.printStackTrace();
		}
		
		try {
			
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Thread.sleep(1000);
			System.out.println("Killed chrome browser");
		} catch (Exception e) {
			System.out.println("Error in killing chrome browser");
			e.printStackTrace();
		}

	}

}
