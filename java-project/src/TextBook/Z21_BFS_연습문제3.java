package TextBook;

public class Z21_BFS_연습문제3 {

	public static void main(String args[]) {

		int[][] G = { {}, // 정점 0에 인접한 정점 정보
				{ 2, 3 }, // 정점 1에 인접한 정점 정보
				{ 1, 4, 5 }, // 정점 2에 인접한 정점 정보
				{ 1, 7 }, // 정점 3에 인접한 정점 정보
				{ 2, 6 }, // 정점 4에 인접한 정점 정보
				{ 2, 6 }, // 정점 5에 인접한 정점 정보
				{ 4, 5, 7 }, // 정점 6에 인접한 정점 정보
				{ 3, 6 } // 정점 7에 인접한 정점 정보
		};
		
		////////////////
		//선형큐를 직접 구현해서 사용.
		int q[] = new int[100]; // 큐생성
		int front = -1;
		int rear = -1;
		boolean[] visited = new boolean[8];
		
		int v = 1;
		q[++rear] = v; // q.offer과 동일 
		visited[v] = true;
		while(front != rear) {
			v = q[++front];
			System.out.print(v + " ");
			for (int i = 0; i < G[v].length; i++) {// 인접한 정점의 개수만큼 반복하면서 모두 작업.
				if (!visited[G[v][i]]) {// 방문하지 않았으면
					q[++rear] = (G[v][i]);// 큐에 넣기
					visited[G[v][i]] = true;// 방문한 것으로 표시
				}
			}
			
		}
		////////////////
		
		
		
		
		//API 사용하기.
		/*Queue<Integer> q = new LinkedList<>(); // 큐생성
		boolean[] visited = new boolean[8]; // 0번 정점은 안씀

		int v = 1;// 시작정점지정.
		q.offer(v);// 정점 큐에 삽입
		visited[v] = true;// 방문한 것으로 표시
		while (!q.isEmpty()) {// 반복, 큐가 비어질때 까지.
			v = q.poll();// 큐에서 원소하나 꺼내기.
			System.out.print(v + " ");// 방문 처리(출력)
			for (int i = 0; i < G[v].length; i++) {// 인접한 정점의 개수만큼 반복하면서 모두 작업.
				if (!visited[G[v][i]]) {// 방문하지 않았으면
					q.offer(G[v][i]);// 큐에 넣기
					visited[G[v][i]] = true;// 방문한 것으로 표시
				}
			}
		}*/
	}
}// class