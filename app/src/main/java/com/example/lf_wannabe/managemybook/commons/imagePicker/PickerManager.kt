package com.example.lf_wannabe.managemybook.commons.imagePicker

import android.Manifest
import android.app.Activity
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.support.v4.content.FileProvider
import android.util.Log
import android.widget.Toast
import com.example.lf_wannabe.managemybook.R
import com.tedpark.tedpermission.rx2.TedRx2Permission
import com.yalantis.ucrop.UCrop
import java.io.File
import java.io.IOException

/**
 * Created by lf_wannabe on 17/11/2017.
 */

abstract class PickerManager(var ac: Activity){
    companion object {
        val REQUEST_CODE_SELECT_IMAGE      = 200
        val REQUEST_CODE_IMAGE_PERMISSION  = 201
        val REQUEST_CODE_CAMERA_PERMISSION = 202
    }

    lateinit var mProcessingPhotoUri: Uri
    var tmpFilePath: String
    var tmpImageFile: String
    var cropedTmpImageFileUri: Uri
    var cropedTmpImageFileContentUri: Uri

    protected lateinit var appName: String
    protected lateinit var imageReceivedListener: onImageReceivedListener
    protected lateinit var permissionRefusedListener: onPermissionRefusedListener

    init {
        appName = ac.getString(R.string.app_name)
        tmpFilePath = "${Environment.getExternalStorageDirectory().absolutePath}/${appName}"
        tmpImageFile = "${tmpFilePath}/tmp.jpg"
        cropedTmpImageFileUri = Uri.fromFile(File("${tmpFilePath}/croped.jpg"))

        cropedTmpImageFileContentUri = FileProvider.getUriForFile(ac.applicationContext,
                ac.packageName,
                File("${tmpFilePath}/croped.jpg"))
    }

    interface onPermissionRefusedListener {
        fun onPermissionRefused()
    }

    interface onImageReceivedListener {
        fun onImageReceived(imageUri: Uri)
    }

    fun setOnImageReceivedListener(listener: onImageReceivedListener){
        imageReceivedListener = listener
    }

    fun setOnImageReceivedListener(listener: onPermissionRefusedListener){
        permissionRefusedListener = listener
    }

    fun pickPhotoWithPermission(){

        TedRx2Permission.with(ac.applicationContext)
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .request()
                .subscribe { tedPermissionResult ->
                    if (tedPermissionResult.isGranted) {
                        sendToExternalApp()
                    }  else {
                        Toast.makeText(ac.applicationContext,
                                "Permission Denied\n", Toast.LENGTH_SHORT)
                                .show()
                    }
                }
    }

    @Throws(IOException::class)
    protected fun createImageFile(): File {
        var storageDir = File(tmpFilePath)

        if (!storageDir.exists()) {
            Log.i("mCurrentPhotoPath1", storageDir.toString())
            storageDir.mkdirs()
        }

        return File(tmpImageFile)
    }


    fun  startCropActivity(){
        // FileProvider 관련 한참 삽질
        // 좀더 공부해야할 듯 ㅠㅠ
        Log.d("mim", "src : ${mProcessingPhotoUri} // des : ${cropedTmpImageFileUri}")
        UCrop.of(mProcessingPhotoUri, cropedTmpImageFileUri)
                .withAspectRatio(1f, 1f)
                .start(ac)
    }

    //TODO : 추후 수정
    fun handleCropResult(){
        imageReceivedListener.onImageReceived(cropedTmpImageFileUri)
    }

    protected abstract fun sendToExternalApp()
}