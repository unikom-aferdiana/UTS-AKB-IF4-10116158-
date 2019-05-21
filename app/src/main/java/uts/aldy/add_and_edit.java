/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 21/5/2019
 */

package uts.aldy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uts.aldy.menu.FriendsFragment;
import uts.aldy.model.DbHelper;

public class add_and_edit extends AppCompatActivity {
    EditText txt_id, txt_nim, txt_nama, txt_kelas, txt_telp, txt_email, txt_socmed;
    Button btn_submit;
    DbHelper SQLite = new DbHelper(this);
    String id, nim, nama, kelas, telp, email, socmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_edit);

        txt_id = (EditText) findViewById(R.id.id);
        txt_nim = (EditText) findViewById(R.id.nim);
        txt_nama = (EditText) findViewById(R.id.nama);
        txt_kelas = (EditText) findViewById(R.id.kelas);
        txt_telp = (EditText) findViewById(R.id.telp);
        txt_email = (EditText) findViewById(R.id.email);
        txt_socmed = (EditText) findViewById(R.id.socmed);
        btn_submit = (Button) findViewById(R.id.btn_save);

        id = getIntent().getStringExtra(FriendsFragment.TAG_ID);
        nim = getIntent().getStringExtra(FriendsFragment.TAG_NIM);
        nama = getIntent().getStringExtra(FriendsFragment.TAG_NAMA);
        kelas = getIntent().getStringExtra(FriendsFragment.TAG_KELAS);
        telp = getIntent().getStringExtra(FriendsFragment.TAG_TELP);
        email = getIntent().getStringExtra(FriendsFragment.TAG_EMAIL);
        socmed = getIntent().getStringExtra(FriendsFragment.TAG_SOCMED);

        if (id == null || id == "") {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            txt_id.setText(id);
            txt_nim.setText(nim);
            txt_nama.setText(nama);
            txt_kelas.setText(kelas);
            txt_telp.setText(telp);
            txt_email.setText(email);
            txt_socmed.setText(socmed);
        }

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txt_id.getText().toString().equals("")) {
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e){
                    Log.e("Submit", e.toString());
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Make blank all Edit Text
    private void blank() {
        txt_nama.requestFocus();
        txt_id.setText(null);
        txt_nim.setText(null);
        txt_nama.setText(null);
        txt_kelas.setText(null);
        txt_telp.setText(null);
        txt_email.setText(null);
        txt_socmed.setText(null);
    }

    // Save data to SQLite database
    private void save() {
        if (String.valueOf(txt_nim.getText()).equals(null) || String.valueOf(txt_nim.getText()).equals("") ||
                String.valueOf(txt_nama.getText()).equals(null) || String.valueOf(txt_nama.getText()).equals("") ||
                String.valueOf(txt_kelas.getText()).equals(null) || String.valueOf(txt_kelas.getText()).equals("") ||
                String.valueOf(txt_telp.getText()).equals(null) || String.valueOf(txt_telp.getText()).equals("") ||
                String.valueOf(txt_email.getText()).equals(null) || String.valueOf(txt_email.getText()).equals("") ||
                String.valueOf(txt_socmed.getText()).equals(null) || String.valueOf(txt_socmed.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Silahakan masukan nim, nama, kelas, no telp, email, atau username instagram", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.insert(txt_nim.getText().toString().trim(), txt_nama.getText().toString().trim(),
                    txt_kelas.getText().toString().trim(), txt_telp.getText().toString().trim(),
                    txt_email.getText().toString().trim(), txt_socmed.getText().toString().trim());
            blank();
            finish();
        }
    }

    // Update data in SQLite database
    private void edit() {
        if (String.valueOf(txt_nim.getText()).equals(null) || String.valueOf(txt_nim.getText()).equals("") ||
                String.valueOf(txt_nama.getText()).equals(null) || String.valueOf(txt_nama.getText()).equals("") ||
                String.valueOf(txt_kelas.getText()).equals(null) || String.valueOf(txt_kelas.getText()).equals("") ||
                String.valueOf(txt_telp.getText()).equals(null) || String.valueOf(txt_telp.getText()).equals("") ||
                String.valueOf(txt_email.getText()).equals(null) || String.valueOf(txt_email.getText()).equals("") ||
                String.valueOf(txt_socmed.getText()).equals(null) || String.valueOf(txt_socmed.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Silahakan masukan nim, nama, kelas, no telp, email, atau username instagram", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.update(Integer.parseInt(txt_id.getText().toString().trim()), txt_nim.getText().toString().trim(),
                    txt_nama.getText().toString().trim(), txt_kelas.getText().toString().trim(), txt_telp.getText().toString().trim(),
                    txt_email.getText().toString().trim(), txt_socmed.getText().toString().trim());
            blank();
            finish();
        }
    }
}
