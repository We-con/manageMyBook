package com.example.lf_wannabe.managemybook.commons.imagePicker

import android.app.Activity
import android.net.Uri
import android.os.Build
import android.util.Log
import com.example.lf_wannabe.managemybook.R

/**
 * Created by lf_wannabe on 17/11/2017.
 */

abstract class PickerManager(ac: Activity){
    companion object {
        val REQUEST_CODE_SELECT_IMAGE      = 200
        val REQUEST_CODE_IMAGE_PERMISSION  = 201
        val REQUEST_CODE_CAMERA_PERMISSION = 202
    }

    protected lateinit var appName: String
    protected lateinit var mProcessingPhotoUri: Uri
    protected lateinit var imageReceivedListener: onImageReceivedListener
    protected lateinit var permissionRefusedListener: onPermissionRefusedListener

    init {
        appName = ac.getString(R.string.app_name)
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
        var isAllowed =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) checkPermission() else true

        if (isAllowed) {
            Log.d("MIM", "pickPhotoWithPermission")
            sendToExternalApp()
        }
    }

    //TODO : 추후 수정
    fun handleCropResult(){
        imageReceivedListener.onImageReceived(mProcessingPhotoUri)
    }

    protected abstract fun sendToExternalApp()

    protected abstract fun checkPermission(): Boolean
}