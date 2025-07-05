# Task 3: Multithreaded Chat Application - Study Group Chat

## Description
This Java application is a simple client-server chat system for a study group. The server can handle multiple clients at once using multithreading. Clients can send and receive messages in real time.

## Features
- Real-time group chat
- Multiple clients supported
- Simple command-line interface

## How to Run
1. Open two terminals. In the first, navigate to this folder and start the server:
   ```
   javac ChatServer.java
   java ChatServer
   ```
2. In the second (and more), start clients:
   ```
   javac ChatClient.java
   java ChatClient
   ```
3. Enter your name and start chatting!

## Notes
- All code is commented for clarity.
- Server must be started before clients connect. 