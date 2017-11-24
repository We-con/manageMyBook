package com.wecon.lf_wannabe.walkonnovel.commons

import io.realm.RealmList
import org.parceler.converter.CollectionParcelConverter
import io.realm.RealmObject


abstract class RealmListParcelConverter<T : RealmObject> : CollectionParcelConverter<T, RealmList<T>>() {
    override fun createCollection(): RealmList<T> = RealmList()
}
