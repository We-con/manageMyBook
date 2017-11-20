package com.wecon.lf_wannabe.walkonnovel.commons

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.RequestManager
import io.realm.RealmObject

/**
 * Created by lf_wannabe on 08/11/2017.
 */
abstract class BaseViewHolder<T: RealmObject>(itemView: View) : RecyclerView.ViewHolder(itemView){

    abstract fun onBind(glide: RequestManager, item: T?)

}
