import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17144 {
	static int R;
	static int C;
	static int[][] board;
	static int[] dr = new int[] {0, 1, 0, -1};
	static int[] dc = new int[] {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			diffusion();
			purification();
		}
		print();
		
	}
	
	// 확산
	private static void diffusion() {
		int[][] copy = copy(board);
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] != 0 && board[r][c] != -1) {
					
					copy[r][c] -= board[r][c];
					int s = board[r][c] / 5;
					int mr, mc;
					for (int i = 0; i < 4; i++) {
						mr = r + dr[i];
						mc = c + dc[i];
						
						if (mr >= 0 && mr < R && mc >= 0 && mc < C) {
							if (board[mr][mc] != -1) {
								copy[mr][mc] += s;
								board[r][c] -= s;
							}
						}
					}
					
					copy[r][c] += board[r][c];
				}
			}
		}
			
		board = copy(copy);
	}
	
	// 정화
	private static void purification() {
		
	}
	
	private static int[][] copy(int[][] board) {
		int[][] copy = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copy[r][c] = board[r][c];
			}
		}
		
		return copy;
	}
	
	private static void print() {
		for (int r = 0; r<R; r++) {
			for (int c = 0; c <C; c++) {
				System.out.print(board[r][c] +" ");
			}
			System.out.println();
		}
	}
} 
