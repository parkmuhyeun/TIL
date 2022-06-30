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

```python
n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visit = [0] * (n+1)
for i in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

def dfs(start):
  visit[start] = 1
  for i in graph[start]:
    if visit[i] == 0:
      dfs(i)

dfs(1)
ans = 0
for i in range(2, n+1):
  if visit[i] == 1:
    ans += 1
print(ans)
```

```python
import sys
sys.setrecursionlimit(10000)

t = int(input())

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(x, y):
  board[x][y] = 0
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == 1:
        dfs(nx, ny)

for case in range(t):
  m, n, k  = map(int, input().split())
  board = [[0] * n for _ in range(m)]
  for i in range(k):
    x, y = map(int, input().split())
    board[x][y] = 1
  ans = 0
  for i in range(m):
    for j in range(n):
      if board[i][j] == 1:
        dfs(i, j)
        ans += 1
  print(ans)
```

```python
#review
n = int(input())
nums = list(map(int, input().split()))
pl, mi, mu, di = map(int, input().split())

min_res = 1e9
max_res = -1e9

def dfs(dep, now):
    global min_res, max_res, pl, mi, mu, di
    if dep == n:
        min_res = min(min_res, now)
        max_res = max(max_res, now)
    else:
        if pl > 0:
            pl -= 1
            dfs(dep + 1, now + nums[dep])
            pl += 1
        if mi > 0:
            mi -= 1
            dfs(dep + 1, now - nums[dep])
            mi += 1
        if mu > 0:
            mu -= 1
            dfs(dep + 1, now * nums[dep])
            mu += 1
        if di > 0:
            di -= 1
            dfs(dep + 1, int(now / nums[dep]))
            di += 1

dfs(1, nums[0])

print(max_res)
print(min_res)

# from itertools import permutations

# n = int(input())
# nums = list(map(int, input().split()))
# pl, mi, mu, di = map(int, input().split())
# signs = []

# for i in range(pl):
#   signs.append('+')
# for i in range(mi):
#   signs.append('-')
# for i in range(mu):
#   signs.append('*')
# for i in range(di):
#   signs.append('/')


# max_res = -1e9
# min_res = 1e9
# for perm in list(permutations(signs, len(signs))):
#   sum = nums[0]
#   for i in range(len(perm)):
#     if perm[i] == '+':
#       sum = sum + nums[i+1]
#     elif perm[i] == '-':
#       sum = sum - nums[i+1]
#     elif perm[i] == '*':
#       sum = sum * nums[i+1]
#     elif perm[i] == '/':
#       if sum < 0:
#         sum = -1 * sum
#         sum = sum // nums[i+1]
#         sum = -1 * sum
#       else:
#         sum = sum // nums[i+1]
#   max_res = max(max_res, sum)      
#   min_res = min(min_res, sum)
# print(max_res)
# print(min_res)
```