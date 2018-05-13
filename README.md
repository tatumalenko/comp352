# README
## How to compile and run the code 
To run on a unix setup, change the current directory in the terminal to where the `*.java` lives. 

To compile, type:
```
$ javac ISort.java
```

This should generate the `.class` file in the same directory.

To then run the code, type:
```
$ java ISort <integer-array>
```
where `<integer-array>` is a space delimited array of integer value of length and values of your choosing.

To run the code with printed debug statements illustrating the steps of the code, type:
```
$ java ISort debug <integer-array>
```
