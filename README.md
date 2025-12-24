# Distributed Chat System (Java)

This project is a **peer-to-peer chat application** developed in Java, demonstrating my understanding of **Network Communications** and **Distributed Systems**.

## Key Technical Features
* **UDP Protocol**: Uses `DatagramSocket` and `DatagramPacket` for efficient, connectionless message transmission.
* **Concurrency**: Designed to handle simultaneous message sending and receiving through a continuous listening loop.
* **GUI Implementation**: Built with **Java Swing**, featuring custom windows, scrollable text areas, and event listeners for real-time interaction.
* **Software Architecture**: Implements a modular design where the chat logic (`P11T05ChatA/B`) is separated from the interface definition (`P11T05Ventana`).

## How it Works
The system allows two users on different IP addresses to communicate by sending byte-encoded strings over specific ports (2000 and 3000). It includes a custom `KeyListener` that triggers message transmission upon pressing the **Enter** key.
