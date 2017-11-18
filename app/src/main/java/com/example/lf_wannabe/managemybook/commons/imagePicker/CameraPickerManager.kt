package com.example.lf_wannabe.managemybook.commons.imagePicker

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import com.tedpark.tedpermission.rx2.TedRx2Permission
import java.io.File
import java.io.IOException
import android.support.v4.content.FileProvider



/**
 * Created by lf_wannabe on 17/11/2017.
 */
class CameraPickerManager(var ac: Activity): PickerManager(ac){
    override fun sendToExternalApp() {
        Log.d("MIM", "sendToExternalApp")
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        var photoFile: File? = null
        try {
            photoFile = createImageFile()
        } catch (e: IOException){
            Log.e("MIM", "FileCreate Error")
        }

        val providerURI: Uri = FileProvider.getUriForFile(ac.applicationContext, ac.packageName, photoFile)
        mProcessingPhotoUri = providerURI

        intent.putExtra(MediaStore.EXTRA_OUTPUT, mProcessingPhotoUri)
        ac.startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
    }

    @Throws(IOException::class)
    private fun createImageFile(): File{
        var imageFileName = "tmp.jpg"
        var tmpFilePath = "${Environment.getExternalStorageDirectory().absolutePath}/${appName}"
        //TODO: 파일명 나중에 수정
        var storageDir = File(tmpFilePath)

        if (!storageDir.exists()) {
            Log.i("mCurrentPhotoPath1", storageDir.toString())
            storageDir.mkdirs()
        }

        var finalPhotoName = File("${tmpFilePath}/${imageFileName}")


        return finalPhotoName
    }

    override fun checkPermission(): Boolean {
        TedRx2Permission.with(ac.applicationContext)
                .setRationaleTitle("퍼미션 체크")
                .setRationaleMessage("카메라 퍼미션이 필요합니다.")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .request()
                .subscribe { tedPermissionResult ->
                if (tedPermissionResult.isGranted) {
                    Toast.makeText(ac.applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
                }  else {
                    Toast.makeText(ac.applicationContext,
                            "Permission Denied\n" + tedPermissionResult.getDeniedPermissions().toString(), Toast.LENGTH_SHORT)
                            .show()
                }
        }

        return (ContextCompat.checkSelfPermission(ac, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED)

    }

}