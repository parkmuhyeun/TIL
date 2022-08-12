# Shortest Path
#알고리즘/Shortest Path

---
말 그대로 가장 짧은 경로를 찾는 알고리즘

## 다익스트라 최단 경로 알고리즘
특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘.
### 동작원리
1. 출발 노드를 설정한다.
2. 최단 거리 테이블을 초기화한다.
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
5. 위 과정에서 3, 4번 반복

```python
# 간단한 다익스트라 알고리즘 - 시간복잡도 - O(N^2)
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())
# 시작 노드 번호를 입력받기
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n+1)]
# 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
visited = [False] * (n+1)
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
  a, b, c = map(int, input().split())
  # a번 노드에서 b번 노드로 가는 비용이 c
  graph[a].append((b,c))

# 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
def get_smallest_node():
  min_value = INF
  index = 0 # 가장 최단 거리가 짧은 노드(인덱스)
  for i in range(1, n+1):
    if distance[i] < min_value and not visited[i]:
      min_value = distance[i]
      index = i
  return index

def dijkstra(start):
  # 시작 노드에 대해서 초기화
  distance[start] = 0
  visited[start] = True
  for j in graph[start]:
    distance[j[0]] = j[1]
  # 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
  for i in range(n - 1):
    # 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
    now = get_smallest_node()
    visited[now] = True
    # 현재 노드와 연결된 다른 노드를 확인
    for j in graph[now]:
      cost = distance[now] + j[1]
      # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
      if cost < distance[j[0]]:
        distance[j[0]] = cost

# 다익스트라 알고리즘 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
  # 도달할 수 없는 경우, 무한(INFINITY)라고 출력
  if distance[i] == INF:
    print("INFINITY")
  # 도달할 수 있는 경우 거리를 출력
  else:
    print(distance[i])
```

```python
# 개선된 다익스트라 알고리즘(최소힙 사용) - 시간복잡도 O(ElogV), V는 노드의 개수, E는 간선의 개수를 의미

import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())
# 시작 노드 번호를 입력받기
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n+1)]
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
  a, b, c = map(int, input().split())
  # a번 노드에서 b번 노드로 가는 비용이 c
  graph[a].append((b,c))

def dijkstra(start):
  q = []
  # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
  heapq.heappush(q, (0, start))
  distance[start] = 0
  while q: # 큐가 비어있지 않다면
    # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
    dist, now = heapq.heappop(q)
    #현재 노드가 이미 처리된 적이 있는 노드라면 무시
    if distance[now] < dist:
      continue
    for i in graph[now]:
     cost = dist + i[1]
     # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
     if cost < distance[i[0]]:
       distance[i[0]] = cost
       heapq.heappush(q, (cost, i[0]))

# 다익스트라 알고리즘을 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
  # 도달할 수 없는 경우, 무한(INFINITY)라고 출력
  if distance[i] == INF:
    print("INFINITY")
  # 도달할 수 있는 경우 거리를 출력
  else:
    print(distance[i])
```

## 플로이드 워셜 알고리즘
다익스트라 알고리즘은 '한 지점에서 다른 특정 지점까지의 최단 경로를 구해야 하는 경우'에 사용할 수 있는 최단 경로 알고리즘이다. 이번에 설명하는 플로이드 워셜 알고리즘(Floyd-Warshall Algorithm)은 '모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우'에 사용한다.

### 동작원리
플로이드 워셜 알고리즘은 단계마다 '거쳐 가는 노드'를 기준으로 알고리즘을 수행하며, 각 단계에서는 해당 노드를 거쳐가는 경우를 고려한다. 예를 들어 1번 노드에 대해서 확인할 때는 1번 노드를 중간에 거쳐 지나가는 모든 경우를 고려하면 된다. A -> 1번노드 -> B로 가는 비용을 확인한 후에 최단 거리를 갱신한다. 예를 들면 현재 최단 거리 테이블에 A번 노드에서 B번 노드로 이동하는 비용이 3으로 기록되어 있을 때, A번 노드에서 1번 노드를 거쳐 B번 노드로 이동하는 비용이 2라는 것이 밝혀지면, A번 노드에서 B번 노드로 이동하는 비용을 2로 갱신하는 것.

```python
# 플로이드 워셜 알고리즘 - 시간 복잡도 O(N^3)

INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수 및 간선의 개수를 입력받기
n = int(input())
m = int(input())
# 2차원 리스트(그래프 표현)를 만들고, 모든 값을 무한으로 초기화
graph = [[INF] * (n + 1) for _ in range(n + 1)]
# 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
for a in range(1, n + 1):
  for b in range(1, n + 1):
    if a == b:
      graph[a][b] = 0

# 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
for _ in range(m):
  # A에서 B로 가는 비용은 C라고 설정
  a, b, c = map(int, input().split())
  graph[a][b] = c

# 점화식에 따라 플로이드 워셜 알고리즘을 수행
for k in range(1, n + 1):
  for a in range(1, n + 1):
    for b in range(1, n + 1):
      graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 수행된 결과를 출력
for a in range(1, n + 1):
  for b in range(1, n + 1):
    # 도달할 수 없는 경우, 무한(INFINITY)
    if graph[a][b] == INF:
      print("INFINITY", end=" ")
    # 도달할 수 있는 경우 거리를 출력
    else:
      print(graph[a][b], end=" ")
  print()
```

## 관련 문제

```python
INF = int(1e9)

n, m = map(int, input().split())
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
  for j in range(1, n + 1):
    if i == j:
      graph[i][j] = 0

for _ in range(m):
  a, b = map(int, input().split())
  graph[a][b] = 1
  graph[b][a] = 1

x, k = map(int, input().split())

for k in range(1, n + 1):
  for a in range(1, n + 1):
    for b in range(1, n + 1):
      graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

dis = graph[1][k] + graph[k][x]

if dis >= INF:
  print(-1)
else:
  print(dis)
```

```python
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m, c = map(int, input().split())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
  x, y, z = map(int, input().split())
  graph[x].append((y,z))

def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  distance[start] = 0
  while q:
    dist, now = heapq.heappop(q)
    if dist > distance[now]:
      continue
    for i in graph[now]:
      cost = dist + i[1]
      if cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(q, (cost, i[0]))

dijkstra(c)

res1 = 0
res2 = 0
for i in range(n + 1):
  if distance[i] != INF:
    res2 = max(res2, distance[i])
    res1 += 1

print(res1-1, res2)
```

```python
n = int(input())
m = int(input())
INF = int(1e9)
graph = [[INF] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):  
  for j in range(1, n+1):
    if i == j:
      graph[i][j] = 0
      

for _ in range(m):
  a, b, c = map(int, input().split())
  if c < graph[a][b]:
    graph[a][b] = c

for k in range(1, n+1):
  for i in range(1, n+1):
    for j in range(1, n+1):
      graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(1, n+1):
  for j in range(1, n+1):
    if graph[i][j] == INF:
      print(0, end='')
    else:
      print(graph[i][j], end='')
    if j == n:
      print()
    else:
      print(end=' ')
```

```python
n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):  
  for j in range(1, n+1):
    if i == j:
      graph[i][j] = 0

for _ in range(m):
  a, b = map(int, input().split())
  graph[a][b] = 1

for k in range(1, n+1):
  for i in range(1, n+1):
    for j in range(1, n+1):
      graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

result = 0
for i in range(1, n+1):
  cnt = 0
  for j in range(1, n+1):
    if graph[i][j] != INF or graph[j][i] != INF:
      cnt += 1

    if cnt == n:
      result += 1
print(result)
```

```python
import heapq
INF = int(1e9)

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

t = int(input())
for _ in range(t):
  n = int(input())
  cost = []
  for _ in range(n):
    row = list(map(int, input().split()))
    cost.append(row)
  d = [[INF] * n for _ in range(n)]

  x, y = 0, 0
  q = []
  heapq.heappush(q, (cost[x][y], x, y))
  d[x][y] = cost[x][y]
  
  while q:
    dist, x, y = heapq.heappop(q)
    if d[x][y] < dist:
      continue
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or n <= nx or ny < 0 or n <= ny:
        continue
      val = dist + cost[nx][ny]
      if d[nx][ny] > val:
        d[nx][ny] = val
        heapq.heappush(q, (val, nx, ny))
  print(d[n-1][n-1])
```

```python
import heapq
INF = int(1e9)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

distance = [INF] * (n+1)

q = []
heapq.heappush(q, (0, 1))
distance[1] = 0

while q:
  dist, now = heapq.heappop(q)
  if distance[now] < dist:
    continue
  for i in graph[now]:
    cost = dist + 1
    if distance[i] > cost:
      distance[i] = cost
      heapq.heappush(q, (cost, i))
distance[0] = -1
res = max(distance)
cnt = distance.count(res)
idx = distance.index(res)
print(idx, res, cnt)
```

```python
import heapq
INF = int(1e9)

v, e = map(int, input().split())
k = int(input())
graph = [[] for _ in range(v+1)]
for _ in range(e):
  a, b, w = map(int, input().split())
  graph[a].append((b, w))
distance = [INF] * (v+1)

q = []
heapq.heappush(q, (0, k))
distance[k] = 0

while q:
  dist, now = heapq.heappop(q)
  if distance[now] < dist:
    continue
  for i in graph[now]:
    cost = dist + i[1]
    if distance[i[0]] > cost:
      distance[i[0]] = cost
      heapq.heappush(q, (cost, i[0]))

for i in range(1, v+1):
  if distance[i] == INF:
    print("INF")
  else:
    print(distance[i])
```

```python
INF = int(1e9)

n = int(input())
graph = [[INF] * n for _ in range(n)]
for i in range(n):
  row = list(map(int, input().split()))
  for j in range(n):
    if row[j] == 1:
      graph[i][j] = 1

for k in range(n):
  for i in range(n):
    for j in range(n):
      graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(n):
  for j in range(n):
    if graph[i][j] == INF:
      print(0, end='')
    else:
      print(1, end='')
    if j != n-1:
      print(end=' ')
  print()
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {
    static int V, E, K;
    static List<Node>[] adj;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adj = new ArrayList[V + 1];
        dis = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < V + 1; i++) {
            dis[i] = (int) 1e9;
        }

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        pq.add(new Node(K, 0));
        dis[K] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (dis[curNode.pos] < curNode.weight)
                continue;
            for (int i = 0; i < adj[curNode.pos].size(); i++) {
                Node nextNode = adj[curNode.pos].get(i);
                int cost = curNode.weight + nextNode.weight;
                if (cost < dis[nextNode.pos]) {
                    dis[nextNode.pos] = cost;
                    pq.add(new Node(nextNode.pos, cost));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dis[i] == 1e9)
                System.out.println("INF");
            else
                System.out.println(dis[i]);
        }
    }
}

class Node {
    int pos;
    int weight;

    public Node(int next, int weight) {
        this.pos = next;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {
    static int N, M;
    static int[][] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dis = new int[N + 1][N + 1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i != j)
                    dis[i][j] = (int) 1e9;
            }
        }

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            dis[a][b] = Math.min(dis[a][b], c);
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (dis[i][j] == 1e9)
                    System.out.print("0");
                else
                    System.out.print(dis[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11657 {
    static int N, M;
    static List<Edge> adj;
    static long[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new long[N + 1];
        adj = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            dis[i] = (long) 1e9;
        }

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj.add(new Edge(a, b, c));
        }


        //1.출발 노드 설정
        //2. 최단 거리 테이블 초기화
        //3. 다음 과정 V(정점-1)번 반복
        // 3-1. 모든 간선 E개 하나씩 확인
        // 3-2각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
        //만약 음수 간선 순환 발생 체크하고 싶다면 3번 한번더 체크 이때, 최단 거리 테이블 갱신된다면 음수 간선 순환 존재
        
        dis[1] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = adj.get(j);
                int cur = edge.from;
                int next = edge.to;
                int cost = edge.weight;

                if (dis[cur] == 1e9)
                    continue;
                if (dis[next] > dis[cur] + cost) {
                    dis[next] = dis[cur] + cost;

                    if (i == N - 1) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        for (int i = 2; i < N+1; i++) {
            if (dis[i] == 1e9)
                System.out.println("-1");
            else
                System.out.println(dis[i]);
        }

    }
}

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854 {
	static int N, M, K, A, B, C;
	static List<Edge>[] adj = new ArrayList[1001];
	static List<Integer>[] dist = new ArrayList[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			adj[A].add(new Edge(B, C));
		}
		
		dijkstra(1);
		
		for(int i = 1; i < N+1; i++) {
			if(dist[i].size() < K)
				bw.write("-1\n");
			else
				bw.write(dist[i].get(K-1) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
		pq.add(new Edge(start, 0));
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int cur = edge.pos;
			if(dist[cur].size() < K)
				dist[cur].add(edge.weight);
			else
				continue;
			if(dist[cur].size() == K)
				cnt++;
			if(cnt == N)
				break;
			for(int i =0; i < adj[cur].size(); i++) {
				Edge nextEdge = adj[cur].get(i);
				int next = nextEdge.pos;
				int cost = edge.weight + nextEdge.weight;
				if (dist[next].size() < K)
					pq.add(new Edge(next, cost));
			}
		}
	}
}

class Edge {
	int pos;
	int weight;
	
	public Edge(int pos, int weight) {
		this.pos = pos;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
```

```java
package ct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10217 {
	static int T, N, M, K, U, V, C, D;
	static List<Edge>[] adj = new ArrayList[101];
	static int dp[][] = new int[101][10001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i < N + 1; i++) {
				adj[i] = new ArrayList<>();
				for(int j = 0; j < M + 1; j++)
					dp[i][j] = Integer.MAX_VALUE;
			}

			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				U = Integer.parseInt(st.nextToken());
				V = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				D = Integer.parseInt(st.nextToken());
				adj[U].add(new Edge(V, C, D));
			}
			
			dijkstra(1);
			
			int result = Integer.MAX_VALUE;
			for(int i = 1; i < M + 1; i++) {
				result = Math.min(result, dp[N][i]);
			}
			
			if (result == Integer.MAX_VALUE)
				bw.write("Poor KCM\n");
			else
				bw.write(result+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getTime));
		pq.add(new Edge(start, 0 , 0));
		dp[start][0] = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int cur = edge.pos;
			if (dp[cur][edge.cost] < edge.time)
				continue;
			for(int i = 0; i < adj[cur].size(); i++) {
				Edge nextEdge = adj[cur].get(i);
				int next = nextEdge.pos;
				int c = edge.cost + nextEdge.cost;
				int t = edge.time + nextEdge.time;
				if (c <= M && dp[next][c] > t) {
					dp[next][c] = t;
					pq.add(new Edge(next, c, t));
				}
			}
			
		}
	}

}

class Edge{
	int pos;
	int cost;
	int time;
	
	public Edge(int pos, int cost, int time) {
		this.pos = pos;
		this.cost = cost;
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1162 {
	static int N, M, K, A, B, C;
	static List<Edge>[] adj = new ArrayList[10001];
	static long[][] dp = new long[10001][21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
			for(int j = 0; j < 21; j++) {
				dp[i][j] = Long.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A, C));
		}
		
		dijkstra(1);
		
		long res = Long.MAX_VALUE;
		for(int i = 1; i < K +1 ;i++) {
			res = Math.min(res, dp[N][i]);
		}

		System.out.print(res);
	}

	static void dijkstra(int start) {
		PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparingLong(Road::getWeight));
		pq.add(new Road(start, 0, 0));
		dp[start][0] = 0;
		dp[start][1] = 0;
		
		while(!pq.isEmpty()) {
			Road road = pq.poll();
			int cur = road.pos;
			
			if(dp[cur][road.k] < road.weight)
				continue;
			for(int i = 0; i < adj[cur].size(); i++) {
				Edge edge = adj[cur].get(i);
				int next = edge.pos;
				Long cost = road.weight + edge.weight; 
				
				if(dp[next][road.k] > cost) {
					dp[next][road.k] = cost;
					pq.add(new Road(next, cost, road.k));
				}
				
				if(road.k + 1 <= K) {
					if(dp[next][road.k + 1] > road.weight) {
						dp[next][road.k + 1] = road.weight;
						pq.add(new Road(next, road.weight, road.k + 1));
					}	
				}
				
			}
		}
		
	}
}

class Edge {
	int pos;
	int weight;
	
	public Edge(int pos, int weight) {
		this.pos = pos;
		this.weight = weight;
	}
}

class Road {
	int pos;
	long weight;
	int k;
	
	public Road(int pos, long weight, int k) {
		this.pos = pos;
		this.weight = weight;
		this.k = k;
	}
	
	public long getWeight() {
		return weight;
	}
}
```