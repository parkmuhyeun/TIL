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