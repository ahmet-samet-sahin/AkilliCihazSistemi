
public class SogutucuA implements ISogutucu{
	
	private String sogutucuAdi;
    private String sogutucuMarkasi;
    private Integer sogutucuGarantiSuresi;
    private String sogutucuOrijinalMi;

    private boolean sogutucuDurum = false;

    public SogutucuA(String sogutucuAdi , String sogutucuMarkasi,Integer sogutucuGarantiSuresi,String sogutucuOrijinalMi) {
        this.sogutucuAdi = sogutucuAdi;
        this.sogutucuMarkasi = sogutucuMarkasi;
        this.sogutucuGarantiSuresi = sogutucuGarantiSuresi;
        this.sogutucuOrijinalMi = sogutucuOrijinalMi;
    }
    
    @Override
    public boolean sogutucuDurum() {
        return sogutucuDurum;
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu kapatildi ...");
        sogutucuDurum = false;
    }
    
    @Override
    public void sogutucuAc(IAlgilayici algilayici) {
        if(algilayici.degerGetir() == null)
            System.out.println("Henuz olcum yapilmamis, algiyaciyi calistirin..");
        else{
            if(algilayici.degerGetir() <15)
                System.out.printf("Yeterli sogutma saglandi.. Mevcut sicaklik: %.2f Derece\n",algilayici.degerGetir());
            else{
                algilayici.yeniDeger(algilayici.degerGetir() - 5);
                System.out.printf("Sogutucu calistirildi.. Yeni sicaklik degeri %.2f Derece\n",algilayici.degerGetir());
                sogutucuDurum = true;
            }
        }

    }
    
    @Override
    public void sogutucuOzellikleri(){
        System.out.println("Sogutucu Adi :"+sogutucuAdi);
        System.out.println("Sogutu Markasi :"+sogutucuMarkasi);
        System.out.println("Sogutucu Garanti Suresi :"+sogutucuGarantiSuresi+" yil");
        System.out.println("Sogutucu Orijinal Mi :"+sogutucuOrijinalMi);
    }
    
}
