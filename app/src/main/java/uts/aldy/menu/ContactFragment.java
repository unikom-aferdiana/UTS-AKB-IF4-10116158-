/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 18/5/2019
 */

package uts.aldy.menu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import uts.aldy.R;
import uts.aldy.presenter.contactFragmentPresenter;
import uts.aldy.view.contactView;

public class ContactFragment extends Fragment implements contactView, View.OnClickListener {

    private TextView namaTV, socmedTV, phoneTV, emailTV;
    private ImageView foto;
    private contactFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        namaTV = view.findViewById(R.id.contact_name);
        socmedTV = view.findViewById(R.id.contact_socmed);
        phoneTV = view.findViewById(R.id.contact_phone);
        emailTV = view.findViewById(R.id.contact_email);
        foto = view.findViewById(R.id.contact_photo);

        presenter = new contactFragmentPresenter(this);

        updateNamaTV(presenter.getNama());
        updateEmail(presenter.getEmail());
        updateFoto(presenter.getFoto());
        updatePhone(presenter.getPhone());
        updateSocmedTV(presenter.getSocmed());

        phoneTV.setOnClickListener(this);
        emailTV.setOnClickListener(this);
        socmedTV.setOnClickListener(this);

        return view;
    }


    @Override
    public void updateNamaTV(String nama) {
        namaTV.setText(nama);
    }

    @Override
    public void updateFoto(int i) {
        foto.setImageResource(i);
    }

    @Override
    public void updateSocmedTV(String socmed) {
        socmedTV.setText(socmed);
    }

    @Override
    public void updateEmail(String email) {
        emailTV.setText(email);
    }

    @Override
    public void updatePhone(String phone) {
        String formatted_number = new PhoneNumberUtils().formatNumber(phone, "ID");
        phoneTV.setText(formatted_number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.contact_phone:
                Intent dialNumberIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + presenter.getPhone()));
                startActivity(dialNumberIntent);
                break;
            case R.id.contact_email:
                Intent sendEmail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto: " + presenter.getEmail()));
                startActivity(sendEmail);
                break;
            case R.id.contact_socmed:
                Intent openProfile = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/" + presenter.getSocmed()));
                openProfile.setPackage("com.instagram.android");
                try {
                    startActivity(openProfile);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/" + presenter.getSocmed())));
                }
                break;
        }
    }
}
