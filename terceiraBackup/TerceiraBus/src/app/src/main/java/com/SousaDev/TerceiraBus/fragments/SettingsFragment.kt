package com.SousaDev.TerceiraBus.fragments

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.SousaDev.TerceiraBus.R
import com.SousaDev.TerceiraBus.data.Datasource

import android.text.Html
import androidx.appcompat.app.AlertDialog



class SettingsFragment: Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings, container, false);
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val not_developed: Button = view.findViewById(R.id.button_not_developed)
        val rate: Button = view.findViewById(R.id.button_rate_app)
        val patreon: Button = view.findViewById(R.id.button_support_creator)
        val mail: TextView = view.findViewById(R.id.report_mail)
        val bus_contacts: Button = view.findViewById(R.id.button_bus_contact)
        val faqs: Button = view.findViewById(R.id.button_faq)
        val sousadev_logo: ImageView = view.findViewById(R.id.sousadev_logo)

        sousadev_logo.setOnClickListener {
            Toast.makeText(context, resources.getString(R.string.toast_link_message), Toast.LENGTH_SHORT).show()

            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://linktr.ee/sousadev_")
                    )
                )
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://linktr.ee/sousadev_")
                    )
                )
            }
        }

        faqs.setOnClickListener {
            val builder = context?.let { AlertDialog.Builder(it) }
            builder?.setTitle(getString(R.string.faq_label))
            builder?.setMessage(getString(R.string.faq1_question) + "\n\t\t" + getString(R.string.faq1_answer)
                    + "\n\n" + getString(R.string.faq2_question) + "\n\t\t" + getString(R.string.faq2_answer))
            builder?.setPositiveButton(android.R.string.yes) { dialog, which ->
            }

            builder?.show()
        }

        bus_contacts.setOnClickListener {
            val builder = context?.let { AlertDialog.Builder(it) }
            builder?.setTitle(getString(R.string.company_contacts_label))
            builder?.setMessage(
                "" + Html.fromHtml("<b>Empresa de Viação Terceirense</b>") + "\n\t\t+351 295 217 001\n\t\t" +
                        Html.fromHtml("<a href='https://www.evt.pt/'>evt.pt</a>")
            )

            builder?.setPositiveButton(android.R.string.yes) { dialog, which ->
            }

            builder?.show()
        }

        not_developed.setOnClickListener {
            val builder = context?.let { AlertDialog.Builder(it) }
            builder?.setTitle(getString(R.string.warning_dialog_title))
            builder?.setMessage(getString(R.string.warning_dialog_message))

            builder?.setPositiveButton(android.R.string.yes) { dialog, which ->
            }

            builder?.show()
        }

        rate.setOnClickListener {
            Toast.makeText(context, resources.getString(R.string.toast_link_message), Toast.LENGTH_SHORT).show()

            val appPackageName: String? = activity?.packageName

            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$appPackageName")
                    )
                )
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                    )
                )
            }
        }

        patreon.setOnClickListener {
            Toast.makeText(context, resources.getString(R.string.toast_link_message), Toast.LENGTH_SHORT).show()

            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://linktr.ee/sousadev_")
                    )
                )
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://linktr.ee/sousadev_")
                    )
                )
            }
        }

        mail.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "sousadev@yahoo.com", null
                )
            )
            intent.putExtra(Intent.EXTRA_SUBJECT, "Terceira Bus: [Problem]")
            startActivity(Intent.createChooser(intent, "Choose an Email client:"))
        }
    }

    private fun swapFrags(f : Fragment) {
        val t = activity?.supportFragmentManager?.beginTransaction()
        if (t != null) {
            t.replace(R.id.frag_container, f)
            t.addToBackStack(null)
            t.commit()
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                /*
                R.id.bttnStores -> {
                    swapFrags(StoresFragment())
                }

                R.id.bttnProds -> {
                    swapFrags(CategoriesFragment())
                }

                R.id.searchBar -> {
                    view?.findViewById<SearchView>(R.id.searchBar)?.onActionViewExpanded()
                }*/
            }
        }
    }
}