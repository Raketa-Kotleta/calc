package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var firstVal: String = ""
    lateinit var operation: ((Double, Double) -> String)
    var valSign: Int = 1;
    lateinit var firstVal_textview:TextView
    lateinit var operation_textview:TextView
    lateinit var secondVal_textview:TextView
    lateinit var result_textview:TextView
    var secondVal: String = ""
    var ButtonMap: Map<String, Button>? = null;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstVal_textview = findViewById(R.id.text_firstval)
        operation_textview = findViewById(R.id.text_operation)
        secondVal_textview = findViewById(R.id.text_secondval)
        result_textview = findViewById(R.id.text_result)
        var buttons: Array<Button> = arrayOf(
            findViewById(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
            findViewById(R.id.button_plus),
            findViewById(R.id.button_minus),
            findViewById(R.id.button_cross),
            findViewById(R.id.button_divide),
            findViewById(R.id.button_equal),
            findViewById(R.id.button_clear)
        )
        ButtonMap = mapOf(
            "0" to buttons[0],
            "1" to buttons[1],
            "2" to buttons[2],
            "3" to buttons[3],
            "4" to buttons[4],
            "5" to buttons[5],
            "6" to buttons[6],
            "7" to buttons[7],
            "8" to buttons[8],
            "9" to buttons[9],
            "plus" to buttons[10],
            "minus" to buttons[11],
            "cross" to buttons[12],
            "divide" to buttons[13],
            "equal" to buttons[14],
            "clear" to buttons[15],
        )

        ButtonMap!!["plus"]?.setOnClickListener{
            plusButtonOnClick()
        }
        ButtonMap!!["minus"]?.setOnClickListener{
            minusButtonOnClick()
        }
        ButtonMap!!["cross"]?.setOnClickListener{
            crossButtonOnClick()
        }
        ButtonMap!!["divide"]?.setOnClickListener{
            divideButtonOnClick()
        }
        ButtonMap!!["0"]?.setOnClickListener{
            inputValues('0')
        }
        ButtonMap!!["1"]?.setOnClickListener{
            inputValues('1')
        }
        ButtonMap!!["2"]?.setOnClickListener{
            inputValues('2')
        }
        ButtonMap!!["3"]?.setOnClickListener{
            inputValues('3')
        }
        ButtonMap!!["4"]?.setOnClickListener{
            inputValues('4')
        }
        ButtonMap!!["5"]?.setOnClickListener{
            inputValues('5')
        }
        ButtonMap!!["6"]?.setOnClickListener{
            inputValues('6')
        }
        ButtonMap!!["7"]?.setOnClickListener{
            inputValues('0')
        }
        ButtonMap!!["8"]?.setOnClickListener{
            inputValues('0')
        }
        ButtonMap!!["9"]?.setOnClickListener{
            inputValues('0')
        }

    }
    fun getResult():Unit{
        if (operation != null && firstVal.isNotEmpty() && secondVal.isNotEmpty()){
            result_textview.text = operation(firstVal.toDouble(),secondVal.toDouble())
        }
    }
    fun clearValues():Unit{
        firstVal_textview.text = ""
        secondVal_textview.text = ""
        operation_textview.text = ""
        result_textview.text = ""
    }
    fun inputValues(char: Char):Unit{
        if (operation == null){
            firstVal_textview.text = firstVal_textview.text.toString() + char.toString();
            firstVal = firstVal_textview.text.toString();
        }
        else {
            secondVal_textview.text = secondVal_textview.text.toString() + char.toString()
            secondVal = secondVal_textview.text.toString()
        }
    }
    fun plusButtonOnClick():Unit{
        if (firstVal.isEmpty())
            valSign = 1;
        else
            operation = fun(firstTerm: Double, secondTerm: Double): String{
                return (firstTerm + secondTerm).toString()
            }
    }
    fun minusButtonOnClick():Unit{
        if (firstVal.isEmpty()){
            valSign = -1
        }
        else{
            operation = fun(minuend: Double, subtrahend: Double): String{
                return (minuend-subtrahend).toString()
            }
        }
    }
    fun crossButtonOnClick():Unit{
       if (firstVal_textview.text.isNotEmpty()){
           operation_textview.text = "x"
           operation = fun(factorFirst: Double, factorSecond: Double): String{
               return (factorFirst*factorSecond).toString()
           }
       }
    }
    fun divideButtonOnClick():Unit{
        if (firstVal_textview.text.isNotEmpty()){
            operation = fun(dividend: Double, divider: Double): String{
                if (divider == 0.0) return "Infinity"
                return  (dividend/divider).toString()
            }
        }
    }

}