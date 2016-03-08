package kr.co.company.boundservice;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalService extends Service {

	// Ŭ���̾�Ʈ���� ��ȯ�Ǵ� ���δ�
    private final IBinder mBinder = new LocalBinder();
    // ���� �߻���
    private final Random mGenerator = new Random();

    // Ŭ���̾�Ʈ ���δ��� ���� Ŭ���� 
    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // Ŭ���̾�Ʈ�� ���� �޼ҵ� 
    public int getRandomNumber() {
      return mGenerator.nextInt(100);
    }
}