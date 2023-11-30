package com.example.shoplist.domain

import javax.inject.Inject

class EditShopItem @Inject constructor(private val shopListRepository: ShopListRepository) {
    suspend fun edit(shopItem: ShopItem){
        return shopListRepository.edit(shopItem)
    }
}