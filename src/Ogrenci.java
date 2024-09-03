public class Ogrenci implements IAbone{
//Berke Erin
//212106206005
    // Öğrenci fatura hesaplama tarifesi
    //ilk 5 metreküp ücretsiz
    // 6-10 arası her bir metreküp 10 tl
    //11-20 arası herbir metreküp 15 tl
    //21 ve üzeri herbir metreküp 20tl


    // örnek: 36 metreküp su tüketimi varsa
    // 5 metreküp ücretsiz tüketim 5 metreküp  tutar=5*0=0
    // 6-10 arası tüketim 5 metreküp  tutar=5*10=50
    // 11-20 arası tüketim 10 metreküp  tutar=10*15=150
    // 21-36 arası tüketim 16 metreküp  tutar= 16*20=320
    //toplam fatura= 50+150+320=550tl
    //varsa eski borç %10 zamlı olarak faturaya eklenecek
    //eğer 60 tl eski borç varsa güncel fatura= 550 +60 + (60*10)/100= 616tl

    String aboneNo, adi,soyAd, aboneTip,tuketim,eskiBorc;

    public Ogrenci(String aboneNo, String adi, String soyAd, String aboneTip, String tuketim, String eskiBorc) {
        this.aboneNo = aboneNo;
        this.adi = adi;
        this.soyAd = soyAd;
        this.aboneTip = aboneTip;
        this.tuketim = tuketim;
        this.eskiBorc = eskiBorc;
    }

    public double faturaHesapla() {
        int tuk=0,borc=0,toplam=0,total=0;
        if(!eskiBorc.equals("YOK")){
            borc=Integer.parseInt(eskiBorc);
        }else{

            borc=0;
        }
        tuk=Integer.parseInt(tuketim);
        if(tuk <= 5){
            toplam = 0;
        } else if(tuk <= 10) {
            toplam = (tuk - 5) * 10;
        } else if (tuk <= 20) {
            toplam = 5 * 10 + (tuk - 10) * 15;
        } else {
            toplam = 5 * 10 + 10 * 15 + (tuk - 20) * 20;
        }
        total=toplam+borc+((borc*10)/100);
        return total;
    }

    @Override
    public double eskiBorcMiktari() {

        double borc=0;
        if(!eskiBorc.equals("YOK")){
            borc=Double.parseDouble(eskiBorc);
        }else{

            borc=0;
        }
        return borc;
    }

    @Override
    public String aboneTuru() {
        return null;
    }


}
