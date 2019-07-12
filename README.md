# TCP_Tic-Tac-Toe
## Try to commit in a new branch when uploading, we'll merge everyones work back to master when its done
A Tic-Tac-Toe board game through TCP/IP socket
#### To keep track of the [CURRENT STATUS(TODO)](https://github.com/comp3670/TCP_Tic-Tac-Toe/projects/1)
#### Here is a Tic-Tac-Toe [SAMPLE PROGRAM](https://cs.lmu.edu/~ray/notes/javanetexamples/)
Multiplayer game:
1. Server wait and listen to a connection request from a client
2. Once there's a connection request, set up the connection between server and client(player 1)
3. Repeat step 2 to set up another socket for player 2
4. Initiate a game board
5. When client finishes their steps, send the game info to server
6. Server wait the client to finish. One client will wait if it is other player's turn
7. Server receives the data from the client and update the game board
8. Server check if any player wins. Otherwise go back to step 6
