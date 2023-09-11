import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2638 {

	public static void main(String[] args) throws IOException {
		/*
		 * 치즈가 녹아 없어지는데 걸리는 시간 출력
		 */
		
		System.setIn(new FileInputStream("in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] board = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		cheese(board);
	}
	
	private static int cheese(int[][] board) {
		int answer = 0;
		int R = board.length;
		int C = board[0].length;
		
		while (true) {
			if (noCheese(board)) break;
			answer += 1;
			
			// stack에 담기
			
			
			// 치즈 제거
		}
		
		return answer;
	}
	
	private static boolean noCheese(int[][] board) {
		
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != 0) return false;
			}
		}
		
		return true;
	}
}
