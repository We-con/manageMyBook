package com.wecon.lf_wannabe.walkonnovel.util

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
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

        // custom
        fun customA(text: String, num: Int): SpannableStringBuilder {
            return SpannableStringBuilder().apply {
                append(changeSize("이 책은 ", 25))
                append(changeSize(text, 40))
                append(changeSize(" 에 시작되었어요\n", 25))
                append(changeSize("현재까지 등록된 포스트는 ", 25))
                append(changeSize(num.toString(), 40))
                append(changeSize(" 개 입니다", 25))
            }
        }

    }

}