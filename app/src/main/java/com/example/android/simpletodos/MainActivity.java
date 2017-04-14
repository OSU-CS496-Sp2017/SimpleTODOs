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

    private TextView mTodoListTextView;
    private EditText mTodoEntryEditText;
    private ArrayDeque<String> mTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoListTextView = (TextView)findViewById(R.id.tv_todo_list);
        mTodoEntryEditText = (EditText)findViewById(R.id.et_todo_entry_box);
        mTodoList = new ArrayDeque<String>();
//        todoListTextView.setText("Finish my TODO app");

        Button addTodoButton = (Button)findViewById(R.id.btn_add_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText = mTodoEntryEditText.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoList.push(todoText);
//                    mTodoListTextView.setText(todoText);
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
