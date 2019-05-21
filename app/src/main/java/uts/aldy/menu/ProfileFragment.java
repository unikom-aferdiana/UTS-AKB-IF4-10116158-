/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 18/5/2019
 */

package uts.aldy.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import uts.aldy.R;
import uts.aldy.presenter.profileFragmentPresenter;
import uts.aldy.view.profileView;

public class ProfileFragment extends Fragment implements profileView {

    private TextView nimTV, namaTV, kelasTV, descTV;
    private ImageView foto;
    private profileFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nimTV = view.findViewById(R.id.tv_profile_nim);
        namaTV = view.findViewById(R.id.tv_profile_nama);
        kelasTV = view.findViewById(R.id.tv_profile_kelas);
        descTV = view.findViewById(R.id.tv_profile_desc);
        foto = view.findViewById(R.id.imageView_profile);

        presenter = new profileFragmentPresenter(this);

       updateNimTV(presenter.getNim());
       updateNamaTV(presenter.getNama());
       updateKelasTV(presenter.getKelas());
       updateDescTV(presenter.getDesc());
       updateFoto(presenter.getFoto());

        return view;
    }

    @Override
    public void updateNimTV(String nim) {
        nimTV.setText(nim);
    }

    @Override
    public void updateNamaTV(String nama) {
        namaTV.setText(nama);
    }

    @Override
    public void updateKelasTV(String kelas) {
        kelasTV.setText(kelas);
    }

    @Override
    public void updateDescTV(String desc) {
        descTV.setText(desc);
    }

    @Override
    public void updateFoto(int i) {
        foto.setImageResource(i);
    }
}