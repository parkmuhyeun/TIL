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

```python
#review

from itertools import combinations

def check(x, y):
  #x축
  for i in range(x-1, -1, -1):
    if board[i][y] == 'O':
      break
    if board[i][y] == 'S':
      return False
  for i in range(x+1, n):
    if board[i][y] == 'O':
      break
    if board[i][y] == 'S':
      return False
    
  #y축
  for i in range(y-1, -1, -1):
    if board[x][i] == 'O':
      break
    if board[x][i] == 'S':
      return False
  for i in range(y+1, n):
    if board[x][i] == 'O':
      break
    if board[x][i] == 'S':
      return False
      
  return True

n = int(input())
board = []
teacher = []
obstacle = []
for i in range(n):
  row = list(input().split())
  for j in range(n):
    if row[j] == 'T':
      teacher.append((i, j))
    if row[j] == 'X':
      obstacle.append((i, j))
  board.append(row)

flag = False
for comb in list(combinations(obstacle, 3)):
  for x, y in comb:
    board[x][y] = 'O'
  for x, y in teacher:
    if check(x, y):
      flag = True
    else:
      flag = False
      break
  if flag:
    break
  else:
    for x, y in comb:
      board[x][y] = 'X'

if flag:
  print("YES")
else:
  print("NO")
```

```python
#review
def dfs(x, y, cnt):
  visited[x][y] = cnt

  dx = [0, 0, -1, 1]
  dy = [1, -1, 0, 0]
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0 and l <= abs(board[x][y] - board[nx][ny]) <= r:
      dfs(nx, ny, cnt)

n, l, r = map(int, input().split())
board = []
for _ in range(n):
  board.append(list(map(int, input().split())))
visited = [[0] * n for _ in range(n)]

res = 0
while True:
  cnt = 1
  for i in range(n):
    for j in range(n):
      if visited[i][j] == 0:
        dfs(i, j, cnt)
        cnt += 1 
        
  if cnt == (n*n) + 1:
    break

  people_cnt = [0] * cnt
  country_cnt = [0] * cnt
  # 나눌 수 구하기
  for i in range(n):
    for j in range(n): 
      team = visited[i][j]
      people_cnt[team] += board[i][j]
      country_cnt[team] += 1
  
  # 부여
  for i in range(n):
    for j in range(n): 
      team = visited[i][j]
      board[i][j] = people_cnt[team] // country_cnt[team]
  
  res += 1
  for i in range(n):
    for j in range(n):
      visited[i][j] = 0

print(res)
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1062 {
    static int N, K;
    static String[] words;
    static int[] alphabet = new int[26];
    static int max_res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        alphabet[0] = 1;
        alphabet[2] = 1;
        alphabet[8] = 1;
        alphabet[13] = 1;
        alphabet[19] = 1;

        if (K > 5) {
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] == 0)
                    dfs(i, 5);
            }
        }else if (K == 5)
            max_res = getRes();

        System.out.println(max_res);
    }

    static void dfs(int index, int depth){
        alphabet[index] = 1;
        if (depth == K-1) {
            int res = getRes();
            max_res = Math.max(max_res, res);
        }else{
            for (int i = index+1; i < 26; i++   ) {
                if (alphabet[i] == 0) {
                    dfs(i, depth+1);
                }
            }
        }
        alphabet[index] = 0;
    }

    private static int getRes() {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            Boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (alphabet[words[i].charAt(j)-97] != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res += 1;
        }
        return res;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1759 {
    static int L, C;
    static char[] data;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        data = new char[C];
        String[] word = br.readLine().split(" ");
        for (int i = 0; i < word.length; i++) {
            data[i] = word[i].charAt(0);
        }

        Arrays.sort(data);
        dfs(0, 0, 0, -1, "");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    static void dfs(int length, int ja, int mo, int cur, String pwd) {
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                result.add(pwd);
            }
        }

        for (int i = cur+1; i < C; i++) {
            if (isMo(data[i])) {
                dfs(length + 1, ja, mo + 1, i, pwd + data[i]);
            } else {
                dfs(length + 1, ja + 1, mo, i, pwd + data[i]);
            }
        }
    }

    private static boolean isMo(char datum) {
        return datum == 'a' || datum == 'e' || datum == 'i' || datum == 'o' || datum == 'u';
    }

}
```