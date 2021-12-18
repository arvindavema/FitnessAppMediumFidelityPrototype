package com.example.bottom

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
/**
 * A simple [Fragment] subclass.
 * Use the [DietDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DietDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)

            val inflater  = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.fragment_diet_dialog, null))
                .setPositiveButton(R.string.submit,
                DialogInterface.OnClickListener{ dialog, which->
                    Toast.makeText(context, "Succesfully updated your diet data", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener{ dialog, which->
                    Toast.makeText(context, "Update Cancelled", Toast.LENGTH_SHORT).show()
                    getDialog()?.cancel()
                })
            builder.create()
        } ?: throw IllegalStateException("DIET")
    }
}