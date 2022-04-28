# UDP Server & Client
#Computer Network/UDP Server & Client

---

## UDP: User Datagram Protocol
- "No frills", "bare bones" Internet transport protocol
- "Best effort" service
    - UDP segments may be:
        - lost
        - delivered out-of-order to app
- Connectionless: No handshaking between UDP sender and receiver
- Usage
    - Streaming multimedia apps
        - loss tolerant, rate sensitive
    - DNS
    - SNMP
- Reliable transfer over UDP:
    - Add reliabilty at application layer
    - application-specific error recovery

## "Connectionless" (Developer's Point ov View)
- A socket can be used for communications with multiple clients
- A single socket is enough even in the case of server
    - TCP-based server should use server (listening socket) and client socket

## sendto()
```c
#include <sys/socket.h>
ssize_t sendto(int sock, void *buff, size_t nbytes, int flags, struct sockaddr *to, socklen_t addrlen);
```
- sock: UDP socket descriptor for data transmission
- buff: Points to a buffer containing the message to be sent
- nbytes: Specifies the size of the message to  be sent in bytes
- flags: Option flag (generally zero)
- to: Points to a sockaddr structure containing the destination address
- addrlen: Specifies the length of the sockaddr structure pointd to by the "to" argument

*Return value: Upon succesful completion -> The number of bytes sent. Otherwise -> -1

## recvfrom()
```c
#include <sys/socket.h>
ssize_t recvfrom(int sock, void *buff, size_t nbytes, int flags, struct sockaddr *from, socklen_t addrlen);
```
- sock: UDP socket descriptor from which data should be received
- buff: Points to the buffer where the message should be stored
- nbytes: Specifies the length in bytes of the buffer pointd to by the "buff" argument
- flags: Option flag(genarally zero)
- from: Points to a sockaddr structure in which the sending address is to be stored
- addrlen: Specifies the length of the sockaddr structure pointed to by the "from" argument
*Return value: Upon successfull completion -> the number of bytes sent. Otherwise -> -1