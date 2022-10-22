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

```java
import java.util.*;

class L68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                res.add(numbers[i] + numbers[j]);
            }   
        }
        
        int[] answer = new int[res.size()];
        int cnt = 0;
        for (int num : res) {
            answer[cnt++] = num;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}
```

```java
class L77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int cnt = 0;
            for(int j = 1; j <= i; j++){
                if (i % j == 0)
                    cnt++;
            }
            if (cnt % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}
```

```java
class L70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }
        return answer;
    }
}
```

```java
class L87389 {
    public int solution(int n) {
        for(int i = 2; i < n; i++){
            if (n % i == 1)
                return i;
        }
        return 0;
    }
}
```

```java
import java.io.*;

public class L92335 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }

        String kJin = sb.reverse().toString();
        boolean flag = false;
        StringBuilder val = new StringBuilder();
        int answer = 0;
        for (int i = 0; i < kJin.length(); i++) {
            char now = kJin.charAt(i);
            if (now != '0'){
                flag = true;
                val.append(now);
            }else if (now == '0' && flag){
                if(isPrime(Long.parseLong(val.toString())))
                    answer++;
                val = new StringBuilder();
                flag = false;
            }
        }

        if (val.toString().length() != 0 && isPrime(Long.parseLong(val.toString()))) {
            answer++;
        }
        return answer;
    }

    private static boolean isPrime(long x){
        if (x == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(x); i++){
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
```

```java
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L92341 {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},
//                new String[]{
//                        "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
//                        "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
//                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
//                )));
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591},
                new String[]{
                        "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT",
                        "18:00 0202 OUT","23:58 3961 IN"}
        )));
    }

    public static int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> all = new HashMap<>();
        HashMap<Integer, String> now = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            String time = split[0];
            int carNum = Integer.parseInt(split[1]);
            String type = split[2];
            if (type.equals("IN")) {
                now.put(carNum, time);
            } else {
                String start = now.get(carNum);
                String[] sSplit = start.split(":");
                int startHour = Integer.parseInt(sSplit[0]);
                int startMinute = Integer.parseInt(sSplit[1]);
                String[] oSplit = time.split(":");
                int outHour = Integer.parseInt(oSplit[0]);
                int outMinute = Integer.parseInt(oSplit[1]);
                int hour = 0;
                int minute = 0;
                if (outMinute >= startMinute) {
                    hour = outHour - startHour;
                    minute = outMinute - startMinute;
                }else{
                    hour = outHour - 1 - startHour;
                    minute = outMinute + 60 - startMinute;
                }
                all.put(carNum, (hour * 60) + minute + all.getOrDefault(carNum, 0));
                now.remove(carNum);
            }
        }

        for (int key : now.keySet()) {
            String[] split = now.get(key).split(":");
            int hour = 23 - Integer.parseInt(split[0]);
            int minute = 59 - Integer.parseInt(split[1]);
            all.put(key, (hour * 60) + minute + all.getOrDefault(key, 0));
        }

        Object[] mapKey = all.keySet().toArray();
        Arrays.sort(mapKey);
        List<Integer> answerList = new ArrayList<>();
        for (Object key : mapKey) {
            int usedTime = all.get((int) key);
            if (usedTime <= fees[0]) {
                answerList.add(fees[1]);
            }else{
                usedTime -= fees[0];
                answerList.add(fees[1] + (int)(Math.ceil((double)usedTime / fees[2])) * fees[3]);
            }
        }

        int size = answerList.size();
        int[] answer = new int[size];
        for (int i = 0; i <size; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
```

```java
import java.util.Arrays;

public class L92342 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }

    static int[] lion = new int[12];
    static int[] temp = new int[12];
    public static int[] solution(int n, int[] info) {
        Arrays.fill(lion, -1);
        bt(0, n, info);

        if (lion[0] == -1)
            return new int[]{-1};
        else {
            int[] ret = new int[11];
            for (int i = 0; i < 11; i++) {
                ret[i] = lion[i];
            }
            return ret;
        }
    }

    static void bt(int idx, int left, int[] info) {
        if (idx == 10) {
            temp[idx] = left;
            int score = 0;
            for (int i = 0; i < 11; i++) {
                if (temp[i] > info[i])
                    score += (10 - i);
                else if (info[i] != 0)
                    score -= (10 - i);
            }
            if (score <= 0)
                return;
            temp[11] = score;
            if (compare(temp, lion)) {
                for (int i = 0; i < 12; i++)
                    lion[i] = temp[i];
            }

            return;
        }

        for (int i = 0; i <= left; i++) {
            temp[idx] = i;
            bt(idx + 1, left - i, info);
        }
    }

    private static boolean compare(int[] temp, int[] lion) {
        for (int i = 11; i >= 0; i--) {
            if (lion[i] != temp[i])
                return temp[i] > lion[i];
        }
        return false;
    }

}
```

```java
import java.io.*;
import java.util.*;

public class L72411 {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
    }

    static HashMap<String, Integer> count = new HashMap<>();
    static boolean[] check = new boolean[20];
    public static String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                dfs(0, -1, new char[course[j]], orders[i]);
            }
        }

        List<String> keySet = new ArrayList<>(count.keySet());
        int size = keySet.size();
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return count.get(o2) - count.get(o1);
                return o1.length() - o2.length();
            }
        });

        List<String> list = new ArrayList<>();
        List<Integer> changeIdx = new ArrayList<>();
        changeIdx.add(0);
        int pre = keySet.get(0).length();
        for (int i = 1; i < size; i++) {
            int now = keySet.get(i).length();
            if (pre != now) {
                changeIdx.add(i);
                pre = now;
            }
        }

        for (int i = 0; i < changeIdx.size(); i++) {
            int cnt = count.get(keySet.get(changeIdx.get(i)));
            if (cnt == 1)
                continue;
            for (int j = changeIdx.get(i); j < size; j++) {
                String key = keySet.get(j);
                if (cnt == count.get(key))
                    list.add(key);
                else
                    break;
            }
        }
        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static void dfs(int idx, int at, char[] data, String order) {
        if (idx == data.length) {
            char[] clone = data.clone();
            Arrays.sort(clone);
            String key = new String(clone);
            count.put(key, count.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = at + 1; i < order.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                data[idx] = order.charAt(i);
                dfs(idx + 1, i, data, order);
                check[i] = false;
            }
        }
    }
}
```

```java
import java.io.*;
import java.util.*;

public class L72412 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210",
                        "python frontend senior chicken 150", "cpp backend senior pizza 260",
                        "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
                        "- and - and - and chicken 100", "- and - and - and - 150"})));
    }

    static HashMap<String, Integer> index = new HashMap<>();
    static List<List<Integer>> scores = new ArrayList<>();
    static int cnt = 0;
    static boolean[] check = new boolean[4];
    public static int[] solution(String[] info, String[] query) {
        int length = query.length;
        int[] answer = new int[length];

        for (String s : info) {
            String[] split = s.split(" ");
            String key = "" + split[0].charAt(0) + split[1].charAt(0) + split[2].charAt(0) + split[3].charAt(0);
            int score = Integer.parseInt(split[4]);
            if (!index.containsKey(key)) {
                index.put(key, cnt++);
                scores.add(new ArrayList<>());
            }
            scores.get(index.get(key)).add(score);

            for (int i = 1; i <= 4; i++) {
                dfs(0, new int[i], -1, new StringBuilder(key), score);
            }
        }

        for (int i = 0; i < scores.size(); i++) {
            Collections.sort(scores.get(i));
        }

        for (int i = 0; i < length; i++) {
            String q = query[i];
            String[] split = q.split(" and ");
            String[] last = split[3].split(" ");
            int score = Integer.parseInt(last[1]);
            String key = "" + split[0].charAt(0) + split[1].charAt(0) + split[2].charAt(0) + last[0].charAt(0);

            if(!index.containsKey(key))
                answer[i] = 0;
            else{
                List<Integer> list = scores.get(index.get(key));
                int size = list.size();
                if (score > list.get(size - 1)) {
                    answer[i] = 0;
                    continue;
                }

                int start = 0;
                int end = size - 1;
                int idx = 0;
                //이진 탐색
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (list.get(mid) >= score) {
                        idx = mid;
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                answer[i] = size - idx;
            }
        }

        return answer;
    }

    static void dfs(int idx, int[] data, int at, StringBuilder sb, int score){
        if (idx == data.length) {
            StringBuilder clone = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                clone.append(sb.charAt(i));
            }
            for (int i = 0; i < data.length; i++) {
                clone.setCharAt(data[i], '-');
            }
            String key = clone.toString();
            if (!index.containsKey(key)) {
                index.put(key, cnt++);
                scores.add(new ArrayList<>());
            }
            scores.get(index.get(key)).add(score);
            return;
        }

        for (int i = at+1; i < 4; i++) {
            if (!check[i]){
                check[i] = true;
                data[idx] = i;
                dfs(idx+1, data, i, sb, score);
                check[i] = false;
            }
        }
    }

}
```

```java
import java.io.*;
import java.util.Arrays;

public class L70129 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution("110010101001")));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            int curSize = s.length();
            int nextSize = s.replace("0", "").length();
            answer[1] += curSize - nextSize;
            answer[0]++;
            StringBuilder sb = new StringBuilder();
            while (nextSize != 0) {
                sb.append(nextSize % 2);
                nextSize = nextSize / 2;
            }
            s = sb.reverse().toString();
        }

        return answer;
    }
}
```

```java
import java.io.*;
import java.util.Stack;

public class L60058 {
    public static void main(String[] args) throws IOException {
//        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
    }

    public static String solution(String p) {
        return rec(p);
    }

    static String rec(String w) {
        if (w.equals(""))
            return "";

        String u = divideString(w);
        String v = w.substring(u.length());
        if (rightString(u))
            return u + rec(v);

        String substring = u.substring(1, u.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '(')
                sb.append(')');
            else
                sb.append('(');
        }
        return "(" + rec(v) + ')' + sb.toString();
    }

    private static boolean rightString(String u) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty() || st.pop() != '(')
                    return false;
            }
        }
        if (!st.isEmpty())
            return false;

        return true;
    }

    private static String divideString(String w) {
        int cnt1 = 0;
        int cnt2 = 0;
        int i;
        for (i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(')
                cnt1++;
            else
                cnt2++;
            if (cnt1 == cnt2)
                break;
        }
        return w.substring(0, i+1);
    }
}
```

```java
import java.io.*;

public class L60057 {
    public static void main(String[] args) throws IOException {
//        System.out.println(solution("aabbaccc"));
//        System.out.println(solution("ababcdcdababcdcd"));
//        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("a"));
    }

    public static int solution(String s) {
        int length = s.length();
        int answer = 1001;
        for (int i = 1; i <= (length+1) / 2; i++) {
            String pre = s.substring(0, i);
            StringBuilder cur = new StringBuilder();
            StringBuilder res = new StringBuilder();
            int cutSize = i;
            int cnt = 1;
            for (int j = i; j < length; j++) {
                cur.append(s.charAt(j));
                cutSize--;
                if (cutSize == 0) {
                    if (pre.equals(cur.toString())) {
                        cnt++;
                    }else{
                        if (cnt != 1)
                            res.append(cnt);
                        res.append(pre);
                        cnt = 1;
                        pre = cur.toString();
                    }
                    cutSize = i;
                    cur = new StringBuilder();
                }
            }
            if (cnt != 1)
                res.append(cnt);
            res.append(pre);
            if (cur.length() != 0)
                res.append(cur);
            answer = Math.min(answer, res.length());
        }
        return answer;
    }
}
```

```java
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class L12981 {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
//        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage",
//                "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    public static int[] solution(int n, String[] words) {
        HashMap<String, Integer> check = new HashMap<>();
        int id = 1;
        int turn = 1;
        char cur = words[0].charAt(words[0].length() - 1);
        check.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            if (cur != words[i].charAt(0) || check.containsKey(words[i])) {
                break;
            }

            cur = words[i].charAt(words[i].length() - 1);
            check.put(words[i], 1);
            id++;
            if (id == n) {
                id = 0;
                turn++;
            }

            if (i == words.length - 1) {
                return new int[]{0, 0};
            }
        }
        return new int[]{id+1, turn};
    }
}
```

```java
import java.io.*;
import java.util.Stack;

public class L12973 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length() == 0)
            return 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.push(c);
                continue;
            }

            if (st.peek() == c)
                st.pop();
            else
                st.push(c);
        }
        if (!st.isEmpty())
            return 0;
        else
            return 1;
    }
}
```

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[][]{{2, 5}}));
    }

    public static int solution(int[][] queries) {
        int[][] arr = new int[1001][2];
        int answer = 0;

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int cnt = queries[i][1];

            if (arr[idx][0] + cnt > arr[idx][1]) {
                arr[idx][1] = findSize(arr[idx][0] + cnt);
                if (arr[idx][0] != 0) {
                    answer += arr[idx][0];
                }
            }
            arr[idx][0] += cnt;
        }

        return answer;
    }

    private static int findSize(int i1) {
        int n = 1;
        while (n < i1) {
            n *= 2;
        }
        return n;
    }
}
```

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"slang", "badcode"},
                "badcode s.n. bad.code .code s..ng ... .."));
//        System.out.println(solution(3, new String[]{"abcde", "cdefg", "efgij"},
//                ".. ab. cdefgh .gi. .z."));
    }

    public static String solution(int k, String[] dic, String chat) {
        HashMap<String, Integer> check = new HashMap<>();
        for (String key : dic) {
            check.put(key, key.length());
        }

        StringBuilder answer = new StringBuilder();
        String[] chats = chat.split(" ");
        for (int i = 0; i < chats.length; i++) {
            String word = chats[i];
            int chatLength = word.length();
            List<Integer> dotPos = hasDot((word));
            int cnt = dotPos.size();
            if (cnt != 0) {
                boolean flag = true;
                for (int j = 0; j < dic.length; j++) {
                    int dicLength = check.get(dic[j]);
                    if (chatLength <= dicLength && dicLength <= k * cnt + chatLength - cnt) {
                        int cur = 0;
                        int pl = 0;
                        for (int l = 0; l < cnt; l++) {
                            int next = dotPos.get(l);
                            //전
                            flag = false;
                            for (int m = cur; m < next; m++) {
                                if (word.charAt(m) != dic[j].charAt(m+pl)) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag)
                                break;

                            int temp = 1;
                            for (int m = 2; m <= k; m++) {
                                if (cur + m + (chatLength - (next + 1)) <= dicLength)
                                    temp = m;
                            }
                            pl += (temp - 1);
                            cur = next+1;
                        }
                        for (int l = chatLength - 1; l > cur; l--) {
                            if (word.charAt(l) != dic[j].charAt(l)) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag)
                            break;
                    }
                }
                if (!flag) {
                    for (int l = 0; l < chatLength; l++) {
                        answer.append("#");
                    }
                }else
                    answer.append(word);
            }else{
                if (check.containsKey(word)) {
                    for (int j = 0; j < chatLength; j++) {
                        answer.append("#");
                    }
                }else
                    answer.append(word);
            }
            if (i != chats.length -1)
                answer.append(" ");
        }

        return answer.toString();
    }

    private static List<Integer> hasDot(String chat) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < chat.length(); i++) {
            if (chat.charAt(i) == '.')
                pos.add(i);
        }
        return pos;
    }
}
```

```java
public class L12985 {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b)
    {
        int answer = 1;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (!isPossible(a, b)) {
            a = getNextNumber(a);
            b = getNextNumber(b);
            answer++;
        }

        return answer;
    }

    private static boolean isPossible(int a, int b) {
        return b - a == 1 && !isEven(a) && isEven(b);
    }

    private static int getNextNumber(int num) {
        return (num - 1) / 2 + 1;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

}
```

```java
public class L12914 {

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static long solution(int n) {
        long dp[] = new long[n+1];

        if (n <= 2)
            return n;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;

        return dp[n];
    }

}

//중복 순열 + 백트레킹으로 풀면 시간초과
// public class L12914 {

//     public static void main(String[] args) {
//         System.out.println(solution(3));
//     }

//     static long answer = 0;

//     public static long solution(int n) {
//         bt(new int[n], 0, 0, n);

//         return answer;
//     }

//     static void bt(int arr[], int idx, int sum, int end) {
//         if (sum == end) {
//             answer = (answer+1) % 1234567;
//             return;
//         }

//         for (int i = 1; i <= 2; i++){
//             if (sum + i <= end) {
//                 arr[idx] = i;
//                 bt(arr, idx + 1, sum + i, end);
//             }
//         }
//     }
// }
```

```java
//순열 Review

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        dfs(new int[M], 0);
    }

    static void dfs(int arr[], int idx) {
        if (idx == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                dfs(arr, idx + 1);
                visited[i] = false;
            }
        }
    }
}
```

```java
//조합 review

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(new int[M], 0, 0);
    }

    static void dfs(int arr[], int idx, int at) {
        if (idx == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = at+1; i <= N; i++) {
            arr[idx] = i;
            dfs(arr, idx + 1, i);
        }
    }
}
```

```java
//중복 순열 review

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(new int[M], 0);
        System.out.println(sb);
    }

    static void dfs(int arr[], int idx) {
        if (idx == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[idx] = i;
            dfs(arr, idx + 1);
        }
    }
}
```

```java
//중복 조합 review

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(new int[M], 0, 1);
        System.out.println(sb);
    }

    static void dfs(int arr[], int idx, int at) {
        if (idx == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[idx] = i;
            dfs(arr, idx + 1, i);
        }
    }
}
```

```java
import java.io.*;
import java.util.*;

public class SW2072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t;

        t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 1)
                    sum += num;
            }

            bw.write("#" + i + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.*;

public class SW2071 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t;

        t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                sum += Integer.parseInt(st.nextToken());
            bw.write("#" + i + " " + Math.round((double)sum/10) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW1545 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = n; i >= 0; i--) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW2019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int answer = 1;
        for (int i = 0; i <= n; i++) {
            bw.write(answer + " ");
            answer *= 2;
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW1936 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A != 1) {
            if (A > B)
                bw.write("A");
            else
                bw.write("B");
        }else{
            if (B == 2)
                bw.write("B");
            else
                bw.write("A");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW1933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW1938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(a + b + "\n");
        bw.write(a - b + "\n");
        bw.write(a * b + "\n");
        bw.write(a / b + "\n");

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW2025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println((input * (input+1)) / 2);
    }
}
```

```java
import java.io.*;

public class SW2027 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j)
                    bw.write("#");
                else
                    bw.write("+");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW2029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int a, b;

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write("#" + i + " " + (a / b) + " " + (a % b) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW2043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(P - K + 1);
    }
}
```

```java
import java.io.*;

public class SW2046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 3; i++) {
            bw.write("#");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.Locale;

public class SW2047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(br.readLine().toUpperCase(Locale.ROOT));

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            bw.write((input.charAt(i) - 'A' + 1) + " ");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String input = br.readLine();
            String month = input.substring(4, 6);

            bw.write("#" + i + " ");
            if (isValidMonth(Integer.parseInt(month))) {
                String day = input.substring(6,8);
                if (isValidDay(Integer.parseInt(month), Integer.parseInt(day))) {
                    bw.write(input.substring(0, 4) + "/" + month + "/" + day +"\n");
                }else
                    bw.write("-1\n");
            }else
                bw.write("-1\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isValidMonth(int month) {
        return 1 <= month && month <= 12;
    }

    private static boolean isValidDay(int month, int day) {
        if (month == 2)
            return 1 <= day && day <= 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 1 <= day && day <= 30;
        else
            return 1 <= day && day <= 31;
    }
}
```

```java
import java.io.*;

public class SW2058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += input.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
```

```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW2063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.print(arr[n/2]);
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int max = -1;
            for (int j = 0; j < 10; j++) {
                int next = Integer.parseInt(st.nextToken());
                if (max < next)
                    max = next;
            }
            bw.write("#" + i + " " + max + "\n");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW2070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write("#" + i + " ");
            if (a < b)
                bw.write("<");
            else if (a == b)
                bw.write("=");
            else
                bw.write(">");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] arr = new int[101];
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr[Integer.parseInt(st.nextToken())] += 1;

            int cnt = arr[0];
            int idx = 0;
            for (int j = 1; j < 100; j++) {
                if (cnt <= arr[j]) {
                    cnt = arr[j];
                    idx = j;
                }
            }

            bw.write("#" + i + " " + idx + "\n");

            for (int j = 0; j < 100; j++) {
                arr[j] = 0;
            }
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int x = 0, y = 0, num = 2, dir = 0;
            arr[0][0] = 1;
            while (num <= n * n) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || n <= nx || ny < 0 || n <= ny || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    continue;
                }
                arr[nx][ny] = num++;
                x = nx;
                y = ny;
            }

            bw.write("#" + i + "\n");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    bw.write(arr[j][k] + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
```

```java
import java.io.*;

public class SW1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != '0' && (c - '0') % 3 == 0)
                    cnt++;
            }

            if (cnt == 0) {
                bw.write(""+i);
            } else {
                for (int j = 0; j < cnt; j++) {
                    bw.write("-");
                }
            }
            bw.write(" ");
        }

        bw.flush();
        bw.close();
    }

}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] sell = new int[n];
            for (int j = 0; j < n; j++) {
                sell[j] = Integer.parseInt(st.nextToken());
            }

            int j = n - 1;
            int k;
            int cnt = 0;
            long sum = 0;
            long buy = 0;
            int price = 0;
            while (j >= 0) {
                price = sell[j];
                for (k = j-1; k >= 0; k--) {
                    if (sell[k] <= price) {
                        cnt++;
                        buy += sell[k];
                    } else {
                        if (cnt != 0)
                            sum += (long) cnt * price - buy;
                        cnt = 0;
                        buy = 0;
                        break;
                    }
                }
                j = k;
            }
            if(cnt > 0)
                sum += (long) cnt * price - buy;

            bw.write("#" + i +" " + sum + "\n");
        }

        bw.flush();
        bw.close();
    }

}
```


```java
import java.io.*;

public class SW2007 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String input = br.readLine();
            int answer = 0;

            for (int length = 1; length <= 15; length++) {
                boolean flag = false;
                String pattern = input.substring(0, length);
                int k = length;

                while (k + length <= 30) {
                    String next = input.substring(k, k + length);
                    if (!pattern.equals(next)) {
                        flag = true;
                        break;
                    }
                    k += length;
                }
                if (!flag) {
                    answer = length;
                    break;
                }
            }

            bw.write("#" + i + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;

public class SW2005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                arr[j][0] = 1;
                arr[j][j] = 1;
            }
            
            for (int j = 2; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
                }
            }

            bw.write("#" + i + "\n");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] != 0)
                        bw.write(arr[j][k] + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW2001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n, m;
        int[][] arr = new int[15][15];
        
       for (int i = 1; i <= t; i++) {
           st = new StringTokenizer(br.readLine());
           n = Integer.parseInt(st.nextToken());
           m = Integer.parseInt(st.nextToken());

           for (int j = 0; j < n; j++) {
               st = new StringTokenizer(br.readLine());
               for (int k = 0; k < n; k++) {
                   arr[j][k] = Integer.parseInt(st.nextToken());
               }
           }

           int max = -1;
           for (int j = 0; j < n - m + 1; j++) {
               for (int k = 0; k < n - m + 1; k++) {
                   int sum = 0;
                   for (int l = j; l < j + m; l++) {
                       for (int o = k; o < k + m; o++) {
                           sum += arr[l][o];
                       }
                   }
                   max = Math.max(max, sum);
               }
           }
           
           bw.write("#" + i + " " +max + "\n");

           for (int j = 0; j < n; j++) {
               for (int k = 0; k < n; k++) {
                   arr[j][k] = 0;
               }
           }
        }

        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class SW1961 {

    static int n;
    static String[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            res = new String[n][3];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rotate1 = rotate(arr);
            write(rotate1, 0);

            int[][] rotate2 = rotate(rotate1);
            write(rotate2, 1);

            int[][] rotate3 = rotate(rotate2);
            write(rotate3, 2);

            bw.write("#" + i + "\n");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    bw.write(res[j][k] + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void write(int[][] rotate, int x) {
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                sb.append(rotate[j][k]);
            }
            res[j][x] = sb.toString();
        }
    }

    static int[][] rotate(int[][] arr) {
        int length = arr.length;
        int[][] copy = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                copy[j][length - i - 1] = arr[i][j];
            }
        }
        return copy;
    }
}
```

```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1984 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int sum = 0;
            for (int j = 1; j < 9; j++) {
                sum += arr[j];
            }

            bw.write("#" + i + " " + (int)Math.round((double)sum / 8) + "\n");
        }

        bw.flush();
        bw.close();
    }

}
```