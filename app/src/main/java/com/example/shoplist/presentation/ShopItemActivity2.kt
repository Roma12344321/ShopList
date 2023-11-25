package com.example.shoplist.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoplist.R
import com.example.shoplist.domain.ShopItem

class ShopItemActivity2 : AppCompatActivity() {

    private var screenMode = UNKNOWN
    private var shopItemId = ShopItem.UNDEF_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item2)
        parseIntent()
        if (savedInstanceState == null) {
            val fragment = when (screenMode) {
                MODE_EDIT -> ShopItemFragment.newInstanceEditItem(shopItemId)
                MODE_ADD -> ShopItemFragment.newInstanceAddItem()
                else -> throw RuntimeException("Unknown")
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.shop_item_container, fragment)
                .commit()
        }
    }

    private fun parseIntent() {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw RuntimeException("Param screen mode is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT && !intent.hasExtra(EXTRA_ID)) {
            throw RuntimeException("ID is absent")
        }
        if (screenMode == MODE_EDIT) {
            shopItemId = intent.getIntExtra(EXTRA_ID, ShopItem.UNDEF_ID)
        }
    }

    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val MODE_EDIT = "mode_edit"
        private const val MODE_ADD = "mode_add"
        private const val EXTRA_ID = "extra_shop_item_id"
        private const val UNKNOWN = ""

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity2::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, id: Int): Intent {
            val intent = Intent(context, ShopItemActivity2::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_ID, id)
            return intent
        }
    }
}