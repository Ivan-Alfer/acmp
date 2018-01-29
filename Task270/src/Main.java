import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {

			String s = sc.nextLine();
			String t = sc.nextLine();

			int tI = 0;

			for (int i = 0; i < s.length(); ++i) {
				char sCh = s.charAt(i);
				while (tI < t.length() && sCh != t.charAt(tI)) {
					++tI;
				}

				if (tI == t.length()) {
					out.println("NO");
					return;
				}
				
				++tI;
			}
			
			out.println("YES");
		}
	}

}
