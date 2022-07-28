# Other Graph Thoery
#알고리즘/Other Graph Thoery

---

## 서로소 집합 자료구조
수학에서 서로소 집합(Disjoint Sets)이란 공통원소가 없는 두 집합을 의미한다. 서로소 집합 자료구조란 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조라고 할수 있다. 서로소 집합 자료구조는 union과 find 이 2개의 연산으로 조작할 수 있다. 그래서 union-find 자료구조라고 불리기도 한다.

### 동작 방식 
1. union(합집합) 연산을 확인하며, 서로 연결된 두 노드 A, B를 확인한다.
    - A와 B의 루트 노드 a, b를 각각 찾는다.
    - a, b의 부모 노드로 설정한다(b가 a를 가리키도록 함), 보통 a, b중 더 작은 노드를 부모 노드로 설정
2. 모든 union(합집합) 연산을 처리할 때까지 1번 과정을 반복

```python
# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
  # 루트 노드가 아니라면, 루트 노드를 찾을 때 까지 재귀적으로 호출
  if parent[x] != x:
    return find_parent(parent, parent[x])
  return x

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

# 노드의 개수와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
parent = [0] * (v + 1) # 부모 테이블 초기화

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
  parent[i] = i

# union 연산을 각각 수행
for i in range(e):
  a, b = map(int, input().split())
  union_parent(parent, a, b)

# 각 원소가 속한 집합 출력
print('각 원소가 속한 집합: ', end='')
for i in range(1, v + 1):
  print(find_parent(parent, i), end=' ')

print()

# 부모 테이블 내용 출력
print('부모 테이블: ', end='')
for i in range(1, v + 1):
  print(parent[i], end = ' ')
```

부모루트를 찾는데 최악의 경우에 O(V)의 시간이 소요될 수 있기 때문에 한번에 찾도록 최적화 할 수 있다. find 함수를 다음과 같이 변경하면 경로 압축을 할수있다.

```python
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]
```

노드의 개수가 V개이고, 최대 V - 1개의 union 연산과 M개의 find 연산이 가능할 때, 서로소 집합 알고리즘의 시간 복잡도는 대략 V + Mlog_2V정도로 알고있자.

## 서로소 집합을 활용한 사이클 판별
서로소 집합은 다양한 알고리즘에 사용될 수 있다. 특히 서로소 집합은 무방향 그래프 내에서의 사이클을 판별할 때 사용할 수 있다는 특징이 있다. 참고로 방향 그래프에서 사이클 여부는 DFS로 가능.

### 동작 방식
1. 각 간선을 확인하며 두 노드의 루트 노드를 확인한다.
    - 루트 노드가 서로 다르다면 두 노드에 대하여 union 연산을 수행한다.
    - 루트 노드가 서로 같다면 사이클(Cycle)이 발생한 것
2. 그래프에 포함되어 있는 모든 간선에 대하여 1번 과정을 반복

```python
# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
  # 루트 노드가 아니라면, 루트 노드를 찾을 때 까지 재귀적으로 호출
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

# 노드의 개수와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
parent = [0] * (v + 1) # 부모 테이블 초기화

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
  parent[i] = i

cycle = False # 사이클 발생 여부

for i in range(e):
  a, b = map(int, input().split())
  # 사이클이 발생한 경우 종료
  if find_parent(parent, a) == find_parent(parent, b):
    cycle = True
    break
  # 사이클이 발생하지 않았다면 합집합(union) 수행
  else:
    union_parent(parent, a, b)

if cycle:
  print("사이클이 발생했습니다.")
else:
  print("사이클이 발생하지 않았습니다.")
```

--- 

## 신장 트리
신장트리란 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프

## 크루스칼 알고리즘(Kruskal Algorithm)
최소한의 비용으로 신장 트리를 찾는 최소 신장 트리 알고리즘 

### 동작방식
1. 간선 데이터를 비용에 따라 오름차순으로 정렬.
2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인한다.
    - 사이클이 발생하지 않는 경우 최소 신장 트리에 포함.
    - 사이클이 발생하는 경우 최소 신장 트리에 포함시키지 않는다.
3. 모든 간선에 대하여 2번의 과정을 반복

```python
# 크루스칼 알고리즘 - 간선의 개수가 E개일 때 시간 복잡도 O(ElogE)

def find_parent(parent, x):
  # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b
  
# 노드의 개수와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
parent = [0] * (v + 1) # 부모 테이블 초기화

# 모든 간선을 담을 리스트와 최종 비용을 담을 변수
edges = []
result = 0

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
  parent[i] = i

# 모드 간선에 대한 정보를 입력받기
for _ in range(e):
  a, b, cost = map(int, input().split())
  # 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
  edges.append((cost, a, b))

# 간선을 비용순으로 정렬
edges.sort()

# 간선을 하나씩 확인하며
for edge in edges:
  cost, a, b = edge
  # 사이클이 발생하지 않는 경우에만 집합에 포함
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    result += cost

print(result)
```

---

## 위상 정렬(Topology Sort)
위상 정렬은 정렬 알고리즘의 일종이다. 순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘이다. 예를들어 컴퓨터공학과 커리큘럼에서 '자료구조'과목을 수강한 뒤에 '알고리즘'강의를 수강하는 것을 권장한다. 이때 '자료구조' 및 '알고리즘'을 각각의 노드로 표현하고, '자료구조'에서 '알고리즘'으로 이어질 수 있도록 방향성을 갖는 간선을 그릴 수 있다.

### 동작 방식
1. 진입차수가 0인 노드를 큐에 넣는다.(진입차수(Indegree)란 특정한 노드로 '들어오는' 간선의 개수)
2. 큐가 빌 때까지 다음의 과정을 반복한다.
    - 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
    - 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.

```python
from collections import deque

# 노드의 개수와 간선의 개수를 입력받기
v, e = map(int, input().split())
# 모든 노드에 대한 진입차수는 0으로 초기화
indegree = [0] * (v + 1)
# 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트(그래프) 초기화
graph = [[] for i in range(v + 1)]

# 방향 그래프의 모든 간선 정보를 입력받기
for _ in range(e):
  a, b = map(int, input().split())
  graph[a].append(b) # 정점 A에서 B로 이동 가능
  # 진입차수를 1 증가
  indegree[b] += 1

# 위상 정렬 함수
def topology_sort():
  result = [] # 알고리즘 수행결과를 담을 리스트
  q = deque() # 큐 기능을 위한 deque 라이브러리 사용

  # 처음 시작할때는 진입차수가 0인 노드를 큐에 삽입
  for i in range(1, v + 1):
    if indegree[i] == 0:
      q.append(i)

  # 큐가 빌 때까지 반복
  while q:
    # 큐에서 원소 꺼내기
    now = q.popleft()
    result.append(now)
    # 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
    for i in graph[now]:
      indegree[i] -= 1
      # 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
      if indegree[i] == 0:
        q.append(i)

  # 위상 정렬을 수행한 결과 출력
  for i in result:
    print(i, end=' ')

topology_sort()
```

위상 정렬의 시간 복잡도는 O(V + E)

## 관련 문제

```python
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a > b:
    parent[a] = b
  else:
    parent[b] = a

n, m = map(int, input().split())
parent = [0] * (n + 1)

for i in range(n + 1):
  parent[i] = i

for _ in range(m):
  c, a, b = map(int, input().split())
  if c == 0:
    union_parent(parent, a, b)
  else:
    if parent[a] == parent[b]:
      print("YES")
    else:
      print("NO")
```

```python
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a > b:
    parent[a] = b
  else:
    parent[b] = a

n, m = map(int, input().split())
parent = [0] * (n + 1)
edges = []

for i in range(n + 1):
  parent[i] = i

for _ in range(m):
  a, b, c = map(int, input().split())
  edges.append((c, a, b))

edges.sort()
max = 0
res = 0

for edge in edges:
  cost, a, b = edge
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    res += cost
    max = cost

print(res - max)
```

```python
from collections import deque
import copy

n = int(input())

time = [0] * (n + 1)
indegree = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]

for i in range(1, n + 1):
  inp = list(map(int, input().split()))
  time[i] = inp[0]
  j = 1
  while inp[j] != -1:
    graph[inp[j]].append(i)
    indegree[i] += 1
    j += 1

def topology_sort():
  result = copy.deepcopy(time)
  q = deque()

  for i in range(1, n + 1):
    if indegree[i] == 0:
      q.append(i)

  while q:
    now = q.popleft()
    pre = 0
    for i in graph[now]:
      result[i] = max(result[i], result[now] + time[i])
      indegree[i] -= 1
      if indegree[i] == 0:
        q.append(i)

  for i in result:
    print(i)

topology_sort()
```

```python
n, m = map(int, input().split())
trip = [[0] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):
  road = list(map(int, input().split()))
  for j in range(1, n+1):
    trip[i][j] = road[j-1]

want_list = list(map(int, input().split()))
want = []
for x in want_list:
  if x not in want:
    want.append(x)

parent = [0] * (n+1)

for i in range(1, n+1):
  parent[i] = i
  
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

for i in range(1, n+1):
  for j in range(1, n+1):
    if trip[i][j] == 1:
      union_parent(parent, i, j)

flag = True
val = parent[want[0]]
for i in range(1, len(want)):
  if parent[want[i]] != val:
    flag = False

if flag == True:
  print("YES")
else:
  print("NO")
```

```python
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

g = int(input())
p = int(input())

parent = [0] * (g+1)

for i in range(g+1):
  parent[i] = i

res = 0
for _ in range(p):
  d = int(input())
  next = find_parent(parent, d)
  if next != 0:
    union_parent(parent, next, next-1)
    res += 1
  else:
    break
print(res)
```

```python
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

n, m = map(int, input().split())
parent = [0] * n
for i in range(n):
  parent[i] = i
edges = []
first_res = 0
for _ in range(m):
  x, y, cost = map(int, input().split())
  edges.append((cost, x, y))
  first_res += cost
edges.sort()
last_res = 0

for edge in edges:
  cost, a, b = edge
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    last_res += cost

print(first_res - last_res)
```

```python
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

n = int(input())
parent = [0] * (n+1)
for i in range(1, n+1):
  parent[i] = i
xEdges = []
yEdges = []
zEdges = []
edges = []
for i in range(1, n + 1):
  x, y, z = map(int, input().split())
  xEdges.append((x, i))
  yEdges.append((y, i))
  zEdges.append((z, i))
xEdges.sort()
yEdges.sort()
zEdges.sort()
for i in range(1, n):
  edges.append((abs(xEdges[i][0] - xEdges[i-1][0]), xEdges[i-1][1], xEdges[i][1]))
  edges.append((abs(yEdges[i][0] - yEdges[i-1][0]), yEdges[i-1][1], yEdges[i][1]))
  edges.append((abs(zEdges[i][0] - zEdges[i-1][0]), zEdges[i-1][1], zEdges[i][1]))
edges.sort()
res = 0
cnt = 0
for edge in edges:
  cost, a, b = edge
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    res += cost
  if cnt == n-1:
    break
print(res)
```

```python
from collections import deque

t = int(input())

for _ in range(t):
  n = int(input())
  rank = list(map(int, input().split()))
  indegree = [0] * (n+1)
  graph = [[False] * (n+1) for _ in range(n+1)]
  for i in range(n):
    for j in range(i + 1, n):
      graph[rank[i]][rank[j]] = True
      indegree[rank[j]] += 1
  m = int(input())
  for i in range(m):
    a, b = map(int, input().split())
    if graph[a][b]:
      graph[a][b] = False
      graph[b][a] = True
      indegree[a] += 1
      indegree[b] -= 1
    else:
      graph[a][b] = True
      graph[b][a] = False
      indegree[a] -= 1
      indegree[b] += 1

  q = deque()
  for i in range(1, n+1):
    if indegree[i] == 0:
      q.append(i)

  flag = 0
  res = []
  for i in range(n):
    if len(q) == 0:
      flag = 1
      break
    if len(q) == 2:
      flag = 2
      break
    now = q.popleft()
    res.append(now)
    for j in range(1, n+1):
      if graph[now][j]:
        indegree[j] -= 1
        if indegree[j] == 0:
          q.append(j)
        
  if flag == 0:
    for i in range(n):
      print(res[i], end=' ')
  elif flag == 1:
    print("IMPOSSIBLE")
  else:
    print("?")
```

```python
def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

n = int(input())
m = int(input())
edges = []
parent = [0] * (n+1)
for i in range(1, n+1):
  parent[i] = i

for _ in range(m):
  a, b, c = map(int, input().split())
  edges.append((c, a, b))
edges.sort()

res = 0
for edge in edges:
  cost, a, b = edge
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    res += cost
print(res)
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {

    static int N,M;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
            depth[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int select, a, b;
            select = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (select == 0) {
                //union
                union(a, b);
            } else {
                //같은지 확인
                if (find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P1922 {
    static int N, M, A, B, C;
    static int[] parent = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<Edge> edges = new LinkedList<>();

        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        int cnt = 0;
        int result = 0;
        while (cnt < N-1) {
            Edge edge = edges.remove(0);
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                result += edge.weight;
                cnt++;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
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
import java.util.*;

public class P2252 {
    static int N, M, A, B;
    static int[] indegree = new int[32001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 32001; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            indegree[B] += 1;
            graph.get(A).add(B);
        }

        for (int i = 1; i < N+1; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        //0이 되는 것 부터 출력
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");
            for (int i = 0; i < graph.get(poll).size(); i++) {
                int connect = graph.get(poll).get(i);
                indegree[connect] -= 1;
                if (indegree[connect] == 0)
                    queue.add(connect);
            }
        }

    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11438 {
    static int N, M;
    static int[][] dp = new int[18][100001];
    static int[] depth = new int[100001];
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        //1. tree 생성(깊이, dp[0][v] 채우기)
        int a, b;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < adj[cur].size(); i++) {
                int next = adj[cur].get(i);
                if (visit[next]) {
                    continue;
                }
                dp[0][next] = cur;
                visit[next] = true;
                depth[next] = depth[cur] + 1;
                q.add(next);
            }

        }

        //2. parent 초기화
        for (int i = 1; i < 18; i++) {
            for (int j = 1; j < N+1; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b) + "\n");
        }

        System.out.print(sb);
    }

    static int lca(int a, int b) {
        //3. 높이를 맞춰라
        if (depth[a] > depth[b]) {
            int temp = b;
            b = a;
            a = temp;
        }

        int gap = depth[b] - depth[a];
        for (int i = 0; i < 18; i++) {
            if ((gap & 1 << i) > 0) {
                b = dp[i][b];
            }
        }

        //4. 같이 위로 올라가면서 조상찾기
        if (a == b)
            return a;
        for (int i = 17; i >= 0; i--) {
            if (dp[i][a] != dp[i][b]) {
                a = dp[i][a];
                b = dp[i][b];
            }
        }

        return dp[0][a];
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

public class P2458 {
    static int N, M;
    static boolean[] visited;
    static int[] inCnt;
    static int[] outCnt;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        inCnt = new int[N + 1];
        outCnt = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            outCnt[i] = dfs(i) - 1;
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (inCnt[i] + outCnt[i] == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }


    static int dfs(int cur) {
        int outCnt = 0;
        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if (visited[next])
                continue;
            inCnt[next]++;
            visited[next] = true;
            outCnt += dfs(next);
        }
        return outCnt + 1;
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

public class P11266 {
    static int V, E;
    static List<Integer>[] adj;
    static int[] order;
    static boolean[] isCut;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        order = new int[V + 1];
        isCut = new boolean[V + 1];
        adj = new ArrayList[V + 1];
        for (int i = 1; i < V+1; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i < V + 1; i++) {
            if (order[i] == 0)
                dfs(i, true);
        }

        int ans = 0;
        for (int i = 1; i < V+1; i++) {
            if (isCut[i])
                ans+=1;
        }
        System.out.println(ans);

        for (int i = 1; i < V + 1; i++) {
            if (isCut[i])
                System.out.print(i + " ");
        }
    }

    static int dfs(int cur, boolean isRoot) {
        //단절점 판별
        order[cur] = ++cnt;

        int ret = cnt;
        int child = 0;
        //A가 시작정점이 아닐떄, order(A) <= low(B) 단절점, order(A) > low(B) 단절점이아니다
        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if (order[next] == 0) {
                child++;
                int low = dfs(next, false);
                if (!isRoot && order[cur] <= low) {
                    isCut[cur] = true;
                }
                ret = Math.min(ret, low);
            }else{
                ret = Math.min(ret, order[next]);
            }
        }

        //A가 시작정점일때, child > 1일때 단절점
        if (isRoot && child > 1) {
            isCut[cur] = true;
        }
        return ret;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3176 {
    static int N, K;
    static int[][] parent;
    static int[][] max;
    static int[][] min;
    static int[] depth;
    static boolean[] visited;
    static List<Edge>[] adj;
    static int minRes, maxRes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[18][N + 1];
        max = new int[18][N + 1];
        min = new int[18][N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        int A, B, C;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            adj[A].add(new Edge(B, C));
            adj[B].add(new Edge(A, C));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        //트리구성
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < adj[cur].size(); i++) {
                Edge edge = adj[cur].get(i);
                int next = edge.to;
                int cost = edge.cost;
                if (visited[next])
                    continue;
                parent[0][next] = cur;
                depth[next] = depth[cur] + 1;
                visited[next] = true;
                max[0][next] = cost;
                min[0][next] = cost;
                q.add(next);
            }
        }

        //parent 초기화
        for (int i = 1; i < 18; i++) {
            for (int j = 1; j < N + 1; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                max[i][j] = Math.max(max[i-1][j], max[i - 1][parent[i - 1][j]]);
                min[i][j] = Math.min(min[i-1][j], min[i - 1][parent[i - 1][j]]);
            }
        }

        K = Integer.parseInt(br.readLine());

        int D, E;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            lca(D, E);
            sb.append(minRes + " " + maxRes + "\n");
        }

        System.out.println(sb);
    }

    static void lca(int a, int b) {
        //높이 맞추기
        if (depth[a] > depth[b]) {
            int temp = b;
            b = a;
            a = temp;
        }

        minRes = Integer.MAX_VALUE;
        maxRes = -1;
        
        int gap = depth[b] - depth[a];
        for (int i = 0; i < 18; i++) {
            if ((gap & 1 << i) > 0) {
                maxRes = Math.max(maxRes, max[i][b]);
                minRes = Math.min(minRes, min[i][b]);
                b = parent[i][b];
            }
        }
        
        if (a == b)
            return;
        //같아지면 동시에 올리기
        //lca
        //최소 조상 찾을떄 까지 도로 거리 중에 가장 짧은 값, 가장 긴 값 구하기
        for (int i = 17; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                maxRes = Math.max(maxRes, Math.max(max[i][a], max[i][b]));
                minRes = Math.min(minRes, Math.min(min[i][a], min[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        maxRes = Math.max(maxRes, Math.max(max[0][a], max[0][b]));
        minRes = Math.min(minRes, Math.min(min[0][a], min[0][b]));

        return;
    }
}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3830 {
    static int N, M;
    static Node[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char select;
        int a, b, w;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new Node[N + 1];
            for (int i = 1; i < N + 1; i++) {
                parent[i] = new Node(i, 0);
            }
            if (N == 0 && M == 0)
                break;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                select = st.nextToken().charAt(0);
                if (select == '!') {
                    //무게 추가
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else {
                    //무게 재기
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    if (find(a).root == find(b).root) {
                        System.out.println(parent[a].dis - parent[b].dis);
                    } else {
                        System.out.println("UNKNOWN");
                    }
                }
            }
        }
    }

    static Node find(int x) {
        if (parent[x].getRoot() != x) {
            Node node = find(parent[x].getRoot());
            parent[x].root = node.root;
            parent[x].dis += node.dis;
        }
        return parent[x];
    }

    static void union(int a, int b, int w) {
        Node aNode = find(a);
        Node bNode = find(b);
        if (aNode.root == bNode.root)
            return;
        parent[aNode.root].dis = w + parent[b].dis - parent[a].dis;
        parent[aNode.root].root = bNode.root;
    }
}

class Node {
    int root;
    long dis;

    public Node(int parent, long dis) {
        this.root = parent;
        this.dis = dis;
    }

    public int getRoot() {
        return root;
    }

    public long getDis() {
        return dis;
    }
}
```

```java
package WEEK2.DAY03.P5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5719 {
    static final int MAXN = 500;
    static int N, M, S, D;
    static int[][] adj;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0)
                break;

            dis = new int[N];

            adj = new int[MAXN][MAXN];
            for (int i = 0; i < MAXN; i++) {
                for (int j = 0; j < MAXN; j++) {
                    adj[i][j] = 0;
                }
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int u, v, p;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                adj[u][v] = p;
            }

            //다익스트라 돌리는데 최단 경로를 추적해서 기록
            //제거 후
            //다익스트라 하면 거의 최단경로
            dijkstra(S);
            removeShortest();
            dijkstra(S);
            if (dis[D] == Integer.MAX_VALUE)
                System.out.println("-1");
            else
                System.out.println(dis[D]);

        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        q.add(new Node(S, 0));

        for (int i = 0; i < N; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        dis[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.pos;
            int curCost = node.weight;

            if (dis[cur] < curCost)
                continue;
            for (int i = 0; i < N; i++) {
                if (adj[cur][i] == 0) continue;
                int next = i;
                int nextCost = adj[cur][i];
                int cost = curCost + nextCost;
                if (dis[next] > cost) {
                    dis[next] = cost;
                    q.add(new Node(next, cost));
                }
            }
        }
    }

    static void removeShortest() {
        Queue<Integer> q = new LinkedList<>();
        q.add(D);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < N; i++) {
                if (adj[i][cur] != 0 && dis[cur] - adj[i][cur] == dis[i]) {
                    adj[i][cur] = 0;
                    q.add(i);
                }
            }
        }
    }
}

class Node {
    int pos;
    int weight;

    public Node(int pos, int weight) {
        this.pos = pos;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
```