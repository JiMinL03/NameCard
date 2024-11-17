package com.jimin.self_introduction_card;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jimin.self_introduction_card.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 뷰 바인딩 객체 생성
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide(); //툴바 숨김
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boolean[] clickHeart = {false};
        binding.emptyHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clickHeart[0]) {
                    binding.emptyHeart.setBackgroundResource(R.drawable.heart);
                    clickHeart[0] = true;
                } else {
                    binding.emptyHeart.setBackgroundResource(R.drawable.empty_heart);
                    clickHeart[0] = false;
                }
            }
        });
        // 코틀린오류,  람다식으로 바꿔야 함!!
    }
}