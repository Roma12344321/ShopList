package com.example.shoplist.domain

import javax.inject.Inject

class AddShopItem @Inject constructor(private val shopListRepository: ShopListRepository) {
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}