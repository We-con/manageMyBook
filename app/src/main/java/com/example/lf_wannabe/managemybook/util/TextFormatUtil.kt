package com.example.lf_wannabe.managemybook.util

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan

/**
 * Created by mangob on 2017. 11. 8..
 */
class TextFormatUtil() {

    companion object {

        fun changeColor(text: SpannableString, color: Int): SpannableString {
            var ss = SpannableString(text)
            ss.setSpan(ForegroundColorSpan(color),
                    0,
                    text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return ss
        }

        fun changeColor(text: String, color: Int): SpannableString {
            var ss = SpannableString(text)
            ss.setSpan(ForegroundColorSpan(color),
                    0,
                    text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return ss
        }

        fun changeSize(text: SpannableString, dp: Int): SpannableString {
            var ss = SpannableString(text)
            ss.setSpan(AbsoluteSizeSpan(dp, true),
                    0,
                    text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return ss
        }

        fun changeSize(text: String, dp: Int): SpannableString {
            var ss = SpannableString(text)
            ss.setSpan(AbsoluteSizeSpan(dp, true),
                    0,
                    text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return ss
        }

        fun changeStyle(text: SpannableString, flag: Int): SpannableString {
            var ss = SpannableString(text)
            when(flag) {
                0 ->  ss.setSpan(StyleSpan(Typeface.BOLD),
                        0,
                        text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
                1 -> ss.setSpan(StyleSpan(android.graphics.Typeface.ITALIC),
                        0,
                        text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
                2 ->  ss.setSpan(StyleSpan(android.graphics.Typeface.BOLD_ITALIC),
                        0,
                        text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
            }
            return ss
        }

        fun changeStyle(text: String, flag: Int): SpannableString {
            var ss = SpannableString(text)
            when(flag) {
                0 ->  ss.setSpan(StyleSpan(Typeface.BOLD),
                        0,
                        text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
                1 -> ss.setSpan(StyleSpan(android.graphics.Typeface.ITALIC),
                        0,
                        text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
                2 ->  ss.setSpan(StyleSpan(android.graphics.Typeface.BOLD_ITALIC),
                        0,
                        text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
            }
            return ss
        }

        fun changeUnderline(text: SpannableString): SpannableString {
            var ss = SpannableString(text)
            ss.setSpan(UnderlineSpan(),
                    0,
                    text.length,
                    0
            )

            return ss
        }

        fun changeUnderline(text: String): SpannableString {
            var ss = SpannableString(text)
            ss.setSpan(UnderlineSpan(),
                    0,
                    text.length,
                    0
            )

            return ss
        }

    }

}