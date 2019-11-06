package sortingalgorithms;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t7047098
 */
public class ArrayADT 
{
    private int[] data;
    int size;
    
    public ArrayADT(int capacity)
    {
        data = new int[capacity];
        size = 0;
    }
    
    public ArrayADT()
    {
        data = new int[10];
        size = 0;
    }
    
    public ArrayADT(int[] knownArray)
    {
        data = knownArray;
        size = data.length;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void addValue(int value)
    {
//        if (size != data.length)
//        {
//            data[size + 1] = value;
//        }
//        else
//        {
//            outOfBoundsException(value);
//        }
        try 
        {
           data[size + 1] = value;
           size +=1;
        }
        catch (IndexOutOfBoundsException e)
        {
            outOfBoundsException();
            data[size + 1] = value;
            size += 1;
        }
    }
    
    public void removeValue(int position)
    {
        for (int i = position; i < data.length; i++) 
        {
            data[i] = data[i+1]; 
        }
    }
    
    public void outOfBoundsException()
    {
        int[] temp = data;
        data = new int[size + 1];
        data = temp;
    }
    
    public void insertValue(int position, int value)
    {
        try
        {
            for (int i = data.length; i >= position; i--) 
            {
                data[i+1] = data[i];
                if (i == position)
                {
                    data[i] = value;
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            outOfBoundsException();
            for (int i = data.length; i >= position; i--) 
            {
                data[i+1] = data[i];
                if (i == position)
                {
                    data[i] = value;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }
    
    public boolean isFull()
    {
        return size == data.length;
    }
    
    public void destroy()
    {
        data = null;
    }
    
    public int returnValue(int i)
    {
        return data[i];
    }
}
