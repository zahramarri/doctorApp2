package com.learning.doctorapp2

object Test {
    val consultant1: Consultant = Consultant("d001", "Rose Kennedy",
        Status.Online, Speciality.ClinicalPsychologists, R.drawable.rose_doctor)

    val consultant2: Consultant = Consultant("d002", "James Johnson",
        Status.Online, Speciality.DevelopmentalPsychologists, R.drawable.james_doctor)

    val consultant3: Consultant = Consultant("d003", "Robert Smith",
        Status.Offline, Speciality.EducationalPsychologists, R.drawable.robert_doctor)

    val consultantsList = mutableListOf(consultant1, consultant2, consultant3)

    val consultancy1: Consultancy = Consultancy("c001", 10, Mode.OnlineVoiceCall)
    val consultancy2: Consultancy = Consultancy("c002", 30, Mode.OnlineVoiceCall)
    val consultancy3: Consultancy = Consultancy("c003", 60, Mode.OnlineVoiceCall)

    fun getConsultant(id: String?): Consultant? {
        var consultantWanted: Consultant? = null
        for (consultant in consultantsList) {
            if(consultant.iD == id) {
                consultantWanted = consultant
            }
        }
        return consultantWanted
    }
}
