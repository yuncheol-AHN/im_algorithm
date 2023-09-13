import java.io.*;
import java.util.*;

public class BJ2580 {
	
	static int[][] board;
	public static void main(String[] args)  throws IOException {
		System.setIn(new FileInputStream("in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[9][9];
		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		sdoku();
		print();
	}
	
	private static void sdoku() {
		
		Queue<int[]> q = new LinkedList<>();	// 빈칸의 좌표를 담는 큐
		// 큐에 빈칸의 좌표 담기
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] == 0) { 
					q.add(new int[] {r, c});
				}
			}
		}
		
		int[] point = new int[2];
		int r, c;
		
		while (!q.isEmpty()) {
			point = q.poll();
			r = point[0];
			c = point[1];

			System.out.println(r + " " + c);
			if (!fillBlank(r, c)) q.add(new int[] {r, c});
//			if (fillBlank(r, c)) {
//				//가로, 세로
//				for (int i = 0; i < 9; i++) {
//					if (board[r][i] == 0 && i != c) { 
//						q.add(new int[] {r, i});
//						continue Loop;
//					}
//					if (board[i][c] == 0 && i != r)  {
//						q.add(new int[] {i, c});
//						continue Loop;
//					}
//				}
//				
//				//작은 삼각형
//				
//				for (int i = 3*(r/3); i < 3*(r/3)+3; i++) {
//					for (int j = 3*(c/3); j < 3*(c/3)+3; j++) {
//						if (board[i][j] == 0) {
//							q.add(new int[] {i, j});
//							continue Loop;
//						}
//					}
//				}
//			}
			
			if (chkfinish()) return;
		}
	}
	
	private static boolean chkfinish() {
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] == 0) return false;
			}
		}
		
		return true;
	}
	
	private static boolean fillBlank(int r, int c) {
		
		int verticalCnt = 0, horizontalCnt = 0, miniSquareCnt = 0;
		int verticalSum = 0, horizontalSum = 0, miniSquareSum = 0;
		
		// 가로, 세로, 중앙 방향 체크
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				// 가로
				if (board[r][i*3+j] == 0) verticalCnt += 1;
				verticalSum += board[r][i*3+j];
				
				// 세로
				if (board[i*3+j][c] == 0) horizontalCnt += 1;
				horizontalSum += board[i*3+j][c];
				
				// 미니
				if (board[(r/3)*3+i][(c/3)*3+j] == 0) miniSquareCnt += 1;
				miniSquareSum += board[(r/3)*3+i][(c/3)*3+j];
			}
		}
		
		if (verticalCnt == 1) {
			board[r][c] = 45 - verticalSum;
			return true;
		}
		if (horizontalCnt == 1) {
			board[r][c] = 45 - horizontalSum;
			return true;
		}
		if (miniSquareCnt == 1) {
			board[r][c] = 45 - miniSquareSum;
			return true;
		}
		
		return false;
	}
	
	private static void print() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
	}
}
