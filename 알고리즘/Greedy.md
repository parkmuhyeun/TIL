# Greedy
#알고리즘/Greedy

---
현재 상황에서 지금 당장 좋은 것만 고르는 방법

```python
n = 1260
count = 0

coint_types = [500, 100, 50, 10]

for coin in coint_types:
  count += n // coin
  n %= coin

print(count)
```

```python
n, m, k = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
max = arr[n-1]
bmax = arr[n-2]

res = 0
chk = 0
for i in range(m):
  if k==m:
    res = max * m
    break

  if chk != k:
    res += max
    chk +=1
  else:
    res += bmax
    chk = 0
  
print(res)
```

```python
n, m =map(int, input().split())
arr = [[0] * m for _ in range(n)]
marr = []

for i in range(n):
  min = 10001
  inp = list(map(int, input().split()))
  for j in range(m):
    if min > inp[j]:
      min = inp[j]
    arr[i][j] = inp[j]
  marr.append(min)

marr.sort()
print(marr[n-1])
```

```python
n, k =map(int, input().split())
count = 0

while True:
  if n % k ==0:
    n = n // k
  else:
    n -= 1
  count += 1
  if n == 1:
    break

print(count)
```

```python
n = int(input())
mo = list(map(int, input().split()))
mo.sort()

res = 0
group = 0
go = 0

for i in range(n):
  group = mo[i]
  go += 1

  if group == go:
    res += 1
    go = 0

print(res)
```

```python
s = input()
l = len(s)

res = int(s[0])
for i in range(1, l):
  num = int(s[i])
  if num <= 1 or res <= 1:
    res += num
  else:
    res *= num

print(res)
```

```python
s = input()

pre1 = int(s[0])
res1 = 0

pre2 = int(s[0])
res2 = 0
for i in range(1, len(s)):
  if pre1 == 1 and pre1 != int(s[i]):
    res1 += 1
  pre1 = int(s[i])
  
  if pre2 == 0 and pre2 != int(s[i]):
    res2 += 1
  pre2 = int(s[i])

if int(s[len(s)-1]) == 1:
  res1 += 1
else:
  res2 += 1

print(min(res1, res2))
```

```python
n = int(input())
coins = list(map(int, input().split()))
coins.sort()

target = 1

for coin in coins:
  if target < coin:
    break
  target += coin

print(target)
```

```python
n, m = map(int, input().split())

balls = list(map(int, input().split()))

res = 0
for i in range(n):
  for j in range(i+1, n):
    if balls[i] != balls[j]:
      res += 1

print(res)
```

```python
import heapq

def solution(food_times, k):   
    
    if k >= sum(food_times):
        return -1
    
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i+1))
        
    sum_value = 0
    previous = 0
    length = len(food_times)
    
    while sum_value + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous) * length
        length -= 1
        previous = now
        
    result = sorted(q, key = lambda x:x[1])
    return result[(k-sum_value) % length][1]
```

```python
n = int(input())

res = 0

while n >= 0:
  if n % 5 == 0:
    res += (n // 5)
    print(res)
    break
  n -= 3
  res += 1
else:
  print(-1)
```

```python
n = int(input())
line = list(map(int, input().split()))

line.sort()

cur = 0
sum = 0
for x in line:
  cur += x
  sum += cur
print(sum)

---

n = int(input())
line = list(map(int, input().split()))

line.sort()

sum = 0
for i in range(n):
  for j in range(i+1):
    sum += line[j]
print(sum)
```

```python
n, k = map(int, input().split())
coins = []
for _ in range(n):
  coin = int(input())
  coins.append(coin)

coins.sort(reverse = True)

res = 0

for x in coins:
  if k == 0:
    break
  if x > k:
    continue
  cnt = k // x
  res += cnt
  k -= cnt * x

print(res)
```

```python
n = int(input())
room = []
for i in range(n):
	s, e = map(int, input().split())
	room.append((s, e))
room.sort(key=lambda x: (x[1], x[0]))
res = end = 0
for s, e in room:
	if s >= end:
		res += 1
		end = e
print(res)
```

```python
s = input().split("-")
num = []
for i in s:
  sum = 0
  arr = i.split("+")
  for j in arr:
    sum += int(j)
  num.append(sum)
res = num[0]
for i in range(1, len(num)):
  res -= num[i]
print(res)
```

```python
money = 1000 - int(input())
arr = [500, 100, 50, 10, 5, 1]
res = 0
for i in arr:
  if money == 0:
    break
  if money < i:
    continue
  n = money // i
  money -= i * n
  res += n
print(res)
```

```python
n = int(input())
rope = []
for _ in range(n):
  l = int(input())
  rope.append(l)
rope.sort(reverse = True)

res = 0
cnt = 0
for i in rope:
  cnt += 1
  val = i * cnt
  if res < val:
    res = val
print(res)
```

```python
n = list(input())
n.sort(reverse = True)
sum = 0

if '0' not in n:
  print(-1) 
else:  
  for i in n:
    sum += int(i)
  if sum % 3 != 0:
    print(-1)
  else:
    print(''.join(n))
```

```python
n = int(input())
i = 1
res = 0
while True:
  if n - i >= 0:
    n = n - i
    res += 1
  else:
    break
  i += 1
print(res)
```

```python
import sys

t = int(input())
for _ in range(t):
  test = []
  cnt = 1
  n = int(input())
  for _ in range(n):
    s, m = map(int, sys.stdin.readline().split())
    test.append((s, m))
  test.sort()
  max = test[0][1]
  for i in range(1, n):
    if max > test[i][1]:
      cnt += 1
      max = test[i][1]
  print(cnt)
```

```python
n = int(input())
words = []
for _ in range(n):
  word = input()
  words.append(word)

cnt = 9
num_dict = {}

for i in range(n):
  for j in range(len(words[i])):
    if words[i][j] in num_dict:
      num_dict[words[i][j]] += 10 ** (len(words[i]) - j - 1)
    else:
      num_dict[words[i][j]] = 10 ** (len(words[i]) - j - 1)

num_list = list(num_dict.values())
num_list.sort(reverse = True)

sum = 0
cnt = 9
for x in num_list:
  sum += cnt * x
  cnt -= 1
print(sum)
```

```python
import heapq

n = int(input())
card = []

for _ in range(n):
  size = int(input())
  card.append(size)

heapq.heapify(card)

answer = 0

if len(card) == 1:
  print(0)
else:
  while True:
    if len(card) == 1:
      break
    sum = heapq.heappop(card) + heapq.heappop(card)
    answer += sum
    heapq.heappush(card, sum)
  print(answer)
```

```python
a, b = map(int, input().split())
res = 1
flag = False
while b > a:
  if a == b:
    break
  if b % 2 == 0:
    b = b // 2
    res += 1
  else:
    val = str(b)
    if val[len(val)-1] == '1':
      val = val[:-1]
      b = int(val)
      res += 1
    else:
      flag = True
      break

if b < a or flag == True:
  print(-1)
else:
  print(res)
```

```python
def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    visit = [False] * (n+2)
    res = 0
    rlost = []
    for x in lost:
        if x not in reserve:
            rlost.append(x)
    res = n - len(rlost)
    for x in lost:
        if x in rlost:
            if existInReserve(x-1, reserve) and not existInLost(x-1, lost) and not visit[x-1]:
                res += 1
                visit[x-1] = True
            elif existInReserve(x+1, reserve) and not existInLost(x+1, lost) and not visit[x+1]:
                res += 1
                visit[x+1] = True
    return res

def existInReserve(num, reserve):
    if num in reserve:
        return True
    return False

def existInLost(num, lost):
    if num in lost:
        return True
    return False

# 정리
def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    _reserve = [r for r in reserve if r not in lost]
    _lost = [l for l in lost if l not in reserve]
    for l in _reserve:
        f = l - 1
        b = l + 1
        if f in _lost:
            _lost.remove(f)
        elif b in _lost:
            _lost.remove(b)
    return n - len(_lost)
```

```python
def solution(name):
    length = len(name)
    min_move = length-1
    res = 0
    next = 0
    
    while name[min_move] == "A" and min_move >0:
        min_move -= 1
    if min_move < 0:
        return res
        
    for i in range(length):
        res += min(ord(name[i]) - ord("A"), ord("Z") - ord(name[i]) + 1)
        next = i+1
        
        while next < length and name[next] == "A":
            next += 1
        
        min_move = min(min_move, (2 * i) + length - next)
        min_move = min(min_move, 2 * (length - next) + i)
    res += min_move
    return res

# def solution(name):
#     length = len(name)
#     front = 0
#     back = 0
#     s = "A" * length
#     cnt = 0
    
#     for i in range(length):
#         if name[i] != "A":
#             cnt += 1
#     for i in range(1, length):
#         if name[i] != "A":
#             front = i
#             break
#     for i in range(length-1, 0, -1):
#         if name[i] != "A":
#             back = length - i
#             break
            
#     res = 0  
#     if cnt == 0:
#         return 0
#     elif length == 1:
#         res += change(0, name, s)
#         return res
#     else:
#         res += change(0, name, s)
#         if front < back:
#             for i in range(1, length):
#                 res += change(i, name, s)
#                 cnt -= 1
#                 if cnt == 0:
#                     break
#                 res += 1
#         else:
#             for i in range(length-1, 0, -1):
#                 res += change(i, name, s)
#                 cnt -= 1
#                 if cnt == 0:
#                     break
#                 res += 1
        
#     return res

# def change(i, name, s):
#     val = 0
#     if name[i] != s[i]:
#         if ord(name[i]) <= ord("N"):
#             val =  ord(name[i]) - ord("A")
#         else:
#             val =  abs(ord(name[i]) - (ord("Z") + 1))
#     return val
```