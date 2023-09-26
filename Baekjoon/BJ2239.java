import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2239 {
	static int[][] board = new int[9][9];
	static int[][] chkHor = new int[10][10];
	static int[][] chkVer = new int[10][10];
	
	public static void main(String[] args) throws IOException {
		/*
		 * 앞쪽부터 순서대로 채워야할까?
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String sb;
		
		
		for (int r = 0; r < 9; r++) {
			sb = br.readLine().trim();
			for (int c = 0; c < 9; c++) {
				board[r][c] = sb.charAt(c) - '0';
			}
		}
		
		
		
		
		
		
		
		
//		for (int r = 0; r < 9; r++) {
//			for (int c = 0; c < 9; c++) {
//				System.out.print(board[r][c] + " ");
//			}
//			System.out.println();
//		}
	}
	
	private static void recursive() {
		
	}
}
