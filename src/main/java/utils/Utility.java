package utils;

/**
 * @author Sumit Kumar Sharma
 * @created at 20-Nov-2018
 */
public class Utility {
	
	/**
	 * This method is used for hard wait 
	 * @param sec
	 */
	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
