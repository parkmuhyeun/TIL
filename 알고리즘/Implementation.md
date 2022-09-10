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

```java
import java.io.IOException;

public class L118666 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }

    static int[][] score = new int[4][2];
    public static String solution(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                addScore(survey[i].charAt(0), 4 - choices[i]);
            } else if(choices[i] > 4) {
                addScore(survey[i].charAt(1), choices[i] - 4);
            }
        }

        return getAnswer("");
    }

    private static String getAnswer(String answer) {
        if (score[0][0] >= score[0][1])
            answer += "R";
        else
            answer += "T";
        if (score[1][0] >= score[1][1])
            answer += "C";
        else
            answer += "F";
        if (score[2][0] >= score[2][1])
            answer += "J";
        else
            answer += "M";
        if (score[3][0] >= score[3][1])
            answer += "A";
        else
            answer += "N";
        return answer;
    }

    private static void addScore(char type, int num) {
        if (type == 'R')
            score[0][0] += num;
        else if(type == 'T')
            score[0][1] += num;
        else if(type == 'C')
            score[1][0] += num;
        else if(type == 'F')
            score[1][1] += num;
        else if(type == 'J')
            score[2][0] += num;
        else if(type == 'M')
            score[2][1] += num;
        else if(type == 'A')
            score[3][0] += num;
        else if(type == 'N')
            score[3][1] += num;
    }
}
```

```java
import java.io.IOException;
import java.util.*;

public class L92334 {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}
                , new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"}
                , new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 2)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> relate = new HashMap<>();
        List<Set<String>> list = new ArrayList<>();

        for (int i = 0; i < id_list.length; i++) {
            relate.put(id_list[i], i);
            list.add(new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            String bad = split[1];
            list.get(relate.get(bad)).add(split[0]);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < list.size(); i++) {
            Set<String> send = list.get(i);
            if (send.size() >= k) {
                for (String s : send) {
                    answer[relate.get(s)] += 1;
                }
            }
        }

        return answer;
    }
}
```

```java
class Solution {
    public int[] L77484(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int length = 6;
        int cnt = 0;
        int zero = 0;
        for (int i = 0; i < length; i++) {
            if (lottos[i] == 0)
                zero++;
            for (int j = 0; j < length; j++) {
                if (lottos[i] == win_nums[j])
                    cnt++;
            }
        }
        answer[1] = 7 - cnt;
        answer[0] = 7 - (cnt + zero);
        if(answer[1] == 7)
            answer[1] = 6;
        if(answer[0] == 7)
            answer[0] = 6;

        return answer;
    }
}
```


```java
class L72410 {
    public static String solution(String new_id) {
        int length1 = new_id.length();
        StringBuilder first = new StringBuilder();
        one(new_id, length1, first);

        StringBuilder second = new StringBuilder();
        two(length1, first, second);

        boolean flag = false;
        StringBuilder third = new StringBuilder();
        three(second, flag, third);

        if (third.length() != 0) {
            four(second, third);
        }

        five(third);

        return last(third);
    }

    private static String last(StringBuilder third) {
        if (third.length() >= 16) {
            if (third.charAt(14) == '.')
                return(third.substring(0, 14));
            else
                return(third.substring(0, 15));
        }else{
            if (third.length() == 1) {
                third.append(third.charAt(0));
                third.append(third.charAt(0));
            } else if (third.length() == 2)
                third.append(third.charAt(1));
            return third.toString();
        }
    }

    private static void five(StringBuilder third) {
        if (third.length() == 0)
            third.append("a");
    }

    private static void four(StringBuilder second, StringBuilder third) {
        if (second.charAt(0) == '.')
            third.replace(0, 1, "");
        int length3 = third.length();
        if (third.charAt(length3 - 1) == '.')
            third.replace(length3 - 1, length3, "");
    }

    private static void three(StringBuilder second, boolean flag, StringBuilder third) {
        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            if (c == '.') {
                if (!flag) {
                    flag = true;
                }
            }else{
                if (flag) {
                    flag = false;
                    third.append(".");
                }
                third.append(c);
            }
        }
    }

    private static void two(int length1, StringBuilder first, StringBuilder second) {
        for (int i = 0; i < length1; i++) {
            char c = first.charAt(i);
            if(isCheck(c))
                second.append(c);
        }
    }

    private static void one(String new_id, int length1, StringBuilder first) {
        for (int i = 0; i < length1; i++) {
            char c = new_id.charAt(i);
            if (65 <= c && c <= 90)
                first.append(Character.toLowerCase(c));
            else
                first.append(c);
        }
    }

    private static boolean isCheck(char c) {
        if (97 <= c && c <= 122)
            return true;
        if (48 <= c && c <= 57)
            return true;
        if (c == 45 || c == 46 || c == 95)
            return true;

        return false;
    }
}
```

```java
import java.io.*;
import java.util.HashMap;

public class L81301 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
    }

    public static int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        Init(map);

        StringBuilder answer = new StringBuilder();
        StringBuilder val = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (48 <= c && c <= 57) {
                if (isConvert(map, val)) {
                    answer.append(map.get(val.toString()));
                    val = new StringBuilder();
                }
                answer.append(c);
            }else if (!isConvert(map, val)) {
                val.append(c);
            } else if (isConvert(map, val)) {
                answer.append(map.get(val.toString()));
                val = new StringBuilder();
                val.append(c);
            }
        }

        if(isConvert(map, val))
            answer.append(map.get(val.toString()));

        return Integer.parseInt(answer.toString());
    }

    private static boolean isConvert(HashMap<String, Integer> map, StringBuilder val) {
        return map.get(val.toString()) != null;
    }

    private static void Init(HashMap<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}
```

```java
import java.util.Arrays;

class L12982 {
    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget -= d[i];
                answer++;
            }else
                break;
        }
        return answer;
    }
}
```

```java
class L17681 {
   public static String[] solution(int n, int[] arr1, int[] arr2) {
        int length = arr1.length;
        int[][] divide1 = new int[length][length];
        int[][] divide2 = new int[length][length];
        String[] res = new String[length];
        
        init(arr1, length, divide1);
        init(arr2, length, divide2);
        
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if (divide1[i][j] == 1 || divide2[i][j] == 1) {
                    sb.append('#');
                }else{
                    sb.append(' ');
                }
            }
            res[i] = sb.toString();
        }

        return res;
    }

    private static void init(int[] arr, int length, int[][] divide) {
        for (int i = 0; i < length; i++) {
            int temp = arr[i];
            int cnt = 0;
            while (temp != 0) {
                int val = temp % 2;
                divide[i][length - 1 - cnt] = val;
                temp /= 2;
                cnt++;
            }
        }
    }
}
```

```java
class L17682 {
    public static int solution(String dartResult) {
        int[] res = new int[3];
        int length = dartResult.length();

        int cnt = 0;
        for (int i = 0; i < length; i += 2) {
            int score = dartResult.charAt(i) - '0';
            char bonus = dartResult.charAt(i+1);
            if (bonus == '0') {
                score = 10;
                bonus = dartResult.charAt(i+2);
                i++;
            }
            if (i + 2 <= length) {
                char option =' ';
                if (i + 2 != length)
                    option = dartResult.charAt(i + 2);
                int pow = (int) Math.pow(score, getBonus(bonus));
                if (option == '*') {
                    if (cnt != 0)
                        res[cnt-1] *= 2;
                    res[cnt] = pow * 2;
                    i++;
                } else if (option == '#') {
                    res[cnt] = pow * -1;
                    i++;
                }else{
                    res[cnt] = pow;
                }
            }
            cnt++;
        }

        return res[0] + res[1] + res[2];
    }

    private static int getBonus(char bonus) {
        if (bonus == 'S')
            return 1;
        else if(bonus == 'D')
            return 2;
        return 3;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

class L12977 {
     public static int solution(int[] nums) {
        List<int[]> combinations = new ArrayList<>();
        boolean[] prime = new boolean[50001];
        for (int i = 0; i < 50001; i++)
            prime[i] = true;

        combination(combinations, new int[3], nums, 0, nums.length - 1, 0);

        for (int i = 2; i < Math.sqrt(50000); i++) {
            if (prime[i]) {
                for (int j = 2; i * j < 50001; j++) {
                    prime[i * j] = false;
                }
            }
        }

        int answer = 0;
        for (int[] combination : combinations) {
            int sum = 0;
            for (int num : combination) {
                sum += num;
            }
            if (prime[sum])
                answer++;
        }

        return answer;
    }

    static void combination(List<int[]> combinations, int[] data, int[] nums, int start, int end, int idx) {
        if (idx == data.length) {
            int[] clone = data.clone();
            combinations.add(clone);
        } else if (start <= end) {
            data[idx] = nums[start];
            combination(combinations, data, nums, start + 1, end, idx + 1);
            combination(combinations, data, nums, start + 1, end, idx);
        }
    }
}

```

```java
class L67256 {
public static String solution(int[] numbers, String hand) {
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};
        int[][] keyPad = new int[][]{{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (isLeft(number))
                answer.append("L");
            else if (isRight(number))
                answer.append("R");
            else{
                int x = keyPad[number][0];
                int y = keyPad[number][1];
                int leftDis = Math.abs(left[0] - x) + Math.abs(left[1] - y);
                int rightDis = Math.abs(right[0] - x) + Math.abs(right[1] - y);
                if (leftDis < rightDis)
                    answer.append("L");
                else if (leftDis > rightDis)
                    answer.append("R");
                else {
                    if (hand.equals("right"))
                        answer.append("R");
                    else
                        answer.append("L");
                }
            }

            if (answer.charAt(i) == 'L') {
                left[0] = keyPad[number][0];
                left[1] = keyPad[number][1];
            } else {
                right[0] = keyPad[number][0];
                right[1] = keyPad[number][1];
            }
        }

        return answer.toString();
    }

    private static boolean isLeft(int number) {
        return number == 1 || number == 4 || number == 7;
    }

    private static boolean isRight(int number) {
        return number == 3 || number == 6 || number == 9;
    }
}
```

```java
class L86051 {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int i = 0; i < numbers.length; i++)
            answer -= numbers[i];
        return answer;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L64061 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}
        }, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    public static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> bStack = new ArrayList<>();
        Stack<Integer> res = new Stack<>();

        for (int i = 0; i < board[0].length; i++) {
            bStack.add(new Stack<Integer>());
            for (int j = board.length - 1; j >= 0; j--) {
                int num = board[j][i];
                if (num != 0)
                    bStack.get(i).push(num);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            int idx = moves[i] - 1;
            int top = -1;
            if (bStack.get(idx).isEmpty())
                continue;
            int push = bStack.get(idx).pop();
            if (!res.isEmpty())
                top = res.peek();
            if (top == push) {
                res.pop();
                answer += 2;
            } else
                res.push(push);
        }
        
        return answer;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class L68935 {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    public static int solution(int n) {
        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add(n % 3);
            n /= 3;
        }

        int answer = 0;
        int pow = list.size() -1;
        for (int i = 0; i < list.size(); i++) {
            answer += Math.pow(3, pow) * list.get(i);
            pow--;
        }
        return answer;
    }
}
```

```java
class L82612 {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for(int i = 1; i < count+1; i++){
            sum += price * i;
        }
        
        if (money - sum >= 0)
            return 0;
        else
            return -(money - sum);
    }
}
```

```java
class L76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            if (signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }
        return answer;
    }
}
```