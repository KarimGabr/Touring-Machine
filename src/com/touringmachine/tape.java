package com.touringmachine;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Object;

public class tape
{
    private LinkedList tape;

    private String tape_string;
    private String[] tape_string_array;

    private String initial_state;
    private String initial_head_location;

    public void set_tape(state tm_states, alphabet tm_machine_alphabet)
    {
        while (true)
        {
            tape = new LinkedList();

            Scanner sc = new Scanner(System.in);

            tape_string = sc.next();

            tape_string_array = tape_string.split(",");

            initial_head_location = tape_string_array[0];
            initial_state = tape_string_array[1];

            tape_string_array = ArrayUtils.remove(tape_string_array, 0);
            tape_string_array = ArrayUtils.remove(tape_string_array, 0);

            tape.addAll(Arrays.asList(tape_string_array));

            if (check_format(tm_states.get_states(), tm_machine_alphabet.get_alphabet())) break;
        }
    }

    public LinkedList get_tape()
    {
        return tape;
    }

    public String get_initial_state()
    {
        return initial_state;
    }

    public String get_initial_head_location()
    {
        return initial_head_location;
    }

    public boolean check_format(String[] states, String[] machine_symbols)
    {
        if(!StringUtils.isNumeric(initial_head_location))
        {
            System.out.println("INPUT ERROR INITIAL HEAD LOCATION MUST BE POSITIVE INTEGER");
            return false;
        }

        else if(Integer.parseInt(initial_head_location) >= tape.size())
        {
            System.out.println("INPUT ERROR INITIAL HEAD LOCATION " + initial_head_location + " MUST BE LESSER THAN TAPE SIZE " + tape.size());
            return false;
        }

        else if(Integer.parseInt(initial_head_location) < 0)
        {
            System.out.println("INPUT ERROR INITIAL HEAD LOCATION MUST BE POSITIVE INTEGER");
            return false;
        }

        if (!Arrays.asList(states).contains(initial_state))
        {
            System.out.println("INPUT ERROR UNKNOWN INITIAL STATE " + initial_state);
            return false;
        }

        for(int i = 0; i < tape.size(); i++)
        {
            if (!Arrays.asList(machine_symbols).contains(tape.get(i).toString()))
            {
                System.out.println("INPUT ERROR UNKNOWN MACHINE SYMBOL " + tape.get(i).toString());
                return false;
            }
        }
        return true;
    }
}
