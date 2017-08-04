package com.spreys.viewholderexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spreys.viewholderexample.Model.Contact;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT = "contact";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Contact contact = getIntent().getExtras().getParcelable(EXTRA_CONTACT);
        assert contact != null;

        ((TextView)findViewById(R.id.activity_details_name))
                .setText(contact.getName());
        ((TextView)findViewById(R.id.activity_details_landline))
                .setText(contact.getLandline());
        ((TextView)findViewById(R.id.activity_details_mobile))
                .setText(contact.getMobile());
    }
}
