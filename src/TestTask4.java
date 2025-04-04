import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestTask4 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1;
			s1 = br.readLine();
			int[] nAndXYZ = Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = nAndXYZ[0];
			int x = nAndXYZ[1];
			int y = nAndXYZ[2];
			int z = nAndXYZ[3];
			String s2 = br.readLine();
			int[] nums = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] numremsX = new int[n];
			int[] numremsY = new int[n];
			int[] numremsZ = new int[n];
			int[] numremsXY = new int[n];
			int[] numremsYZ = new int[n];
			int[] numremsXZ = new int[n];
			int[] numremsXYZ = new int[n];
			int xy = lcm(x, y);
			int xz = lcm(x, z);
			int yz = lcm(y, z);
			int xyz = lcm(xy, z);
			for (int i = 0; i < n; i++) {
				numremsX[i] = minchange(x, nums[i]);
				numremsY[i] = minchange(y, nums[i]);
				numremsZ[i] = minchange(z, nums[i]);
				numremsXY[i] = minchange(xy, nums[i]);
				numremsYZ[i] = minchange(yz, nums[i]);
				numremsXZ[i] = minchange(xz, nums[i]);
				numremsXYZ[i] = minchange(xyz, nums[i]);
			}
			long minChanges = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						long totalChanges = Long.MAX_VALUE;
						if (i != j && i != k && j != k) {
							totalChanges = numremsX[i] + numremsY[j] + numremsZ[k];
						}
						if (i == j && i != k) {
							totalChanges = numremsXY[i] + numremsZ[k];
						}
						if (i == k && i != j) {
							totalChanges = numremsXZ[i] + numremsY[j];
						}
						if (k == j && i != k) {
							totalChanges = numremsYZ[j] + numremsX[i];
						}
						if (i == j && i == k) {
							totalChanges = numremsXYZ[i];
						}
						minChanges = Math.min(minChanges, totalChanges);
					}
				}
			}
			System.out.println(minChanges);
		} catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public static int lcm(int a, int b) {
		if (a > b) {
			return b * (a / gcd(a, b));
		}
		return a * (b / gcd(a, b));
	}

	public static int minchange(int base, int val) {
		int reminder = val % base;
		int halfbase = base / 2;
		if (reminder < halfbase) {
			return reminder;
		} else {
			return base - reminder;
		}
	}

}
