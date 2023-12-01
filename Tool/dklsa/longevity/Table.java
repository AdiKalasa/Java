package dklsa.longevity;
 
import java.util.ArrayList;
 


/*
 * Table maker Log
 * start at 24/11/2023 13:5 {makan dulu}
 * 24/11/2023 22:44 gacorrr, dah sampe isi, turu dulu
 * 25/11/2023 18:25 {
 *  mencuba membuat print isi datanya kedalam tabel, btw kodenya masih amburadul
 *  TODONE:Rapihin kode kalo dah bisa print header sama isi datanya
 *  Done simple table, mau nambahin fitur with number print tapi rapihin kode dulu
 *  misahin biar gk inheritance, supaya set border cuma bisa diakses sama member tabel
 * }
 * 25/11/2023 22:20 dahan dulu mentok kesemutan
 * 28/11/2023 19:42 mencoba membuat printtable auto with number list 
 * 
 */

/*
 * Tabel maker idea
 * (Line Numbers)
 * 26/11/2023 20:26 (Line Numbers)ide nambahin fitur urutan angka di kolom pertama tabel { Done Start 28/11/2023 19:42  End 28/11/2023 21:10}
 * 29/11/2023 8:47 benerin dikit masalah kalo fungsi withNumber sama printTable nya dipanggil berkali kali
 * **************************************************************************************************************************
 * 28/11/2023 21:10 multi title maksudnya awalnya 1 title trus beranak, contoh ada data member title "Jenis Kelamin" trus bawahnya dia
 * ada 2 title bersampingan "Laki-laki" sama "Perempuan" bawahnya baru datanya;
 * **************************************************************************************************************************
 * 
 */
public class Table {

    protected ArrayList<DataTable> listDataTable = new ArrayList<>();
    
    protected char border_header = '#';
    protected char border_body = '|';
    protected char border_footer = '-';
    protected char border_separator = border_body;
    private String tablename;
    private boolean autoNumber = false;
    private boolean autoNumberDone = false;
    

    public Table(String tablename){
        this.tablename = tablename;
    }

    /*
     * Print
     */
    // private void getTableSetting(){

    // }
    public void printTable(){
        int datasize = this.listDataTable.size();

        // auto number
        if(this.autoNumber&&this.autoNumberDone==false){
            int numlength = this.listDataTable.get(0).data.length;
            int[] num = new int[numlength];
            for(int i=0;i<numlength;i++){
                num[i] = i+1;
            }
            
            DataTable dt_num = new DataTable("NO", num);
            this.addData(dt_num);
            datasize = this.listDataTable.size();

            // kolom 1 for num, geser semua data 1x ke kanan
            for(int i=0;i<datasize;i++){
                DataTable cur = this.listDataTable.get(i);
                DataTable last_dat = this.listDataTable.get(datasize-1);
                this.listDataTable.set(i, last_dat);
                this.listDataTable.set(datasize-1, cur);
            }
            this.autoNumberDone = true;
        }else if(this.autoNumberDone && this.autoNumber==false){
            this.listDataTable.remove(0);
            this.autoNumberDone =false;
            datasize = this.listDataTable.size();
        }
        
        // cari max length dari data
        int[] maxlength = new int[datasize];
        for(int i =0;i<datasize;i++){

            DataTable currentDT = this.listDataTable.get(i);
            int datasizeDT = currentDT.data.length;

            for(int j=0;j<datasizeDT;j++){
                int currentDTlength = currentDT.data[j].length();
                
                maxlength[i] = (maxlength[i]<currentDTlength) ? currentDTlength:maxlength[i]; 
            }

            // maybe max from its title
            maxlength[i] = (maxlength[i]<(currentDT.dataTitle.length()+2)) ? (currentDT.dataTitle.length()+2):maxlength[i]; 
        }
       
        // print header
        System.out.println(this.tablename);
        this.printHeader(maxlength, datasize);
    }
    private void printHeader(int[] maxlength, int datasize){

        //for upper and lower size
        int sizeUpperDT = 0;
        for(int i=0;i<maxlength.length;i++){
            sizeUpperDT+=maxlength[i];
        }

        // upper        
        int freeBorder = datasize+1;
        sizeUpperDT+=freeBorder;
        for(int j =0;j<sizeUpperDT;j++){
            System.out.print(this.border_header);
        }
        System.out.println();

        // middle ( hard part )
        for(int i=0;i<datasize;i++){
            DataTable currentDT = this.listDataTable.get(i);
            System.out.print(this.border_separator);
            /*
            * get title size ganjil or genap and adjust with maxlength
            * if same ganjil or genap then biarin, else
            */
            int titleDTlength = currentDT.dataTitle.length();
            int leftSpace = 0;
            int rightSpace = 0;
            if(currentDT.dataTitle.length()<maxlength[i]){
                if(titleDTlength%2 != maxlength[i]%2){
                    // jika beda
                    leftSpace = ((maxlength[i]-1)-titleDTlength)/2;
                    rightSpace = ((maxlength[i]-titleDTlength)/2)+1;
                    if(leftSpace == 0){leftSpace =1;}
                }else{
                     
                    leftSpace = (maxlength[i]-titleDTlength)/2;
                    rightSpace = (maxlength[i]-titleDTlength)/2;
                }
            }else{
                leftSpace = 1;
                rightSpace = 1;
            }
            // left side title
            for(int ils = 0;ils<leftSpace;ils++){
                System.out.print(" ");
            }
            System.out.print(currentDT.dataTitle);
            // right side title
            for(int irs = 0;irs<rightSpace;irs++){
                System.out.print(" ");
            }
        }
        System.out.println(this.border_separator);

        // lower
        for(int j =0;j<sizeUpperDT;j++){
            System.out.print(this.border_header);
        }
        System.out.println();
        int stat = printData(maxlength, datasize);
        if(stat == 0){System.err.println("Print data aborted!");}
        printFooter(sizeUpperDT);
    }
    private int printFooter(int uppersize){
        // upper size is lower size too
        for(int j =0;j<uppersize;j++){
            System.out.print(this.border_footer);
        }
        System.out.println();
        return 1;
    }
    private int printData(int[] maxlength, int datatable_size){
        // temporary
        // each data size must be same size
        Throwable c_DTsize = new Throwable("Invalid DataTable size");
        int datatable_sizedata =0;
        try{

            DataTable currentDT = this.listDataTable.get(0);
            for(int i=0;i<datatable_size;i++){

                DataTable currentDTloop = this.listDataTable.get(i);
                if(currentDT.data.length!=currentDTloop.data.length){
                   
                    Throwable e = new Throwable("All DataTable must at same size", c_DTsize);
                    throw e;
                }
                
                datatable_sizedata = currentDT.data.length;
            }
            
        }catch(Throwable e){
            e.printStackTrace();
            return 0;
        }
        
        /*
         * Print data here
         */
        for(int i=0;i<datatable_sizedata;i++){
            System.out.print(this.border_body);
            for(int j = 0;j<datatable_size;j++){
                DataTable curDT = this.listDataTable.get(j);
                String a =curDT.data[i];
                System.out.print(a);
                int fillSpace = maxlength[j]-a.length();

                // space for empty coloumn
                for(int k=0;k<fillSpace;k++){
                    System.out.print(" ");
                }

                System.out.print(this.border_body);
            }
            System.out.println();
        }
        return 1;
    }

    /*
     * Add
     */
    public void addData(DataTable data){
        this.listDataTable.add(data);
    }



    /*
     * Setter 
     */

    public void withNumber(boolean an){
        this.autoNumber = an;
    }
    public void setHeaderBorder(char border){
        this.border_header = border;
    }
    public void setBodyBorder(char border){
        this.border_body = border;
    }
    public void setFooterBorder(char border){
        this.border_footer = border;
    }

}