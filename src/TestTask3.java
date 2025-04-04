import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestTask3 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1;
			s1 = br.readLine();
			int[] nAndM = Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = nAndM[0];
			int m = nAndM[1];
			String s2 = br.readLine();
			int[] sprintLengths = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
			int first = sprintLengths[0];
			int second = sprintLengths[1];
			int[] differences = new int[n - 2];
			for (int i = 2; i < n; i++) {
				differences[i-2] = getSmallestChange(first, second, sprintLengths[i]);
			}
			Arrays.sort(differences);
			long sum = 0;
			for (int i = 0; i < m; i++) {
				sum = sum + (long) differences[i];
			}
			System.out.println(sum);
		} catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	public static int getSmallestChange(int first, int last, int current) {
		int firstDiff = Math.abs(first - current);
		int secondDiff = Math.abs(last - current);
		if(current >= first && current <= last) {
			return 0;
		}
		return firstDiff < secondDiff ? firstDiff : secondDiff;
	}
}
