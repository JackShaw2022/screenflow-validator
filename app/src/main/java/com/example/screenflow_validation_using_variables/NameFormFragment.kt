package com.example.screenflow_validation_using_variables

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.screenflow_validation_using_variables.databinding.FragmentFormBinding

// Import androidx fragment
class NameFormFragment : Fragment() {

    // ? after type means nullable
    private var _binding: FragmentFormBinding? = null

    // !! asserting non null, don't do too often can cause NPE(null pointer exception)
    private val binding: FragmentFormBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            firstNameEt.editText?.addTextChangedListener { text ->
                Log.d(TAG, text.toString())

                nextBtn.isEnabled = text.toString().length > 8
            }

            nextBtn.setOnClickListener {
                Log.d(TAG, "nexBtn Clicked")
                // Create bundle to pass data in fragment transaction.
                val firstName = firstNameEt.editText?.text.toString()
                val lastName = lastNameEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString("First", firstName)
                bundle.putString("Last", lastName)

                Log.d(TAG, "firstName is $firstName, last name is $lastName")

                // FragmentManger allows us to perform transaction.
                // Use replace to switch between fragments.
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, NameInfoFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    // Set binding to null to release resource for garbage collection.
    // Only in fragments.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val TAG = NameFormFragment::class.java.name
    }
}