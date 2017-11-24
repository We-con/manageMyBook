package com.wecon.lf_wannabe.walkonnovel.model

import android.os.Parcel
import com.wecon.lf_wannabe.walkonnovel.commons.RealmListParcelConverter
import org.parceler.Parcels

class PostListParcelConverter : RealmListParcelConverter<Post>() {
    override fun itemFromParcel(parcel: Parcel?): Post =
            Parcels.unwrap(parcel?.readParcelable(Post::class.java.classLoader))


    override fun itemToParcel(input: Post?, parcel: Parcel?) {
        parcel?.writeParcelable(Parcels.wrap(input), 0)
    }
}
