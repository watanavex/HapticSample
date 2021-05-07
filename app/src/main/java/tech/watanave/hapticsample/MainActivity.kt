package tech.watanave.hapticsample

import android.os.Bundle
import android.os.VibrationEffect
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.os.VibrationEffect.EFFECT_CLICK
import android.os.VibrationEffect.EFFECT_DOUBLE_CLICK
import android.os.Vibrator
import android.view.HapticFeedbackConstants.CONFIRM
import android.view.HapticFeedbackConstants.REJECT
import androidx.appcompat.app.AppCompatActivity
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

        val vibrator = getSystemService(Vibrator::class.java)

        binding.vibrationClickButton.setOnClickListener {
            val effect = VibrationEffect.createPredefined(EFFECT_CLICK)
            vibrator.vibrate(effect)
        }

        binding.vibrationDoubleClickButton.setOnClickListener {
            val effect = VibrationEffect.createPredefined(EFFECT_DOUBLE_CLICK)
            vibrator.vibrate(effect)
        }

        binding.vibrationCustom.setOnClickListener {
            val effect = VibrationEffect.createWaveform(longArrayOf(3, 150, 3), intArrayOf(DEFAULT_AMPLITUDE, 0, DEFAULT_AMPLITUDE), -1)
            vibrator.vibrate(effect)
        }
    }
}