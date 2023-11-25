package com.example.shoplist.domain

class DeleteShopItem(private val shopListRepository: ShopListRepository) {
    suspend fun delete(shopItem: ShopItem){
        shopListRepository.delete(shopItem)
    }
}