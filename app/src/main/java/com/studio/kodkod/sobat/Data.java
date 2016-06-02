package com.studio.kodkod.sobat;

import java.util.ArrayList;

/**
 * Created by pcode on 30/05/16.
 */
public class Data {
    //public static String[] namaObat, golongan, bentukSediaan, indikasi, kontraIndikasi, perhatian, efekSamping, dosis, interaksiObat, kemasan, peresepan;
    public static String namaDokter, sipDokter, alamatDokter, namaPasien, umur, beratBadan;

    public static ArrayList<String> rNamaObat = new ArrayList<>();
    public static ArrayList<String> rBentukSediaan = new ArrayList<>();
    public static ArrayList<String> rDosis = new ArrayList<>();
    public static ArrayList<String> rTotal = new ArrayList<>();
    public static ArrayList<String> rAturanPakai = new ArrayList<>();

    public static String[] namaObat = {"prokain benzil penisilin","doksisiklin","tetrasiklin","Kloramfenikol"};
    public static String[] golongan = {"-","-","-","-"};
    public static String[] bentukSediaan = {"serb inj 3 juta IU (i.m.)","kaps 100 mg","kaps 250 mg","kaps 250 mg"};
    public static String[] indikasi = {"Infeksi yang disebabkan oleh microorganisme gram + dan gram - yang peka terhadap benzilpenisilin.","Infeksi saluran pernafasan, saluran pencernaan, kulit, dan jaringan lunak.","Infeksi saluran pernafasan, saluran pencernaan, saluran kencing dan alat kelamin, ingeksi pada kulit, jaringan lunak, dan infeski sistemik.","Tifus, paratifus. Infeksi berat yang disebabkan oleh Salmonella sp, H Influenza, Ricketsia, Lymphogranuloma, gram negatif yang menyebabkan bacteremia meningitis."
    };
    public static String[] kontraIndikasi = {"Hipersensitifitas.","Hipersensitifitas, fotodermatosis, kerusakan hati, diskrasia darah.","Hipersensitifitas.","Hipersensitifitas, gangguan fungsi hati berat, gangguan ginjal berat."
    };
    public static String[] perhatian = {"Bayi dan lansia, gagal ginjal, gagal jantung kongestif, hipersensitif terhadap sefalosporin.","-","Tidak dianjrkan untuk wanita hamil atau menyusui, anak <8 tahun, penderita gangguan ginjal, tidak untuk pemakaian jangka panjang.","Tidak dianjurkan untuk wanita hamil atau menyusui. Hanya digunakan untuk infeksi yang jelas penyebabnya. Perlu dilakukan pengawasan terhadap kemungkinan timbulnya super infeksi dengan bakteri dan jamur. Hati-hati pada bayi yang lahir prematur dan bayi baru lahir (2 minggu pertama). Tidak untuk pencegahan infeksi"};
    public static String[] efekSamping = {"Ruam, demam, urtrikaria, pruritus, anafilaksis, gangguan GI, glossitis, stomatitis, lidah 'berbulu' hitam, kejang, gangguan darah dan koagulasi, superinfeksi.","Gangguan liver, darah, dan ginjal.","Gangguan gastrointestinal, kulit, kenaikan BUN, gangguan hematologi.","Diskrasia darahm gangguan gastrointestinal, sindroma grey pada bayi baru lahir, terutama bayi prematur."};
    public static String[] dosis = {"Dewasa: sehari 300.000-900.000 UI terbagi dalam 1-2 dosis, anak 10.000 u/kgBB/hari.","Anak dan dewasa BB 50 kg: 200 mg. Pemeliharaan: sehari 100 mg dalam dosis tunggal per 12 jam. Infeksi berat: sehari 200 mg.","Anak 8 tahun 25-50 mg/kgBB sehari dalam dosis terbbagi, dewasa sehari 3-4 kali 1-2 kapsul. Sebaiknya diberikan 1  jam sebelum atau 2 jam setelah makan.","Dewasa anak-anak, dan bayi diatas 2 minggu: sehari 3-4x 50 mg/kgBB. Bayi berumur dibawah 2 minggu: 25 mg/kgBB dalam dosis terbagi 4."};
    public static String[] interaksiObat = {"-","-","Antikoagulan oral dapat terjadi potensiasi. Antasida, dairy product, zat besi oral, seng sulfat, dan sukralfat akan memperkecil absorbsi Tetrasiklin.","Menghambat biotransformasi senyawa lain yang dimetabolisme oleh enzim mikrosoma hati."
    };
    public static String[] kemasan = {"PROCAINE PENICILLIN-6 MEIJI: 20 vial.","DOTUR: Dus 5x10 kap.","TETRASANBE: Dus 10x10 Kaps Rp. 22.550.","CHLORAMPHENICOL: Botol 250 kapsul Rp. 77.963."};
    public static String [] peresepan = {"3 vial/kasus","2 kaps/hari (10 hari)","4 kaps/hari (10 hari)","4 kaps/hari (10 hari)"};
}