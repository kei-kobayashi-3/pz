import java.util.*;


public class A057 {
   public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = Integer.valueOf(sc.nextLine());

		Map<Integer, int[]> map = new HashMap<>();
		int[] array;

		for (int i = 0; i < N; i++) {
			String[] line = sc.nextLine().split("");
			array = new int[N];

			for (int j = 0; j < line.length; j++) {
				array[j] = Integer.parseInt(line[j]);
			}
			map.put(i, array);
		}

		int horizontal = horizontalSwipeMax(map);
		int vertical = verticalSwipeMax(map);
		int leftDiagonal = leftDiagonal(map);
		int rightDiagonal = rightDiagonal(map);

		int[] resultArray = {
				horizontal,
				vertical,
				leftDiagonal,
				rightDiagonal
		};

		Arrays.sort(resultArray);
		System.out.println(resultArray[3]);




	}

	// HashMap<int[]>から横探索の最大スワイプ数を返すメソッド
	public static int horizontalSwipeMax(Map<Integer, int[]> map) {

		List<int[]> list = new ArrayList<>();

		for (HashMap.Entry<Integer, int[]> m : map.entrySet()) {
			list.add(map.get(m.getKey()));
		}

		return resultN(list);
	}

	// HashMap<int[]から縦探索の最大スワイプ数を返すメソッド
	public static int verticalSwipeMax(Map<Integer, int[]> map) {

		List<int[]> list = new ArrayList<>();

		int n = map.size();

		for (int i = 0; i < n; i++) {
			int[] array = new int[n];

			for (int j = 0; j < n; j++) {
				array[j] = map.get(j)[i];
			}
			list.add(array);
		}
		return resultN(list);
	}

	// HashMap<int[]から左上から右下ななめ探索の最大スワイプ数を返すメソッド
	public static int leftDiagonal(Map<Integer, int[]> map) {

		List<int[]> list = new ArrayList<>();

		int n = map.size();

		for(int i=0; i<n-1; i++) {
			int[] array = new int[n-i];
			int k = 0;
			int l = i;

			for(int j=0; j<n-i; j++) {
				array[j] = map.get(l)[k];
				k++;
				l++;
			}
			list.add(array);
		}

		for(int i= 1; i<n-1;i++) {
			int[] array = new int[n-i];
			int l = 0;
			int k = i;

			for(int j=0; j<n-i; j++) {
				array[j] = map.get(l)[k];
				l++;
				k++;
			}
			list.add(array);
		}
		return resultN(list);
	}

	// HashMap<int[]から左下から右上ななめ探索の最大スワイプ数を返すメソッド
		public static int rightDiagonal(Map<Integer, int[]> map) {

			List<int[]> list = new ArrayList<>();

			int n = map.size();

			for(int i=0; i<n-1; i++) {
				int[] array = new int[n-i];
				int k = i;
				int l = n-1;

				for(int j=0; j<n-i; j++) {
					array[j] = map.get(l)[k];
					k++;
					l--;
				}
				list.add(array);
			}

			for(int i= 1; i<n-1;i++) {
				int[] array = new int[i+1];
				int l = i;
				int k = 0;

				for(int j=0; j<i+1; j++) {
					array[j] = map.get(l)[k];
					l--;
					k++;
				}
				list.add(array);
			}
			return resultN(list);
		}

	// List<Integer[]>を引数に最大のスワイプ数を返すメソッド
	public static int resultN(List<int[]> list) {
		int result = 0;

		for (int[] l : list) {
			int n = resultSwipeNth(l);
			if (result < n) {
				result = n;
			}
		}
		return result;
	}

	// int[] array を引数に最大のスワイプ数を返すメソッド
	public static int resultSwipeNth(int[] array) {

		int result = 0;
		int tempResult = 1;

		for (int i = 0; i < array.length - 1; i++) {

			int nowN = array[i];
			int nextN = array[i + 1];

			int tempPattern = nextN - nowN;

			if (tempPattern == 1) {
				tempResult++;
				if (result < tempResult) {
					result = tempResult;
				}
			} else {
				tempResult = 1;
			}
		}

		for (int i = array.length - 1; i > 0; i--) {

			int nowN = array[i];
			int nextN = array[i - 1];

			int tempPattern = nextN - nowN;

			if (tempPattern == 1) {
				tempResult++;
				if (result < tempResult) {
					result = tempResult;
				}
			} else {
				tempResult = 1;
			}
		}

		return result;
	}
}
