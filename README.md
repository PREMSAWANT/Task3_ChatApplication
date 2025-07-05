# Task 3: Multithreaded Chat Application - Study Group Chat

JAVA-PROGRAMMING-TASK
COMPANY: CODTECH IT SOLUTIONS PVT. LTD
NAME: PREM ANANDRAO SAWANT
INTERN ID: CT04DH1720
DOMAIN: JAVA PROGRAMMING
DURATION: 4 WEEKS (5th July 2025 to 5th August 2025)
MENTOR: NEELA SANTHOSH

📌 Task 3: Java Chat Application – Client-Server Real-Time Messaging
📝 Description of the Task:
This task required the development of a console-based chat application in Java using Socket Programming. The project simulates a basic messaging platform with multiple clients connected to a central server, enabling real-time group chat functionality over a local network.

The system consists of two major components:

ChatServer.java – The server that handles client connections and message broadcasting.

ChatClient.java – The client interface that users run to join the chat.

This application closely models how real-world chat systems function at the network layer and demonstrates important communication protocols in action.

💡 What I Learned:
From this task, I learned a lot about:

Socket programming in Java using Socket and ServerSocket classes

Input/Output Streams for reading and writing data across sockets

Multithreading for handling multiple client sessions concurrently

Client-server architecture, connection handling, and message broadcasting

Building interactive command-line communication interfaces

This task enhanced my understanding of how scalable backend communication systems are built using basic Java features without relying on external frameworks.

🛠 Technologies Used:
Java Sockets (java.net)

Input/Output Streams (BufferedReader, PrintWriter, InputStreamReader)

Multithreading (Runnable interface and Thread class)

Localhost Networking (TCP-based)

🔍 Features Implemented:
Server Setup: A chat server that runs on a specified port (e.g., 12345) and listens for client connections.

Multiple Client Handling: Uses threads to support multiple users chatting simultaneously.

Broadcast Messaging: Any message sent by a client is instantly shared with all others in the chat room.

User Identification: Each user enters their name at the start, and it prefixes their messages.

Live Message Exchange: Supports dynamic, real-time chatting across clients.

Graceful Exit Support: When a user closes the client window, it disconnects without crashing the server.

🧠 Code Explanation:
ChatServer.java starts a ServerSocket on port 12345 and waits for clients to connect. Each client connection is handed off to a new ClientHandler thread, which listens for incoming messages and sends them to all other connected clients using a shared list of output streams.

ChatClient.java connects to the server, asks the user for their name, and starts two threads:

One to continuously listen for incoming messages.

Another to read input from the user and send it to the server.

All data transmission is text-based, and the communication is achieved using standard TCP socket streams.

The screenshot shows the smooth flow of a chat conversation where users like "Prem" and "Ankita" are exchanging real-time messages successfully.

⚠️ Challenges Faced:
Handling multiple clients simultaneously was a new concept for me. Implementing multithreading was essential to allow concurrent conversations without blocking the server.

Another challenge was making sure message broadcasting didn’t result in duplicate outputs or missing messages. I had to carefully manage the list of client writers to ensure synchronized communication.

Gracefully handling disconnected clients without affecting the rest of the system was also a tricky edge case, especially when a client exited abruptly.

🚀 How to Run the Code:
Step 1: Start the Server

Open terminal or CMD and navigate to the folder containing ChatServer.java.

Compile and run the server:

javac ChatServer.java

java ChatServer

Step 2: Start Clients

In separate terminals or windows, navigate to the folder with ChatClient.java.

Compile and run each client:

javac ChatClient.java

java ChatClient

Enter your name when prompted, and start chatting.

You can open multiple client instances to simulate multiple users chatting in a shared group environment.

📦 Sample Output:

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/754d821e-7bae-4dff-a3e5-06145a922adc" />


🌱 Future Improvements:
Implement private messaging using recipient selection

Add GUI using JavaFX or Swing

Enable timestamps and message history

Add login authentication for users

Improve scalability for larger group chats

✅ Conclusion:
This task offered an eye-opening experience in building real-time communication systems using basic Java. I learned the core principles behind chat applications, including socket communication, client-server logic, and multithreading. It provided an excellent foundation for more advanced projects like multiplayer games, collaborative tools, or scalable messaging services.

I now feel confident in setting up and managing socket-based applications and truly appreciate how underlying network communication works in professional software systems.

