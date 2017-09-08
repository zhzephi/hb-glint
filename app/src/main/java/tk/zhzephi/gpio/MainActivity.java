package tk.zhzephi.gpio;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;

import java.io.IOException;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String GPIO_NAME = "BCM6";

    Handler handler = new Handler();
    Gpio gpio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLedStrip();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyLedStrip();
    }

    private void setupLedStrip() {
        try {
            Log.d(TAG, "Initializing LED strip");
            PeripheralManagerService managerService = new PeripheralManagerService();
            gpio = managerService.openGpio(GPIO_NAME);
            gpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            Log.d(TAG, "Start GPIO");
            handler.postDelayed(runnable, 1000l);
        } catch (IOException e) {
            Log.e(TAG, "Error initializing LED strip", e);
        }
    }

    private void destroyLedStrip() {
        if (gpio != null) {
            try {
                gpio.close();
            } catch (IOException e) {
                Log.e(TAG, "Exception closing LED strip", e);
            } finally {
                gpio = null;
            }
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (gpio == null) {
                return;
            }
            try {
                //闪灯一次
                gpio.setValue(true);
                Thread.sleep(200l);
                gpio.setValue(false);
                //等待一秒
                Thread.sleep(1000l);
                //连闪两次
                gpio.setValue(true);
                Thread.sleep(500l);
                gpio.setValue(false);
                Thread.sleep(300l);
                gpio.setValue(true);
                Thread.sleep(500l);
                gpio.setValue(false);
                handler.postDelayed(runnable, 1000l);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
