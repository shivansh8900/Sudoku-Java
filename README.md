# Sudoku-Java 🧩

A desktop Sudoku game built using Java Swing, following the MVC (Model-View-Controller) design pattern. This project allows users to solve Sudoku puzzles manually or automatically, and includes features like dark mode, reset, check, and solve functionality.

---

## 🔥 Features

- 🎮 Interactive 9x9 Sudoku Grid
- 🌙 Dark Mode toggle for better UI experience
- ✅ Check Button to verify if the current board is valid
- 🧠 Solve Button that uses backtracking to solve the puzzle
- ♻️ Reset Button to clear editable cells
- 📐 Clean and modular MVC structure (Model, View, Controller)
- 💡 Basic input validation and board highlighting

---

## 🛠 Technologies Used

- Java 22
- Java Swing (for GUI)
- MVC Architecture

---

## 📂 Folder Structure

```plaintext
Sudoku-Java/
│
├── SudokuModel.java      # Stores the board and original puzzle values
├── SudokuView.java       # UI rendering using Swing
├── SudokuSolver.java     # Solves the puzzle using backtracking
├── SudokuApp.java        # Main class with event listeners and logic
├── README.md             # This file
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 22 installed on your machine
- A Java-compatible IDE (IntelliJ, VS Code, Eclipse) or use `javac`/`java` via terminal

### 🧾 To Compile and Run:

1. **Open terminal** and navigate to the folder containing `.java` files.

2. **Compile all files**:
   ```bash
   javac *.java
   ```

3. **Run the main app**:
   ```bash
   java SudokuApp
   ```

---



## 🤔 What I Learned

- Java Swing layout management and styling
- MVC pattern in a Java desktop app
- Backtracking algorithm for Sudoku solving
- How to use event listeners for interactive components
- Java GitHub project publishing

---

## 🧠 Future Improvements

- Import custom Sudoku puzzles
- Timer & scoring system
- Mobile version using JavaFX or Kotlin
- Add sound effects or animation transitions

---


## 🙌 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 🌐 Connect

Made with ❤️ by [Shivansh](https://github.com/shivansh8900)
