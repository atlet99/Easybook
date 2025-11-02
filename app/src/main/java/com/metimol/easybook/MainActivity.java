package com.metimol.easybook;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "MyAppPrefs";
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        setContentView(R.layout.main_layout);

        var main_layout = findViewById(R.id.main_activity_screen);
        ViewCompat.setOnApplyWindowInsetsListener(main_layout, (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            mainViewModel.setStatusBarHeight(systemBars.top);
            view.setPadding(
                    systemBars.left,
                    0,
                    systemBars.right,
                    systemBars.bottom
            );
            return WindowInsetsCompat.CONSUMED;
        });
    }

    public static int dpToPx(float dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}