/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 18/5/2019
 */

package uts.aldy.menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import uts.aldy.R;
import uts.aldy.model.Adapter;
import uts.aldy.model.DbHelper;
import uts.aldy.model.peopleModel;

public class FriendsFragment extends Fragment implements View.OnClickListener {

    ListView listView;
    List<peopleModel> itemList = new ArrayList<peopleModel>();
    Adapter adapter;
    AlertDialog.Builder dialog;
    DbHelper SQLite = new DbHelper(getActivity());

    public static final String TAG_ID = "id";
    public static final String TAG_NIM = "nim";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KELAS = "kelas";
    public static final String TAG_TELP = "telp";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_SOCMED = "socmed";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        SQLite = new DbHelper(getActivity());

        FloatingActionButton add_btn = view.findViewById(R.id.fab);
        listView = (ListView) view.findViewById(R.id.list_view);

        add_btn.setOnClickListener(this);

        listView.setDivider(null);

        adapter = new Adapter(getActivity(), itemList);
        listView.setAdapter(adapter);

        // long press listview to show edit and delete
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                final String idx = itemList.get(position).getId();
                final String nim = itemList.get(position).getNim();
                final String nama = itemList.get(position).getNama();
                final String kelas = itemList.get(position).getKelas();
                final String telp = itemList.get(position).getTelepon();
                final String email = itemList.get(position).getEmail();
                final String socmed = itemList.get(position).getSocmed();


                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(getActivity(), uts.aldy.add_and_edit.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NIM, nim);
                                intent.putExtra(TAG_NAMA, nama);
                                intent.putExtra(TAG_KELAS, kelas);
                                intent.putExtra(TAG_TELP, telp);
                                intent.putExtra(TAG_EMAIL, email);
                                intent.putExtra(TAG_SOCMED, socmed);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
            }

        });

        getAllData();

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab){
            Intent intent = new Intent(getActivity(), uts.aldy.add_and_edit.class);
            startActivity(intent);
        }
    }

    public void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++){
            String id = row.get(i).get(TAG_ID);
            String nim = row.get(i).get(TAG_NIM);
            String nama = row.get(i).get(TAG_NAMA);
            String kelas = row.get(i).get(TAG_KELAS);
            String telp = row.get(i).get(TAG_TELP);
            String email = row.get(i).get(TAG_EMAIL);
            String socmed = row.get(i).get(TAG_SOCMED);

            peopleModel data = new peopleModel();

            data.setId(id);
            data.setNim(nim);
            data.setNama(nama);
            data.setKelas(kelas);
            data.setTelepon(telp);
            data.setEmail(email);
            data.setSocmed(socmed);

            itemList.add(data);

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.bottomnavigation_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.tv_profile_nama) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
