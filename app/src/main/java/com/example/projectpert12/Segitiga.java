package com.example.projectpert12;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Segitiga extends AppCompatActivity {
    Button hitung, hapus;
    EditText alas, tinggi;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segitiga);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        hitung = findViewById(R.id.btn_hitung);
        hapus = findViewById(R.id.btn_hapus);

        alas = findViewById(R.id.editalas);
        tinggi = findViewById(R.id.edittinggi);

        hasil = findViewById(R.id.texthasilhitung);

        // Set listener untuk tombol Hitung
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasSegitiga();
            }
        });

        // Set listener untuk tombol Hapus
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusField();
            }
        });
    }

    private void hitungLuasSegitiga() {
        String alasInput = alas.getText().toString();
        String tinggiInput = tinggi.getText().toString();

        if (!alasInput.isEmpty() && !tinggiInput.isEmpty()) {
            double alasValue = Double.parseDouble(alasInput);
            double tinggiValue = Double.parseDouble(tinggiInput);

            // Rumus luas segitiga: 1/2 * alas * tinggi
            double luas = 0.5 * alasValue * tinggiValue;

            // Menampilkan hasil ke EditText hasil
            hasil.setText(String.valueOf(luas));
        } else {
            Toast.makeText(this, "Silakan masukkan nilai alas dan tinggi", Toast.LENGTH_SHORT).show();
        }
    }

    private void hapusField() {
        // Mengosongkan semua field
        alas.setText("");
        tinggi.setText("");
        hasil.setText("");

        // Mengarahkan kursor ke field alas
        alas.requestFocus();
        Toast.makeText(Segitiga.this, "Data Telah terhapus", Toast.LENGTH_SHORT).show();
    }
}