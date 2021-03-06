package com.example.simplequiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.simplequiz.databinding.FragmentCorrectAnswerBinding
import com.example.simplequiz.databinding.FragmentWrongAnswerBinding
import kotlinx.android.synthetic.main.fragment_wrong_answer.*


/**
 * A simple [Fragment] subclass.
 */
class QuizLostFragment : Fragment() {

    lateinit var binding: FragmentWrongAnswerBinding
    var earnedScore:String = ""
    var wrongAnswerText:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_wrong_answer,container,false)
        binding.btnTryAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizLostFragment_to_titleFragment)
        }
        binding.quizlost = this
        return binding.root
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let{
            val args = QuizWonFragmentArgs.fromBundle(it)
            earnedScore = args.score.toString()
            if (args.wrongAnswers.isNotEmpty()){
                yourwronganswer.visibility = View.VISIBLE
                txt_wrong_answer.visibility = View.VISIBLE

                for (ans in args.wrongAnswers){
                    wrongAnswerText = wrongAnswerText + ans + "\n"
                }
            }
        }
    }
}

