# SM_Coursework_02
## For maintenance

* **Bugs refactor**
    1. Removed the bug generates from long-term keyboard press, frogger will no longer jump into the boundaries between blocks;

    2. Removed the bug exists in the score display process, refresh entire ```playerScoreBoard``` after player's score has changed;

* **Appliance of MVC**
    1. Rewrite the ```World``` class into ```GameController``` class. Then develop different game levels classes extends from ```GameController``` class.

    2. Changed all game elements into MVC design pattern. Divided each class into ```View```, ```Controller``` and ```Model```.

* **Alliance of SINGLETON**
    1. Because there will be only one frogger that exists on the screen, it is refacted by using SINGLETON design pattern.

* **Classes and interfaces**
    1. Add ```Platform``` class to describe standable elements such as ```Log``` and ```Turtle```. Preserve ```Obstacle``` class to describle lethal elements such as ```car``` and ```truck```;

    2. Rename ```Animal``` class to ```FroggerView``` class;

    3. Removed the ```musicPlayer``` 

* **Package rearrangement**
    1. Allocated all game elements into com package;

    2. Built a util package to keep 
----
## For extension

* **Additional pages**
    1. A start menu with animation;
    
    2. A difficulty selection page;

    3. A high score page and high score name input page:
        * This board could be accessed by the termination of game;
        * It could be accessedfrom the start menu.

    4. Three gameView pages for different levels of game mode.

    
* **Game termination**
    1. Reached all ends:
        * Game will terminates if player reaches all 5 ends in ```EasyGame``` mode and ```HardGame``` mode;
    2. Wasted all life:
        * Game will terminates if player used up his three chances of life.
        * Player will get a deduction of 50 points after each time they die.

* **Extra game elements**
    1. ```CrocEnd``` and ```BugEnd``` classes:
        * More ```End``` status, implemented in ```Hard``` mode and ```Infinite``` mode;
        * The position of different types of ```End``` could change after each time frogger reached one of the ```End``` and survive;
        * ```CrocEnd```: A lethal ```End``` which could kill the frogger;
        * ```BugEnd```: An ```End``` with a snack which provides player extra bonus.
    2. ```Snake``` class:
        * Implemented in ```Hard``` mode and ```Infinite``` mode;
        * A lethal ```Snake``` appears in the middle lane of the game stage.
    3. ```InfiniteGameController``` class:
        * Implemented in ```Infinite``` mode;
        * Player could play infinite terms of game with an increasing difficulty.
    4. ```GameModeView``` class:
        * Display present game mode;
        * DIsplay present difficulty of the game, if the mode is inifinite.

* **Extra game feature**
    1. Pause: Player could press SPACE on the keyboard to pause and restart the game;
    2. Opening Cinematic: The original opening cinematic has been remade and allocated on the start menu.

* **High score board**
    1. ```Main``` will check whether the player's score is high enough to be kept in game record;
    2. If so, ```InputNameView``` will ask player to leave their name;
    3. This board could be accessed from menu and after the game's termination.