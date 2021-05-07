package tech.watanave.hapticsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants.CONFIRM
import android.view.HapticFeedbackConstants.REJECT
import tech.watanave.hapticsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.confirmButton.setOnClickListener {
            binding.confirmButton.performHapticFeedback(CONFIRM)
        }

        binding.rejectButton.setOnClickListener {
            binding.rejectButton.performHapticFeedback(REJECT)
        }
    }
}