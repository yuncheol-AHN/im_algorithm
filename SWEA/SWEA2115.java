import java.io.*;
import java.util.*;

public class SWEA2115 {
	static int[][] board;
	static List<int[]> list;
	static int N;
	static int M;
	static int C;
	static int max;
	
	public static void main(String[] args) throws IOException {
		/*
		 * N : 벌통 크기
		 * M : 선택할 수 있는 벌통 개수
		 * C : 채취할 수 있는 최대 양
		 */
		
		System.setIn(new FileInputStream("in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int xx = 1; xx <= T; xx++) {
			
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			
			
			for (int r = 0; r< N; r++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int c = 0 ; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			recursive(new boolean[N][N], 0, 0, 0, 0);
			System.out.printf("#%d %d\n", xx, max);
		}
	}
	
	private static void recursive(boolean[][] chk, int cnt, int idxR, int idxC, int sum) {

		if (cnt == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int r = idxR; r < N; r++) {
			for (int c = idxC; c < N-(M-1); c++) {
				
				if (chk[r][c] == false) {
					chk[r][c] = true;
					
					if (c + (M-1) >= N) {
						recursive(chk, cnt+1, 0, c+1, sum + calc(r, c));
					} else {
						recursive(chk, cnt+1, r+1, 0, sum + calc(r, c));
					}
					
					chk[r][c] = false;
				}
			}
		}
	}
	
	private static int calc(int r, int c) {
		
		int[] list = new int[M+1];	// value : 무게
		
		for (int i = 0 ; i < M; i++) {
			list[i+1] = board[r][c+i];
		}
		
		int[][] K = new int[M+1][C+1];
		for (int i = 0; i <= M; i++) K[i][0] = 0;
		for (int i = 0; i <= C; i++) K[0][i] = 0;
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= C; j++) {
				
				if (list[i] > j) {
					K[i][j] = K[i-1][j];
				} else {
					K[i][j] = Math.max(K[i-1][j], K[i-1][j-list[i]] + list[i]*list[i]);
				}
			}
		}
		
		return K[M][C];
	}
}
