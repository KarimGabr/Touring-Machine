package com.touringmachine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\nWelcome to Turing Machine Simulator...");
        System.out.println("Developed by Karim Gabr | 2082");

        System.out.println("\n1. Please Specify the Turing Machine Tuples:");
        state tm_states = new state(); //create a new object state
        System.out.println("Please Enter Number of States");
        tm_states.set_n_states(); //scan number of states
        tm_states.set_states(); //generate states numbers q1, q2, q3 ...
        System.out.println("TM States: " + Arrays.deepToString(tm_states.get_states()));

        alphabet tm_machine_alphabet = new alphabet(); //create a new object machine alphabet
        System.out.println("\n2. Please enter Number of Machine Alphabet");
        tm_machine_alphabet.set_n_alphabet(); //scan number of machine alphabet
        System.out.println("Please enter the " + tm_machine_alphabet.get_n_alphabet() + " Machine Symbols");
        tm_machine_alphabet.set_alphabet(); //scan machine alphabet
        tm_machine_alphabet.has_blank_symbol(); //check if user has inserted the blank symbol, if not insert it
        System.out.println("TM Machine Alphabet: " + Arrays.deepToString(tm_machine_alphabet.get_alphabet()));

        alphabet tm_input_alphabet = new alphabet(); //create a new object input alphabet
        System.out.println("\n3. Please enter Number of Input Alphabet");
        tm_input_alphabet.set_n_alphabet(); //scan number of machine alphabet
        System.out.println("Please enter the " + tm_input_alphabet.get_n_alphabet() + " Input Symbols");
        tm_input_alphabet.set_alphabet(); //scan input alphabet
        tm_input_alphabet.has_blank_symbol(); //check if user has inserted the blank symbol, if not insert it
        System.out.println("TM Input Alphabet: " + Arrays.deepToString(tm_input_alphabet.get_alphabet()));

        transition tm_transition = new transition(); //create a new object transition
        while(true)
        {
            System.out.println("\n4. Please enter Number of Transitions:");
            tm_transition.set_n_transitions(); //set number of transitions
            System.out.println("\n4. Please enter the " + tm_transition.get_n_transitions() + " Transitions in the following format:");
            System.out.println("current_state,machine_symbol,next_state,input_symbol,tape_head_next_direction");
            System.out.println("example: q1,a,q2,b,R");
            tm_transition.set_transitions(tm_states, tm_machine_alphabet, tm_input_alphabet); //scan transitions
            if(tm_transition.has_Y_decision())  break; //check if user has inserted at least 1 transition that has Y decision
        }
        System.out.println("TM Transition Table: " + Arrays.deepToString(tm_transition.get_transitions()));



        tape tm_tape = new tape(); //create a new object tape
        System.out.println("\n5. Please enter the TM tape initial configuration in the following format: :");
        System.out.println("initial_head_position,initial_state,start_tape_symbol1,tape_symbol2,tape_symbol3");
        System.out.println("example: 1,q0,a,a,a");
        tm_tape.set_tape(tm_states, tm_machine_alphabet); //scan tape initial configuration
        tm_states.set_initial_state(tm_tape.get_initial_state()); //set the initial state of the TM
        System.out.println("TM tape initial configuration: " + tm_tape.get_tape());
        System.out.println("TM tape initial state: " + tm_tape.get_initial_state());
        System.out.println("TM tape initial head location: " + tm_tape.get_initial_head_location() + "\n");

        simulation tm_simulation = new simulation(tm_tape.get_initial_state(),tm_tape.get_initial_head_location(),tm_tape.get_tape(),tm_transition.get_transitions());
        tm_simulation.start_simulation();
    }
}
