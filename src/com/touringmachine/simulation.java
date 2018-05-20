package com.touringmachine;

import java.util.LinkedList;
import java.util.Scanner;

public class simulation
{
    private String     initial_state;
    private String     initial_head_location;
    private LinkedList initial_tape;
    private String[][] transition_table;

    private String     current_state;
    private int        active_cell;
    private LinkedList current_tape;
    private String     input_symbol;

    public simulation(String initial_state, String initial_head_location, LinkedList initial_tape, String[][] transition_table)
    {
        this.initial_state         =    initial_state;
        this.initial_head_location =    initial_head_location;
        this.initial_tape          =    initial_tape;
        this.transition_table      =    transition_table;
        this.current_state         =    initial_state;
        this.active_cell           =    Integer.parseInt(initial_head_location);
        this.current_tape          =    initial_tape;
    }

     public boolean start_simulation()
     {
         int flag = 0;
         while(true)
         {
             flag = 0;
             for(int i = 0; i < transition_table.length; i++)
             {
                 if(this.current_state.equals(this.transition_table[i][0]))
                 {
                     this.input_symbol = this.current_tape.get(this.active_cell).toString();

                     if(this.input_symbol.equals(this.transition_table[i][1]))
                     {
                         System.out.println("Active Cell: " + this.active_cell);
                         System.out.println("Input Symbol: " + this.input_symbol);
                         System.out.println("Current Tape: " + this.current_tape);

                         this.current_state = this.transition_table[i][2];
                         this.input_symbol  = this.transition_table[i][3];

                         this.current_tape.set(this.active_cell, this.input_symbol);

                         if(transition_table[i][4].equals("R"))
                         {
                             this.active_cell++;
                             flag = 2;
                             if(this.active_cell >= this.current_tape.size())    this.current_tape.addLast("#");
                         }
                         else if(transition_table[i][4].equals("L"))
                         {
                             this.active_cell--;
                             flag = 2;
                             if(this.active_cell < 0)
                             {
                                 flag = -2;
                                 System.out.println("MACHINE CRASHED.. CANNOT EXTEND TAPE BEFORE THE START CELL");
                                 return false;
                             }
                         }
                         else if(transition_table[i][4].equals("Y"))
                         {
                             flag = 1;
                             System.out.println("\nACCEPT TAPE.. RETURN TRUE\n");
                             return true;
                         }
                         else if(transition_table[i][4].equals("N"))
                         {
                             flag = -1;
                             System.out.println("\nREJECT TAPE.. RETURN FALSE\n");
                             return false;
                         }
                     }
                 }
             }

             if(flag == 0)
             {
                 System.out.println("Active Cell: " + this.active_cell);
                 System.out.println("Input Symbol: " + this.input_symbol);
                 System.out.println("Current Tape: " + this.current_tape);
                 System.out.println("TM HALTING.. WE ARE IN 2018 AND STILL NO SOLUTION TO TM HALTING PROBLEM");
                 return false;
             }
         }
     }
}