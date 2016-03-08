package kr.co.company.providertest2;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;


public class ProviderTest2Activity extends Activity {
    /**
     * Called when the activity is first created.
     */
    EditText nameEdit;
    EditText phoneEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        nameEdit = (EditText) findViewById(R.id.name);
        phoneEdit = (EditText) findViewById(R.id.phonenumber);
    }

    public void onClick(View v) {
        ContentValues values = new ContentValues();

        String name = nameEdit.getText().toString();
        String phone = phoneEdit.getText().toString();

        values.put(ContactsContract.RawContacts.ACCOUNT_TYPE, "com.google");
        values.put(ContactsContract.RawContacts.ACCOUNT_NAME, name);
        Uri rawContactUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
        long rawContactId = ContentUris.parseId(rawContactUri);

        values = new ContentValues();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

        values = new ContentValues();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phone);
        values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
    }
}
