package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.atv,
            R.drawable.cruiser,
            R.drawable.dirtbike,
            R.drawable.dualbike,
            R.drawable.motocross,
            R.drawable.nakedbike,
            R.drawable.scrambler,
            R.drawable.skuter,
            R.drawable.sportbike,
            R.drawable.sporttouring,
        )

        title = arrayOf(
            getString(R.string.atv),
            getString(R.string.cruiser),
            getString(R.string.dirtbike),
            getString(R.string.dualbike),
            getString(R.string.motocross),
            getString(R.string.nakedbike),
            getString(R.string.scrambler),
            getString(R.string.skuter),
            getString(R.string.sportbike),
            getString(R.string.sporttouring),

        )
        description = arrayOf(
            getString(R.string.desc_atv),
            getString(R.string.desc_cruiser),
            getString(R.string.desc_dirtbike),
            getString(R.string.desc_dualbike),
            getString(R.string.desc_motocross),
            getString(R.string.desc_nakedbike),
            getString(R.string.desc_scrambler),
            getString(R.string.desc_skuter),
            getString(R.string.desc_sportbike),
            getString(R.string.desc_sporttouring),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
