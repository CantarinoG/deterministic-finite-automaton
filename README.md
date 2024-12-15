# Deterministic Finite Automaton (DFA) Implementation

This Java project implements a Deterministic Finite Automaton (DFA) that can process and validate input strings based on a predefined set of rules specified in an input file.

## Overview

A DFA is a finite state machine that accepts or rejects strings based on a fixed set of rules. It consists of:
- A finite set of states
- A finite set of input symbols (alphabet)
- A transition function
- An initial state
- A set of final (accepting) states

## Features

- Reads DFA configuration from a text file
- Processes input strings to determine if they are accepted or rejected by the automaton
- Interactive command-line interface for testing words
- Efficient state transition implementation

## File Format

The input file should follow this format:

```
letras;symbol1;symbol2;...
finais;state1;state2;...
dimensao;numRows;numColumns
transition_row_1
transition_row_2
```


Example:

```
letras;a;b
finais;2;3
dimensao;4;2
0;1
2;3
2;3
3;3
```

## Usage

1. Place your automaton definition file in the `inputFiles` directory
2. Run the program
3. Enter words to test when prompted
4. Type 'sair' to exit the program

## Installation

1. Clone this repository
2. Ensure you have Java installed
3. Compile the source files
4. Run the Main class