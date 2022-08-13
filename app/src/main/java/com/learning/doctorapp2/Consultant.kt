package com.learning.doctorapp2

class Consultant(var iD: String, var name: String, var status: Status, var speciality: Speciality, var imageId: Int) {
    override fun toString(): String {
        return "Consultant $name specialist in $speciality"
    }
}