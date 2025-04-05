
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TestTask2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1;
			s1 = br.readLine();
			int numOfDays = Integer.parseInt(s1);
			BigInteger[] cash = new BigInteger[numOfDays];
			for (int i = 0; i < numOfDays; i++) {
				String s = br.readLine();
				cash[i] = BigInteger.valueOf(Long.parseLong(s));
			}
			for (int i = 0; i < numOfDays; i++) {
				System.out.println(amountSpent(cash[i]));
			}
		} catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	public static BigInteger amountSpent(BigInteger cash) {
		int day = 3;
		BigInteger initCash = cash;
		int cashBitCount;
		int cashBitLength;
		while (day > 0) {
			cashBitCount = initCash.bitCount();
			cashBitLength = initCash.bitLength();
			if (cashBitLength < day) {
				return BigInteger.valueOf(-1);
			}
			initCash = initCash.flipBit(cashBitLength - 1);
			if (cashBitCount < 2 && cashBitLength != day) {
				initCash = initCash.flipBit(cashBitLength - 2);
			}
			day--;
		}
		return cash.subtract(initCash);
	}
}
