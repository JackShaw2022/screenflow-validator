package com.example.screenflow_validation_using_variables
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.screenflow_validation_using_variables.databinding.FragmentEmailFormBinding

// Import androidx fragment
class EmailFormFragment: Fragment() {

    // Let the binding be nullable
    private var _binding: FragmentEmailFormBinding? = null

    // !! Assert the binding is non-null for certain, but be careful about an NPE (null pointer exception)
    private val binding: FragmentEmailFormBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            emailEt.editText?.addTextChangedListener { text ->
                Log.d(NameFormFragment.TAG, text.toString())

                nextBtn.isEnabled = text.toString().length > 8
            }

            nextBtn.setOnClickListener {
                Log.d(NameFormFragment.TAG, "nexBtn Clicked")
                // Create bundle to pass data in fragment transaction.
                val email = emailEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString("Email", email)

                Log.d(NameFormFragment.TAG, "email is $email")

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
