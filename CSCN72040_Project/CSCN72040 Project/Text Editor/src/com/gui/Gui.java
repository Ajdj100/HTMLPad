package com.gui;

import com.texteditor.Editor;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui {
    public void RunGui()
    {
        Editor textEditor = new Editor();
        JFrame windowFrame = new JFrame("Text Editor");
        
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(500,500);

        JMenuBar fileMenuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        JPanel panel = new JPanel();
        JTextArea editField = new JTextArea(200,200);
        Document editFieldDocument = editField.getDocument();

        fileMenuBar.add(file);
        fileMenuBar.add(edit);

        JMenuItem fileAction_Open = new JMenuItem(new AbstractAction("Open") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JMenuItem fileAction_Close = new JMenuItem(new AbstractAction("Close") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JMenuItem editAction_Undo = new JMenuItem(new AbstractAction("Undo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                textEditor.UndoText();
                
                editField.setText(textEditor.GetText());
            }
        });
        JMenuItem editAction_Redo = new JMenuItem(new AbstractAction("Redo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                textEditor.RedoText();
                editField.setText(textEditor.GetText());
            }
        });

        file.add(fileAction_Open);
        file.add(fileAction_Close);
        edit.add(editAction_Undo);
        edit.add(editAction_Redo);

        
        editFieldDocument.addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                textEditor.SaveText(editField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textEditor.SaveText(editField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textEditor.SaveText(editField.getText());
            }

        });
        editField.setLineWrap(true);
        panel.add(editField);

        windowFrame.getContentPane().add(BorderLayout.NORTH, fileMenuBar);
        windowFrame.getContentPane().add(BorderLayout.CENTER, editField);
        windowFrame.setVisible(true);
        

    }
}
