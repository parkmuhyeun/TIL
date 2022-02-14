# Sorting
#알고리즘/Sorting

---
정렬이란 데이터를 특정한 기준에 따라서 순서대로 나열하는 것

## 선택 정렬(Selection Sort)
데이터가 무작위로 여러 개 있을 때, 이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두번째 데이터와 바꾸는 과정을 반복 (시간 복잡도 - O(N^2))

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i] # Swap

print(array) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## 삽입 정렬(Insertion Sort)
'데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 삽입', 특히 삽입 정렬은 필요할 때만 위치를 바꾸므로 '데이터가 거의 정렬 되어 있을 때' 훨신 효율적이다. (시간 복잡도 - O(N^2), 최선의 경우(거의 정렬 되어있을 때) - O(N))

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):   # 인덱스 i부터 1까지 감소하며 반복
        if array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
        else:
            break

print(array) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## 퀵 정렬(Quick Sort)
'기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 변경', 리스트에서 첫 번째 데이터를 기준(pivot)으로 정한 후 왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터 피벗보다 작은 데이터를 찾는다. 그 다음 큰 데이터와 작은 데이터의 위치를 서로 교환한다. 값이 서로 엇갈린 경우에는 '작은 데이터를 찾던 데이터 부분'과 '피벗'의 위치를 서로 변경한다. 이러한 과정을 반복하면 피벗에 대하여 정렬이 수행된다. (평균 시간 복잡도 - O(NlogN), 최악의 경우(이미 데이터가 정렬되어 있는 경우) - O(N^2))

```python
# 일반적인 퀵 정렬

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end: # 원소가 1개인 경우 종료
        return
    pivot = start # 피벗은 첫 번째 원소
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을 때까지 반복
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if right < left: # 엇갈렷다면 작은 데이터와 피벗을 교체
            array[pivot], array[right] = array[right], array[pivot]
        else: # 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            array[left], array[right] = array[right], array[left]
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)


quick_sort(array, 0, len(array)-1)
print(array) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

```python
# 파이썬의 장점을 살린 퀵 정렬

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array
    
    pivot = array[0] # 피벗은 첫 번째 원소
    tail = array[1:] # 피벗을 제외한 리스트
    
    left_side = [x for x in tail if x <= pivot] # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot] # 분할된 오른쪽 부분
    
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트를 반환
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array)) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```