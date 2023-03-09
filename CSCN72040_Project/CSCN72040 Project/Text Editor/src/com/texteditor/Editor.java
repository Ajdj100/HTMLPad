package com.texteditor;

public class Editor
{
    private PrgHistory history;
    private String editorTextState;

    public Editor()
    {
        history = new PrgHistory();
        editorTextState = new String();
    }

    public void SaveText(String text)
    {
        editorTextState = text;
        history.Add(new Progress(editorTextState)); 
    }

    public String GetText()
    {
        return editorTextState;
    }

    public String UndoText()
    {
        editorTextState = history.GetLast().GetState();
        return editorTextState;
    }

    public String RedoText()
    {
        editorTextState = history.GetNext().GetState();
        return editorTextState;
    }

    @Override
    public String toString()
    {
        return editorTextState;
    }
}