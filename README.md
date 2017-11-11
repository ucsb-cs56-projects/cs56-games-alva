# cs56-games-alva

This games objective is to create a fun and interesting platformer where you move boxes, flip switches, and avoid obstacles.

## Features to add:
* Adding obstacles to test players reaction time and ability
* Add an ultimate objective to the game, a way to win. Think the flag pole in Mario.
* Create a background.
* Make new maps
* Add level editor GUI
* Add animations for different things the robot can do (pushing boxes, flipping switches)

## Things to refactor:
* The physics engine. It currently is slow and doesn't work that well. Look into AABX collision or another method that is more efficient.
* Animation on non-Linux machines. This game uses Linux graphics and runs unbearably slow on Windows and Mac. Find a way to run animation on these machines at the same rate as on Linux. 

## How to Run
To start the game, put "ant run" into the command line (no quotations).

## Use Space bar to use Switches

![Alt Text](https://github.com/a-saied/cs56-games-alva/blob/master/assets/1z7lhq.gif)

## How to Play
Objective: Get Alva from one end of the level to the other 
To play, simply use A and D to move left and right. W is to jump. SPACE is used to flip switches when nearby. Hold F to grab boxes and move them.
