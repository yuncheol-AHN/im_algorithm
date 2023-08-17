package Baekjoon;

import java.io.*;
import java.util.*;

/*
 * 밤밤맨
 * 폭탄이 동시에 터지나 순차적으로 터지나
 * 시뮬레이션?
 */
public class BJ16918 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[R][C];
		String s;
		for (int r = 0; r < R; r++) {
			s = br.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = s.charAt(c);
			}
		}
		
		if (n % 2 == 0)
			printBomb(R, C);
		else {
			if (n % 4 == 3) {
				print(bomb(board));
			} else
				print(board);
		}
		
		//char[][] newBoard = bomb(board);
		//print(newBoard);
		
	}
	
	private static char[][] bomb(char[][] board) {
		int R = board.length;
		int C = board[0].length;
		char[][] newBoard = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				
				if (board[r][c] == 'O') {
					newBoard[r][c] = 'O';
					if (r-1 >= 0) newBoard[r-1][c] = 'O';
					if (r+1 <  R) newBoard[r+1][c] = 'O';
					if (c-1 >= 0) newBoard[r][c-1] = 'O';
					if (c+1 <  C) newBoard[r][c+1] = 'O';
				} else {
					newBoard[r][c] = '.';
					if (r-1 >= 0) newBoard[r-1][c] = '.';
					if (r+1 <  R) newBoard[r+1][c] = '.';
					if (c-1 >= 0) newBoard[r][c-1] = '.';
					if (c+1 <  C) newBoard[r][c+1] = '.';
				}
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				
				if (newBoard[r][c] == 'O')
					newBoard[r][c] = '.';
				else
					newBoard[r][c] = 'O';
			}
		}
		
		return newBoard;
	}
	
	private static void print(char[][] board) {
		
		int R = board.length;
		int C = board[0].length;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}
	}
	
	private static void printBomb(int R, int C) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print('O');
			}
			System.out.println();
		}
	}
}
