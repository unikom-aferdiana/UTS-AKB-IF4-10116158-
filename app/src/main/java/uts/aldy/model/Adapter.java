/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 21/5/2019
 */

package uts.aldy.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uts.aldy.R;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<peopleModel> items;

    public Adapter(Activity activity, List<peopleModel> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nim = (TextView) convertView.findViewById(R.id.nim);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView kelas = (TextView) convertView.findViewById(R.id.kelas);
        TextView telp = (TextView) convertView.findViewById(R.id.telp);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        TextView socmed = (TextView) convertView.findViewById(R.id.socmed);

        peopleModel data = items.get(position);

        id.setText(data.getId());
        nim.setText(data.getNim());
        nama.setText(data.getNama());
        kelas.setText(data.getKelas());
        telp.setText(data.getTelepon());
        email.setText(data.getEmail());
        socmed.setText(data.getSocmed());

        return convertView;
    }
}
