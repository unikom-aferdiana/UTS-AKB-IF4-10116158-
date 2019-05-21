/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 20/5/2019
 */

package uts.aldy.presenter;

import uts.aldy.R;
import uts.aldy.model.aldyModel;
import uts.aldy.view.contactView;

public class contactFragmentPresenter implements contactPresenter {
    private aldyModel aldy = new aldyModel();
    private contactView view;

    public contactFragmentPresenter(contactView view) {
        this.view = view;
    }

    @Override
    public String getNama() {
        aldy.setNama("Aldy Ferdian Adam");
        return aldy.getNama();
    }

    @Override
    public int getFoto() {
        aldy.setResource_foto(R.drawable.aldy);
        return aldy.getResource_foto();
    }

    @Override
    public String getPhone() {
        aldy.setTelepon("+6281222008692");
        return aldy.getTelepon();
    }

    @Override
    public String getEmail() {
        aldy.setEmail("aferdiana@email.unikom.ac.id");
        return aldy.getEmail();
    }

    @Override
    public String getSocmed() {
        aldy.setSocmed("nooo.be");
        return aldy.getSocmed();
    }
}
