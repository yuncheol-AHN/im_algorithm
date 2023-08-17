package Baekjoon;

// N Queen
public class BJ9963 {
	static boolean[][] board;
	static int N;
	static int answer = 0;
	
	static int[] dr = { -1, -1, -1 };
	static int[] dc = { 0, 1, -1 };
	
	public static void main(String[] args) {
		/*
		 * tree를 구상?
		 * 언제 노드가 호출되고, 언제 노드가 끝나는지...
		 * -> 해당 메소드에서 퀸이 위치한 좌표를 true로 변경 후 다음 메소드 호출
		 * 노드가 전달 받는 값과 전달하는 값은 어떤지...
		 * 
		 * careful !
		 * 자식 노드를 탐색한 후, false 처리를 하는 경우는 언제인가?
		 */
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		N = sc.nextInt();
		board = new boolean[N][N];
		
		recursive(board, 0);
		System.out.println(answer);
		
		return;
	}
	
	private static void recursive(boolean[][] board, int idx) {
		
		if (idx == N)
			answer += 1;
		
		for (int col = 0; col < N; col++) {
			if (positionCheck(board, idx, col)) {	// 0 - (N-1) , 0 - (N-1)
				board[idx][col] = true;
				recursive(board, idx + 1);
				board[idx][col] = false;
			}
		}
	}
	
	private static boolean positionCheck(boolean[][] board, int r, int c) {
		
		for (int i = 0; i < 3; i++) {
			
			int nr = r, nc = c;
			while (true) {
				
				nr += dr[i];
				nc += dc[i];
				
				if (nr < 0 || nc < 0 || nc >= N) {
					break;
				} else {
					if (board[nr][nc] == true) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
