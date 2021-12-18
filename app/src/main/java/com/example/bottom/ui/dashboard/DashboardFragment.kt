package com.example.bottom.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottom.DietDialogFragment
import com.example.bottom.ExerciseDialogFragment
import com.example.bottom.R
import com.example.bottom.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        root.findViewById<Button>(R.id.updateExerciseButton).setOnClickListener {
            val d = ExerciseDialogFragment()
            d.show(parentFragmentManager, "ExerciseDialogFragment")
        }
        root.findViewById<Button>(R.id.updateDietButton).setOnClickListener{
            val d = DietDialogFragment()
            d.show(parentFragmentManager, "DietDialogFragment")
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}