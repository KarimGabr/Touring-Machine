package com.touringmachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class state
{
    private int n_states;
    private String[] states;
    private String initial_state;

    public void set_n_states()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            String line = sc.nextLine();
            try
            {
                n_states = Integer.parseInt(line);
                if (n_states > 0) return;
            }catch(NumberFormatException e){}
            System.out.println("ERROR INPUT MUST BE POSITIVE INTEGER");
        }
    }

    public int get_n_states()
    {
        return n_states;
    }

    public void set_states()
    {
        this.states = new String[get_n_states()];
        for (int i = 0; i < get_n_states(); i++)
        {
            states[i] = "q" + (i);
        }
    }

    public String[] get_states()
    {
        return states;
    }

    public void set_initial_state(String initial_state)
    {
        this.initial_state = initial_state;
    }
}
