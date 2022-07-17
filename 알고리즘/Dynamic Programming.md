# Dynamic Programming
#알고리즘/Dynamic Programming

---
컴퓨터는 연산 속도에 한계가 있고, 메모리 공간을 사용할 수 있는 데이터의 개수도 한정적이다. 그래서 우리는 연산속도와 메모리 공간을 최대한 활용할 수 있는 효율적인 알고리즘을 작성해야 한다. 메모리 공간을 약간 더 사용하면 연산속도를 비약적으로 증가시킬 수 있는데 대표적으로 다이나믹 프로그래밍 기법이 있다.

```python
# 피보나치 함수 재귀 함수로 구현
def fibo(x):
    if x ==1 or x == 2:
        return 1
    return fibo(x - 1) + fibo(x - 2)
```

위처럼 피보나치 수열의 점화식을 재귀 함수로 만들 수는 있지만 효율적이지 않다.
이러한 문제는 다이나믹 프로그래밍을 사용하면 효율적으로 해결할 수 있다. 하지만 항상 사용할 수 는 없으며, 다음 조건을 만족할 때 사용 가능.

1. 큰 문제를 작은 문제로 나눌 수 있다.
2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서 동일하다.

이 문제를 메모리제이션 기법을 사용해서 해결해보자. 메모리제이션은 다이나믹 프로그래밍을 구현하는 방법 중 한 종류로, 한 번 구한 결과를 메모리 공간에 메모해두고 같은식을 다시 호출하면 메모한 결과를 그대로 가져오는 기법.

```python
# 한 번 계산된 결과를 메모리제이션 하기위한 리스트 초기화
d = [0] * 100

# 피보니치 함수

# 피보나치 함수를 재귀함수로 구현(탑다운 다이나믹 프로그래밍)
def fibo(x):
    # 종료 조건(1 혹은 2 일때 1 반환)
    if x == 1 or x == 2:
        return 1
    # 이미 계산한 적 있는 문제라면 그대로 반환
    if d[x] != 0:
        return d[x]
    # 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
    d[x] = fibo(x - 1) + fibo(x - 2)
    return d[x]
```

이렇게 큰 문제를 해결하기 위해 작은 문제를 호출한다고 하여 탑다운방식이라고 말한다. 반면에 단순히 반복문을 이용하여 소스코드를 작성하는 경우 작은 문제부터 차근차근 답을 도출한다고 하여 바텀업방식이라고 한다.

```python
d = [0] * 100

# 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
d[1] = 1
d[2] = 1
n = 99

#피보나치 함수 반복문으로 구현(바텀업 다이나믹 프로그래밍)
for i in range(3, n + 1):
    d[i] = d[i - 1] + d[i - 2] 

print(d[n])
```

## 관련 문제

```python
x = int(input())
 
d = [30001] * (x+1)
d[x] = 0

while x != 1:
  if x % 5 == 0:
    if d[x//5] > d[x] + 1:
      d[x//5] = d[x] + 1
  if x % 3 == 0:
    if d[x//3] > d[x] + 1:
      d[x//3] = d[x] + 1
  if x % 2 == 0:
    if d[x//2] > d[x] + 1:
      d[x//2] = d[x] + 1
  if d[x-1] > d[x] + 1:
    d[x-1] = d[x] + 1
  x -= 1

print(d[1])


# ------------------

x = int(input())
 
d = [0] * (x+1)

for i in range(2, x+1):
  d[i] = d[i-1] + 1
  if i % 5 == 0:
    d[i] = min(d[i], d[i//5] + 1)
  if i % 3 == 0:
    d[i] = min(d[i], d[i//3] + 1)
  if i % 2 == 0:
    d[i] = min(d[i], d[i//2] + 1)

print(d[x])
```

```python
x = int(input())
 
arr = list(map(int, input().split()))
d = [0] * x
d[0] = arr[0]
d[1] = max(arr[0], arr[1])

for i in range(2, x):
  d[i] = max(d[i-1], d[i-2] + arr[i])

print(d[x-1])
```

```python
x = int(input())
 
d = [0] * (x+1)
d[1] = 1
d[2] = 3

for i in range(3, x+1):
  d[i] = (d[i-1] + 2 * d[i-2]) % 796796

print(d[x]) 
```

```python
n, m  = map(int, input().split())
coin = []

for i in range(n):
  coin.append(int(input()))

d = [-1] * (m+1)

d[0] = 1
for i in range(m+1):
  for j in range(n):
    if d[i] != -1:
      if i+coin[j] > m:
        continue
      if d[i+coin[j]] == -1:
        d[i+coin[j]] = d[i] + 1
      else:
        d[i+coin[j]] = min(d[i+coin[j]], d[i] + 1)

if d[m] == -1:
  print(d[m])
else:
  print(d[m]-1)
```

```python
import sys
input = sys.stdin.readline

t = int(input())

res = []
for _ in range(t):
  n, m = map(int, input().split())
  arr = list(map(int, input().split()))
  board = [[0] * (m+1) for _ in range(n+1)]
  cnt = 0
  for i in range(1, n+1):
    for j in range(1, m+1):
      board[i][j] = arr[cnt]
      cnt += 1
      
  # 2차원 테이블 초기화 다른방법
  # board = []
  # index = 0
  # for i in range(n):
  #   board.append(arr[index:index+m])
  #   index += m

  d = [[0] * (m+1) for _ in range(n+1)]
  for i in range(1, n+1):
    d[i][1] = board[i][1]
    
  for i in range(2, m+1):
    for j in range(1, n+1):
      if 1 <= j-1 <= n and 1 <= i-1 <= m:
        d[j][i] = max(d[j][i], d[j-1][i-1] + board[j][i])
      if 1 <= i-1 <= m:
        d[j][i] = max(d[j][i], d[j][i-1] + board[j][i])
      if 1 <= j+1 <= n and 1 <= i-1 <= m:
        d[j][i] = max(d[j][i], d[j+1][i-1] + board[j][i])

  mval = 0
  for i in range(1, n+1):
    mval = max(mval, d[i][m])
  res.append(mval)
for i in range(t):
  print(res[i])
```

```python
n = int(input())
d = []
for _ in range(n):
  d.append(list(map(int, input().split())))

for i in range(1, n):
  for j in range(i+1):
    if 0 <= i-1 and 0 <= j-1:
      up_left = d[i-1][j-1]
    else:
      up_left = 0
    if 0 <= i-1 and j <= i-1:
      up_right = d[i-1][j]
    else:
      up_right = 0
    d[i][j] = d[i][j] + max(up_left, up_right)

res = 0
for i in range(n):
  res = max(res, d[n-1][i])
print(res)
```

```python
n = int(input())
bs = []
for _ in range(n):
  t, p = map(int, input().split())
  bs.append((t, p))

mval = 0
d = [0] * (n+1)
for i in range(n-1, -1, -1):
  time = i + bs[i][0]
  if time <= n:
    d[i] = max(bs[i][1] + d[time], mval)
    mval = d[i]
  else:
      d[i] = mval

print(mval)
```

```python
n = int(input())
arr = list(map(int, input().split()))

dp = [1] * n

for i in range(1, n):
  for j in range(i):
    if arr[j] > arr[i]:
      dp[i] = max(dp[i], dp[j]+1)
      
print(n-max(dp))
```

```python
n = int(input())

d = [0] * n
n2 = n3 = n5 = 0
d[0] = 1
next2, next3, next5 = 2, 3, 5

for i in range(1, n):
  d[i] = min(next2, next3, next5)
  if d[i] == next2:
    n2 += 1
    next2 = d[n2] * 2
  if d[i] == next3:
    n3 += 1
    next3 = d[n3] * 3
  if d[i] == next5:
    n5 += 1
    next5 = d[n5] * 5
print(d[n-1])
```

```python
a = input()
b = input()

la = len(a)
lb = len(b)
d = [[0] * (lb+1) for _ in range(la+1)]

for i in range(lb + 1):
  d[0][i] = i
for i in range(la + 1):
  d[i][0] = i

for i in range(1, la+1):
  for j in range(1, lb+1):
    if a[i-1] == b[j-1]:
      d[i][j] = d[i-1][j-1]
    else:
      d[i][j] = 1 + min(d[i][j-1], d[i-1][j-1], d[i-1][j-1])

print(d[la][lb])
```

```python
t = int(input())
res = []
for _ in range(t):
  n = int(input())
  d = [[0] * 2 for _ in range(n+1)]
  if n == 0:
    res.append((1, 0))
  elif n == 1:
    res.append((0, 1))
  else:
    d[0][0] = 1
    d[0][1] = 0
    d[1][0] = 0
    d[1][1] = 1
    for i in range(2, n+1):
      d[i][0] = d[i-1][0] + d[i-2][0]
      d[i][1] = d[i-1][1] + d[i-2][1]
    res.append((d[n][0], d[n][1]))
for i in range(len(res)):
  print(res[i][0], res[i][1])
```

```python
n = int(input())
arr = []
for _ in range(n):
  s = int(input())
  arr.append(s)
d = [0] * n

if n == 1:
  print(arr[0])
elif n == 2:
  print(arr[0] + arr[1])
else:
  d[0] = arr[0]
  d[1] = arr[0] + arr[1]
  for i in range(2, n):
    d[i] = arr[i] + max(arr[i-1] + d[i-3], d[i-2])
  print(d[n-1])
```

```python
t = int(input())
res = []
for _ in range(t):
  n = int(input())

  if n == 1 or n == 2  or n == 3:
    res.append(1)
  elif n == 4 or n == 5:
    res.append(2)
  else:
    d = [0] * n
    d[0] = d[1] = d[2] = 1
    d[3] = d[4] = 2
    for i in range(5, n):
      d[i] = d[i-5] + d[i-1]
    res.append(d[n-1])
for i in range(len(res)):
  print(res[i])
```

```python
t = int(input())
res = []
for _ in range(t):
  n, m = map(int, input().split())
  dp = [[0] * (m+1) for _ in range(n+1)]
  for i in range(1, m+1):
    dp[1][i] = i
  for i in range(2, n+1):
    for j in range(i, m+1):
      for k in range(j-1, i-2, -1):
        dp[i][j] += dp[i-1][k]
  res.append(dp[n][m])
for i in range(len(res)):
  print(res[i])
```

```python
n = int(input())
d = [0] * (n+1)

if n == 1:
  print("1")
elif n == 2:
  print("2")
else:
  d[1] = 1
  d[2] = 2
  for i in range(3, n+1):
    d[i] = (d[i-1] + d[i-2]) % 15746
  print(d[n])
```

```python
n, k = map(int, input().split())
arr = [(0, 0)]
for i in range(n):
  w, v = map(int, input().split())
  arr.append((w, v))
d = [[0] * (k+1) for _ in range(n+1)]

for i in range(1, n+1):
  for j in range(1, k+1):
    if arr[i][0] > j:
      d[i][j] = d[i-1][j]
    else:
      d[i][j] = max(d[i-1][j], d[i-1][j-arr[i][0]] + arr[i][1])

print(d[n][k])
```

```python
n, k = map(int, input().split())
coins = [0]
for _ in range(n):
  coin = int(input())
  coins.append(coin)

# 2차원(메모리초과)
# d = [[0] * (k+1) for _ in range(n+1)]
# for i in range(1, n+1):
#   for j in range(1, k+1):
#     if coins[i] > j:
#       d[i][j] = d[i-1][j]
#     else:
#       d[i][j] = d[i-1][j] + d[i][j-coins[i]]
#       if j == coins[i]:
#         d[i][j] += 1
# print(d[n][k])

# 1차원으로 변경
d = [0] * (k+1)
for i in range(1, n+1):
  for j in range(1, k+1):
    if coins[i] <= j:
      d[j] += d[j-coins[i]]
      if j == coins[i]:
        d[j] += 1
print(d[k])
```

```python
n = int(input())
line = [(0,0)]
for _ in range(n):
  left, right = map(int, input().split())
  line.append((left, right))
line.sort()
d = [1] * (n+1)

for i in range(2, n+1):
  for j in range(1, i):
    if line[j][1] < line[i][1]:
      d[i] = max(d[i], d[j]+1)
print(n - max(d))
```

```python
n, m = map(int ,input().split())
d = [[0] * (m+1) for _ in range(n+1)]
for i in range(1, n+1):
  row = list(map(int, input().split()))
  for j in range(1, m+1):
    d[i][j] = row[j-1]

for i in range(1, n+1):
  for j in range(1, m+1):
    d[i][j] = d[i][j] + max(d[i-1][j], d[i-1][j-1], d[i][j-1])

print(d[n][m])
```

```python
import math
n, k = map(int ,input().split())
print(math.factorial(n) // (math.factorial(k) * math.factorial(n - k)) % 10007)
```

```python
n = int(input())
box = list(map(int, input().split()))

d = [1] * n

for i in range(1, n):
  for j in range(i):
    if box[i] > box[j]:
      d[i] = max(d[i], d[j] + 1)
print(max(d))
```

```python
#review

#DP(Dynamic Programming)
# 재귀를 이용한 탑다운 방식
d = [0] * 10

def fibo(x):
  if x == 1 or x == 2:
    return 1
  if d[x] != 0:
    return d[x]
  d[x] = fibo(x-1) + fibo(x-2)
  return d[x]

# print(fibo(4))  # -> 3  ( 1 1 2 3)

# 반복문 이용한 바텀업 방식

d = [0] * 10

d[1] = 1
d[2] = 1
n = 4

for i in range(3, n+1):
  d[i] = d[i-1] + d[i-2]

print(d[n])
```

```python
t = int(input())

for _ in range(t):
  n, m = map(int, input().split())
  golds = [[0] * m for _ in range(n)]
  row = list(map(int, input().split()))
  for i in range(n):
    for j in range(m):
      golds[i][j] = row[(i * m) + j]

  for i in range(1, m):
    for j in range(0, n):
      left_up = 0
      left = 0
      left_down = 0
      if 0 <= j-1 < n:
        left_up = golds[j-1][i-1]
      if 0 <= j < n:
        left = golds[j][i-1]
      if 0 <= j+1 < n:
        left_down = golds[j+1][i-1]
      golds[j][i] += max(left_up, left, left_down)

  res = 0
  for i in range(0, n):
    res = max(res, golds[i][m-1])
  print(res)
```

```python
n = int(input())
nums = []
for _ in range(n):
  nums.append(list(map(int, input().split())))

for i in range(1, n):
  for j in range(0, i+1):
    left = 0
    right = 0
    if 0 <= j-1 < i:
      left = nums[i-1][j-1]
    if 0 <= j < i:
      right = nums[i-1][j]
    nums[i][j] += max(left, right)

res = 0
for i in range(0, n):
  res = max(res, nums[n-1][i])
print(res)
```

```python
n = int(input())
day = []
for _ in range(n):
  t, p = map(int, input().split())
  day.append((t, p))

d = [0] * (n+1)
max_money = 0

for i in range(n-1, -1, -1):
  if i+day[i][0] <= n:
    d[i] = max(d[i+day[i][0]] +day[i][1], max_money)
    max_money = d[i]
  else:
    d[i] = max_money

print(max_money)

# n = int(input())
# day = []
# for _ in range(n):
#   t, p = map(int, input().split())
#   day.append((t, p))

# d = [0] * n

# for i in range(n-1, -1, -1):
#   if i+day[i][0]-1 < n:
#     d[i] += day[i][1]
#   max_money = 0
#   for j in range(i+day[i][0], n):
#     max_money = max(max_money, d[j])
#   d[i] += max_money

# print(max(d))
```

```python
n = int(input())
power = list(map(int, input().split()))
d = [1] * n

for i in range(1, n):
  for j in range(0, i):
    if power[i] < power[j]:
      d[i] = max(d[j] + 1, d[i])
print(n-max(d))
```

```python
n = int(input())

ugly = [0]
i2 = 1
i3 = 1
i5 = 1

for i in range(1, n):
  min_val = min(2 * i2, 3 * i3, 5 * i5)
  ugly.append(min_val)
  if min_val == 2 * i2:
    i2 += 1
  if min_val == 3 * i3:
    i3 += 1
  if min_val == 5 * i5:
    i5 += 1
print(ugly[n-1])

# n = int(input())

# ugly = [0] * n
# ugly[0] = 1
# i2 = 0
# i3 = 0
# i5 = 0 

# next2 = 2
# next3 = 3
# next5 = 5

# for i in range(1, n):
#   ugly[i] = min(next2, next3, next5)
#   if ugly[i] == next2:
#     i2 += 1
#     next2 = ugly[i2] * 2
#   if ugly[i] == next3:
#     i3 += 1
#     next3 = ugly[i3] * 3
#   if ugly[i] == next5:
#     i5 += 1
#     next5 = ugly[i5] * 5
# print(ugly[n-1])
```

```python
#편집거리 알고리즘
# 1) n번째 m번째 문자 같을때 - d[i][j] = d[i-1][j-1]
# 2) n번째 m번째 문자 다를때 - d[i][j] = min(d[i][j-1], d[i-1][j-1], d[i-1][j]) + 1
# 2-1) 삽입(왼쪽) - d[i][j] = d[i][j-1] + 1
# 2-2) 교체(왼쪽위) - d[i][j] = d[i-1][j-1] + 1
# 2-3) 삭제(위) - d[i][j] = d[i-1][j] + 1

a = input()
b = input()

alen = len(a)
blen = len(b)
d = [[0] * (blen+1) for _ in range(alen+1)]
for i in range(blen+1):
  d[0][i] = i
for i in range(alen+1):
  d[i][0] = i

for i in range(1, alen+1):
  for j in range(1, blen+1):
    if a[i-1] == b[j-1]:
      d[i][j] = d[i-1][j-1]
    else:
      d[i][j] = min(d[i][j-1], d[i-1][j-1], d[i-1][j]) + 1
print(d[alen][blen])
```