package com.spreys.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spreys.butterknife.Model.Contact;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT = "contact";

    private TextView nameTextView;
    private TextView landlineTextView;
    private TextView mobileTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Contact contact = getIntent().getExtras().getParcelable(EXTRA_CONTACT);
        assert contact != null;

        //TODO: Step 3, use Butter Knife in the details activity
        nameTextView = (TextView)findViewById(R.id.activity_details_name);
        landlineTextView = (TextView)findViewById(R.id.activity_details_landline);
        mobileTextView = (TextView)findViewById(R.id.activity_details_mobile);

        nameTextView.setText(contact.getName());
        landlineTextView.setText(contact.getLandline());
        mobileTextView.setText(contact.getMobile());
    }
}
