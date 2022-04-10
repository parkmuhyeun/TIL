# BFS
#알고리즘/BFS

---
BFS(Breadth First Search) 알고리즘은 '너비 우선 탐색'이라는 의미를 가진다. 즉 가까운 노드부터 탐색하는 알고리즘.

BFS는 큐 자료구조를 이용하며 구체적인 동작 과정은 다음과 같다.
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복

``` python
from collections import deque

# BFS 메서드 정의
def bfs(graph, start, visited):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start] = True
    # 큐가 빌 때까지 반복
    while queue:
      # 큐에서 하나의 원소를 뽑아 출력
      v = queue.popleft()
      print(v, end=' ')
    # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
      for i in graph[v]:
        if not visited[i]:
          queue.append(i)
          visited[i] = True

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

# 정의된 BFS 함수 호출
bfs(graph, 1, visited)
```

```
from collections import deque

n, m = map(int, input().split())

graph = []

for i in range(n):
  graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x,y):
  queue = deque()
  graph[x][y] = 1
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
        continue
      if graph[nx][ny] == 0:
        queue.append((nx, ny))
        graph[nx][ny] = 1


res = 0
for i in range(n):
  for j in range(m):
    if graph[i][j] == 0:
      print(i, j)
      bfs(i,j)
      res += 1

print(res)
```

```
from collections import deque

n, m = map(int, input().split())

graph = []

for i in range(n):
  graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
  queue = deque()
  queue.append((x,y))
  
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
        continue
      if graph[nx][ny] == 1:
        queue.append((nx, ny))
        graph[nx][ny] = graph[x][y] + 1

  return graph[n-1][m-1]

print(bfs(0,0))
```

```python
from collections import deque
import sys
input = sys.stdin.readline

def bfs(graph, start, visited):
  queue = deque()
  queue.append(start)
  visited[start] = True
  dis[start] = 0
  while queue:
    v = queue.popleft()
    if dis[v] == k:
      result.append(v)
    for x in graph[v]:
      if not visited[x]:
        visited[x] = True
        queue.append(x)
        dis[x] = dis[v]+1

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)

visited = [False] * (n+1)
dis = [-1] * (n+1)
result = []
bfs(graph, x, visited)

if len(result) == 0:
  print(-1)
else:
  result.sort()
  for x in result:
    print(x)
```

```python
from itertools import combinations
import copy
from collections import deque

def bfs(x, y):
  queue = deque()
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < n and 0 <= ny < m:
        if cboard[nx][ny] == 0:
          cboard[nx][ny] = 2
          queue.append((nx, ny))

dx = [0, 0, 1, -1]
dy = [1, -1, 0 ,0]

n, m = map(int, input().split())
board = []
for _ in range(n):
  board.append(list(map(int, input().split())))
walls = []
for i in range(n):
  for j in range(m):
    walls.append((i, j))
virus = []
for i in range(n):
  for j in range(m):
    if board[i][j] == 2:
      virus.append((i,j))

res = 0
for wall in list(combinations(walls, 3)):
  flag = False
  cboard = copy.deepcopy(board)
  cnt = 0
  for i in range(3):
    x = wall[i][0]
    y = wall[i][1]
    if cboard[x][y] == 0:
      cboard[x][y] = 1
    else:
      flag = True
      break
  if flag:
    continue
  for i in range(len(virus)):
    bfs(virus[i][0], virus[i][1])
  for i in range(n):
    for j in range(m):
      if cboard[i][j] == 0:
        cnt += 1
  res = max(res, cnt)
print(res)
```

```python
import sys
import copy
input = sys.stdin.readline

n, k = map(int, input().split())
board = [[0] * (n+1) for _ in range(n+1)]
pos = [[] for _ in range(k+1)]
for i in range(1, n+1):
  row = list(map(int, input().split()))
  for j in range(1, n+1):
    board[i][j] = row[j-1]
    pos[row[j-1]].append((i, j))
s, a, b = map(int, input().split())

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def infect(x, y, num):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 1 <= nx <= n and 1 <= ny <= n:
      if board[nx][ny] == 0:
        board[nx][ny] = num
        next.append((nx, ny))
        
cnt = 1
while cnt <= s:
  for i in range(1, len(pos)):
    next = []  
    for j in range(len(pos[i])):
      infect(pos[i][j][0], pos[i][j][1], i)
    pos[i] = copy.deepcopy(next)
  cnt += 1
print(board[a][b])
```

``python
from collections import deque

def solution(board):
    n = len(board)
    visit = []
    pos = [(0, 0), (0, 1)]
    q = deque()
    q.append((pos, 0))
    visit.append(pos)
    
    while q:
        pos, cost = q.popleft()
        if (n-1, n-1) in pos:
            return cost
        for next_pos in get_next_pos(pos, board):
            if not next_pos in visit:
                q.append((next_pos, cost + 1))
                visit.append(next_pos)
    return 0


def get_next_pos(pos, board):
    next = []
    n = len(board)
    pos = list(pos)
    pos1_x, pos1_y, pos2_x, pos2_y = pos[0][0], pos[0][1], pos[1][0], pos[1][1]
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    # 상하좌우
    for i in range(4):
        pos1_next_x, pos1_next_y, pos2_next_x, pos2_next_y = pos1_x + dx[i], pos1_y + dy[i], pos2_x + dx[i], pos2_y + dy[i]
        if 0 <= pos1_next_x < n and 0 <= pos1_next_y < n and 0 <= pos2_next_x < n and 0 <= pos2_next_y < n:
            if board[pos1_next_x][pos1_next_y] == 0 and board[pos2_next_x][pos2_next_y] == 0:
                next.append({(pos1_next_x, pos1_next_y), (pos2_next_x, pos2_next_y)})
    
    # 회전 (가로, 세로)
    if pos1_x == pos2_x:
        for i in [-1, 1]:
            pos1_next_x = pos1_x + i
            pos2_next_x = pos2_x + i
            if 0 <= pos1_next_x < n and 0 <= pos2_next_x < n:
                if board[pos1_next_x][pos1_y] == 0 and board[pos2_next_x][pos2_y] == 0:
                    next.append({(pos1_x, pos1_y), (pos1_next_x, pos1_y)})
                    next.append({(pos2_x, pos2_y), (pos2_next_x, pos2_y)})
    elif pos1_y == pos2_y:
        for i in [-1, 1]:
            pos1_next_y = pos1_y + i
            pos2_next_y = pos2_y + i
            if 0 <= pos1_next_y < n and 0 <= pos2_next_y < n:
                if board[pos1_x][pos1_next_y] == 0 and board[pos2_x][pos2_next_y] == 0:
                    next.append({(pos1_x, pos1_y), (pos1_x, pos1_next_y)})
                    next.append({(pos2_x, pos2_y), (pos2_x, pos2_next_y)})
    return next
```