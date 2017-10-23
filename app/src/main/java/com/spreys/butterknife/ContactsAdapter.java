package com.spreys.butterknife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spreys.butterknife.Model.Contact;

import java.util.List;

public class ContactsAdapter extends ArrayAdapter<Contact> {

    public ContactsAdapter(Context context, List<Contact> contacts) {
        super(context, -1, contacts);
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

        Contact contact = getItem(position);

        viewHolder.nameTextView.setText(contact.getName());
        viewHolder.mobileTextView.setText(contact.getMobile());
        viewHolder.landlineTextView.setText(contact.getLandline());

        return convertView;
    }

    class ViewHolder {
        TextView nameTextView;
        TextView mobileTextView;
        TextView landlineTextView;

        public ViewHolder(@NonNull View view) {
            //TODO: Step 4: Update the view holder
            nameTextView = (TextView)view.findViewById(R.id.name_text_view);
            mobileTextView = (TextView)view.findViewById(R.id.mobile_text_view);
            landlineTextView = (TextView)view.findViewById(R.id.landline_text_view);
        }
    }
}
