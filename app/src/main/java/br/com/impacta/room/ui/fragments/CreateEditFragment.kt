package br.com.impacta.room.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.impacta.room.R
import br.com.impacta.room.databinding.FragmentCreateEditBinding


class CreateEditFragment : Fragment() {

    private var _binding: FragmentCreateEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

}