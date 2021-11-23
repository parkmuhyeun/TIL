# Wireless LANs
#데이터 통신/Wireless LANs

---
### IEEE 802.11: Infrastructure Mode
Access point(AP) connects mobiles into wired network
- AP is L2 device

![](./img/WL_1.PNG)

### IEEE 802.11: Ad-hoc Mode
- No APs
- Nodes can only transmit to other nodes within link coverage
- Nodes organize themselves into a network
- Example: Wi-Fi direct

![](./img/WL_2.PNG)

### IEEE 802.11: Channels, Association
- Spectrum divided into channels at different frequencies
    - AP admin chooses frequency for AP
    - Interference possible
- Arriving host: must associate with an AP
    - Scans channels, listening for beacon frames containing AP's name(SSID) and MAC address(BSSID)
    - Selects AP to associate with

### IEEE 802.11: Channel Scanning
- Procedure for the mobile node to find APs that exists nearby
    - Passive scanning vs active scanning

### IEEE 802.11: Passive/Active Scanning

![](./img/WL_3.PNG)

Passive scanning:
1) beacon frames sent from APs
2) association Request frame sent: H1 to selected AP
3) associaion Response frame sent from selected AP to H1

![](./img/WL_4.PNG)

Active scanning
1) Probe Request frame broadcast from H1
2) Probe Respone frames sent from APs
3) association Request frame sent: H1 to selected AP
4) associaion Response frame sent from selected AP to H1

## Wireless Link Characteristics
Important differences from wired link...
- Decreased signal strength
- Interference from other sources
- Multipath propagationL: radio signal reflects off objects ground, arriving at destination at slightly different times

Multiple wireless senders, receivers create additional problems

![](./img/WL_5.PNG)