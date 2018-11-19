package com.example.aftermath.hifi.news;


import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aftermath.hifi.R;

import java.util.ArrayList;

public class FragmentNews extends Fragment {
    public FragmentNews(){}
    private RecyclerView rvHighlight, rvTourismSpot, rvDelicacies;
    private ArrayList<ModelHighlight> listModelHighlight = new ArrayList<>();
    private ArrayList<ModelTourismSpot> listModelTourismSpot = new ArrayList<>();
    private ArrayList<ModelDelicacy> listModelDelicacy = new ArrayList<>();
    DataDelicacies dataDelicacies = new DataDelicacies();
    DataTourismSpot dataTourismSpot = new DataTourismSpot();
    DataHighlight dataHighlight = new DataHighlight();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        rvHighlight = view.findViewById(R.id.rv_highlight);
        rvTourismSpot = view.findViewById(R.id.rv_tourism_spot);
        rvDelicacies = view.findViewById(R.id.rv_delicacy);

        return view;
    }

    private void prepareData(){
        dataHighlight.addData("MERAIH BINTANG - VIA VALLEN", "https://www.youtube.com/watch?v=1ak17RxcqBQ", R.mipmap.highlight1);
        dataHighlight.addData("KEMAYORAN ATHLETE VILLAGE", "https://www.youtube.com/watch?v=c5dATO9lXxE", R.mipmap.highlight2);
        dataHighlight.addData("ASIAN FEST", "https://www.youtube.com/watch?v=75dd-lI640I", R.mipmap.highlight3);
        dataHighlight.addData("TONGUE TWISTER","https://www.youtube.com/watch?v=nnsrup8e4_I",R.mipmap.highlight4);
        dataHighlight.addData("THIS OR THAT","https://www.youtube.com/watch?v=1THesUJkrks",R.mipmap.highlight5);

        dataDelicacies.addData("KETOPRAK","Ketoprak adalah salah satu jenis makanan khas Jakarta menggunakan ketupat yang mudah dijumpai. Biasanya ketupat dijajakan menggunakan kereta dorong di jalan-jalan atau di kaki lima",R.mipmap.delicacies_ketoprak);
        dataDelicacies.addData("KERAK TELOR","Kerak telur adalah makanan asli daerah Jakarta (Betawi), dengan bahan-bahan beras ketan putih, telur ayam, ebi (udang kering yang diasinkan) yang disangrai kering ditambah bawang merah goreng, lalu diberi bumbu yang dihaluskan berupa kelapa sangrai, cabai merah, kencur, jahe, merica butiran, garam dan gula pasir. ",R.mipmap.delicacies_keraktelor);
        dataDelicacies.addData("NASI UDUK", "Nasi gurih karena dicampur santan, ditambah bihun menjadikannya sebagai menu sarapan yang sangat mantap. Kamu bisa menambahkan lauk tambahan seperti telur, tempe, hingga ayam. Nasi uduk mudah dikombinasikan dengan lauk apa pun dan dinikmati kapan pun.",R.mipmap.delicacies_nasiuduk);
        dataDelicacies.addData("NASI ULAM", "Mirip seperti nasi campur, kamu bisa memilih aneka lauk untuk disantap bersama nasi ulam. Paling mantap jika ditemani daging semur potong, bihun, dan kerupuk. Hhmmm...maknyus!", R.mipmap.delicacies_nasiulam);
        dataDelicacies.addData("SEMUR JENGKOL","Jika pengolahannya benar, jengkol bisa menjadi sangat lezat, bahkan tak ada baunya seperti yang kita dengar selama ini. Apalagi, jengkol bisa jadi empuk seperti daging. Langsung cobain ya, jangan dibayangin.", R.mipmap.delicacies_semurjengkol);
        dataDelicacies.addData("SOTO BETAWI","Menggunakan kuah santan atau kuah susu, soto Betawi berisi daging, potongan tomat, kentang, dan seledri. Rasanya gurih dan enak disantap saat hangat.", R.mipmap.delicacies_sotobetawi);
        dataDelicacies.addData("SARI ROTI","Sari roti adalah salah satu produsen roti terbesar di Indonesia yang memiliki slogan yaitu \"Rotinya Indonesia\". Sari Roti Makanan Halal, Sehat, & Higienis.",R.mipmap.delicacies_sariroti);


        dataTourismSpot.addData("MONUMEN NASIONAL", "Monumen Nasional atau yang populer disingkat dengan Monas atau Tugu Monas adalah monumen peringatan setinggi 132 meter (433 kaki) yang didirikan untuk mengenang perlawanan dan perjuangan rakyat Indonesia untuk merebut kemerdekaan dari pemerintahan kolonial Hindia Belanda.",R.mipmap.tour_monas);
        dataTourismSpot.addData("BUNDARAN HI","Bundaran HI adalah Monumen Selamat Datang terletak di pusat Bundaran Hotel Indonesia atau Bundaran HI. Dinamakan demikian karena letaknya yang dekat dengan Hotel Indonesia. Ejaan lain yang diterima adalah Bunderan HI, yaitu bahasa yang lebih dekat dengan Bahasa Jawa-Betawi, dialek yang lebih dekat dengan identitas Jakarta.", R.mipmap.tour_hi);
        dataTourismSpot.addData("TAMAN MINI INDONESIA INDAH","Taman Mini Indonesia Indah adalah taman hiburan ikonik bertemakan Indonesia yang populer sejak tahun 90-an. Pengunjung bisa menikmati berbagai wahana dan fasilitas seperti misalnya Anjungan Daerah, kereta gantung, Teater 4D, museum, Teater IMAX Keong Mas, dan masih banyak lagi. Semua fasilitas, bangunan, wahana, dan dekorasi di tempat wisata di Jakarta ini merupakan miniatur dari 33 provinsi di Indonesia.", R.mipmap.tour_tmii);
        dataTourismSpot.addData("MUSEUM NASIONAL INDONESIA","Museum Nasional Indonesia adalah museum di Jakarta Pusat yang menyimpan koleksi prasasti, arca, senjata tradisional, tekstil, gerabah, manuskrip, hasil penggalian arkeologis, serta benda kuno lainnya dari berbagai wilayah Nusantara. Tempat wisata di Jakarta Pusat ini berdiri sejak tahun 1778, dan kini terkenal sebagai salah satu museum terbesar di Asia Tenggara. Museum Nasional juga dikenal sebagai “Museum Gajah”, karena patung gajah yang ada di halamannya.",R.mipmap.tour_museum);
        dataTourismSpot.addData("PANTAI ANCOL","Pantai Ancol adalah jalur pantai wisata yang terdiri dari lima pantai, yaitu Pantai Indah, Elok, Ria, Festival Ancol, dan Karnaval Ancol. Tempat wisata di Jakarta yang satu ini buka selama 24 jam dan menawarkan panorama indah, tempat makan, serta lokasi ideal untuk melihat matahari terbit atau terbenam. Pengunjung bisa berfoto, bermain pasir, jogging, atau makan di salah satu restoran yang ada di kawasan wisata terpadu ini. Berbagai titik di tempat wisata di Jakarta yang satu ini juga cocok untuk meramaikan album Instagram Anda.",R.mipmap.tour_pantaiancol);
        dataTourismSpot.addData("TAMAN ISMAIL MARZUKI", "Pusat Kesenian Jakarta Taman Ismail Marzuki yang populer disebut Taman Ismail Marzuki (TIM) merupakan sebuah pusat kesenian dan kebudayaan yang berlokasi di jalan Cikini Raya 73, Jakarta Pusat. Di sini terletak Institut Kesenian Jakarta dan Planetarium Jakarta. Selain itu, TIM juga memiliki enam teater modern, balai pameran, galeri, gedung arsip, dan bioskop. Acara-acara seni dan budaya dipertunjukkan secara rutin di pusat kesenian ini, termasuk pementasan drama, tari, wayang, musik, pembacaan puisi, pameran lukisan dan pertunjukan film.", R.mipmap.tour_tim);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //test data, bakal diisi static data saja(?)
        prepareData();
        for(int i=0;i<dataHighlight.highlightHeader.size();i++) {
            ModelHighlight modelHighlight = new ModelHighlight(dataHighlight.highlightLink.get(i), dataHighlight.highlightHeader.get(i), dataHighlight.highlightImage.get(i));
            listModelHighlight.add(modelHighlight);
        }
        //
        for(int i=0;i<dataTourismSpot.tourismSpotHeader.size();i++){
            ModelTourismSpot modelTourismSpot = new ModelTourismSpot(dataTourismSpot.tourismSpotHeader.get(i), dataTourismSpot.tourismSpotBody.get(i), dataTourismSpot.tourismSpotImage.get(i));
            listModelTourismSpot.add(modelTourismSpot);
        }

        for(int i=0;i<dataDelicacies.delicacyHeader.size();i++){
            ModelDelicacy modelDelicacy = new ModelDelicacy(dataDelicacies.delicacyHeader.get(i), dataDelicacies.delicacyBody.get(i),dataDelicacies.delicacyImage.get(i));
            listModelDelicacy.add(modelDelicacy);
        }

        rvHighlight.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvHighlight.setLayoutManager(layoutManager);
        rvHighlight.setAdapter(new AdapterHighlight(listModelHighlight,getContext()));

        rvTourismSpot.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTourismSpot.setLayoutManager(layoutManager2);
        rvTourismSpot.setAdapter(new AdapterTourismSpot(listModelTourismSpot,getContext()));


        rvDelicacies.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext());
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDelicacies.setLayoutManager(linearLayoutManager3);
        rvDelicacies.setAdapter(new AdapterDelicacy(listModelDelicacy, getContext()));
        super.onViewCreated(view, savedInstanceState);
    }
}
