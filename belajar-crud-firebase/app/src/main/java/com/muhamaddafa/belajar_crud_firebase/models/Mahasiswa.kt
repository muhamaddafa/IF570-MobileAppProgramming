package com.muhamaddafa.belajar_crud_firebase.models

class Mahasiswa {
    var key: String? = null
    var nim: String? = null
    var nama: String? = null

    constructor()

    constructor(key: String?, nim: String?, nama: String?) {
        this.key = key
        this.nim = nim
        this.nama = nama
    }
}