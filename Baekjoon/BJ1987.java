package Baekjoon;

import java.util.*;

public class BJ1987 {
	static int answer = Integer.MIN_VALUE;
	static char[][] board;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 방문한 알파벳인지 체크
		 */
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		board = new char[R][C];
		
		String s;
		for (int r = 0; r< R; r++) {
			s = sc.next();
			for (int c = 0; c < C; c++) {
				board[r][c] = s.charAt(c);
			}
		}
		
		recursive(new ArrayList<Character>(), board[0][0], 0, 0, 0);
		System.out.println(answer);
	}
	
	private static void recursive(List<Character> list, char value, int idx, int r, int c) {
		
		/*if (list.contains(value)) {
			answer = Math.max(idx, answer);
			return;
		}*/
		
		int R = board.length;
		int C = board[0].length;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (!list.contains(board[nr][nc])) {
					list.add(board[nr][nc]);
					recursive(list, board[nr][nc], idx + 1, nr, nc);
				}
			}
		}
		
		answer = Math.max(idx, answer);
	}
}
