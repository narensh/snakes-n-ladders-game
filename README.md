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
Turn # 1  | Dice Outcome: 1 | Player A moved from position 0 to 1
Turn # 2  | Dice Outcome: 1 | Player A moved from position 1 to 2
Turn # 3  | Dice Outcome: 6 | Player A moved from position 2 to 8
Turn # 4  | Dice Outcome: 4 | Player A moved from position 8 to 12
Turn # 5  | Dice Outcome: 4 | Player A moved from position 12 to 16
Turn # 6  | Dice Outcome: 3 | Player A moved from position 16 to 19
Turn # 7  | Dice Outcome: 3 | Player A moved from position 19 to 22
Turn # 8  | Dice Outcome: 3 | Player A moved from position 22 to 25
Turn # 9  | Dice Outcome: 5 | Player A moved from position 25 to 30
Turn # 10 | Dice Outcome: 6 | Player A moved from position 30 to 36
Turn # 11 | Dice Outcome: 1 | Player A moved from position 36 to 37
Turn # 12 | Dice Outcome: 5 | Player A moved from position 37 to 42
Turn # 13 | Dice Outcome: 6 | Player A moved from position 42 to 48
Turn # 14 | Dice Outcome: 2 | Player A moved from position 48 to 50
Turn # 15 | Dice Outcome: 6 | Player A moved from position 50 to 56
Turn # 16 | Dice Outcome: 2 | Player A moved from position 56 to 58
Turn # 17 | Dice Outcome: 3 | Player A moved from position 58 to 61
Turn # 18 | Dice Outcome: 1 | Player A moved from position 61 to 62
Turn # 19 | Dice Outcome: 5 | Player A moved from position 62 to 67
Turn # 20 | Dice Outcome: 2 | Player A moved from position 67 to 69
Turn # 21 | Dice Outcome: 4 | Player A moved from position 69 to 73
Turn # 22 | Dice Outcome: 3 | Player A moved from position 73 to 76
Turn # 23 | Dice Outcome: 3 | Player A moved from position 76 to 79
Turn # 24 | Dice Outcome: 5 | Player A moved from position 79 to 84
Turn # 25 | Dice Outcome: 6 | Player A moved from position 84 to 90
Turn # 26 | Dice Outcome: 4 | Player A moved from position 90 to 94
Turn # 27 | Dice Outcome: 2 | Player A moved from position 94 to 96
Turn # 28 | Dice Outcome: 3 | Player A moved from position 96 to 99
Turn # 29 | Dice Outcome: 5 | Player A didn't move, still at position 99
Turn # 30 | Dice Outcome: 1 | Player A moved from position 99 to 100
Player A has Won
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

Game
- has Board
- has Player
```