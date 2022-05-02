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