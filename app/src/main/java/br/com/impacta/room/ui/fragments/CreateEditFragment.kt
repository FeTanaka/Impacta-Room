package br.com.impacta.room.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.impacta.room.R
import br.com.impacta.room.data.models.Comida
import br.com.impacta.room.databinding.FragmentCreateEditBinding
import br.com.impacta.room.ui.activities.MainActivity
import br.com.impacta.room.ui.viewModels.HomeViewModel
import br.com.impacta.room.ui.viewModels.HomeViewModelFactory


class CreateEditFragment : Fragment() {

    private var _binding: FragmentCreateEditBinding? = null
    private val binding get() = _binding!!
    private val args: CreateEditFragmentArgs by navArgs()
    private val viewModel: HomeViewModel by activityViewModels {
        HomeViewModelFactory((activity as MainActivity).db)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.comidaId == -1) {
            binding.button2.visibility = View.GONE

            binding.button.setOnClickListener {
                var comida = Comida(
                    id = 2,
                    nomeComida = binding.editTextTextPersonName.text.toString(),
                    origem = binding.editTextTextPersonName2.text.toString(),
                    calorias = binding.editTextTextPersonName3.text.toString().toInt(),
                    tipo = binding.editTextTextPersonName4.text.toString(),
                )

                viewModel.criarComida(comida)

                val action = CreateEditFragmentDirections.actionCreateEditFragmentToHomeFragment()
                findNavController().navigate(action)
            }
        } else {
            var comida: Comida? = null
            viewModel.comida.observe(viewLifecycleOwner) { it ->
                it?.let { comidaLiveData ->
                    comida = comidaLiveData
                    binding.comida = comidaLiveData
                }
            }
            viewModel.recuperaComida(args.comidaId)

            binding.button.setOnClickListener {
                comida?.let {
                    it.nomeComida = binding.editTextTextPersonName.text.toString()
                    it.origem = binding.editTextTextPersonName2.text.toString()
                    it.calorias = binding.editTextTextPersonName3.text.toString().toInt()
                    it.tipo = binding.editTextTextPersonName4.text.toString()

                    viewModel.atualizaComida(it)

                    val action = CreateEditFragmentDirections.actionCreateEditFragmentToHomeFragment()
                    findNavController().navigate(action)
                }
            }

            binding.button2.setOnClickListener {
                comida?.let{
                    viewModel.deletaComida(it)

                    val action = CreateEditFragmentDirections.actionCreateEditFragmentToHomeFragment()
                    findNavController().navigate(action)
                }
            }
        }
    }

}