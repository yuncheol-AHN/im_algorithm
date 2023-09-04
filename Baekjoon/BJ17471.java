import java.io.*;
import java.util.*;

// 게리맨더링
public class BJ17471 {
	
	static int[][] graph;
	static int[] peoples;
	static int total;
	static int N;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		/*
		 * 인구 차이의 최소값 -> 노드값의 합을 구해야한다.
		 * 언제 연결이 끊어지나?
		 * 총합을 먼저 구할까?
		 * 연결되는지 체크하는 메소드?
		 * dfs?
		 */
		System.setIn(new FileInputStream("in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		peoples = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		for (int e: peoples) total += e;
		
		int n;
		int k;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < n; j++) {
				k = Integer.parseInt(st.nextToken());
				graph[i][k] = peoples[k];
			}
		}
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		
		boolean[] chk = new boolean[N+1];
		dfs(chk, 1, 0);
	}
	
	private static void dfs(boolean[] chk, int idx, int sum) {
		
		if (chk[idx] == true) {
			return;
		}
		
		chk[idx] = true;
		sum += peoples[idx];

		if (check(chk)) {
			min = Math.min(min, total - (sum * 2));
			System.out.println(Arrays.toString(chk) + " " + idx + " " + sum + " " + min);
			for (int i = 1; i <= N; i++) {
				if (graph[idx][i] != 0) {
					dfs(chk, i, sum);
				}
			}
		} else {
			
		}
		
		chk[idx] = false;
		sum -= peoples[idx];
	}
	
	private static boolean check(boolean[] chk) {
		
		boolean[] tmp = deepCopy(chk);
		boolean answer = true;
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (tmp[i] == false) {
				tmp[i] = true;
				q.add(i);
				break;
			}
		}
		
		int from;
		while (!q.isEmpty()) {
			from = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if (tmp[i] == false && graph[from][i] != 0) {
					tmp[i] = true;
					q.add(i);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (tmp[i] == false) answer = false;
		}
		
		return answer;
	}
	
	private static boolean[] deepCopy(boolean[] arr) {
		boolean[] tmp = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		return tmp;
	}
}
