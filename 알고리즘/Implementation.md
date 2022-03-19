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