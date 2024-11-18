package com.jimin.self_introduction_card;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
        binding.emptyHeartButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clickHeart[0]) {
                    binding.emptyHeartButt.setBackgroundResource(R.drawable.heart);
                    clickHeart[0] = true;
                } else {
                    binding.emptyHeartButt.setBackgroundResource(R.drawable.empty_heart);
                    clickHeart[0] = false;
                }
            }
        });
        // 코틀린오류,  람다식으로 바꿔야 함!!

        boolean[] clickSave = {false};
        binding.saveButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clickSave[0]) {
                    binding.saveButt.setBackgroundResource(R.drawable.save);
                    clickSave[0] = true;
                } else {
                    binding.saveButt.setBackgroundResource(R.drawable.emptysave);
                    clickSave[0] = false;
                }
            }
        });
        // 코틀린오류,  람다식으로 바꿔야 함!!

        binding.downloadButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                TextView messageView = new TextView(v.getContext());
                messageView.setText(android.text.Html.fromHtml(
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\" 아이콘\"> 아이콘 제작자: Freepik - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\"저장 아이콘\">저장 아이콘 제작자: Freepik - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\"전화 아이콘\">전화 아이콘 제작자: iconmas - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\"이메일 아이콘\">이메일 아이콘 제작자: Uniconlabs - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/github\" title=\"github 아이콘\">Github 아이콘 제작자: Pixel perfect - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\"교실 아이콘\">교실 아이콘 제작자: Uniconlabs - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\"지구 아이콘\">지구 아이콘 제작자: Freepik - Flaticon</a><br>" +
                                "<a href=\"https://www.flaticon.com/kr/free-icons/\" title=\"설치자 아이콘\">설치자 아이콘 제작자: IYAHICON - Flaticon</a><br>"
                ));
                messageView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
                messageView.setPadding(50, 50, 50, 50);

                builder.setTitle("아이콘 출처")
                        .setView(messageView)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

    }
}