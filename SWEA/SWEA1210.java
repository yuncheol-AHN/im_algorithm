package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1210 {

	public static void main(String[] args) throws IOException {
		
		// 입력 구성
		// System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 변수 생성
		int[][] ladder = new int[100][100]; 
		
		// 10개의 케이스 실행
		for (int xx = 1; xx <= 10; xx++) {
			
			// make ladder
			br.readLine();
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.printf("#%d %d\n", xx, explor(ladder));
		}
	}
	
	private static int explor(int[][] ladder) {
		
		int col;
		for (int c = 0; c < 100; c++) {
			if (ladder[0][c] == 0)
				continue;
			
			// ladder[0][c] == 1 일 때
			col = c;
			for (int r = 0; r < 100; r++) {
				
				// 언제 좌/우로 이동할 것인가!
				if (col-1 >= 0 && ladder[r][col-1] == 1) {
					
					while (true) {
						col -= 1;
						
						if (col-1 < 0 || ladder[r][col-1] == 0)
							break;
					}
				} else if (col+1 < 100 && ladder[r][col+1] == 1) {
					
					while (true) {
						col += 1;
						if (col+1 >= 100 || ladder[r][col+1] == 0)
							break;
					}
				}
			}
			
			if (ladder[99][col] == 2) {
				return c;
			}
		}
		
		// 컴파일 에러 방지
		return -1;
	}

}
