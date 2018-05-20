package com.touringmachine;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;

public class transition
{
    private int n_transitions;
    private String[][] transitions;
    private String transition_string;

    public void set_n_transitions()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            String line = sc.nextLine();
            try
            {
                n_transitions = Integer.parseInt(line);
                if (n_transitions > 0) return;
            }catch(NumberFormatException e){}
            System.out.println("ERROR INPUT MUST BE POSITIVE INTEGER");
        }
    }

    public int get_n_transitions()
    {
        return n_transitions;
    }

    public void set_transitions(state tm_states, alphabet tm_machine_alphabet, alphabet tm_input_alphabet)
    {
        Scanner sc = new Scanner(System.in);
        this.transitions = new String[get_n_transitions()][5];
        for(int i = 0; i < get_n_transitions(); i++)
        {
            transition_string = sc.next();
            transitions[i] = transition_string.split(",");
            if(!check_format(i, tm_states.get_states(), tm_machine_alphabet.get_alphabet(), tm_input_alphabet.get_alphabet())) { i--; continue;}
        }
    }

    public String[][] get_transitions()
    {
        return transitions;
    }

    public boolean has_Y_decision()
    {
        for(int i = 0; i < get_n_transitions(); i++)
        {
            if(transitions[i][4].equals("Y")) return true;
        }

        System.out.println("YOU MUST SPECIFY AT LEAST 1 TRANSITION THAT HAVE Y DECISION");
        return false;
    }

    private boolean check_format(int i, String[] states, String[] machine_symbols, String[] input_symbols)
    {
        if(!Arrays.asList(states).contains(transitions[i][0].toString()))
        {
            System.out.println("INPUT ERROR UNKNOWN CURRENT STATE");
            return false;
        }

        if((!Arrays.asList(machine_symbols).contains(transitions[i][1].toString())) && (!Arrays.asList(input_symbols).contains(transitions[i][1].toString())))
        {
            System.out.println("INPUT ERROR UNKNOWN MACHINE SYMBOL");
            return false;
        }

        if(!Arrays.asList(states).contains(transitions[i][2].toString()))
        {
            System.out.println("INPUT ERROR UNKNOWN NEXT STATE");
            return false;
        }

        if(!Arrays.asList(input_symbols).contains(transitions[i][3].toString()))
        {
            System.out.println("INPUT ERROR UNKNOWN INPUT SYMBOL");
            return false;
        }

        String[] direction = {"R", "L", "Y","N"};
        if(!Arrays.asList(direction).contains(transitions[i][4].toString()))
        {
            System.out.println("INPUT ERROR UNKNOWN DIRECTION");
            return false;
        }

        return true;
    }
}
