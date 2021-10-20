# Digital Transmission
#데이터통신/Digital Transmission

---

## Line Coding
- Digital data -> Digital Signal
- 전압차를 이용해 0, 1 구분

![](./img/DT1_1.png)

## Data Element vs Signal Element

![](./img/DT1_2.png)

### Considerations
- DC Components
    - Zero frequency of the signal이 나올수 있으면 Dc component가 있을 수 있다(안좋음)
- Synchronization
    - To correctly interpret the signals, the receiver's bit intervals must correspond
- Bandwidth
    - 적은 Bandwidth가 더 좋음

## Unipolar

![](./img/DT1_3.png)

- Unipolar scheme has DC component
- It has no synchronization capacity

## Polar - NRZ(Non-Return to Zero)

![](./img/DT1_4.png)

- NRZ-L: positive voltage for one symbol and negative for the other
- NRZ-I: 1이 오면 신호 전이 발생
- DC Component 있고 synchronization 할수 없음

## Polar - RZ(Return to Zero)

![](./img/DT1_5.png)

- 중간에 전이를 함
- requires a wider band width
- No DC componenct
- Synchronization 가능
- More complex as it use three voltage levels

## Polar - Manchester and Differential Manchester(biPhase)
- Mancheser encoding
    - Combining NRZ-L and RZ schemes
    - 중간에서 전이(similar to RZ)
    - use two voltage level(similar to NRZ-L)

- Diffrential Manchester encoding
    - Combining the NRZ-I and RZ schemes

![](./img/DT1_6.png)

- No DC Component
- Synchronization 가능
- 주로 짧은거리에 씀

## Bipolar - AMI and Pseudoternary

![](./img/DT1_7.png)

- AMI - 1일 때 전이(+,-) 0일 때는 0
- Pseudoternary - 0일 때 전이(+,-) 1일때는 0
- No DC Component 
- Synchronization 불가능 그래서 혼자 안쓰고 다른 거랑 같이 씀
- 긴거리에 씀

## Block Coding
4B/5B encoding: resolve synchronization issue of NRZ-I

![](./img/DT1_8.png)

## Scrambling
- AMI Synchronization 해결
- 0이 8개일 때 0001101101이 아니고 000VB0VB로 바꿔줌
- V는 Violation으로 원래하던 AMI 반대로
- B는 Bipolar로 원해라던 AMI 방식대로

![](./img/DT1_9.png)

---

# Analog data to digital data conversion

## Pulse Code Modulation (PCM)
PCM consists of three steps to digitize an analog signal:
- Sampling
- Quantization
- Binary encoding

![](./img/DT1_10.png)

### PCM: Sampling
- Analog signal is ampled every Ts secs
- Ts is referred to as the sampling interval

Nyquist theorem
- The sampling rate must be at least 2 time the highest frequency contained in the signal

![](./img/DT1_11.png)

### Quantization
Infinite amplitude values -> a finite set of known values

![](./img/DT1_12.png)

More quantization level?
- Pros: 더 정밀한 표현 가능
- Cons: 더 많은 비트가 필요함(encode할 양 많아진다)

Required bitrate = Sampling rate * #of bits per sample