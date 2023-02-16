import java.util.*;


public class B108 {
  public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int N = Integer.valueOf(line[0]);
		int M = Integer.valueOf(line[1]);

		Queue<Integer> gondra = new ArrayDeque<>(N);
		for (int i = 0; i < N; i++) {
			gondra.add(i);
		}

		int[] gonTeiin = new int[N];
		int[] gonCusN = new int[N];
		int[] groupcusN = new int[M];

		for (int i = 0; i < N; i++) {
			gonTeiin[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			groupcusN[i] = sc.nextInt();
		}

		int p = 0;

		for (int i = 0; i < M; i++) {

			p = groupcusN[i];

			int nthGondra = nextGondra(gondra);
			int teiinn = gonTeiin[nthGondra];

			while (p > 0) {
				if (p == teiinn) {
					gonCusN[nthGondra] += p;
					p = 0;

				} else if (p < teiinn) {
					gonCusN[nthGondra] += p;
					p = 0;
				} else {
					gonCusN[nthGondra] += teiinn;
					p -= teiinn;
					nthGondra = nextGondra(gondra);
					teiinn = gonTeiin[nthGondra];

				}
			}
		}

		for(int cusN: gonCusN) {
			System.out.println(cusN);
		}

	}

	public static int nextGondra(Queue<Integer> que) {
		int q = que.poll();
		que.add(q);
		return q;
	}
}
