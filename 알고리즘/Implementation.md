# Implementation
#알고리즘/Implementation

---
코딩 테스트에서 구현이란 '머릿속에 잇는 알고리즘을 소스코드로 바꾸는 과정'

```python
n = int(input())
move = input().split()
cnt = len(move)

x = 1
y = 1

for i in range(cnt):
  if move[i] == 'L' and y-1 >= 1:
    y -= 1
  elif move[i] == 'R' and y+1 <= n:
    y += 1
  elif move[i] == 'U' and x-1 >= 1:
    x -= 1
  elif move[i] == 'D' and x+1 <= n:
    x += 1

print(x, y)

## 더 좋은 답안
n = int(input())
moves = input().split()
x = 1
y = 1

# L, R, U, D에 따른 이동 방향
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

for move in moves:
    for i in range(len(move_types)):
      if move == move_types[i]:
        nx = x + dx[i]
        ny = y + dy[i]
    # 공간 벗어난 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny > n:
      continue
    # 이동 수행
    x, y = nx, ny

print(x, y)
```

```python
n = int(input())
cnt = 0

for h in range(n+1):
  for m in range(60):
    for s in range(60):
      if '3' in str(h) + str(m) + str(s):
        cnt += 1

print(cnt)
```

```python
input_data = input()

x = int(input_data[1])
y = ord(input_data[0])-96

dx = [-1, 1, -2, -2, -1, 1, 2, 2]
dy = [-2, -2, -1, 1, 2, 2, -1, 1]

cnt = 0
for i in range(8):
  nx = x + dx[i]
  ny = y + dy[i]
  if nx >= 1 and ny >= 1 and nx <= 8 and ny <= 8:
    cnt += 1

print(cnt)
```

```python
n, m = map(int, input().split())
a, b, d = map(int, input().split())

arr = [[0] * m for _ in range(n)]

for i in range(n):
  row = list(map(int, input().split()))
  for j in range(m):
    arr[i][j] = row[j]

# 북, 동, 남, 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

res = 1
x = a
y = b
ro = 0
arr[x][y] = 2

while True:
  d = (d+3) % 4
  nx = x + dx[d]
  ny = y + dy[d]
  if arr[nx][ny] != 0:
    # 반시계 방향으로 방향만 회전
    ro += 1
  else:
    # 반시계 방향으로 전진
    res +=1
    arr[nx][ny] = 2
    x = nx
    y = ny
    ro = 0
  if ro == 4:
    # 뒤로
    bx = x + dx[(d+2) % 4]
    by = y + dy[(d+2) % 4]

    if arr[bx][by] == 1:
      break
    x = bx
    y = by
    ro = 0

print(res)
```

```python
n = input()
l = len(n)
left = 0
right = 0

for i in range(l//2):
  left += int(n[i])
for i in range(l//2, l):
  right += int(n[i])

if left == right:
  print("LUCKY")
else:
  print("READY")
```

```python
s = input()
num = 0
res = []
for i in s:
  if 65 <= ord(i) <= 90:
    res.append(i)
  else:
    num += int(i)
res.sort()
print(''.join(res), end='')
if num != 0:
  print(num)
```

```python
def solution(s):
    l = len(s)
    
    answer = l
    pre = ''
    slice = 1
    while slice <= l//2:
        cnt = 1
        res = ""
        pre = s[0:slice]
        for j in range(slice, l, slice):
            if pre == s[j:j+slice]:
                cnt += 1
            else:
                if cnt == 1:
                    res += pre
                else:
                    res += str(cnt) + pre
                    cnt = 1
                pre = s[j:j+slice]
        if cnt == 1:
            res += pre
        else:
            res += str(cnt) + pre
        answer = min(answer, len(res))
        slice += 1
        
    return answer
```

```python
import copy

def solution(key, lock):
  board = [[0] * (len(lock) * 3) for _ in range(len(lock) * 3)]
  for i in range(len(lock)):
    for j in range(len(lock)):
      board[len(lock) + i][len(lock) + j] = lock[i][j]
  start = len(lock) - len(key) + 1
  search = len(lock) + len(key) - 1
  for _ in range(4):
    key = rotate(key)
    for i in range(search):
      for j in range(search):
        if moveKey(start + i, start + j, key, lock, board):
          return True
  return False

def moveKey(x, y, key, lock, board):
  board_copy = copy.deepcopy(board)
  for i in range(len(key)):
    for j in range(len(key)):
      board_copy[x+i][y+j] += key[i][j]
  return checkLock(board_copy, lock)
  
def checkLock(board, lock):
  start = len(board) // 3
  for i in range(len(lock)):
    for j in range(len(lock)):
      if board[start+i][start+j] != 1:
        return False
  return True

def rotate(key):
  rotate_key = [[0] * len(key) for _ in range(len(key))]
  for i in range(len(key)):
    for j in range(len(key)):
      rotate_key[j][len(key)-i-1] = key[i][j]
  return rotate_key

key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
print(solution(key, lock))
```

```python
n = int(input())
board = [[0] * (n+1) for _ in range(n+1)]
apple = [[0] * (n+1) for _ in range(n+1)]
k = int(input())
for _ in range(k):
  x, y = map(int, input().split())
  apple[x][y] = 1
L = int(input())
change = []
for _ in range(L):
  t, c = input().split()
  change.append((int(t), c))

time = 1
step = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
board[1][1] = 1
startx = 1
starty = 1
nextt = change[0][0]
nextr = change[0][1]
move = 0

while True:
  startx += dx[step]
  starty += dy[step]
  # 벽에 부딪히거나 몸에 부딪힐 때 까지
  if 1 > startx or startx > n or 1 > starty or starty > n or board[startx][starty] != 0:
    break
  # 사과있으면 머리부분 +1, 없으면 꼬리부분 삭제
  if apple[startx][starty] == 1:
    board[startx][starty] = board[startx-dx[step]][starty-dy[step]] + 1
    apple[startx][starty] = 0
  else:
    board[startx][starty] = board[startx-dx[step]][starty-dy[step]] + 1
    for i in range(1, n+1):
      for j in range(1, n+1):
        if board[i][j] == 1:
          board[i][j] = 0
        if board[i][j] > 1:
          board[i][j] -= 1
  if nextt == time:
    if nextr == 'D':
      step = (step + 1) % 4
    else:
      step -= 1
      if step == -1:
        step = 3

    if move < L-1:
      move += 1
      nextt = change[move][0]
      nextr = change[move][1]
  time += 1
print(time)
```

```python
def solution(n, build_frame): 
  answer = []

  for f in build_frame:
    x, y, what, how = f

    #설치
    if how == 1:
      answer.append([x, y, what])
      if possible(answer) is False:
        answer.remove([x, y, what])
    # 삭제
    else:
      answer.remove([x, y, what])
      if possible(answer) is False:
        answer.append([x, y, what])

  answer.sort()
  return answer

def possible(ans):
  for x, y, what in ans:
    # 기둥
    # 기둥위 기둥
    # 보의 한쪽 끝 부분 위 기둥
    # 바닥위 기둥
    if what == 0:
      if y == 0 or [x-1, y, 1] in ans or [x, y, 1] in ans or [x, y-1, 0] in ans:
        continue
      else:
        return False
    # 보
    # 기둥 위 보
    # 왼쪽 보 오른쪽 보 사이
    elif what == 1:
      if [x, y-1, 0] in ans or [x+1, y-1, 0] in ans or ([x-1, y, 1] in ans and [x+1, y, 1] in ans):
        continue
      else:
        return False
  return True
```

```pyhton
import sys
from itertools import combinations

n, m = map(int, input().split())
city = [[0] * (n+1) for _ in range(n+1)]
dis = [[0] * (n+1) for _ in range(n+1)]
chi = []
home = []
for i in range(1, n+1):
  row = list(map(int, sys.stdin.readline().rstrip().split()))
  for j in range(1, n+1):
    city[i][j] = row[j-1]
    if row[j-1] == 2:
      chi.append((i, j))
    elif row[j-1] == 1:
      home.append((i, j))

comb = list(combinations(chi, m))

result = 1e9
for co in comb:
  sum = 0
  for h in home:
    d = 1e9
    for c in co:
      d = min(d, abs(h[0] - c[0]) + abs(h[1] - c[1]))
    sum += d
  result = min(result, sum)
print(result)
```

```python
from itertools import permutations

def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)

    result = len(dist) + 1
    for start in range(length):
        for pe in list(permutations(dist, len(dist))):
            cnt = 1
            end = weak[start] + pe[cnt - 1]
            for i in range(start, start + length):
                if weak[i] > end:
                    cnt += 1
                    if cnt > len(dist):
                        break    
                    end = weak[i] + pe[cnt - 1]
            result = min(result, cnt)
    if result > len(dist):
        return -1
    return result
```

```python
ans = []
pa = []
for i in range(1, 10001):
  val = i
  if i not in pa:
    ans.append(i)
  pos = len(str(i))
  temp = i
  while pos:
    n = temp // (10 ** (pos-1))
    val += n
    temp -= n * (10 ** (pos-1))
    pos -= 1
  pa.append(val)
  
for i in range(len(ans)):
  print(ans[i])
```

```python
n = int(input())
words = []
for i in range(n):
  word = input()
  words.append(list(word))

ans = 0
for word in words:
  exist = []
  pre = word[0]
  for i in range(1, len(word)):
    now = word[i]
    if pre != now:
      if now in exist:
        break
      exist.append(pre)
      pre = now
    if i == len(word)-1:
      ans += 1
  if len(word) == 1:
    ans += 1
print(ans)
```

```python
word = list(input())

res = 0
i = 0
while i < len(word):
  if word[i] == '=' or word[i] == '-':
    i += 1
    continue
  if word[i] == 'd' and i+2 < len(word):
    if word[i+1] == 'z' and word[i+2] == '=':
      res += 1
      i += 3
      continue
  if word[i] == 'l' and i+1 < len(word):
    if word[i+1] == 'j':
      res += 1
      i += 2
      continue
  if word[i] == 'n' and i+1 < len(word):
    if word[i+1] == 'j':
      res += 1
      i += 2
      continue
  res += 1
  i += 1
print(res)
```

```python
import copy

s = list(input())
copys = copy.deepcopy(s)
st = []
cst = []
flag = False
ans = 0

if len(s) == 1 or s[len(s)-1] == '(' or s[len(s)-1] == '[':
  print(ans)
else:
  while s:
    sp = s.pop()
    if sp == ')' or sp == ']':
      st.append(sp)
    elif sp =='(':
      if len(st) == 0 or st[len(st)-1] != ')':
        flag = True
        break
      st.pop()
    else:
      if len(st) == 0 or st[len(st)-1] != ']':
        flag = True
        break
      st.pop()

  if flag or st:
    print(ans)
  else:
    while copys:
      sp = copys.pop()
      if sp == ')' or sp == ']':
        cst.append(sp)
      elif sp == '(':
        cstp = cst[len(cst)-1]
        if cstp == ')':
          cst.pop()
          cst.append(2)
        else:
          val = 0
          while cstp != ')':
            val += cst.pop()
            cstp = cst[len(cst)-1]
          cst.pop()
          val *= 2
          cst.append(val)
      else:
        cstp = cst[len(cst)-1]
        if cstp == ']':
          cst.pop()
          cst.append(3)
        else:
          val = 0
          while cstp != ']':
            val += cst.pop()
            cstp = cst[len(cst)-1]
          cst.pop()
          val *= 3
          cst.append(val)
    print(sum(cst))
```

```python
n, m = map(int, input().split())
r, c, d = map(int, input().split())
floor = [[0] * (m) for _ in range(n)]
for i in range(n):
  row = list(map(int, input().split()))
  for j in range(m):
    floor[i][j] = row[j]

x = r
y = c
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

flag = False
floor[x][y] = 2
ans = 1
while True:
  for i in range(4):
    d -= 1
    if d == -1:
      d = 3
    nx = x + dx[d]
    ny = y + dy[d]
    if nx < 0 or nx > n-1 or ny < 0 or ny > m-1 or floor[nx][ny] != 0:
      if i == 3:
        back = (d + 2) % 4
        if floor[x+dx[back]][y+dy[back]] == 1:
          flag = True
        x = x + dx[back]
        y = y + dy[back]
      continue
    else:
        x = nx
        y = ny
        floor[x][y] = 2
        ans += 1
        break
  if flag:
    break
print(ans)
```

```python
from itertools import permutations

def solution(n, weak, dist):
  tweak = weak + [n+x for x in weak]
  wlen = len(weak)
  dlen = len(dist)
  ans = dlen + 1
  
  for i in range(wlen):
    for perm in permutations(dist, dlen):
      cnt = 1
      start = tweak[i] + perm[0]
      for j in range(i, i + wlen):
        if tweak[j] > start:
          cnt += 1
          if cnt > dlen:
            break
          start = tweak[j] + perm[cnt-1]
      ans = min(ans, cnt)

      # cnt = 0
      # start = tweak[i]
      # m = 0
      # c = 0
      # next = 0
      # for j in range(len(perm)):
      #   for k in tweak:
      #     if start <= k <= start + perm[j]:
      #       m += 1
      #       c = 1
      #     elif k > start + perm[j]:
      #       next = k
      #       break
      #   if c == 1:
      #     cnt += 1
      #   start = next
      #   if m >= wlen:
      #     ans = min(ans, cnt)
          
  if ans == dlen + 1:
    print(-1)
  else:
    print(ans)

solution(12, [1, 5, 6, 10], [1, 2, 3, 4])
solution(12, [1, 3, 4, 9, 10], [3, 5, 7])
```

```python
def ins(dice, num1, num2, num3, num4):
  temp1 = dice[num1]
  dice[num1] = dice[num2]
  temp2 = dice[num3]
  dice[num3] = temp1
  temp3 = dice[num4]
  dice[num4] = temp2
  dice[num2] = temp3

def check(board, dice, x, y):
  if board[x][y] != 0:
    dice[0] = board[x][y]
    board[x][y] = 0
  else:
    board[x][y] = dice[0]

n, m, x, y, k = map(int, input().split())
board = [[0] *  m for _ in range(n)]
dice = [0] * 6
for i in range(n):
  col = list(map(int, input().split()))
  for j in range(m):
    board[i][j] = col[j]
move = list(map(int, input().split()))

temp1 = 0
temp2 = 0
temp3 = 0
res = []

if not (n == 1 and m == 1):
  for i in range(k):
    # 동쪽
    if move[i] == 1:
      y += 1
      if x < 0 or x > n-1 or y < 0 or y > m-1:
        y -= 1
        continue
      ins(dice, 5, 2, 1, 0)
      check(board, dice, x, y)
    # 서쪽
      res.append(dice[5])
    elif move[i] == 2:
      y -= 1
      if x < 0 or x > n-1 or y < 0 or y > m-1:
        y += 1
        continue
      ins(dice, 1, 0, 5, 2)
      check(board, dice, x, y)
      res.append(dice[5])
    elif move[i] == 3:
      x -= 1
      if x < 0 or x > n-1 or y < 0 or y > m-1:
        x += 1
        continue
      ins(dice, 0, 3, 4, 5)
      check(board, dice, x, y)
      res.append(dice[5])
    else:
      x += 1
      if x < 0 or x > n-1 or y < 0 or y > m-1:
        x -= 1
        continue
      ins(dice, 5, 3, 4, 0)
      check(board, dice, x, y)
      res.append(dice[5])

for x in res:
  print(x)
```

```python
from collections import deque

def solution(p):
    u = []
    v = []
    if p == '':
        return '';
    if perfect(p):
        return p    
    
    return recur(p)

def recur(start):
    if len(start) == 0:
        return ""
    u = deque()
    v = deque()
    u = balance(start)
    for i in range(len(u), len(start)):
        v.append(start[i])
    if perfect(u):
        return "".join(u) + recur(v)
    else:
        return "(" + recur(v) + ")" + "".join(trans(u))

def trans(arr):
    arr.popleft()
    arr.pop()
    rarr = []
    for i in range(len(arr)):
        if arr[i] == '(':
            rarr.append(')')
        else:
            rarr.append('(')
    return rarr            
    
def perfect(arr):
    st = []
    for i in range(len(arr)):
        if arr[i] == '(':
            st.append(arr[i])
        else:
            if len(st) == 0:
                return False
            c = st.pop()
            if c != '(':
                return False
    return True

def balance(array):
    cnt1 = 0
    cnt2 = 0
    rarray = deque()
    for i in range(len(array)):
        if array[i] == '(':
            cnt1 += 1
            rarray.append('(')
        else:
            cnt2 += 1
            rarray.append(')')
        if cnt1 == cnt2:
            break
    return rarray
```

```python
from itertools import permutations

n = int(input())
arr = list(map(int, input().split()))
pl, mi, mu, di = map(int, input().split())
mark = []
for i in range(pl):
  mark.append("+")
for i in range(mi):
  mark.append("-")
for i in range(mu):
  mark.append("*")
for i in range(di):
  mark.append("/")
  
maxres = -1e9
minres = 1e9

for perm in permutations(mark, len(mark)):
  res = arr[0]
  for i in range(1, len(arr)):
    if perm[i-1] == '+':
      res += arr[i]
    elif perm[i-1] == '-':
      res -= arr[i]
    elif perm[i-1] == '*':
      res *= arr[i]
    else:
      if res < 0:
        res *= -1
        res //= arr[i]
        res *= -1
      else:
        res //= arr[i]
  maxres = max(maxres, res)
  minres = min(minres, res)
print(maxres)
print(minres)
```

```python
from itertools import permutations

n = int(input())
board = [['X'] * (n+1) for _ in range(n+1)]
obs = []
t = []
for i in range(1, n+1):
  row = list(input().split())
  for j in range(1, n+1):
    board[i][j] = row[j-1]
    obs.append((i, j))
    if board[i][j] == 'T':
      t.append((i, j))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

flag = True
for perm in permutations(obs, 3):
  imp = True
  for x in perm:
    if board[x[0]][x[1]] == 'X':
      board[x[0]][x[1]] = 'O'
    else:
      for x in perm:
        if board[x[0]][x[1]] == 'O':
          board[x[0]][x[1]] = 'X'
      imp = False
      break
  if not imp:
    continue
  flag = True
  for pos in t:
    for dir in range(4):
      x = pos[0]
      y = pos[1]
      while True:
        nx = x + dx[dir]
        ny = y + dy[dir]
        if nx < 1 or n < nx or ny < 1 or n < ny:
          break
        else:
          if board[nx][ny] == 'O':
            break
          elif board[nx][ny] == 'S':
            flag = False
            break
          else:
            x = nx
            y = ny
      if not flag:
        break
    if not flag:
      break
  if flag:
    break
  else:
    for x in perm:
      board[x[0]][x[1]] = 'X'

if flag:
  print("YES")
else:
  print("NO")
```

```python
#review
n = input()
left = 0
right = 0
for i in range(len(n)//2):
  left += int(n[i])
for i in range(len(n)//2, len(n)):
  right += int(n[i])
if left == right:
  print("LUCKY")
else:
  print("READY")
```

```python
#review
s = input()
res = sorted(s)
val = 0
front = ""
for i in range(len(res)):
  if 65 <= ord(res[i]):
    front += res[i]
  else:
    val += int(res[i])
print(front+str(val))
```

```python
def solution(s):
    answer = len(s)
    
    for i in range(1, len(s)//2 + 1):
        previous = s[:i]
        now = ""
        res = ""
        val = 0
        for j in range(len(s)):
            now += s[j]
            if len(now) == i:
                if previous == now:
                    val += 1
                    now = ""
                else:
                    if val == 1:
                        res += previous
                    else:
                        res += str(val) + previous
                        val = 1
                    previous = now
                    now = ""
        if val == 1:
            res += previous
        else:
            res += str(val) + previous
        if len(s) % i != 0:
            res += now
        answer = min(answer, len(res))
    return answer
```

```python
#review
def bodyCollision(nx, ny):
  for body in snake:
    if nx == body[0] and ny == body[1]:
      return True
  return False

from collections import deque

N = int(input())
K = int(input())
apples = [[0] * (N+1) for _ in range(N+1)]
dirs = deque()
for _ in range(K):
  x, y = map(int, input().split())
  apples[x][y] = 1
L = int(input())
for _ in range(L):
  time, dir = input().split()
  dirs.append((int(time), dir))

x = 1
y = 1
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
dir = 0
cnt = 0
snake = deque()
snake.append((1, 1))
while(1):
  if dirs and cnt == dirs[0][0]:
    if dirs[0][1] == 'L':
      dir = (dir - 1) % 4
    else:
      dir = (dir + 1) % 4
    dirs.popleft()
  nx = x + dx[dir]
  ny = y + dy[dir]
  if nx < 1 or N < nx or ny < 1 or N < ny or bodyCollision(nx, ny):
    break
  if apples[nx][ny] == 1:
    apples[nx][ny] = 0
  else:
    snake.pop()
  snake.appendleft((nx, ny))
  x = nx
  y = ny
  cnt += 1
print(cnt+1)
```

```python
#review
def solution(key, lock):
    N = len(key)
    M = len(lock)
    length = M + 2 * (N-1)
    board = [[0] * length for _ in range(length)]
    for i in range(N-1, N-1+M):
        for j in range(N-1, N-1+M):
            board[i][j] = lock[i-(N-1)][j-(N-1)]

    flag = 1
    for rotate in range(4):
        for i in range(length):
            for j in range(length):
                flag = 1
                # 범위 안에 있는 값만 찍어준다
                for k in range(i, i + N):
                    for l in range(j, j + N):
                        if N-1 <= k < N-1+M and N-1 <= l < N-1+M:
                            if board[k][l] == 0:
                                board[k][l] = key[k-i][l-j]
                            elif board[k][l] == 1 and key[k-i][l-j] == 1:
                                flag = 0
                # Check
                for k in range(N-1, N-1+M):
                    for l in range(N-1, N-1+M):
                        if board[k][l] == 0:
                            flag = 0
                            break
                    if flag == 0:
                        break
                # 열 수 있으면 True, 없으면 원상복귀
                if flag == 1:
                    return True
                else:
                    for k in range(N-1, N-1+M):
                        for l in range(N-1, N-1+M):
                            board[k][l] = lock[k-(N-1)][l-(N-1)]
        key = rotateKey(key)
    return False

def rotateKey(key):
    n = len(key)
    m = len(key[0])
    rotate_key = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            rotate_key[j][n-1-i] = key[i][j]
    return rotate_key
```

```python
def possible(res):
    for r in res:
        x, y, a = r
        # 기둥
        if a == 0:
            if y == 0 or (x-1, y, 1) in res or (x, y, 1) in res or (x, y-1, 0) in res:
                continue
            else:
                return False
        # 보
        else:
            if (x, y-1, 0) in res or (x+1, y-1, 0) in res or ((x-1, y, 1) in res and (x+1, y, 1) in res):
                continue
            else:
                return False
    return True            

def solution(n, build_frame):
    
    res = []
    for build in build_frame:
        x, y, a, b = build
                
        # 설치
        if b == 1:
            res.append((x, y, a))
            if not possible(res):
                res.remove((x, y, a))
        # 삭제
        else:
            res.remove((x, y, a))
            if not possible(res):
                res.append((x, y, a))
    res.sort()
    return res
```

```python
#review
from itertools import combinations
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
homes = []
chomes = []
for i in range(n):
  row = list(map(int, input().split()))
  for j in range(n):
    if row[j] == 1:
      homes.append((i+1, j+1))
    elif row[j] == 2:
      chomes.append((i+1, j+1))

res = 1e9
for comb in combinations(chomes, m):
  sum = 0
  for home in homes:
    min_dis = 1e9
    for cx, cy in comb:
      min_dis = min(min_dis, abs(cx - home[0]) + abs(cy - home[1]))
    sum += min_dis
  res = min(res, sum)
print(res)
```

```python
#review
from itertools import permutations
import copy

def solution(n, weak, dist):
    dlen = len(dist)
    wlen = len(weak)
    nweak = copy.deepcopy(weak)
    for i in range(wlen):
        nweak.append(weak[i] + n)
        
    res = dlen + 1 
    for perm in permutations(dist, dlen):
        for start in range(wlen):
            cnt = 1
            end = nweak[start] + perm[cnt - 1]
            for i in range(start, start + wlen):
                if nweak[i] > end:
                    cnt += 1
                    if cnt > dlen:
                        break
                    end = nweak[i] + perm[cnt - 1]
            res = min(res, cnt)
    if res > dlen:
        res = -1
    return res
```

```java
import java.io.*;

public class L86491 {

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[][]{{60,50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(arr));
    }

    static int maxA = 0;
    static int maxB = 0;
    public static int solution(int[][] sizes) {
        int length = sizes.length;
        for (int i = 0; i < length; i++) {
            maxA = Math.max(maxA, sizes[i][0]);
            maxB = Math.max(maxB, sizes[i][1]);
        }
        int max1 = Math.max(maxA, maxB);

        int max2 = 0;
        for (int i = 0; i < length; i++) {
            int min = Math.min(sizes[i][0], sizes[i][1]);
            max2 = Math.max(max2, min);
        }

        return max1 * max2;
    }

}
```

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class L87946 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        List<int[][]> permutations = new ArrayList<>();
        int answer = -1;
        int length = dungeons.length;
        boolean[] visited = new boolean[length];
        perm(permutations, dungeons, new int[length][2], visited, 0);

        for (int[][] permutation : permutations) {
            int p = k;
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                if (permutation[i][0] > p)
                    break;
                cnt++;
                p -= permutation[i][1];
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void perm(List<int[][]> permutations, int[][] arr, int[][] data, boolean[] visited, int depth) {
        if (depth == data.length) {
            int[][] clone = new int[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    clone[i][j] = data[i][j];
                }
            }
            permutations.add(clone);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                data[depth][0] = arr[i][0];
                data[depth][1] = arr[i][1];
                perm(permutations, arr, data, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
```