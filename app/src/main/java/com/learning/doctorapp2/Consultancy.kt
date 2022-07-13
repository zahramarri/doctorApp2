package com.learning.doctorapp2

class Consultancy(var iD: String, var time: Int, var mode: Mode) {
    override fun toString(): String {
        return "$time minutes of $mode consultancy"
    }
}