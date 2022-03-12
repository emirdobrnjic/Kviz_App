package com.example.kvizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*
import org.w3c.dom.Text

class KvizPitanjaActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 1
    private var mQuestiontList: ArrayList<Pitanja>? = null
    private var mSelectedOptionPosition: Int = 0

    private var mUserName : String? = null

    private var mCorrectAnswers : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestiontList = Constants.getQuestion()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }


    private fun setQuestion() {

        val question = mQuestiontList!!.get(mCurrentPosition - 1)

        defaultOptionsView()
        if(mCurrentPosition ==mQuestiontList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progress_bar.progress = mCurrentPosition
        tv_progress.text = "${mCurrentPosition}" + "/" + progress_bar.max

        tv_question.text = question!!.questions
        iv_image.setImageResource(question.Image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionTre
        tv_option_four.text = question.optionFour


    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestiontList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,Result_Activity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTTIONS,mQuestiontList?.size)
                            startActivity(intent)
                            finish()
                        }

                    }
                } else {
                    val question = mQuestiontList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnsver != mSelectedOptionPosition) {
                        answerViev(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else {
                        mCorrectAnswers++
                    }

                    answerViev(question.correctAnsver, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestiontList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "IDITE NA IDUCE PITANJE"
                    }
                    mSelectedOptionPosition = 0
                }


            }
        }
    }

    private fun answerViev(answer: Int, drawableViwe: Int) {
        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableViwe
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableViwe
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableViwe
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableViwe
                )
            }
        }


    }

    private fun selectedOptionView(
        tv: TextView,
        selectedOptionNum: Int
    ) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )


    }

}