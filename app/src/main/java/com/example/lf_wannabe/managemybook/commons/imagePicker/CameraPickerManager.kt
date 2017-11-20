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
class CameraPickerManager(ac: Activity): PickerManager(ac){
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
}