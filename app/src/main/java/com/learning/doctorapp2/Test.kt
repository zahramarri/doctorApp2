package com.learning.doctorapp2

object Test {
    val consultant1: Consultant = Consultant("d001", "Rose Kennedy",
        Status.Offline, Speciality.ClinicalPsychologists, R.drawable.rose_doctor)

    val consultant2: Consultant = Consultant("d002", "James Johnson",
        Status.Offline, Speciality.DevelopmentalPsychologists, R.drawable.james_doctor)

    val consultant3: Consultant = Consultant("d003", "Robert Smith",
        Status.Offline, Speciality.EducationalPsychologists, R.drawable.robert_doctor)

    val consultancy1: Consultancy = Consultancy("c001", 10, Mode.OnlineVideoCall)
    val consultancy2: Consultancy = Consultancy("c002", 30, Mode.OnlineVoiceCall)
    val consultancy3: Consultancy = Consultancy("c003", 60, Mode.OnlineVideoCall)
}
