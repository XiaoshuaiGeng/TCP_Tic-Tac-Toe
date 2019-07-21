# An early_version Tic-Tac-Toe game using TCP
## The server have the source file to run the game
## The client only need to receive the game board information and send the move info
## To run Server program:
  `java Server`
  
## To run Client program: 
  ### In another terminal:
   `java Client localhost`
  ### On another device from a different network:
   `java Client [server's IP address]`
- **block.java** a block represents a playable cell and maintains a state attribute that is either EMPTY, occupied by X, or occupied by O) . By default it is EMPTY, would require setState, getState, and a toString where EMPTY is just a blank space.

- **board.java** a board has or contains 9 blocks in a 2D array (3x3) that shapes the game space of tic-tac-toe. It also maintains an internal state which can be one of the following: EMPTY (the initial state of the board), X (X claims a win), Y (Y claims a win), or DRAW (where neither X nor Y can claim a win and no further moves are possible). The board has the key methods makeMove( ) that is called by a player making a move and getState() or updateState() that updates the state of the board after every move. It checks for a win or a draw when they occur. Note that the board instantiates and maintains all the blocks.

- **game.java** contains a game board and two players, clientPlayer and playerAI. It manages the iteration with the players. First by getting the player names, does a coin toss to decide the turn and allows each player to take a turn and make a move. It finally announces the winner/draw when the game ends.

- **player.java** is an abstract class that maintains a design that every player has a symbol (X or O), a name, and an abstract play(board gameboard) method. It also maintains a reference to the game board for players to examine and make their move.

- **HumanPlayer.java** extends player, a type of player that requests its input from the user and submit the move (or play) to the gameboard.

- **AIPlayer.java** extends player, a type of player that implements a simple AI player.**It has its own preference move: it will pick the diagonal cells first rather other cells.**

- global.java this is a class that only has some global attributes. 
