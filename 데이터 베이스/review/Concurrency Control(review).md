# Concurrency Control(review)
#etc/Concurrency Control(review)

---
## Concurrency Control의 목적
- Concurrency Control의 목적
- Concurrency Control이 없을 경우 문제점
    - Lost Update
    - Dirty Read
    - Unrepeatable Read
    - Phantom Read

### SQL의 Transaction Isolation Level
- READ UNCOMMITTED
    - Phantom read/Unrepeatable read/Dirty read 허용
- READ COMMITTED
    - Phantom read/Unrepeatable read만 허용
- REPEATABLE READ
    - Phantom read만 허용
- SERIALIZABLE
    - 모두 허용 안됨

## Concurrency Control의 종류
- Concurrency Control의 법칙
- Concurrency Control의 종류
    - Locking
    - Timestamp Ordering
    - Optimistic Concurrency Control

### Locking
- Lock이란?
- Lock Modes
    - Shared(S) Lock
    - Exclusive(X) Lock
- Locking Rule
    - Lock을 획득하는 시점
    - Lock을 해제하는 시점
- Two Phase Locking
    - Two Phase Locking Protocol

## Multiple Granularity Locking
- Fine granularity
- Coarse granularity
- Explicit Locking
- Implicit Locking

### Intention Mode
- Intention Shared (IS) Mode
- Intention Exclusive (IX) Mode
- Shared and Intention Exclusive (SIX) Mode
- Locking Protocol of MGL

## Deadlock 해결 방법
- Deadlock Prevention
    - Wait-Die
    - Wound-Wait
- Deadlock Detection and Resolution

## Other Concurrency Controls
- Timestamp Ordering
- Optimistic Concurrency Control