import java.util.*;


public class A066 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
		int N = Integer.valueOf(sc.nextLine());
		String[] line = sc.nextLine().split(" ");
		int s1 = Integer.parseInt(line[0]);
		int s2 = Integer.parseInt(line[1]);
		int t1 = 0;
		int t2 = 0;

		for (int i = 0; i < N - 1; i++) {
			line = sc.nextLine().split(" ");
			t1 = Integer.parseInt(line[0]);
			t2 = Integer.parseInt(line[1]);

			if (s1 <= t1) {
				if (Math.abs(s2 - t1) <= 1) {
					s2 = t2;
				}else if((s2 <= t1)&&(t1 <= t2)) {
					if((s2-s1) <= (t2 - t1)) {
						s1 = t1;
						s2 = t2;
					}
				}else if((t1 <= s2)&&(s2 <= t2)) {
					s2 = t2;
			}

			if (s1 > t1) {
				if (Math.abs(t2 - s1) <= 1) {
					s1 = t1;
				}else if((t2 <= s1)&&(s1 <= s2)) {
					if((s2 -s1) <= (t2 - t1)) {
						s1 = t1;
						s2 = t2;
					}
				}else if((s1 <= s2)&&(s2 <= t2)) {
					s1 = t1;
					s2 = t2;
				}else if((s1 <= t2)&&(t2 <= s2)) {
					s1 = t1;
				}

				}

			}
		}

		System.out.println(s2 - s1 + 1);

    }
}
