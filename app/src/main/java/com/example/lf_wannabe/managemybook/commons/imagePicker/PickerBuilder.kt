package com.example.lf_wannabe.managemybook.commons.imagePicker

import android.app.Activity

/**
 * Created by lf_wannabe on 17/11/2017.
 */
class PickerBuilder(var ac: Activity, type: Int) {
    companion object {
        val SELECT_FROM_GALLERY = 0
        val SELECT_FROM_CAMERA  = 1

        //TODO: Singleton 으로 만들어볼것
        lateinit var pickerInstance: PickerManager
//
//        fun getPickerInstance() = pickerInstance
    }
    init {
        pickerInstance = if(type == SELECT_FROM_GALLERY) GalaryPickerManager(ac) else CameraPickerManager(ac)
    }



    fun setOnImageReceivedListener(listener: PickerManager.onImageReceivedListener): PickerBuilder{
        pickerInstance.setOnImageReceivedListener(listener)
        return this
    }

    fun start(){
        pickerInstance.pickPhotoWithPermission()
    }
    fun apply(){
        pickerInstance.handleCropResult()
    }

}