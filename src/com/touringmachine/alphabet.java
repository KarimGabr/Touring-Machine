package com.touringmachine;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class alphabet
{
    private int n_alphabet;
    private String[] alphabet;

    public void set_n_alphabet()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            String line = sc.nextLine();
            try
            {
                n_alphabet = Integer.parseInt(line);
                if (n_alphabet > 0) return;
            }catch(NumberFormatException e){}
            System.out.println("ERROR INPUT MUST BE POSITIVE INTEGER");
        }
    }

    public int get_n_alphabet()
    {
        return n_alphabet;
    }

    public void set_alphabet()
    {
        Scanner sc = new Scanner(System.in);
        this.alphabet = new String[get_n_alphabet()];
        for(int i = 0; i < get_n_alphabet(); i++)
        {
            alphabet[i] = sc.next();
        }
    }

    public String[] get_alphabet()
    {
        return alphabet;
    }

    public boolean has_blank_symbol()
    {
        for(int i = 0; i < get_n_alphabet(); i++)
        {
            if(alphabet[i].equals("#")) return true;
        }

        insert_blank_symbol();
        return true;
    }

    private void insert_blank_symbol()
    {
        n_alphabet++;
        alphabet = ArrayUtils.add(alphabet,"#");
    }
}
