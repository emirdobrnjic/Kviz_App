package com.example.kvizapp

object Constants {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTTIONS : String = "total_question"
    const val CORRECT_ANSSWERS : String = "correct_ansver"





    fun getQuestion(): ArrayList<Pitanja> {

        val questionList = ArrayList<Pitanja>()

        val que1 = Pitanja(
            1,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia", "Armenia", "Austria",
            1,
        )
        questionList.add(que1)

        val que2 = Pitanja(
            2,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_australia,
            "Njemacka", "Australija", "Spanija", "Holandija",
            2
        )
        questionList.add(que2)

        val que3 = Pitanja(
            3,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_belgium,
            "Madjarska", "Portugal", "Novi Zeland", "Belgija",
            4

        )
        questionList.add(que3)

        val que4 = Pitanja(
            4,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_brazil,
            "Kamerun", "Brazil", "Nigerija", "Banglades", 2

        )
        questionList.add(que4)

        val que5 = Pitanja(
            5,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_denmark,
            "Danska", "Holandija", "Norveska", "Svedska", 1

        )
        questionList.add(que5)

        val que6 = Pitanja(
            6,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_fiji,
            "Farska Ostrva", "Madagaskar", "Fidzi", "Island", 3
        )
        questionList.add(que6)

        val que7 = Pitanja(
            7,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_germany,
            "Njemacka", "Ukrajina", "Rusija", "Hrvatska", 1

        )
        questionList.add(que7)

        val que8 = Pitanja(
            8,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_india,
            "Andora", "Togo", "India", "Island", 3
        )
        questionList.add(que8)

        val que9 = Pitanja(
            9,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_kuwait,
            "Novi zelad", "Japan", "USA", "Kuvajt", 4
        )
        questionList.add(que9)

        val que10 = Pitanja(
            10,
            "Kojoj drzavi pripada ova zastava",
            R.drawable.ic_flag_of_new_zealand,
            "Australija", "Kanada", "Spanija", "Novi zeland", 4
        )
        questionList.add(que10
        )
        return questionList
    }


}