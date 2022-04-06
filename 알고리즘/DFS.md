# DFS
#알고리즘/DFS

---
DFS는 Depth-First-Search, 깊이 우선 탐 색이라고 부르며, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘

DFS의 동작 원리는 스택을 이용하며 재귀 함수로 구현할 수 있다. 구체적인 동작 과정은 다음과 같다.
1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 2번 과정을 더 이상 수행할 수 없을 때까지 반복

```python
# DFS 메서드 정의
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)
```

```python
import sys
input = sys.stdin.readline

n, l, r = map(int, input().split())
country = [[0] * (n+1) for _ in range(n+1)]
team = [[0] * (n+1) for _ in range(n+1)]
count = [[0] * 2 for _ in range((n*n)+1)]
for i in range(1, n+1):
  row = list(map(int, input().split()))
  for j in range(1, n+1):
    country[i][j] = row[j-1]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(x, y, team, cnt):
  team[x][y] = cnt
  count[cnt][0] += country[x][y]
  count[cnt][1] += 1
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 1 <= nx <= n and 1 <= ny <= n and team[nx][ny] == 0:
      dif = abs(country[nx][ny] - country[x][y])
      if l <= dif <= r:
        dfs(nx, ny, team, cnt)

ans = 0
while True:
  cnt = 1
  for i in range(1, n+1):
    for j in range(1, n+1):
      if team[i][j] == 0:
        dfs(i, j, team, cnt)
        cnt += 1
  if cnt == (n * n) + 1:
    break
  for i in range(1, n+1):
    for j in range(1, n+1):
      t = team[i][j]
      country[i][j] = count[t][0] // count[t][1]
  team = [[0] * (n+1) for _ in range(n+1)]
  count = [[0] * 2 for _ in range((n*n)+1)]
  ans += 1
print(ans)
```