import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTask1 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1;
			s1 = br.readLine();
			char[] s2 = s1.toCharArray();
			checkCharArr(s2);
		} catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	public static void checkCharArr(char[] cc) {
		boolean isVisitedR = false;
		for (char c : cc) {
			if (c == 'M') {
				System.out.println(isVisitedR ? "Yes" : "No");return;
			}
			if (isVisitedR) {
				continue;
			}
			if(c == 'R') {
				isVisitedR = true;
			}
		}
	}

}
