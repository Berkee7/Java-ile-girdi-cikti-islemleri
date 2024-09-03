public class Ticarethane implements IAbone{
//Berke Erin
//212106206005
    // Ticarethane fatura hesaplama tarifesi
    // 1-50 arası her bir metreküp 20 tl
    //51-100 arası herbir metreküp 30 tl
    //101-200 arası herbir metreküp 50 tl
    //201 ve üzeri  herbir metreküp 75 tl

    // örnek: 350 metreküp su tüketimi varsa
    // 1-50 arası tüketim 50 metreküp  tutar=50*20=1000
    // 51-100 arası tüketim 50 metreküp  tutar=50*30=1500
    // 101-200 arası tüketim 100 metreküp  tutar= 100*50=5000
    // 201-350 arası tüketim 150 metreküp  tutar= 150*75=11250
    //toplam fatura= 1000+1500+5000+11250=18750tl
    //varsa eski borç %10 zamlı olarak faturaya eklenecek
    //eğer 200 tl eski borç varsa güncel fatura= 18750 +200 + (200*10)/100= 18970tl

    String aboneNo, adi,soyAd, aboneTip,tuketim,eskiBorc;

    public Ticarethane(String aboneNo, String adi, String soyAd, String aboneTip, String tuketim, String eskiBorc) {
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
        if(tuk <= 50){
            toplam = tuk * 20;
        } else if(tuk <= 100) {
            toplam = 50 * 20 + (tuk - 50) * 30;
        } else if (tuk <= 200) {
            toplam = 50 * 20 + 50 * 30 + (tuk - 100) * 50;
        } else {
            toplam = 50 * 20 + 50 * 30 + 100 * 50 + (tuk - 200) * 75;
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
