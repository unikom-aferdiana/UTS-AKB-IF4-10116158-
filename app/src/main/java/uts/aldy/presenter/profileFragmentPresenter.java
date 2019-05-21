/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 19/5/2019
 */

package uts.aldy.presenter;

import uts.aldy.R;
import uts.aldy.model.aldyModel;
import uts.aldy.view.profileView;

public class profileFragmentPresenter implements profilePresenter {
    private profileView profileview;
    private aldyModel aldy = new aldyModel();

    public profileFragmentPresenter(profileView profileview) {
        this.profileview = profileview;
    }


    @Override
    public String getNim() {
        aldy.setNim("10116158");
        return aldy.getNim();
    }

    @Override
    public String getNama() {
        aldy.setNama("Aldy Ferdian Adam");
        return aldy.getNama();
    }

    @Override
    public String getKelas() {
        aldy.setKelas("IF-4");
        return aldy.getKelas();
    }

    @Override
    public String getDesc() {
        aldy.setDescription("Deskripsi :\nSaya adalah mahasiswa asal Kabupaten Bandung yang sedang menempuh pendidikan di Universitas Komputer Indonesia");
        return aldy.getDescription();
    }

    @Override
    public int getFoto(){
        aldy.setResource_foto(R.drawable.aldy);
        return aldy.getResource_foto();
    }
}
