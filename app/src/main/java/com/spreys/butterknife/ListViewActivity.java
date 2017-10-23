package com.spreys.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.spreys.butterknife.Model.Contact;
import com.spreys.butterknife.Model.MockDataGenerator;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private List<Contact> contacts;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        contacts = MockDataGenerator.getMockContacts(1);

        //TODO: Step 2. Use Butter Knife in the main activity.
        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(new ContactsAdapter(this, contacts));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contact selectedContact = contacts.get(position);

                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_CONTACT, selectedContact);
                startActivity(intent);
            }
        });

        FloatingActionButton addContact = (FloatingActionButton)findViewById(R.id.add_contact);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ArrayAdapter)listView.getAdapter()).add(MockDataGenerator.getMockContact());
            }
        });
    }

    //TODO: Step 5. Add an on-click listener.
}
