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

```python
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

```python
#review
from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)

visited = [False] * (n+1)
q = deque()
q.append((x, 0))

res = []
while q:
  now, cnt = q.popleft()
  visited[now] = True
  res.append((now, cnt))
  for g in graph[now]:
    if not visited[g]:
      visited[g] = True
      q.append((g, cnt+1))
res.sort()

cnt = 0
city = []
for i in range(len(res)):
  if res[i][1] == k:
    cnt += 1
    city.append(res[i][0])
if cnt == 0:
  print("-1")
else:
  for x in city:
    print(x)
```

```python
#reivew
from collections import deque
from itertools import combinations
import copy

def bfs(x, y):
  q = deque()
  q.append((x,y))
  while q:
    x, y = q.popleft()
    for dir in range(4):
      nx = x + dx[dir]
      ny = y + dy[dir]
      if 1 <= nx <= n and 1 <= ny <= m and cboard[nx][ny] == 0:
        cboard[nx][ny] = 2
        q.append((nx, ny))

n, m = map(int, input().split())
board = [[0] * (m+1) for _ in range(n+1)]
virus = []
for i in range(1, n+1):
  row = list(map(int, input().split()))
  for j in range(1, m+1):
    board[i][j] = row[j-1]
    if board[i][j] == 2:
      virus.append((i, j))
      
wall = []
for i in range(1, n+1):
  for j in range(1, m+1):
    wall.append((i, j))

res = -1
for comb in list(combinations(wall, 3)):
  flag = 0
  cboard = copy.deepcopy(board)
  for i, j in comb:
    if cboard[i][j] == 2 or cboard[i][j] == 1:
      flag = 1
      break
    else:
      cboard[i][j] = 1
  if flag == 1:
    continue

  dx = [0, 0, -1, 1]
  dy = [1, -1, 0, 0]
  for x, y in virus:
    bfs(x, y)
  safe = 0
  for i in range(1, n+1):
    for j in range(1, m+1):
      if cboard[i][j] == 0:
        safe += 1
  res = max(res, safe)
print(res)
```

```python
#review
import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
board = [[0] * (N+1) for _ in range(N+1)]
virus = []
for i in range(1, N+1):
  row = list(map(int, input().split()))
  for j in range(1, N+1):
    if row[j-1] != 0:
      board[i][j] = row[j-1]
      virus.append((row[j-1], 0, i, j))
S, X, Y = map(int, input().split())
virus.sort()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = deque()
for i in range(len(virus)):
  q.append(virus[i])
while q:
  type, time, x, y = q.popleft()
  if time == S:
    break
  for dir in range(4):
    nx = x + dx[dir]
    ny = y + dy[dir]
    if 1 <= nx <= N and 1 <= ny <= N and board[nx][ny] == 0:
      board[nx][ny] = type
      q.append((type, time+1, nx, ny))
print(board[X][Y])


# import sys
# input = sys.stdin.readline

# N, K = map(int, input().split())
# board = [[0] * (N+1) for _ in range(N+1)]
# virus = [[] for _ in range(K+1)]
# for i in range(1, N+1):
#   row = list(map(int, input().split()))
#   for j in range(1, N+1):
#     if row[j-1] != 0:
#       board[i][j] = row[j-1]
#       virus[row[j-1]].append((i, j))
# S, X, Y = map(int, input().split())

# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]

# while S: 
#   for i in range(1, K+1):
#     for j in range(len(virus[i])):
#       x, y = virus[i][j]
#       for dir in range(4):
#         nx = x + dx[dir]
#         ny = y + dy[dir]
#         if 1 <= nx <= N and 1 <= ny <= N and board[nx][ny] == 0:
#           board[nx][ny] = i
#           virus[i].append((nx, ny))
#   S -= 1
# print(board[X][Y])
```

```python
#review
def solution(p):
    if isRight(p):
        return p
        
    return recur(p)

def recur(s):
    if s == '':
        return ''
    left = 0
    right = 0
    u = ''
    for i in range(len(s)):
        if s[i] == '(':
            right += 1
            u += '('
        else:
            left += 1
            u += ')'
        if right >= 1 and right == left:
            break
    v = s[left+right:]
    if isRight(u):
        return u + recur(v)
    else:
        last = ''
        for i in range(len(u)):
            if i == 0 or i == len(u)-1:
                continue
            if u[i] == ')':
                last += '('
            else:
                last += ')'
        return '(' + recur(v) + ')' + last
    
def isRight(s):
    st = []
    for x in s:
        if x == '(':
            st.append(x)
        else:
            if not st:
                return False
            c = st.pop()
            if c != '(':
                return False
    return True
```

```python
#review
from collections import deque

def solution(board):
    n = len(board)
    pos = [(0, 0), (0, 1)]
    visit = []
    visit.append(pos)
    
    q = deque()
    q.append((pos, 0))
    
    while q:
        now, cost = q.popleft()
        if (n-1, n-1) in now:
            return cost
        for next_pos in getNextPos(now, board):
            if next_pos not in visit:
                q.append((next_pos, cost+1))            
                visit.append(next_pos)
            
    return 0

def getNextPos(now, board):
    next = []
    n = len(board)
    fx = now[0][0]
    fy = now[0][1]
    sx = now[1][0]
    sy = now[1][1]
    
    dx = [-1, 1, 0 ,0]
    dy = [0, 0, -1, 1]
    # 상하좌우 이동
    for i in range(4):
        nfx = fx + dx[i]
        nfy = fy + dy[i]
        nsx = sx + dx[i]
        nsy = sy + dy[i]
        if 0 <= nfx < n and 0 <= nfy < n and 0 <= nsx < n and 0 <= nsy < n and board[nfx][nfy] == 0 and board[nsx][nsy] == 0:
            next.append([(nfx, nfy), (nsx, nsy)])
    
    #가로회전
    if fx == sx:
        #위가 비어있는 경우
        if 0 <= fx-1 < n and 0 <= sx-1 < n and board[fx-1][fy] == 0 and board[sx-1][sy] == 0:
            next.append([(fx-1, fy), (fx, fy)])
            next.append([(sx-1, sy), (sx, sy)])
        #아래가 비어있는 경우
        if 0 <= fx+1 < n and 0 <= sx+1 < n and board[fx+1][fy] == 0 and board[sx+1][sy] == 0:
            next.append([(fx, fy), (fx+1, fy)])
            next.append([(sx, sy), (sx+1, sy)])
            
    #세로회전
    if fy == sy:
        # 왼쪽이 비어있는 경우
        if 0 <= fy-1 < n and 0 <= sy-1 < n and board[fx][fy-1] == 0 and board[sx][sy-1] == 0:
            next.append([(fx, fy-1), (fx, fy)])
            next.append([(sx, sy-1), (sx, sy)])
        # 오른쪽이 비어있는 경우
        if 0 <= fy+1 < n and 0 <= sy+1 < n and board[fx][fy+1] == 0 and board[sx][sy+1] == 0:
            next.append([(fx, fy), (fx, fy+1)])
            next.append([(sx, sy), (sx, sy+1)])
    return next

print(solution([[0, 0, 0, 1, 1], [0, 0, 0, 1, 0], [0, 1, 0, 1, 1], [1, 1, 0, 0, 1], [0, 0, 0, 0, 0]]))
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P3055 {
    static int R;
    static int C;
    static char[][] board;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        board = new char[R][C];
        distance = new int[R][C];

        Queue<Node> queue = new LinkedList<>();
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                board[i][j] = split[j].charAt(0);
                if (board[i][j] == '*')
                    queue.add(new Node(i, j, '*'));
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (board[i][j] == 'D') {
                    endX = i;
                    endY = j;
                }
            }
        }
        queue.add(new Node(startX, startY, 'S'));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.x == endX && poll.y == endY) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (0 <= nx && nx < R && 0 <= ny && ny < C && distance[nx][ny] == 0) {
                    if (poll.type == 'S' && (board[nx][ny] == '.' || board[nx][ny] == 'D')) {
                        distance[nx][ny] = distance[poll.x][poll.y] + 1;
                        queue.add(new Node(nx, ny, 'S'));
                    }
                    if (poll.type == '*' && (board[nx][ny] == '.' || board[nx][ny] == 'S')) {
                        board[nx][ny] = '*';
                        queue.add(new Node(nx, ny, '*'));
                    }
                }
            }
        }

        if (distance[endX][endY] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(distance[endX][endY]);
        }
    }

    static class Node {
        int x;
        int y;
        char type;

        public Node(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
```

```java
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class L1844 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    static int[][] dis;
    static int X, Y;

    public static int solution(int[][] maps) {
        X = maps.length;
        Y = maps[0].length;
        dis = new int[X+1][Y+1];
        bfs(maps);
        if(dis[X][Y] == 0)
            return -1;
        else
            return dis[X][Y];
    }

    static void bfs(int[][] maps) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(1, 1));
        dis[1][1] = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Pos poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            if (x == X && y == Y)
                break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (1 <= nx && nx <= X && 1 <= ny && ny <= Y && maps[nx-1][ny-1] == 1 && dis[nx][ny] == 0) {
                    dis[nx][ny] = dis[x][y] + 1;
                    q.add(new Pos(nx, ny));
                }
            }
        }
    }
}

class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

```

```java
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class L43162 {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < computers.length; i++) {
                if (cur == i)
                    continue;
                if (computers[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
```