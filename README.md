# Dice Game

## Introduction

This is a **Dice Game** developed in Kotlin for Android. The game allows players to roll dice and compete against a computer to reach a specified target score. It includes features like re-rolling mechanics, score tracking, and an interactive gameplay experience.

## Features

- **Custom Target Score**: Set a target score or use the default of 101.
- **Interactive Dice Rolling**: Roll five dice per round.
- **Re-Roll Mechanics**: Re-roll selected dice up to two times per round.
- **Player vs Computer**: Compete with a computer opponent to achieve the target score.
- **Score Tracking**: View scores for both the player and the computer after each round.
- **Pop-Up Dialogs**: Includes instructions and an about section accessible via the main menu.

## How to Run

1. Clone the repository to your local machine:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in Android Studio.
3. Build the project to install required dependencies.
4. Connect an Android device or start an emulator.
5. Click the Run button in Android Studio to launch the app.


## Gameplay
1. Start:
Launch the app and click "Start Game".
Enter your desired target score or use the default value (101).

2. Roll Dice:
Press the "Roll" button to roll the dice for both the player and the computer.

3.Re-Roll:
Tap on any dice you want to re-roll and click the "Re-Roll" button.
You can re-roll up to two times per round.

4. Check Scores:
Press the "Score" button to calculate and display the round's scores.

5. Winning the Game:
The first to reach or exceed the target score wins.
A winner or loser screen will display the result.

6. Return to Menu:
Use the "Back" button to return to the main menu.

## Code Overview
### Main Components
- **MainActivity: Displays the main menu and handles navigation.**
- **userInputActivity: Accepts the target score input from the player.**
- **GameActivity: Implements the game logic, including dice rolling, re-rolling, and score calculation#.**
- **outcomeActivity: Displays the game outcome (win or lose).**

##File Structure
```bash
Copy code
src/main/java/com/Coursework/w1830958_part1_assignment/
├── MainActivity.kt        # Main menu logic
├── userInputActivity.kt   # Target score input screen
├── GameActivity.kt        # Core game logic
├── outcomeActivity.kt     # Result display logic
```


## License
This project is open-source and can be used for personal or academic purposes. Attribution is appreciated.
