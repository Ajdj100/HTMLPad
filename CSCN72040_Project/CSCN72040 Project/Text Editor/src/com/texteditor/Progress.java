package com.texteditor;


public class Progress implements Momento{
    
    String state;

    Progress(String state)
    {
        this.state = state;
    }

    @Override
    public String GetState() {
        return state;
    }

    @Override
    public String toString(){
        return state;
    }

}
