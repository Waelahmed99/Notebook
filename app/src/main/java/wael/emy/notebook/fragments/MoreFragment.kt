package wael.emy.notebook.fragments

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.more_fragment.view.*
import kotlinx.android.synthetic.main.terms_and_conditions.*
import wael.emy.notebook.BuildConfig
import wael.emy.notebook.R
import wael.emy.notebook.activities.FavoriteActivity


class MoreFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.more_fragment, container, false)
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        // Favorite books list.
        v.favorite_layout.setOnClickListener {
            context?.startActivity(Intent(context, FavoriteActivity::class.java))
        }

        // Contact us.
        v.chat_layout.setOnClickListener {
            contactUs()
        }

        // Terms and conditions.
        v.terms_layout.setOnClickListener {
            termsAndConditions()
        }

        // rate app via app-store.
        v.rate_layout.setOnClickListener {
            rateApplication()
        }

        // Share app.
        v.share_layout.setOnClickListener {
            shareApplication()
        }
        super.onViewCreated(v, savedInstanceState)
    }

    private fun contactUs() {
        val appEmail = resources.getString(R.string.company_email)
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$appEmail")
        startActivity(intent)
    }

    private fun termsAndConditions() {
        val dialog = Dialog(context!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.terms_and_conditions)
        dialog.cancel_btn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.terms_text.movementMethod = ScrollingMovementMethod()
        dialog.show()
    }

    private fun rateApplication() {
        val uri: Uri = Uri.parse("market://details?id=" + context!!.packageName)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)

        goToMarket.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
        try {
            startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context!!.packageName)
                )
            )
        }
    }

    private fun shareApplication() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Notebook")
        var shareMessage = "Hey there\nTry this audio-book app now!\n\n"
        shareMessage = shareMessage + "http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        startActivity(Intent.createChooser(shareIntent, "Choose one"))
    }
}