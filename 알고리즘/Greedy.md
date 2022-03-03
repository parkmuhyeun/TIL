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