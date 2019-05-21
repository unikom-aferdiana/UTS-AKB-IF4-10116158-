/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 19/5/2019
 */

/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 19/5/2019
 */

/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 18/5/2019
 */

/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 16/05/2019
 */

package uts.aldy;

import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;

import uts.aldy.view.splashView;
import uts.aldy.viewPager.viewPageIntro;

public class SplashActivity extends AppCompatActivity implements splashView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        openIntro();
    }


    @Override
    public void openIntro() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashActivity.this, viewPageIntro.class);
                Intent intent = new Intent(SplashActivity.this, viewPageIntro.class);
                startActivity(intent);
                finish();
            }
        },3000L);
    }
}
