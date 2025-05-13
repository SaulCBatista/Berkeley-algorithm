# 🕒 Clock Synchronization - Berkeley Algorithm

This project simulates the Berkeley algorithm for clock synchronization in a distributed environment. The simulation uses Java and TCP socket communication. One process acts as the **coordinator**, responsible for synchronizing the clocks of the other **clients**, considering initial time offsets of up to ±10 seconds.

Implemented features:
- Communication via **TCP Sockets**
- Clock simulation with up to ±10 seconds offset
- Average time calculation and distributed adjustment
- Display of times **before and after synchronization** in `HH:mm:ss` format

## 🔧 Technologies Used

- ☕ **Java 17+**
- 📡 **TCP Sockets**
- 🧵 **Multithreading**
- ⏱️ Time handling with `System.currentTimeMillis()` and `SimpleDateFormat`

## 📦 How to Install

1. Clone the repository:
   ```bash
   git clone https://github.com/SaulCBatista/Berkeley-algorithm.git
   cd Berkeley-algorithm

## Sample Output

 - Server
```bash
Coordenador aguardado conexões...
Tempo do coordenador antes da sincronização: 12:00:35
Tempo recebido do cliente 1: 12:00:24
Tempo recebido do cliente 2: 12:00:31
Tempo recebido do cliente 3: 12:00:25
Tempo recebido do cliente 4: 12:00:39
Tempo médio calculado: 12:00:30
Tempo do cliente 1 após sincronização: 12:00:30
Tempo do cliente 2 após sincronização: 12:00:30
Tempo do cliente 3 após sincronização: 12:00:30
Tempo do cliente 4 após sincronização: 12:00:30
Tempo do coordenador após sincronização: 12:00:30
```
- Clients
```bash
Tempo antes da sincronização: 12:00:24
Tempo após sincronização: 12:00:30
