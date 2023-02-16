import java.util.*;


public class B116 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] data = line.split(" ");
		int[] intData = new int[data.length];
		for(int i= 0; i<data.length; i++) {
			intData[i] = Integer.valueOf(data[i]);
		}

		int row = intData[0];
		int col = intData[1];
		int nth = intData[2];

		Man[] mens = new Man[row];

		for(int i=0; i< row; i++) {
			mens[i] = new Man(i+1, col);
		}

		Woman[] womens = new Woman[col];
		for(int i=0; i< col; i++) {
			womens[i] = new Woman(row, i+1);
		}

		for(int n=0; n <= nth; n++) {
			for(int i=0; i<mens.length; i++) {
				mens[i].setNext();
			}
			for(int j=0; j<womens.length; j++) {
				womens[j].setNext();
			}
			for(int k=0; k<mens.length; k++) {
				for(int l=0; l<womens.length; l++) {
					if(samePosition(mens[k], womens[l])) {
						setPrezentE(mens[k], womens[l]);
					}
				}
			}
		}

		for(int i=0; i<mens.length; i++) {
			System.out.println(mens[i].getPrezent());
		}
		for(int i=0; i<womens.length; i++) {
			System.out.println(womens[i].getPrezent());
		}

	}
	public static boolean samePosition(Man man, Woman woman) {
		int manCol = man.getCol();
		int manRow = man.getRow();
		int womanCol = woman.getCol();
		int womanRow = woman.getRow();
		return (manCol==womanCol) && (manRow == womanRow);
	}
	public static void setPrezentE(Man man, Woman woman) {
		String prezentMan = woman.getPrezent();
		String prezentWoman = man.getPrezent();
		man.setPrezent(prezentMan);
		woman.setPrezent(prezentWoman);
	}
}

class Man {

	private String name;
	private String prezent;
	private int row;
	private int col;
	private final int startCol;
	private final int startRow;
	private Queue<Integer> que;

	public Man(int row, int col) {

		this.col = 0;
		this.row = row;
		this.startCol = col;
		this.startRow = row;
		this.name = "M" + " " +  Integer.valueOf(startRow);
		this.prezent = name;

		que = new ArrayDeque<Integer>(startCol * 2);
		for(int i = 0; i <= startCol; i++) {
			que.add(i);
		}
		for(int i= startCol -1; i > 0; i--) {
			que.add(i);
		}
	}

	public void setNext() {
		col = (int)que.poll();
		que.add(Integer.valueOf(col));
	}

	public int getRow(){
		return row;
	}
	public int getCol() {
		return col;
	}

	public String getName() {
		return name;
	}

	public void setPrezent(String prezent) {
		this.prezent = prezent;
	}
	public String getPrezent() {
		return prezent;
	}
}

class Woman {

	private String name;
	private String prezent;
	private int row;
	private int col;
	private final int startCol;
	private final int startRow;
	private Queue<Integer> que;

	public Woman(int row, int col) {

		this.col = col;
		this.row = 0;
		this.startCol = col;
		this.startRow = row;
		this.name = "F" + " " +  Integer.valueOf(startCol);
		this.prezent = name;

		que = new ArrayDeque<Integer>(startRow * 2);
		for(int i = 0; i <= startRow; i++) {
			que.add(i);
		}
		for(int i= startRow -1; i > 0; i--) {
			que.add(i);
		}
	}

	public void setNext() {
		row = (int)que.poll();
		que.add(Integer.valueOf(row));
	}

	public int getRow(){
		return row;
	}
	public int getCol() {
		return col;
	}

	public String getName() {
		return name;
	}

	public void setPrezent(String prezent) {
		this.prezent = prezent;
	}

	public String getPrezent() {
		return prezent;
	}
}
