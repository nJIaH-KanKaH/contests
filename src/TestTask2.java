import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTask2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1;
			s1 = br.readLine();
			int numOfDays = Integer.parseInt(s1);
			int[] cash = new int[numOfDays];
			for (int i = 0; i < numOfDays; i++) {
				String s = br.readLine();
				cash[i] = Integer.parseInt(s);
			}
			for (int i = 0; i < numOfDays; i++) {
				System.out.println(amountSpent(cash[i]));
			}
		} catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	public static int amountSpent(int cash) {
		if (cash < 7) {
			
			return -1;
		}
		int maxPowOfTwo = (int) Math.floor(log2(cash));
		for (int i = maxPowOfTwo; i > 0; i--) {
			int amountLeftAfterDay1 = cash - highestPowerof2(cash);
			if (amountLeftAfterDay1 < 3) {
				continue;
			}
			int amountLeftAfterDay2 = amountLeftAfterDay1 - highestPowerof2(amountLeftAfterDay1);
			if (amountLeftAfterDay2 < 1) {
				continue;
			}
			int amountLeftAfterDay3 = amountLeftAfterDay2 - highestPowerof2(amountLeftAfterDay2);
			return cash - amountLeftAfterDay3;
		}
		return -1;
	}

	public static int highestPowerof2(int val) {
		if ((val & (val - 1)) == 0)
			return val;
		return (1 << (Integer.toBinaryString(val).length() - 1));
	}

	public static double log2(double x) {
		if (x <= 0) {
			throw new IllegalArgumentException("X lower than 0");
		}
		return Math.log(x) / Math.log(2);
	}
}
