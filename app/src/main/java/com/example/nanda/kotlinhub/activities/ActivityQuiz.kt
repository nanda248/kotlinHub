package com.example.nanda.kotlinhub.activities

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.JSONQuizHelper
import com.example.nanda.kotlinhub.helper.QnAns

class ActivityQuiz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var quizFile = intent.getStringExtra("quizFile")

        var quizHelper = JSONQuizHelper(quizFile, this)
        var quiz: ArrayList<QnAns> = quizHelper.parse()
        var qnAns1 = quiz[0]

        displayQnAns(qnAns1)

        var ans = qnAns1.getAns()

        var index = 1
        var max = quiz.size


        val correctBuilder = AlertDialog.Builder(this@ActivityQuiz)
        correctBuilder.setTitle("You are correct!")
        correctBuilder.setPositiveButton("NEXT"){dialog, which ->
            if(index<max){
                //radio_group.clearCheck()
                ans = quiz[index].getAns()
                displayQnAns(quiz[index])
                 //assign new value to ans variable
                index++

            }else{
                finish()
            }
        }
        val correctDialog: AlertDialog = correctBuilder.create()

        val radio_group = findViewById<RadioGroup>(R.id.options)
        radio_group.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->
                    val selected: RadioButton = findViewById<RadioButton>(checkedId)

                    if(checkedId == R.id.rb_A){
                        if(ans.equals("A")){
                            correctDialog.show()
                        }else{
                            val wrongBuilder = AlertDialog.Builder(this@ActivityQuiz)
                            wrongBuilder.setTitle("Correct solution: " + ans)
                            wrongBuilder.setPositiveButton("NEXT"){dialog, which ->
                                if(index<max){
                                    ans = quiz[index].getAns()
                                    displayQnAns(quiz[index])
                                    index++

                                }else{
                                    finish()
                                }
                            }
                            val wrongDialog: AlertDialog = wrongBuilder.create()
                            wrongDialog.show()
                        }
                    }

                    if(checkedId == R.id.rb_B){
                        if(ans.equals("B")){
                            correctDialog.show()
                        }else{
                            val wrongBuilder = AlertDialog.Builder(this@ActivityQuiz)
                            wrongBuilder.setTitle("Correct solution: " + ans)
                            wrongBuilder.setPositiveButton("NEXT"){dialog, which ->
                                if(index<max){
                                    ans = quiz[index].getAns()
                                    displayQnAns(quiz[index])
                                    index++

                                }else{
                                    finish()
                                }
                            }
                            val wrongDialog: AlertDialog = wrongBuilder.create()
                            wrongDialog.show()
                        }
                    }

                    if(checkedId == R.id.rb_C){
                        if(ans.equals("C")){
                            correctDialog.show()
                        }else{
                            val wrongBuilder = AlertDialog.Builder(this@ActivityQuiz)
                            wrongBuilder.setTitle("Correct solution: " + ans)
                            wrongBuilder.setPositiveButton("NEXT"){dialog, which ->
                                if(index<max){
                                    ans = quiz[index].getAns()
                                    displayQnAns(quiz[index])
                                    index++

                                }else{
                                    finish()
                                }
                            }
                            val wrongDialog: AlertDialog = wrongBuilder.create()
                            wrongDialog.show()
                        }
                    }

                    if(checkedId == R.id.rb_D){
                        if(ans.equals("D")){
                            correctDialog.show()
                        }else{
                            val wrongBuilder = AlertDialog.Builder(this@ActivityQuiz)
                            wrongBuilder.setTitle("Correct solution: " + ans)
                            wrongBuilder.setPositiveButton("NEXT"){dialog, which ->
                                if(index<max){
                                    ans = quiz[index].getAns()
                                    displayQnAns(quiz[index])
                                    index++

                                }else{
                                    finish()
                                }
                            }
                            val wrongDialog: AlertDialog = wrongBuilder.create()
                            wrongDialog.show()
                        }
                    }

                    selected.isChecked = false

                })


    }

    private fun displayQnAns(qnAns: QnAns){

        val qn = qnAns.getQn()
        val code = qnAns.getCode()
        val optA = qnAns.getOptA()
        val optB = qnAns.getOptB()
        val optC = qnAns.getOptC()
        val optD = qnAns.getOptD()

        val tv_qn = findViewById<TextView>(R.id.tv_question)
        tv_qn.text = qn

        if(code.size>0) {
            var codeString = ""
            for (j in 0 until code.size-1) {
                codeString += "   "
                codeString = codeString + code[j] + "\n"
            }
            codeString = codeString + "   " + code[code.size-1]
            val tvCode = findViewById<TextView>(R.id.tv_code)
            tvCode.text = codeString
            tvCode.setBackgroundResource(R.drawable.code_border)
        }

        val rbA = findViewById<RadioButton>(R.id.rb_A)
        rbA.text = optA

        val rbB = findViewById<RadioButton>(R.id.rb_B)
        rbB.text = optB

        val rbC = findViewById<RadioButton>(R.id.rb_C)
        rbC.text = optC

        val rbD = findViewById<RadioButton>(R.id.rb_D)
        rbD.text = optD

    }

}
