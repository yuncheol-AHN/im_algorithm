package Baekjoon;

import java.util.*;

public class BJ1697 {
	static int maxIdx = 0;
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int start = sc.nextInt();
		int target = sc.nextInt();
		
		System.out.println(bfs(start, target));
	}
	
	private static int bfs(int start, int target) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, start});
		int[] element;
		boolean[] visited = new boolean[100001];
		int idx = 0;
		int val;
		while (!q.isEmpty()) {
			
			element = q.poll();
			idx = element[0];
			val = element[1];
			visited[val] = true;
			
			if (val == target)
				return idx;
			
			if (val*2 < 100001 && !visited[val*2]) q.add(new int[] {idx+1, val*2});
			if (val+1 < 100001 && !visited[val+1]) q.add(new int[] {idx+1, val+1});
			if (val-1 >= 0 && !visited[val-1]) q.add(new int[] {idx+1, val-1});
		}
		
		return idx;
	}
}
