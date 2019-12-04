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
    1. A start menu and a difficulty selection page;

    2. A high score page and high score name input page;

    3. Three gameView pages for different levels of interests 

    
* **Game termination**
    1. Besides reach all ends, add ```life``` to froggerModel and ```playerLifeBoard``` to ```GameController``` class.

    2. 


* **Interesting level**
    1. Added more ```End``` status, including ```CrocEnd``` which is lethal to the frogger and ```BugEnd``` which gives player a 50 points bounus when it has been reached by the frogger. And the position of ```End``` with different status might change when the frogger reached one of them and survived.

