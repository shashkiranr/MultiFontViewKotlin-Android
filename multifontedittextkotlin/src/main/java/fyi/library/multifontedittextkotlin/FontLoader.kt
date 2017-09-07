package fyi.library.multifontedittextkotlin


import android.content.Context
import android.graphics.Typeface

import java.util.HashMap

/*
This font loader class is obtained from Future Studio - "Custom Fonts on Android — Extending TextView"
for more info please visit https://futurestud.io
*
* */
object FontLoader {
    private val fontMapCache = HashMap<String, Typeface>()

    fun getTypeface(context: Context, fontname: String): Typeface? {
        var typeface: Typeface? = fontMapCache[fontname]

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, "fonts/" + fontname)
            } catch (e: Exception) {
                return null
            }

            fontMapCache.put(fontname, typeface)
        }

        return typeface
    }
}
