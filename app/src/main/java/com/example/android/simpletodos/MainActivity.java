package com.example.android.simpletodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    // The layout element representing our list of TODOs.
    private TextView mTodoListTextView;

    // The layout element representing the text entry box where the user enters a TODO.
    private EditText mTodoEntryEditText;

    // A list of all the TODOs the user has entered (we'll represent them as a stack).
    private ArrayDeque<String> mTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Use IDs to grab references to the layout items for the TextView representing our TODO
         * list and the EditText representing the TODO text entry box.
         */
        mTodoListTextView = (TextView)findViewById(R.id.tv_todo_list);
        mTodoEntryEditText = (EditText)findViewById(R.id.et_todo_entry_box);

        // Initialize our stack of TODO strings.
        mTodoList = new ArrayDeque<String>();

        // Use ID to grab a reference to the layout element for the button to add a TODO.
        Button addTodoButton = (Button)findViewById(R.id.btn_add_todo);

        /*
         * Create an anonymous class implementing the View.OnClickListener interface to handle
         * clicks on the button to add TODOs.  The onClick() method is implemented to describe
         * how to respond to clicks on the button.
         */
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract the text the user entered into the text entry box.
                String todoText = mTodoEntryEditText.getText().toString();

                /*
                 * If the user-entered text is not empty, push it onto the stack of TODO strings
                 * and then display all the TODOs on the stack within our TextView in order from
                 * most-recently added to least-recently added.  Once all of the TODOs are
                 * displayed, clear the text in the text entry box.
                 */
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoList.push(todoText);
                    mTodoListTextView.setText("");
                    for (String todo : mTodoList) {
                        mTodoListTextView.append(todo + "\n\n");
                    }
                    mTodoEntryEditText.setText("");
                }
            }
        });
    }
}
