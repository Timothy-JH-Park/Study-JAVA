import java.util.Random;
import java.util.Scanner;

public class ArrApp5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	twoDArr01();
	//	tictacToe();
		mineSweeper();
		
	//	int[][] arr = new int [2][40];
		
	}
	
	private static void mineSweeper( ) {
		boolean[][] board = new boolean[10][10];
		
		for (int i=0; i< board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				double val = Math.random();
				if (val < 0.3) {
					board[i][j] = true;
				}
			}
		}
		for (int i=0; i< board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j]) {
					System.out.print(" # ");
				}
				else {
					System.out.print(" . ");
					}
				}
				System.out.println();
			}
				
	}
	
	private static void tictacToe() {
		char [][] board = new char[3][3] ;
		
		initialize(board);
		boolean isOver = false;
		
		while(true) {
			// step 1. board 상태를 출력 (테이블 형태로)
			displayBoard(board);
			if (isOver) break;
			
			// step 2.
			// 사용자로부터 좌표를 입력받는다(row, col) : 1~3
			// 그 좌표가 빈 공간이면 board[row][col-1] = 'x';
			// 빈 공간이 아니면 continue;
			boolean result = userInput(board);
			if (result == false) { // 좌표가 잘못된 경우..
				continue;
			}
			
			// 게임이 끝났는지 체크.. 끝났으면 isOver = true;
			
			// step 3.
			// computer play
//			computerPlay();
//			computerPlay(board);
			computerPlay2(board);
//			break;
			
		}
	}
	
	private static void computerPlay2(char[][] b) {
		Random random = new Random();
		while(true) {
			int row = random.nextInt(3);
			int col = random.nextInt(3);
			
			if (b[row][col] == ' ') {
				b[row][col] = 'O';
				break;
			}
		}
	}
	private static void computerPlay(char[][] b) {
		boolean found = false;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				if (b[i][j] == ' ') {
					b[i][j] = 'O';
					found = true;
					break;
				}
			}
			if (found) break;
		}
	}
	private static boolean userInput(char[][] b) {
		boolean result = false;
		Scanner input = new Scanner(System.in);
		System.out.println("좌표를 입력하세요..");
		
		int row = input.nextInt();
		int col = input.nextInt();
		
		
		if (b[row-1][col-1] == ' ') {
			b[row-1][col-1] = 'X' ;
			result = true;
		} else {
			
		}
//		input.close();
		
		return result;
	}
	
	private static void initialize(char[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++)
				b[i][j] = ' ';
		}
	}
	
	private static void displayBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j < board[i].length-1)
					System.out.print(" " + board[i][j] + " |");
				else
					System.out.print(" " + board[i][j]);
			}
//			System.out.println("\n");
			System.out.println("\n---|---|---");
		}
	}

	private static void twoDArr01() {
//		int [] nums = {1,2,3,4,5};
		int [][] nums2D = new int[2][];
	}
}
