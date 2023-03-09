package com.texteditor;
import java.util.ArrayList;

public class PrgHistory {
    private ArrayList<Momento> history;
    private int index;
    
    public PrgHistory()
    {
        history = new ArrayList<Momento>();
        index = 0;
    }

    public void Add(Progress progress)
    {
        int size = history.size();  
        boolean contains = false;

        for(Momento state : history)
        {
            if(state.GetState().equals(progress.GetState()))
            {
                contains = true;
            }
        }
        if(!contains && !progress.GetState().equals(""))
        {

            if(index < size)
            {
                for(int i = index; i < size; i++)
                {
                    history.remove(i);
                }
            
            }
            history.add(progress);
            index = history.size();
        }

    }

    public Momento GetLast()
    {
        Momento temp = new Progress("");
        index--;
        if(index > 0)
        {
            return history.get(index - 1);
        }
        return temp;
    }

    public Momento GetNext()
    {
        int size = history.size();
        if(index < size)
        {
            return history.get(++index);  
        }
        return history.get(index);
    }

}
