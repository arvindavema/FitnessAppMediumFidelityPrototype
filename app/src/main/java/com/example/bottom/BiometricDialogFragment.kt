package com.example.bottom

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

/**
 * A simple [Fragment] subclass.
 * Use the [BiometricDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BiometricDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val alertDialogBuilder = AlertDialog.Builder(it)
            val inflater= requireActivity().layoutInflater

            alertDialogBuilder.setView(inflater.inflate(R.layout.fragment_biometric_dialog,null ))
                .setPositiveButton(R.string.submit,
                DialogInterface.OnClickListener{ _, _ ->
                    Toast.makeText(context,"Submit", Toast.LENGTH_SHORT).show()

                })
                .setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener{ _, _ ->
                    Toast.makeText(context,"cancel", Toast.LENGTH_SHORT).show()
                    dialog?.cancel()
                })

            alertDialogBuilder.create()
        } ?: throw IllegalStateException("BIOMETRIC DIOLOG")

    }

}