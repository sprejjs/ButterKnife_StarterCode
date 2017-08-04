package com.spreys.viewholderexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spreys.viewholderexample.Model.Contact;

import java.util.List;

public class ContactsAdapter extends ArrayAdapter<Contact> {
    private List<Contact> contacts;

    public ContactsAdapter(Context context, List<Contact> contacts) {
        super(context, -1);
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.contact_item, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contacts.get(position);

        viewHolder.nameTextView.setText(contact.getName());
        viewHolder.mobileTextView.setText(contact.getMobile());
        viewHolder.landlineTextView.setText(contact.getLandline());

        return convertView;
    }

    @Override
    public int getCount() {
        return this.contacts.size();
    }

    class ViewHolder {
        private TextView nameTextView;
        private TextView mobileTextView;
        private TextView landlineTextView;

        public ViewHolder(@NonNull View view) {
            this.nameTextView = (TextView)view
                    .findViewById(R.id.name_text_view);
            this.mobileTextView = (TextView)view
                    .findViewById(R.id.mobile_text_view);
            this.landlineTextView = (TextView)view
                    .findViewById(R.id.landline_text_view);
        }
    }
}
