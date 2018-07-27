package pro.xp.com.activepermissions;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import pro.xp.com.activepermissionslib.PermissionsActivity;
import pro.xp.com.activepermissionslib.PermissionsCheckerUtil;

public class MainActivity2 extends Activity {
    /**
     * 请求码
     */
    private static final int REQUEST_CODE = 0;
    /**
     * 权限检测器
     */
    private PermissionsCheckerUtil mPermissionsChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPermissionsChecker = new PermissionsCheckerUtil(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }

    @Override
    protected void onResume() {
        // 缺少权限时, 进入权限配置页面
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
        }
        super.onResume();
    }

    /**
     * 所需的全部权限
     */
    public static final String[] PERMISSIONS = new String[]{
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.ACCESS_COARSE_LOCATION,
//            Manifest.permission.READ_PHONE_STATE,
//            Manifest.permission.CALL_PHONE,
            Manifest.permission.CAMERA,
//            Manifest.permission.RECORD_AUDIO,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_EXTERNAL_STORAGE
    };
}
