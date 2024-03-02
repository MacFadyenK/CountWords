## Count Words
This program takes a text file filled with words and counts the number of times each word in the file shows up. The result is written to a new file with the word, followed by the number of times it appeared.  

When run, the program will welcome the user and prompt them to enter a file path for input. Once an input is entered, the program scans this input and, if it is a valid path to a text file, will then count the words on the file and return the results in the file countedWords.txt. If the input is not a valid text file, the user will be told, and no counting will occur.
### File Format
#### Input File
The original files must have one word per line for the program to work correctly. The program is not case sensitive, so different capitalization of a word will all count as the same word.
#### Output file
The output file will contain each word and the number of times the word appeared. Each word will appear on a different line, followed by a space and a number indicating the number of times the word appeared.  
Ex.  
hello 4  
book 3  
cat 10  