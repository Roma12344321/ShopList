package com.example.shoplist.domain

class EditShopItem(private val shopListRepository: ShopListRepository) {
    suspend fun edit(shopItem: ShopItem){
        return shopListRepository.edit(shopItem)
    }
}