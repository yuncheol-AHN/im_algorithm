import java.io.*;
import java.util.*;

public class BJ1197 {
	static int[] parents;
	static int N;
	
	static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (x == parents[x]) return x;
		
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if (xRoot == yRoot) return false;
		
		parents[yRoot] = xRoot;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int val;
		public Edge(int from, int to, int val) {
			super();
			this.from = from;
			this.to = to;
			this.val = val;
		}
		@Override
		public int compareTo(Edge o) {
			return this.val - o.val;
		}
		
		@Override
		public String toString() {
			return from + " " + to + " " + val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 간선을 가중치 순으로 정렬
		// 간선을 읽으면서 같은 그룹이 아니면 연결
		// 같은 그룹이면 다음 노드를 읽는다
		
		System.setIn(new FileInputStream("in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(from, to, val));
		}
		
		int answer = 0;
		make();

		Collections.sort(list);
		for (Edge e: list) {
			if (union(e.from, e.to)) {
				answer += e.val;
			}
		}
		System.out.println(answer);
	}
}
