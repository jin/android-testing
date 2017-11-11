/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * An {@link Activity} that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    // The TextView used to display the message inside the Activity.
    private TextView mTextView;

    // The EditText where the user types the message.
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the listeners for the buttons.
        findViewById(R.id.changeTextBt).setOnClickListener(this);
        findViewById(R.id.activityChangeTextBtn).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textToBeChanged);
        mEditText = (EditText) findViewById(R.id.editTextUserInput);
        Log.i("textToBeChangedIdApp", new Integer(R.id.textToBeChanged).toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("debug", "onResume");
        mEditText.clearFocus();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // throw new RuntimeException("break");
    }

    @Override
    public void onClick(View view) {
        // Get the text from the EditText view.
        final String text = mEditText.getText().toString();

        final int changeTextBtId = R.id.changeTextBt;
        final int activityChangeTextBtnId = R.id.activityChangeTextBtn;

        Log.i("view_id", new Integer(view.getId()).toString());
        Log.i("changeTextBtId", new Integer(changeTextBtId).toString());
        Log.i("activityChangeTextBtnId", new Integer(activityChangeTextBtnId).toString());

        // switch(view.getId()) {
        //   case changeTextBtId:
        //     // First button's interaction: set a text in a text view.
        //     mTextView.setText(text);
        //     break;
        //   case activityChangeTextBtnId:
        //     // Second button's interaction: start an activity and send a message to it.
        //     Intent intent = ShowTextActivity.newStartIntent(this, text);
        //     startActivity(intent);
        //     break;
        // }

        if (view.getId() == changeTextBtId) {
          // First button's interaction: set a text in a text view.
          mTextView.setText(text);
        } else if (view.getId() == activityChangeTextBtnId) {
          // Second button's interaction: start an activity and send a message to it.
          Intent intent = com.example.android.testing.espresso.BasicSample.ShowTextActivity
              .newStartIntent(this, text);
          startActivity(intent);
        }
    }
}
