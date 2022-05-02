# Transport Layer Basic
#Computer Network/Transport Layer Basic

## Transport Services And Protocols
- Provide logical communication between app processes running on different hosts
- Transport protocols run in end systems
    - send side: breaks app messages into segments, passes to network layer
    - rcv side: reassembles segments into messages, passes to app layer
- More than one transport protocol available to apps
    - Internet: TCP and UDP

## Internet Transport-layer Protocols
- Reliable, in-order delivery (TCP)
    - Congestion control
    - Flow control
    - Connection setup
- Unreliable, unordered delivery: UDP
- Services not available:
    - delay guarantees
    - bandwidth guarantees

## Transport vs. Network layer
Network layer
- Logical communication between hosts

Transport layer
- Logical communication between processes

## Addressing Processes
- To receive messages, process must have identifier
- Host device has unique 32-bit IP address
- Identifier includes both IP address and port numbers associated with process on host

## Multiplexing and Demultiplexing

![](./img/tlb_1.png)

## How Demultiplexing Works
- Host receives IP datagrams
    - Each datagram has source IP address, destination IP address
    - Each datagram carries one transport-layer segent
    - Each segment has source, destination port number
- Host uses IP address & port numbers to direct segment to appropriate socket

    ![](./img/tlb_2.png)

## Connectionless Demultiplexing
- When host receives UDP segment:
    - checks destination port # in segment
    - directs UDP segment to socket with that port #
    - IP datagrams with same dest.port #, but different source IP addresses and/or source port numbers will be directed to same socket at destination

## Connectionless Demux: Example

![](./img/tlb_3.png)

## Connection-oriented demux
- TCP socket is identified by 4-tuple:
    - Source IP address
    - Source port number
    - Dest IP address
    - Dest port number
- Demux: receiver uses all four values to direct segment to appropriate socket
- Server host may support many simultaneous TCP sockets:
    - each socket identified by its own 4-tuple
- Web servers have diffrent sockets for each connecting client

## UDP: Segment header

![](./img/tlb_4.png)

## UDP checksum
Goal: detect "erros" in transmitted segment

Sender:
- treat segement contents as sequence of 16-bit integers
- checksum: addition (1's complement sum) of segment contents
- sender puts checksum value into UDP checksum field

Receiver:
- compute checksum of received segment
- check if computed checksum equals checksum field value:
    - NO - error detected
    - YES - no error detected. But maybe errors nontheless?

## Internet Checksum Example
16 비트 두개를 더한 후 최상단 비트 한개를 결과값에 더한값을 1의 보수를 취하게 되면 checksum이 나옴

![](./img/tlb_5.png)