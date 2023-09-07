import java.io.*;
import java.util.*;

public class BJ14501 {
	
	static int N;
	static int[][] tables;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("in"));
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		tables = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tables[i][0] = Integer.parseInt(st.nextToken());
			tables[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//bfs();
		dp();
		System.out.println(max);
	}
	
	private static void dp() {
		
		// idx, sum, chk
		int[] dp = new int[N+1];
		
		/*
		 * 3 : tables[1][1] - tables[3][1]
		 * 0 0 10 30 30 45
		 */
	}

	private static void bfs() {
		
		Queue<int[]> q = new LinkedList<int[]>();	// idx, sum
		Queue<boolean[]> bq = new LinkedList<boolean[]>();	// chk
		q.add(new int[] {0, 0});
		bq.add(new boolean[N]);
		
		int[] qpoll;
		boolean[] chk;
		int idx, sum;
		while (!q.isEmpty()) {
			qpoll = q.poll();
			idx = qpoll[0];
			sum = qpoll[1];
			chk = bq.poll();
			
			if (idx == N) {
				max = Math.max(max, sum);
				continue;
			}
			
			if (chk[idx] || tables[idx][0] + idx > N) {
				// 방문 처리가 된 경우
				q.add(new int[] {idx+1, sum});
				bq.add(deepcopy(chk));
			} else {
				// 방문 X
				q.add(new int[] {idx+1, sum});
				bq.add(deepcopy(chk));
				
				// 방문 O
				for (int i = idx; i < idx + tables[idx][0]; i++) {
					chk[i] = true;
				}
				q.add(new int[] {idx+1, sum + tables[idx][1]});
				bq.add(deepcopy(chk));
			}
		}
	}
	
	private static boolean[] deepcopy(boolean[] chk) {
		int n = chk.length;
		boolean[] answer = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			answer[i] = chk[i];
		}
		
		return answer;
	}
}
