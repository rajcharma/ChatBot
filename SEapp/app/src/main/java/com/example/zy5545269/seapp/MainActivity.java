package com.example.zy5545269.seapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView advisorListView;
    private EditText inputText;
    private Button send;
    private AdvisorAdapter adapter;

    private List<Advisor> advisorsList = new ArrayList<Advisor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAdvisor();
        adapter = new AdvisorAdapter(MainActivity.this,R.layout.layout,advisorsList);
        inputText =(EditText)findViewById(R.id.editTextInput);
        send = (Button)findViewById(R.id.button);
        advisorListView = (ListView)findViewById(R.id.LISTVIEW);
        advisorListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content))
                {
                    Advisor advisor =new Advisor(content,Advisor.TYPE_SEND);
                    advisorsList.add(advisor);
                    adapter.notifyDataSetChanged();
                    advisorListView.setSelection(advisorsList.size());
                    inputText.setText("");
                }
            }
        });
    }

    private void initAdvisor()
    {
        Advisor adv1 = new Advisor("Hello, nice to meet you!", Advisor.TYPE_RECEIVED);
        advisorsList.add(adv1);
    }
}
