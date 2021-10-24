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

## 중위 표기법과 후위 표기법
중위 표기법
- 피연산자들 사이에 연산자가 위치
- 괄호를 포함할 수 있고, 계산 과정이 복잡

후위 표기법
- 피연산자들 다음에 연산자가 위치
- 괄호가 필요없고, 한번의 스캔으로 수식 게산 가능

![](./img/SQ_3.png)

### Postfix 수식의 계산
Stack을 이용: 6 2 / 3 - 4 2 * +
- 피연산자는 스택에 저장
- 연산자의 경우, 스택에서 피연산자 pop & 결과를 push

![](./img/SQ_4.png)

```C
#define MAX_STACK_SIZE 100
#define MAX_EXPR_SIZE 100
typedef enum { lparen, rparen, plus, minus, times,
    divide, mod, eos, operand } precedence;
int stack [ MAX_STACK_SIZE ]; // global stack
char expr [ MAX_EXPR_SIZE ]; // input string

int eval (void)
{
    // expr[] 배열에 문자열로 저장된 postfix 수식 계산.
    // expr[]과 stack[], 그리고 top은 전역변수임. 
    // get_token() 함수는 수식의 각 문자의 precedence를 return
    // 수식에서 피연산자는 한 문자로 구성된다고 가정. precedence token;
    char symbol;
    int op1, op2;
    int n = 0; // 수식 문자열의 현재 판독 위치
    top = -1; // stack 초기화
    token = get_token(&symbol, &n);
    while (token != eos) {
        if (token == operand)
            push(symbol – ‘0’); // 피연산자를 만나면 스택에 저장
        else { // stack에서 피연산자 2개를 제거한 후 이를 이용하여
                //수식을 계산한 후 결과를 다시 stack에 저장
        op2 = pop(); // stack delete
        op1 = pop();
        switch ( token ) {
            case plus : push(op1 + op2); break;
            case minus : push(op1 – op2); break;
            case times : push(op1 * op2); break;
            case divide : push(op1 / op2); break;
            case mod : push(op1 % op2);
            }
        }
        token = get_token ( &symbol, &n );
      }
     return pop(); // return result 
}

precedence get_token (char *symbol, int * n)
{ // 수식 문자열에서 다음 문자를 검사하여 해당 token을 반환

    *symbol = expr[(*n)++];
    switch (*symbol)
        case ' ( ' : return lparen;
        case ' ) ' : return rparen;
        case ' + ' : return plus;
        case ' - ' : return minus;
        case ' / ' : return divide;
        case ' * ' : return times;
        case ' % ' : return mod;
        case ' ' : return eos;
        default : return operand; // 오류 검사 없음. 피연산자
    }
}
```

### Infix 수식을 Post 수식으로 변환
Stack을 이용하여 변환
- 연산자들의 우선순위를 이용하여 변환
- 우선순위(top) < 우선순위(incoming): 입력 연산자를 스택에 저장
- 우선순위(top) > 우선순위(incoming): 스택 top에 있는 연산자를 출력
- 우선순위(top) = 우선순위(incoming): 결합성에 따라 처리
- 괄호가 있는 수식 처리에 주의

![](./img/SQ_5.png)

```c
void postfix ( void )
{ // 수식 변환 프로그램. (infix -> postfix)
// expr[](infix 저장)과 stack[], 그리고 top은 전역변수

    char symbol;
    precedence token;
    int n = 0;
    top = -1;

    push(eos);  // place eos on stack
    for (token = get_token(&symbol, &n); token != eos; 
               token = get_token(&symbol, &n)) {
         if (token == operand) printf(“%c”, symbol);
         else if (token == rparen) { 
       // 왼쪽 괄호가 나올 때까지 stack pop
            while (stack[top] != lparen)
                print_token(pop());
            pop(); // 왼쪽 괄호 제거
        }
        else { // 우선순위가 높은 연산자 pop. associativity?
            while (isp[stack[top]] >= icp[token])
                 print_token(pop());
            push(token);
        }
    }
    while ( (token = pop() ) != eos)
       print_token(token); // stack의 모든 연산자 출력
    printf(“\n”);
```