Welcome to Turing Machine Simulator..
Developed by Karim Gabr

The program includes Java library: http://commons.apache.org/proper/commons-lang/

The program handles the following user input errors:

1- Check for numeric inputs must be positive integers at: 
*number of states 
*number of machine symbols
*number of input symbols
*initial head location
2- If there is no input symbol "#" in the input alphabet
3- If there is no transition in the transition table with "Y" as next state
4- Check the format of transition table entries:
*current_state: must be in the states_set
*machine_symbol: must be in the machine_alphabet_set
*next_state: must be in the states_set
*input_symbol: must be in the input_alphabet_set
*head_next_direction: must be in the directions_set {R, L, Y, N}
5-Check the format of the tape initial configuration entry:
*head_location: must be positive integer and less than tape size
*initial_state: must be in the states_set
*machine_symbol: must be in the machine_alphabet_set

Attached files: TM Log - 1, TM Log - 2
TM Log - 1: Simulating the Example from the lecture:
Consider the following the TM 
(q0,a)(q0,#,R)
(q0,b)(q0,#,R)
(q0,#)(q0,#,Y)
Test the following tape: [a,b,a,a], initial head location 0, initial state q0 
 

TM Log - 2: Simulating the following Example:
Consider TM accepts the language aba* , where Q1 = { q0, q1, q2, q3 } ,  = { a , b } ,  = { a , b } and  is as given by the table below.
(q0,a)(q1,a,R)
(q1,b)(q2,b,R)
(q2,a)(q2,a,R)
Test the following tape: [a,b,a,a], initial head location 0, initial state q0
