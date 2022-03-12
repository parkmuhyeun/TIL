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