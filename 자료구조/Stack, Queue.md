# Stack, Queue
#자료구조/Stack, Queue

---
## Stack
- 삽입과 삭제가 "top"이라 불리는 한쪽 끝 지점에서 발생하는 순서화 리스트
- Last-In-First-Out (LIFO)

![](./img/SQ_1.png)

```C
Stack CreateS(max_stack_size) ::=
#define MAX_STACK_SIZE 100
typedef struct {
    int key;
}element;
element stack[MAX_STACK_SIZE];
int top = -1;

Boolean IsEmpty(Stack) ::= top < 0;

Boolean IsFull(Stack) ::= top >= MAX_STACK_SIZE -1;

void push(element item)
{   // 스택에 새로운 항목을 추가
    if (top >= MAX_STACK_SIZE - 1) {
        stack_full();
        return;
    }
    stack[++top] = item;
}

element pop()
{   // 스택 top의 항목을 return
    if (top == -1)
        return stack_empty();
    return stack[top--];
}
```

## Queue
- 삽입과 삭제가 다른 쪽에서 발생하는 순서화 리스트
    - 삽입이 발생하는 위치: rear
    - 삭제가 발생하는 위치: front
- First-In-First-Out(FIFO)

![](./img/SQ_2.png)

```C
Queue CreateQ(max_queue_size) ::=
#define MAX_Q_SIZE 100
typedef struct {
    int key;
} element;
element queue[MAX_Q_SIZE];
int rear = -1, front = -1; // 전역 변수

Boolean IsEmptyQ(queue) ::= front == rear;
Boolean IsFullQ(queue) ::= rear == MAX_Q_SIZE - 1;

void addq(element item)
{   // Queue에 새로운 항목을 추가
    if (rear >= MAX_Q_SIZE – 1) {
        queue_full();
        return;
    }
    queue[++rear] = item;
}
element deleteq()
{   // Queue의 항목을 return
    if (front == rear) return queue_empty();
        return queue[++front];
}
```

### 원형 큐(Circular Queue)
배열을 이용하여 큐를 구현할 때 발생하는 문제점
- QueueFull의 조건: rear == max_Q_SZIE-1
- 문제점: 큐에 저장된 원소의 수 < max_Q_SIZE
    - 큐의 모든 항목들을 왼쪽으로 이동
    - 최악의 성능: O(MAX_Q_SIZE)

원형 큐의 개념
- 큐의 처음과 마지막을 연결
- 나머지(%) 연산자 이용