# Trees
#자료구조/Trees

---
## Introduction
트리란?
- 계층적 구조의 자료를 표현할 때 사용

![](./img/T_1.PNG)

- 하나 이상의 노드로 이루어진 유한집합
- Root라고 하는 노드가 존재

![](./img/T_2.PNG)

- 노드의 차수(degree): A - 3
- 단말 노드(leaf or terminal node) : K, L, F, G, M, I, J)
- Parent: E - B, Children: B - E & F, Siblings: E & F
- Ancestor: (M: H, D, A), Descendants: (B: E, F, K, L)
- Height or Depth: 4

## 트리의표현
Left Child - Right Sibling 표현
- 노드 A의 제일 왼쪽 노드 -> A의 왼쪽 자식 노드
- A의 나머지 자식 노드들 -> 자식 노드의 오른쪽 자식
- 트리의 모든 노드마다 2개의 링크 필드만 포함

![](./img/T_3.PNG)


## 이진 트리
- 모든 노드의 차수는 2를 넘지 않는다
- 왼쪽 서브트리와 오른쪽 서브트리가 구분

이진 트리의 정의
- 유한 개의 노드들의 집합으로서
    - 노드 수는 0이 될수 있으며,
    - 하나의 root 노드와 왼쪽 서브트리, 그리고 오른쪽 서브트리로 구성
    - 각 서브트리는 다시 이진 트리

### 편향 트리와 완전 이진 트리

![](./img/T_4.PNG)

### 이진 트리의 성질
최대 노드 수
- 이진 트리의 레벨i에서 최대 노드 수는 2^i-1
- 깊이가 k인 이진 트리가 가질수 있는 최대 노드 수는 2^k-1

단말 노드 수와 차수가 2인 노드 수
- 단말 노드 수 = 차수가 2인 노드의 수 + 1

깊이가 k인 포화 이진 트리
- 깊이가 k이고 노드 수가 2^k-1 인 이진 트리

n개의 노드를 가진 완전 이진 트리가 순차적으로 표현되어 있다면
- parent = i/2
- Lchild = 2i
- Rchild = 2i + 1

## 이진 트리 순회(Binary Trree Traversal)
이진 트리의 모든 노드를 한번씩 방문

![](./img/T_5.PNG)

세가지 순회 방법
- 중위 순회(inorder traversal)
    - L -> V -> R
- 전위 순회(preorder traversal)
    - V -> L -> R
- 후위 순회(postorder traversal)
    - L -> R -> V

### 이진 트리의 복사
후위 순회 알고리즘 응용

```c
tree_pointer copy(struct node *original)
{ // original 트리를 복사한 새로운 이진 트리를 반환
    struct node *temp;
    if (original) {
    temp = (struct node *) malloc(sizeof(struct node));
    temp->left_child = copy(original->left_child); 
    temp->right_child = copy(original->right_child);
    temp->data = original->data;
    return temp;
    }
    return NULL;
}
```

### 이진 트리의 동일성 검사
전위 순회 알고리즘을 응용

```c
int equal(struct node *first, struct node *second)
{
    /* first와 second 트리가 다를 경우 FALSE를 반환. 트리가 동일할 경우, TRUE를 반환 */
    return ((!first && !second) || (first && second &&
    (first->data == second->data) &&
    equal(first->left_child, second->left_child) &&
    equal(first->right_child, second->right_child)));
}
```

### 이진 트리의 노드 수 계산

```c
int get_node_count(struct node *ptr)
{
int count = 0
    if (ptr != NULL)
        count = 1 + get_node_count(ptrleft_child) +
            get_node_count(ptrright_child);
    return count;
}
```

### 단말 노드 수 계산

```c
int get_leaf_count(struct node *ptr)
{
    int count = 0;
    if (ptr != NULL) {
        if (ptr->left_child == NULL && 
            ptr->right_child == NULL) // 단말 노드
                return 1;
        else count = get_leaf_count(ptrleft_child) + 
                        get_leaf_count(ptrright_child);
    }
    return count;
}
```