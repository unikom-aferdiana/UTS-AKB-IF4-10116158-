/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 16/5/2019
 */

package uts.aldy.model;

public class aldyModel extends peopleModel {
    private String description;
    private int resource_foto;

    public int getResource_foto() {
        return resource_foto;
    }

    public void setResource_foto(int resource_foto) {
        this.resource_foto = resource_foto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
