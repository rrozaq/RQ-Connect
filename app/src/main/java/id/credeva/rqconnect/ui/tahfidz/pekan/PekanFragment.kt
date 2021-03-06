package id.credeva.rqconnect.ui.tahfidz.pekan

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import id.credeva.rqconnect.R
import id.credeva.rqconnect.data.adapter.PekanAdapter
import kotlinx.android.synthetic.main.fragment_pekan.*
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * by Sandy Priyatna
 */

class PekanFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: PekanViewModelFactory by instance()
    private lateinit var viewModel: PekanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pekan, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(PekanViewModel::class.java)

        viewModel.getPekan()
        viewModel.pekan.observe(viewLifecycleOwner, Observer { pekan ->
            try {
                pb_pekan.visibility = View.GONE
                rv_pekan.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = PekanAdapter(pekan)
                }
            } catch (e: Exception) {
                Log.v("errorPekan: ", e.message)
            }
        })

        swipe_pekan.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                this.requireContext(),
                R.color.colorPrimary
            )
        )

        swipe_pekan.setColorSchemeColors(Color.WHITE)

        swipe_pekan.setOnRefreshListener {
            viewModel.getPekan()
            viewModel.pekan.observe(viewLifecycleOwner, Observer { pekan ->
                try {
                    pb_pekan.visibility = View.GONE
                    rv_pekan.also {
                        it.layoutManager = LinearLayoutManager(requireContext())
                        it.setHasFixedSize(true)
                        it.adapter = PekanAdapter(pekan)
                    }
                } catch (e: Exception) {
                    Log.v("errorPekan: ", e.message)
                }
            })

            swipe_pekan.isRefreshing = false
        }

    }
}
