import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class TestTask7 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1;
			s1 = br.readLine();
			int[] nAndK = Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = nAndK[0];
			int k = nAndK[1];
			BigInteger divider = BigInteger.valueOf(998244353);
			String s2 = br.readLine();
			int[] nums = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
			int[][] sums = new int[n][n];
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					sums[i][j] = nums[i] + nums[j];
				}
			}

			for (int p = 1; p <= k; p++) {
				BigInteger sum = BigInteger.valueOf(0);
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < i; j++) {
						BigInteger power = BigInteger.valueOf(sums[i][j]).pow(p);
						sum = sum.add(power).mod(divider);
					}
				}
				System.out.println(sum);
			}

		} catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

}
