package com.example.utsrahmad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utsrahmad2.databinding.ActivityMainBinding
import com.example.utsrahmad2.fragment.HomeFragment
import com.example.utsrahmad2.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    val fragmentHome: Fragment = HomeFragment()
    val fragmentProfile: Fragment = ProfileFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hewanList = listOf<Hewan>(
            Hewan(
                R.drawable.harimau,
                namehewan = "Harimau",
                deschewan = " Harimau (Panthera tigris) adalah spesies kucing terbesar yang masih hidup dari genus Panthera. Harimau memiliki ciri loreng yang khas pada bulunya, berupa garis-garis vertikal gelap pada bulu oranye, dengan bulu bagian bawah berwarna putih"
            ),
            Hewan(
                R.drawable.macan,
                namehewan = "Macan tutul",
                deschewan = "Macan tutul (bahasa Latin: Panthera pardus) atau Harimau Bintang adalah salah satu dari empat kucing besar. Hewan ini dikenal juga dengan sebutan harimau dahan karena kemampuannya memanjat. Pada mulanya, orang berpikiran bahwa macan tutul adalah hibrida dari singa dan harimau, sehingga muncul nama \"leopard\" di kalangan peneliti Eropa awal"
            ),
            Hewan(
                R.drawable.beruang,
                namehewan = "Beruang",
                deschewan = "Seekor beruang kutub jantan bisa memiliki berat hingga 800 kg atau setara dengan 10 orang laki-laki dewasa! Beruang kutub juga dapat tumbuh hingga 3 meter, membuatnya jadi spesies beruang terbesar dan karnivora darat terbesar di dunia"
            ),
            Hewan(
                R.drawable.buaya,
                namehewan = "Buaya",
                deschewan = "Buaya adalah reptil bertubuh besar yang hidup di air. Secara ilmiah, buaya meliputi seluruh spesies anggota famili Crocodylidae, termasuk pula buaya sepit (Tomistoma schlegelii). Meski demikian nama ini dapat pula dikenakan secara longgar untuk menyebut ‘buaya’ aligator, kaiman dan gavial; yakni kerabat-kerabat buaya yang berlainan suku."
            ),
            Hewan(
                R.drawable.hiu,
                namehewan = "Hiu",
                deschewan = "Ikan Hiu atau Cucut (superordo Selachimorpha) adalah sekelompok ikan dengan kerangka tulang rawan yang lengkap dan tubuh yang ramping. Mereka bernapas dengan menggunakan lima liang insang (kadang-kadang enam atau tujuh, tergantung pada spesiesnya) di samping, atau dimulai sedikit di belakang, kepalanya."
            ),
            Hewan(
                R.drawable.komodo,
                namehewan = "CB 200X",
                deschewan = "Komodo atau lengkapnya biawak komodo (Varanus komodoensis), adalah spesies biawak besar yang terdapat di Pulau Komodo, Rinca, Flores, Gili Motang, dan Gili Dasami di Provinsi Nusa Tenggara Timur, Indonesia. Hewan ini oleh penduduk asli pulau Komodo juga disebut dengan nama setempat ora. Nama lain dari komodo adalah buaya darat, walaupun komodo bukanlah spesies buaya."
            ),
            Hewan(
                R.drawable.serigala,
                namehewan = "CBR 250R",
                deschewan = "Serigala merupakan hewan karnivora atau pemakan daging. Hewan ini termasuk ke dalam keluarga anjing yang merupakan anggota keluarga terbesar. Bedanya, serigala tidak sejinak anjing-anjing jenis lain, serta tidak terbiasa menjadi peliharaan bagi manusia. Biasanya serigala hidup di belahan Utara bumi"
            ),
            Hewan(
                R.drawable.singa,
                namehewan = "R15",
                deschewan = "Singa (Sanskerta: Siṃha, atau nama ilmiahnya Panthera leo) adalah spesies hewan dari keluarga felidae atau keluarga kucing. Singa berada di benua Afrika dan sebagian di wilayah India. Singa merupakan hewan yang hidup berkelompok. Biasanya terdiri dari seekor jantan & banyak betina."
            ),
            Hewan(
                R.drawable.ularkobra,
                namehewan = "Ular Kobra",
                deschewan = "Ular sendok atau Ular kobra sejati adalah sebutan khusus untuk semua jenis ular berbisa (Elapidae) yang memiliki kemampuan memipihkan lehernya hingga membentuk seperti sendok atau tudung. Istilah \"ular sendok\" umumnya digunakan untuk jenis-jenis Naja. Akan tetapi, beberapa spesies selain dari genus Naja yang memiliki ciri khas yang sama juga disebut \"ular sendok\", walaupun spesies-spesies tersebut memiliki nama atau sebutan khusus, misalnya sebutan \"ular anang\" yang umum untuk spesies Ophiophagus hannah, walaupun bisa juga disebut \"kobra raja\" atau \"ular sendok raja\". Ular sendok dari genus Naja (kobra sejati) tersebar di Afrika, Asia Barat, Asia Selatan, dan Asia Tenggara."
            ),
            Hewan(
                R.drawable.ularpiton,
                namehewan = "GB350",
                deschewan = "Sanca atau Sawa atau pinjaman bahasa Inggris Piton adalah sebutan umum untuk semua jenis ular pembelit yang diklasifikasikan sebagai familia Pythonidae. Sanca tersebar luas di daerah beriklim panas dan tropis Afrika, Asia, dan Australia. Salah satu spesies sanca, yaitu sanca kembang (Malayopython reticulatus) merupakan ular terpanjang di dunia."
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hewan)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = HewanAdapter(this, hewanList){

            val intent = Intent (this, DetailHewan::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        bottomNavigation()
    }

    private fun bottomNavigation() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()

        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_profile -> {
                    callFragment(1, fragmentProfile)
                }
            }
            false
        }

    }

    private fun callFragment(index: Int, fragmentHome: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragmentHome).commit()
        active = fragmentHome

    }
}
