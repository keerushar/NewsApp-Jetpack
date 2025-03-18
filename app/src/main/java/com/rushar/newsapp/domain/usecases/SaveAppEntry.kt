package com.rushar.newsapp.domain.usecases

import com.rushar.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}