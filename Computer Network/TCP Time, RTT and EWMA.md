# TCP Time, RTT, and EWMA
#Computer Network/TCP Time, RTT, and EWMA

---

## TCP Timeout and RTT
- How to set TCP timeout value?
    - Too short: premature timeout, unnecessary retransmissions
    - Too long: slow reaction to segment loss
- Timeout value should be longer than RTT (But, RTT varies)
- We Should estimate RTT, anyway
    - Sample RTT: measured time from segment transmission until ACK receipt
        - Sample RTT will vary
    - We will make the estimated RTT "smoother"
        - Average several recent measurements, not just current Sample RTT
- Exponential weighted moving average (EWMA)
    - Influence of past sample decreases exponentially fast
        - EstimatedRTT = (1- a) * EstimatedRTT + a * SampleRTT (Typical value: a = 0.125)
- Time out interval: EstimatedRTT plus "safety margin"
    - Large variation in EstimatedRTT: we want a larger safety margin
        - TimeoutInterval = EstimatedRTT + 4 * DevRTT
        - DevRTT = (1-B)*DevRTT + B*|SampleRTT - EstimatedRTT|

## TCP Flow Control: Why?
받을 수 없는데 계속 넘겨 줘봤자 의미가 없음, 받을 수 있는 만큼만!

## TCP Flow Control: Basic Idea
- TCP Receiver side

![](./img/tre_1.png)

- Basic idea
    - Let receiver tell sender how much available room
        ![](./img/tre_2.png)
- TCP receiver "advertises" free buffer space in rwnd field in TCP header
- Sender limits amount of unACKed ("in-flight") data to received rwnd
- Guarantees receive buffer will not overflow

![](./img/tre_3.png)