package com.example.instagramclone.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.instagramclone.R
import com.example.instagramclone.databinding.IntagramPostBinding


class InstagramPost @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(
    context, attrs
) {
    private var binding: IntagramPostBinding = IntagramPostBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    }
