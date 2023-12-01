package dklsa;

import java.util.ArrayList;
import java.util.Scanner;

import dklsa.longevity.DataTable;
import dklsa.longevity.Table;
import dklsa.longevity.Tool;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        testTable();

        
    }
    public static void testTable2(){
        Table tbl_tn = new Table("Test Number");
        int[] dt = new int[12];
        DataTable num = new DataTable("ahmad", dt);
        tbl_tn.addData(num);
        tbl_tn.withNumber(true);
        tbl_tn.printTable();
    }
    public static void testTable(){
        // test table here
        Table tbl_mhs = new Table("Tabel Mahasiswa");

        String[] strnam = {"adi", "dakwokd", "dadd"};
        String[] strnim = {"123", "321", "231"};
        String[] strpro = {"TI", "SI", "SI"};
        DataTable dt_nim = new DataTable("NIM", strnim);
        DataTable dt_nama = new DataTable("NAMA", strnam);
        DataTable dt_prodi = new DataTable("PRODI", strpro);
        
        tbl_mhs.addData(dt_nim);
        tbl_mhs.addData(dt_nama);
        tbl_mhs.addData(dt_prodi);
        tbl_mhs.printTable();


        Table tbl_penjualan = new Table("Tabel Penjualan");

        String[] strnb = {"Baju", "Kaos", "Telor", "Celana", "Kentang"};
        DataTable dt_namabarang = new DataTable("NAMA BARANG", strnb);
        tbl_penjualan.addData(dt_namabarang);

        int[] intqty = {2,3,4,1,5};
        DataTable dt_qty = new DataTable("QTY", intqty);
        tbl_penjualan.addData(dt_qty);
        

        int[] intprice = {25000,30000,5000,15000,42000};
        DataTable dt_price = new DataTable("HARGA",intprice,"Rp %,d");
        tbl_penjualan.addData(dt_price);
        
        int[] intgain = Tool.toIntArrayMultiply(intqty, intprice);
        DataTable dt_gain = new DataTable("PENDAPATAN",intgain, "Rp %,d");  
        tbl_penjualan.addData(dt_gain);
        tbl_penjualan.printTable();
        // tbl_penjualan.setHeaderBorder('-');
        
        










        // Scanner a = new Scanner(System.in);
        // String ai = a.next();
        // a.close();
    }
}