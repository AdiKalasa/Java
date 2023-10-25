package dklsa;
import java.time.*;
import java.time.format.DateTimeFormatter;

// 20/10/2023 19:1 untuk ambil waktu/date di java pake lib java.time aja, selengkapnya cek
//
public class Main{
    public static void main(String[] args) {
        // ambil date+time
        LocalDateTime ldt = LocalDateTime.now();
        // output: 2023-10-20T19:33:14.218608800
        
        // ambil date nya aja
    //  LocalDate ld = LocalDate.now();
        // output: 2023-10-20

        // ambil time nya aja
        LocalTime lt = LocalTime.now();
        // output: 19:33:14.224455300

        // pake Date juga bisa, Date date = new Date();
        // output: Fri Oct 20 19:34:47 WIB 2023

        //=========== FORMAT DATE TIME
        // lib std? java.time.format.DateTimeFormatter
        // mm = menit, HH = jam, yyyy = tahun, ss = detik, SSSSSS = mikro detik max
        // dd = tanggal(angka), DD = hari, MM = bulan(angka), MMMM = nama bulan
        // cara formatnya:
        // 1 ambil mentahan datetime nya
        // 2 bikin formatter pake DateTimeFormatter beserta formatnya didalam .ofPattern("");
        // 3 bikin string buat nampung format dah dibuat

        DateTimeFormatter f = DateTimeFormatter.ofPattern("ss");
        String fdt = ldt.format(f);
        System.out.println(lt);
        System.out.println(fdt);
    }
}