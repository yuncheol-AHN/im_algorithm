package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정사각형방
public class SWEA1861 {

	static boolean[] chk;
	static int maximum = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int xx = 1; xx <= T; xx++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			chk = new boolean[N*N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			square(board, xx);
		}
	}
	
	private static void square(int[][] board, int xx) {
		
		int N = board.length;
		int mr = 0 , mc = 0;
		maximum = Integer.MIN_VALUE;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] == N*N) {
					mr = r;
					mc = c;
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				int v = search(board, r, c) + 1;
				if (maximum < v) {
					maximum = v;
					mr = r;
					mc = c;
				} else if (maximum == v) {
					if (board[mr][mc] > board[r][c]) {
						mr = r;
						mc = c;
					}
				}
			}
		}

		System.out.printf("#%d %d %d\n", xx, board[mr][mc], maximum);
	}
	
	private static int search(int[][] board, int r, int c) {
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		int N = board.length;
		int answer = 0;
		
		Loop:
		while (true) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (board[r][c] + 1 == board[nr][nc]) {
						r = nr;
						c = nc;
						answer += 1;
						continue Loop;
					}
				}
			}
			
			break;
		}
		
		return answer;
	}
}
