#Snakes & Ladders Game

##Instructions:
> Build
```
gradle clean
```
```
gradle build
```

> Run
```
gradle run 
```

```
[#1] allows a player to throw dice and move on the board of size 100

Sample Input:
PlayerName: 'Player A' | Board Size: 100 | MaxTurns: 30
  
Sample Output:
Dice Outcome: 3 | Player A moved from position 0 to 3
Dice Outcome: 2 | Player A moved from position 3 to 5
Dice Outcome: 1 | Player A moved from position 5 to 6
Dice Outcome: 1 | Player A moved from position 6 to 7
Dice Outcome: 3 | Player A moved from position 7 to 10
Dice Outcome: 6 | Player A moved from position 10 to 16
Dice Outcome: 6 | Player A moved from position 16 to 22
Dice Outcome: 3 | Player A moved from position 22 to 25
Dice Outcome: 6 | Player A moved from position 25 to 31
Dice Outcome: 6 | Player A moved from position 31 to 37
Dice Outcome: 6 | Player A moved from position 37 to 43
Dice Outcome: 4 | Player A moved from position 43 to 47
Dice Outcome: 3 | Player A moved from position 47 to 50
Dice Outcome: 2 | Player A moved from position 50 to 52
Dice Outcome: 5 | Player A moved from position 52 to 57
Dice Outcome: 1 | Player A moved from position 57 to 58
Dice Outcome: 5 | Player A moved from position 58 to 63
Dice Outcome: 6 | Player A moved from position 63 to 69
Dice Outcome: 5 | Player A moved from position 69 to 74
Dice Outcome: 3 | Player A moved from position 74 to 77
Dice Outcome: 2 | Player A moved from position 77 to 79
Dice Outcome: 1 | Player A moved from position 79 to 80
Dice Outcome: 2 | Player A moved from position 80 to 82
Dice Outcome: 2 | Player A moved from position 82 to 84
Dice Outcome: 6 | Player A moved from position 84 to 90
Dice Outcome: 4 | Player A moved from position 90 to 94
Dice Outcome: 6 | Player A moved from position 94 to 100
Player A has Won
```

```
[#2] adds snake on the board which moves the player from snake's startPosition to endPosition

Sample Input:
PlayerName: 'Player A' | Board Size: 100 | MaxTurns: 30 | Snake Position {start: 20, end: 10}
  
Sample Output:

Dice Outcome: 3 | Player A moved from position 0 to 3
Dice Outcome: 2 | Player A moved from position 3 to 5
Dice Outcome: 5 | Player A moved from position 5 to 10
Dice Outcome: 2 | Player A moved from position 10 to 12
Dice Outcome: 1 | Player A moved from position 12 to 13
Dice Outcome: 4 | Player A moved from position 13 to 17
Ouch!! Snake Bite at position 20, moving to position 10
Dice Outcome: 3 | Player A moved from position 17 to 10
Dice Outcome: 3 | Player A moved from position 10 to 13
Dice Outcome: 6 | Player A moved from position 13 to 19
Dice Outcome: 4 | Player A moved from position 19 to 23
Dice Outcome: 6 | Player A moved from position 23 to 29
Dice Outcome: 2 | Player A moved from position 29 to 31
Dice Outcome: 1 | Player A moved from position 31 to 32
Dice Outcome: 5 | Player A moved from position 32 to 37
Dice Outcome: 3 | Player A moved from position 37 to 40
Dice Outcome: 1 | Player A moved from position 40 to 41
Dice Outcome: 3 | Player A moved from position 41 to 44
Dice Outcome: 1 | Player A moved from position 44 to 45
Dice Outcome: 6 | Player A moved from position 45 to 51
Dice Outcome: 1 | Player A moved from position 51 to 52
Dice Outcome: 3 | Player A moved from position 52 to 55
Dice Outcome: 2 | Player A moved from position 55 to 57
Dice Outcome: 3 | Player A moved from position 57 to 60
Dice Outcome: 4 | Player A moved from position 60 to 64
Dice Outcome: 4 | Player A moved from position 64 to 68
Dice Outcome: 5 | Player A moved from position 68 to 73
Dice Outcome: 3 | Player A moved from position 73 to 76
Dice Outcome: 4 | Player A moved from position 76 to 80
Dice Outcome: 1 | Player A moved from position 80 to 81
Dice Outcome: 3 | Player A moved from position 81 to 84
```

##Design
``` 
Dice
- can roll

Player
- has name
- can throw dice

Board
- has size
- has player
- has player position
- has snake

Game
- has Board
- has Player

Snake
- has start position
- has end position
- can bite
```